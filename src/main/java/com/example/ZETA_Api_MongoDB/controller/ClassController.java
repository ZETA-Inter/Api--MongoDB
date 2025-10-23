package com.example.ZETA_Api_MongoDB.controller;

import com.example.ZETA_Api_MongoDB.dto.request.ClassRequestDTO;
import com.example.ZETA_Api_MongoDB.dto.response.ClassResponseDTO;
import com.example.ZETA_Api_MongoDB.service.ClassService;
import com.example.ZETA_Api_MongoDB.swagger.ClassControllerDocs;
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
@RequestMapping("/api/classes")
public class ClassController implements ClassControllerDocs {

    private final ClassService classService;

    @GetMapping("/list-all-class")
    public ResponseEntity<List<ClassResponseDTO>> listClasses() {
        return ResponseEntity.status(200).body(classService.listAll());
    }

    @GetMapping("/list-all-class-by-program-id/{id}")
    public ResponseEntity<List<ClassResponseDTO>> listAllClassesByProgramId(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(classService.listAllClassesByProgramId(id));
    }

    @GetMapping("/find-class-by-id/{id}")
    public ResponseEntity<ClassResponseDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(classService.findById(id));
    }

    @PostMapping("/create-class")
    public ResponseEntity<ClassResponseDTO> create(@RequestBody @Valid ClassRequestDTO classRequestDTO) {
        return ResponseEntity.status(201).body(classService.createClass(classRequestDTO));
    }

    @DeleteMapping("/delete-class-by-id/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        classService.deleteById(id);
        return ResponseEntity.status(200).body("Class with ID "+ id +" deleted sucessfully!");
    }

    @PutMapping("/update-class/{id}")
    public ResponseEntity<String> updateClass(@PathVariable Integer id, @RequestBody @Validated({OnCreate.class, Default.class}) ClassRequestDTO classRequestDTO) {
        classService.updateClass(id, classRequestDTO);
        return ResponseEntity.status(200).body("Class with ID "+ id +" updated successfully!");
    }

    @PatchMapping("/update-class/{id}")
    public ResponseEntity<String> partiallyUpdateClass(@PathVariable Integer id, @RequestBody @Validated({OnPatch.class, Default.class}) ClassRequestDTO classRequestDTO) {
        classService.partiallyUpdateClass(id, classRequestDTO);
        return ResponseEntity.status(200).body("Class with ID "+ id +" partially updated successfully!");
    }

}
