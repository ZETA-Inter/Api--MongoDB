package com.example.ZETA_Api_MongoDB.mapper;

import com.example.ZETA_Api_MongoDB.client.PostgresClient;
import com.example.ZETA_Api_MongoDB.dto.ClassRequestDTO;
import com.example.ZETA_Api_MongoDB.dto.ClassResponseDTO;
import com.example.ZETA_Api_MongoDB.dto.ProgramResponseDTO;
import com.example.ZETA_Api_MongoDB.model.Class;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ClassMapper {

    public Class convertRequestToClass(ClassRequestDTO request) {
        Class retorno = new Class();
        retorno.setProgramId(request.getProgramId());
        retorno.setImages(request.getImages());
        retorno.setTitle(request.getTitle());
        retorno.setText(request.getText());
        retorno.setFlashcards(request.getFlashcards());
        retorno.setLaws(request.getLaws());
        return retorno;
    }

    public ClassResponseDTO convertClassToResponse(Class request, ProgramResponseDTO program) {
        ClassResponseDTO retorno = new ClassResponseDTO();
        retorno.setId(request.getId());
        retorno.setTitle(request.getTitle());
        retorno.setText(request.getText());
        retorno.setProgramName(program.getName());
        return retorno;
    }

}
