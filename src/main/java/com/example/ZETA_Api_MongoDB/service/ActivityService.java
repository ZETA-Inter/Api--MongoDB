package com.example.ZETA_Api_MongoDB.service;

import com.example.ZETA_Api_MongoDB.dto.*;
import com.example.ZETA_Api_MongoDB.exception.EntityNotFoundException;
import com.example.ZETA_Api_MongoDB.mapper.ActivityMapper;
import com.example.ZETA_Api_MongoDB.model.Activity;
import com.example.ZETA_Api_MongoDB.repository.ActivityRepository;
import com.example.ZETA_Api_MongoDB.validation.ActivityPatchValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    private final ActivityMapper mapper;

    private final ActivityPatchValidation validation;

    private final SequenceGeneratorService sequenceGenerator;

    public List<ActivityResponseDTO> listAll() {
        return activityRepository.findAll()
                .stream()
                .map(c -> mapper.convertActivityToResponse(c))
                .toList();
    }

    public ActivityResponseDTO findById(Integer id) {
        Activity activity = activityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Activity not found"));

        return mapper.convertActivityToResponse(activity);
    }

    public ActivityResponseDTO createActivity(ActivityRequestDTO request) {
        Activity activity = mapper.convertRequestToActivity(request);
        activity.setId(sequenceGenerator.getNextSequence("activity"));
        activityRepository.save(activity);
        return mapper.convertActivityToResponse(activity);
    }

    public void deleteById(Integer id) {
        if (!activityRepository.existsById(id)) {
            throw new EntityNotFoundException("Activity not found!");
        }
        activityRepository.deleteById(id);
    }

    public void updateActivity(Integer id, ActivityRequestDTO request) {
        Activity exists = activityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Activity not found!"));
        Activity newClass = mapper.convertRequestToActivity(request);
        newClass.setId(id);
        activityRepository.save(newClass);
    }

    public void partiallyUpdateActivity(Integer id, ActivityRequestDTO request) {
        Optional<Activity> exists = activityRepository.findById(id);
        if (exists.isPresent()) {
            Activity newActivity = validation.validator(request, exists.get());

            activityRepository.save(newActivity);
        } else {
            throw new EntityNotFoundException("Activity not found!");
        }
    }

}
