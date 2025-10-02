package com.example.ZETA_Api_MongoDB.service;

import com.example.ZETA_Api_MongoDB.client.PostgresClient;
import com.example.ZETA_Api_MongoDB.dto.ClassRequestDTO;
import com.example.ZETA_Api_MongoDB.dto.ClassResponseDTO;
import com.example.ZETA_Api_MongoDB.dto.ProgramResponseDTO;
import com.example.ZETA_Api_MongoDB.exception.EntityAlreadyExistsException;
import com.example.ZETA_Api_MongoDB.exception.EntityNotFoundException;
import com.example.ZETA_Api_MongoDB.mapper.ClassMapper;
import com.example.ZETA_Api_MongoDB.model.Class;
import com.example.ZETA_Api_MongoDB.repository.ClassRepository;
import com.example.ZETA_Api_MongoDB.validation.ClassPatchValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClassService {

    private final ClassRepository classRepository;

    private final SequenceGeneratorService sequenceGenerator;

    private final PostgresClient client;

    private final ClassPatchValidation validation;

    private final ClassMapper mapper;

    public List<ClassResponseDTO> listAll() {
        return classRepository.findAll()
                .stream()
                .map(c -> mapper.convertClassToResponse(c, client.findProgramById(c.getProgramId())))
                .toList();
    }

    public List<ClassResponseDTO> listAllClassesByProgramId(Integer id) {
        return classRepository.findAll()
                .stream()
                .filter(c -> Objects.equals(c.getProgramId(), id))
                .map(c -> mapper.convertClassToResponse(c, client.findProgramById(c.getProgramId())))
                .toList();
    }

    public ClassResponseDTO findById(Integer id) {
        Class classExists = classRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Class not found!"));

        ProgramResponseDTO program = client.findProgramById(classExists.getProgramId());

        return mapper.convertClassToResponse(classExists, program);
    }

    public ClassResponseDTO createClass(ClassRequestDTO request) {
        if (classRepository.findByTitle(request.getTitle()) != null) {
            throw new EntityAlreadyExistsException("Class already exists!");
        }

        ProgramResponseDTO program = client.findProgramById(request.getProgramId());

        if (program == null) {
            throw new EntityNotFoundException("Program not found!");
        }

        Class newClass = mapper.convertRequestToClass(request);
        newClass.setId(sequenceGenerator.getNextSequence("class"));
        classRepository.save(newClass);
        return mapper.convertClassToResponse(newClass, program);
    }

    public void deleteById(Integer id) {
        if (!classRepository.existsById(id)) {
            throw new EntityNotFoundException("Class not found!");
        }
        classRepository.deleteById(id);
    }

    public void updateClass(Integer id, ClassRequestDTO request) {
        Class exists = classRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Class not found!"));

        ProgramResponseDTO program = client.findProgramById(request.getProgramId());

        if (program == null) {
            throw new EntityNotFoundException("Program not found!");
        }

        Class newClass = mapper.convertRequestToClass(request);
        newClass.setId(id);
        classRepository.save(newClass);
    }

    public void partiallyUpdateClass(Integer id, ClassRequestDTO request) {
        Optional<Class> exists = classRepository.findById(id);
        if (exists.isPresent()) {
            Class newClass = validation.validator(request, exists.get());

            classRepository.save(newClass);
        } else {
            throw new EntityNotFoundException("Class not found!");
        }
    }

}
