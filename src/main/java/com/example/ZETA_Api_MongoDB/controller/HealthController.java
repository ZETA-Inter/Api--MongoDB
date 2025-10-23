package com.example.ZETA_Api_MongoDB.controller;

import com.example.ZETA_Api_MongoDB.swagger.HealthControllerDocs;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/health")
public class HealthController implements HealthControllerDocs {

    @GetMapping
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }

}

