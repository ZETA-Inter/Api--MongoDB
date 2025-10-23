package com.example.ZETA_Api_MongoDB.swagger;

import com.example.ZETA_Api_MongoDB.dto.request.ActivityRequestDTO;
import com.example.ZETA_Api_MongoDB.dto.response.ActivityResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(
        name = "Activities",
        description = "Endpoints for managing activities, including creation, listing, updating, and deletion."
)
public interface ActivityControllerDocs {

    @Operation(
            summary = "List all activities",
            description = "Retrieves a list of all registered activities."
    )
    ResponseEntity<List<ActivityResponseDTO>> listClasses();

    @Operation(
            summary = "List activities by class ID",
            description = "Retrieves all activities associated with a specific class ID."
    )
    ResponseEntity<List<ActivityResponseDTO>> listAllActivitiesByClassId(Integer id);

    @Operation(
            summary = "Find activity by ID",
            description = "Retrieves a single activity by its unique ID."
    )
    ResponseEntity<ActivityResponseDTO> findById(Integer id);

    @Operation(
            summary = "Create a new activity",
            description = "Creates a new activity using the provided request data."
    )
    ResponseEntity<ActivityResponseDTO> create(ActivityRequestDTO requestDTO);

    @Operation(
            summary = "Delete activity by ID",
            description = "Deletes an existing activity by its ID. Requires ADMIN role authorization."
    )
    ResponseEntity<String> delete(Integer id);

    @Operation(
            summary = "Update an activity (PUT-like)",
            description = "Performs a full update of an existing activity by ID."
    )
    ResponseEntity<String> updateClass(Integer id, ActivityRequestDTO request);

    @Operation(
            summary = "Partially update an activity (PATCH)",
            description = "Performs a partial update of an existing activity by ID."
    )
    ResponseEntity<String> partiallyUpdateClass(Integer id, ActivityRequestDTO request);
}