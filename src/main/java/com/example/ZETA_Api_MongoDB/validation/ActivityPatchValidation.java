package com.example.ZETA_Api_MongoDB.validation;

import com.example.ZETA_Api_MongoDB.dto.ActivityRequestDTO;
import com.example.ZETA_Api_MongoDB.exception.EntityNotFoundException;
import com.example.ZETA_Api_MongoDB.exception.MultipleValidationException;
import com.example.ZETA_Api_MongoDB.model.Activity;
import com.example.ZETA_Api_MongoDB.model.Class;
import com.example.ZETA_Api_MongoDB.repository.ClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class ActivityPatchValidation {

    private final ClassRepository classRepository;

    public Activity validator(ActivityRequestDTO updates, Activity activity) {
        Map<String, String> errors = new HashMap<>();

        if (updates.getQuestions() != null && !updates.getQuestions().isEmpty()) {
            activity.setQuestions(updates.getQuestions());
        }

        if (updates.getPoints() != null) {
            if (verifyPoints(updates.getPoints(), errors)) {
                activity.setPoints(updates.getPoints());
            }
        }

        if (updates.getQuestions() != null && !updates.getQuestions().isEmpty()) {
            activity.setQuestions(updates.getQuestions());
        }

        if (updates.getClassId() != null) {
            Class classs = classRepository.findById(updates.getClassId())
                    .orElseThrow(() -> new EntityNotFoundException("Class not found!"));
            activity.setClassId(updates.getClassId());
        }

        if (!errors.isEmpty()) {
            throw new MultipleValidationException(errors);
        }

        return activity;

    }

    public boolean verifyPoints(Integer points, Map<String, String> errors) {
        if (points <= 0) {
            errors.put("points", "'points' must be greather than 0");
            return false;
        }
        return true;
    }

}
