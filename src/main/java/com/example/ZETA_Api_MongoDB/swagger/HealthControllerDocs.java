package com.example.ZETA_Api_MongoDB.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(
        name = "Health",
        description = "Provides a simple health check endpoint to verify that the API is running."
)
public interface HealthControllerDocs {

    @Operation(
            summary = "Health check",
            description = "Returns a simple OK response to confirm that the API is operational."
    )
    ResponseEntity<String> health();
}
