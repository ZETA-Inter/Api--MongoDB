package com.example.ZETA_Api_MongoDB.validation;

import com.example.ZETA_Api_MongoDB.client.PostgresClient;
import com.example.ZETA_Api_MongoDB.dto.ClassRequestDTO;
import com.example.ZETA_Api_MongoDB.dto.ProgramResponseDTO;
import com.example.ZETA_Api_MongoDB.exception.EntityNotFoundException;
import com.example.ZETA_Api_MongoDB.exception.MultipleValidationException;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.example.ZETA_Api_MongoDB.model.Class;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class ClassPatchValidation {

    private final PostgresClient client;

    public Class validator(ClassRequestDTO updates, Class classEntity) {
        Map<String, String> errors = new HashMap<>();

        if (StringUtils.isNotEmpty(updates.getTitle())) {
            if (verifyTitle(updates.getTitle(), errors)) {
                classEntity.setTitle(updates.getTitle());
            }
        }

        if (updates.getContent() != null && !updates.getContent().isEmpty()) {
            classEntity.setContent(updates.getContent());
        }

        if (updates.getFlashcards() != null && !updates.getFlashcards().isEmpty()) {
            classEntity.setFlashcards(updates.getFlashcards());
        }

        if (updates.getLaws() != null && !updates.getLaws().isEmpty()) {
            classEntity.setLaws(updates.getLaws());
        }

        if (updates.getProgramId() != null) {
            ProgramResponseDTO program = client.findProgramById(updates.getProgramId());
            if (program == null) {
                throw new EntityNotFoundException("Program not found");
            }
            classEntity.setProgramId(program.getId());
        }

        if (!errors.isEmpty()) {
            throw new MultipleValidationException(errors);
        }

        return classEntity;

    }

    public boolean verifyTitle(String title, Map<String, String> errors) {
        if (title.length() < 2){
            errors.put("title", "The title should have a minimun of 2 characters");
            return false;
        }
        return true;
    }

}
