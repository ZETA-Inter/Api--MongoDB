package com.example.ZETA_Api_MongoDB.mapper;

import com.example.ZETA_Api_MongoDB.dto.request.ActivityRequestDTO;
import com.example.ZETA_Api_MongoDB.dto.response.ActivityResponseDTO;
import com.example.ZETA_Api_MongoDB.model.Activity;
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
        activity.setPoints(request.getPoints());
        activity.setQuestions(request.getQuestions());
        return activity;
    }

    public ActivityResponseDTO convertActivityToResponse(Activity activity) {
        ActivityResponseDTO response = new ActivityResponseDTO();
        response.setId(activity.getId());
        response.setQuestions(activity.getQuestions());
        response.setPoints(activity.getPoints());
        return response;
    }

}
