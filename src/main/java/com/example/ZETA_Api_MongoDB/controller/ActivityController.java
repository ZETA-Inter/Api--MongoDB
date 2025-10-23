package com.example.ZETA_Api_MongoDB.controller;

import com.example.ZETA_Api_MongoDB.dto.request.ActivityRequestDTO;
import com.example.ZETA_Api_MongoDB.dto.response.ActivityResponseDTO;
import com.example.ZETA_Api_MongoDB.service.ActivityService;
import com.example.ZETA_Api_MongoDB.swagger.ActivityControllerDocs;
import com.example.ZETA_Api_MongoDB.validation.OnCreate;
import com.example.ZETA_Api_MongoDB.validation.OnPatch;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/activities")
public class ActivityController implements ActivityControllerDocs {

    private final ActivityService activityService;

    @GetMapping("/list_all_activity")
    public ResponseEntity<List<ActivityResponseDTO>> listClasses() {
        return ResponseEntity.status(200).body(activityService.listAll());
    }

    @GetMapping("/list_all_activities_by_class_id/{id}")
    public ResponseEntity<List<ActivityResponseDTO>> listAllActivitiesByClassId(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(activityService.listAllActivitiesByClassId(id));
    }

    @GetMapping("/find_activity_by_id/{id}")
    public ResponseEntity<ActivityResponseDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(activityService.findById(id));
    }

    @PostMapping("/create_activity")
    public ResponseEntity<ActivityResponseDTO> create(@RequestBody @Valid ActivityRequestDTO requestDTO) {
        return ResponseEntity.status(201).body(activityService.createActivity(requestDTO));
    }

    @DeleteMapping("/delete_activity_by_id/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        activityService.deleteById(id);
        return ResponseEntity.status(200).body("Activity with ID "+ id +" deleted sucessfully!");
    }

    @PutMapping("/update_activity/{id}")
    public ResponseEntity<String> updateClass(@PathVariable Integer id, @RequestBody @Validated({OnCreate.class, Default.class}) ActivityRequestDTO request) {
        activityService.updateActivity(id, request);
        return ResponseEntity.status(200).body("Activity with ID "+ id +" updated successfully!");
    }

    @PatchMapping("/update_activity/{id}")
    public ResponseEntity<String> partiallyUpdateClass(@PathVariable Integer id, @RequestBody @Validated({OnPatch.class, Default.class}) ActivityRequestDTO request) {
        activityService.partiallyUpdateActivity(id, request);
        return ResponseEntity.status(200).body("Activity with ID "+ id +" partially updated successfully!");
    }

}
