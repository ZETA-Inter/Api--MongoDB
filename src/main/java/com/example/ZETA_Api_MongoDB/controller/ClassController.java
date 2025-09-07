package com.example.ZETA_Api_MongoDB.controller;

import com.example.ZETA_Api_MongoDB.dto.ClassRequestDTO;
import com.example.ZETA_Api_MongoDB.dto.ClassResponseDTO;
import com.example.ZETA_Api_MongoDB.service.ClassService;
import com.example.ZETA_Api_MongoDB.validation.OnCreate;
import com.example.ZETA_Api_MongoDB.validation.OnPatch;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping(name = "/api/classes")
public class ClassController {

    private final ClassService classService;

    @GetMapping("/list_all_class")
    public ResponseEntity<List<ClassResponseDTO>> listClasses() {
        return ResponseEntity.status(200).body(classService.listAll());
    }

    @GetMapping("/find_class_by_id/{id}")
    public ResponseEntity<ClassResponseDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(classService.findById(id));
    }

    @PostMapping("/create_class")
    public ResponseEntity<ClassResponseDTO> create(@RequestBody @Valid ClassRequestDTO classRequestDTO) {
        return ResponseEntity.status(201).body(classService.createClass(classRequestDTO));
    }

    @DeleteMapping("/delete_class_by_id/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        classService.deleteById(id);
        return ResponseEntity.status(200).body("Class with ID "+ id +" deleted sucessfully!");
    }

    @PostMapping("/update_class/{id}")
    public ResponseEntity<String> updateClass(@PathVariable Integer id, @RequestBody @Validated({OnCreate.class, Default.class}) ClassRequestDTO classRequestDTO) {
        classService.updateClass(id, classRequestDTO);
        return ResponseEntity.status(200).body("Class with ID "+ id +" updated successfully!");
    }

    @PatchMapping("/update_class/{id}")
    public ResponseEntity<String> partiallyUpdateClass(@PathVariable Integer id, @RequestBody @Validated({OnPatch.class, Default.class}) ClassRequestDTO classRequestDTO) {
        classService.partiallyUpdateClass(id, classRequestDTO);
        return ResponseEntity.status(200).body("Class with ID "+ id +" partially updated successfully!");
    }

}
