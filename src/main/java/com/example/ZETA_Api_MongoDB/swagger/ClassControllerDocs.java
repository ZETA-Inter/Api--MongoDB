package com.example.ZETA_Api_MongoDB.swagger;

import com.example.ZETA_Api_MongoDB.dto.request.ClassRequestDTO;
import com.example.ZETA_Api_MongoDB.dto.response.ClassResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(
        name = "Classes",
        description = "Endpoints for managing class entities, including creation, listing, updating, and deletion."
)
public interface ClassControllerDocs {

    @Operation(
            summary = "List all classes",
            description = "Retrieves a list of all registered classes."
    )
    ResponseEntity<List<ClassResponseDTO>> listClasses();

    @Operation(
            summary = "List all classes by program ID",
            description = "Retrieves all classes associated with a specific program ID."
    )
    ResponseEntity<List<ClassResponseDTO>> listAllClassesByProgramId(Integer id);

    @Operation(
            summary = "Find class by ID",
            description = "Retrieves a single class by its unique ID."
    )
    ResponseEntity<ClassResponseDTO> findById(Integer id);

    @Operation(
            summary = "Create a new class",
            description = "Creates a new class using the provided request data."
    )
    ResponseEntity<ClassResponseDTO> create(ClassRequestDTO classRequestDTO);

    @Operation(
            summary = "Delete class by ID",
            description = "Deletes an existing class by its ID. Requires ADMIN role authorization."
    )
    ResponseEntity<String> delete(Integer id);

    @Operation(
            summary = "Update a class (PUT-like)",
            description = "Performs a full update of an existing class by ID."
    )
    ResponseEntity<String> updateClass(Integer id, ClassRequestDTO classRequestDTO);

    @Operation(
            summary = "Partially update a class (PATCH)",
            description = "Performs a partial update of an existing class by ID."
    )
    ResponseEntity<String> partiallyUpdateClass(Integer id, ClassRequestDTO classRequestDTO);
}
