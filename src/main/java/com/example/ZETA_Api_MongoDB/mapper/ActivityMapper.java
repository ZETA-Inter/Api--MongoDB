package com.example.ZETA_Api_MongoDB.mapper;

import com.example.ZETA_Api_MongoDB.dto.ActivityRequestDTO;
import com.example.ZETA_Api_MongoDB.dto.ActivityResponseDTO;
import com.example.ZETA_Api_MongoDB.exception.EntityNotFoundException;
import com.example.ZETA_Api_MongoDB.model.Activity;
import com.example.ZETA_Api_MongoDB.model.Class;
import com.example.ZETA_Api_MongoDB.repository.ClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ActivityMapper {

    private final ClassRepository classRepository;

    public Activity convertRequestToActivity(ActivityRequestDTO request) {
        Activity activity = new Activity();
        activity.setClassId(request.getClassId());
        activity.setImages(request.getImages());
        activity.setPoints(request.getPoints());
        activity.setQuestions(request.getQuestions());
        return activity;
    }

    public ActivityResponseDTO convertActivityToResponse(Activity activity) {
        Class newClass = classRepository.findById(activity.getClassId())
                .orElseThrow(() -> new EntityNotFoundException("Class not found"));

        ActivityResponseDTO response = new ActivityResponseDTO();
        response.setId(activity.getId());
        response.setPoints(activity.getPoints());
        response.setClassTitle(newClass.getTitle());
        return response;
    }

}
