package com.example.company.controller;

import com.example.company.model.Company;
import com.example.company.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class CompanyController {

    @Autowired
    private IService iService;

    @GetMapping
    private ResponseEntity<List<Company>> findAll() {
        return new ResponseEntity<>(iService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(iService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<?> createCompany(@RequestBody Company company) {
        return new ResponseEntity<>(iService.save(company), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<?> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        company.setId(id);
        iService.save(company);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<?> deleteCompany(@PathVariable Long id) {
        iService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
