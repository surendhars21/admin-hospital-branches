package org.jsp.springdemo.controller;

import java.util.List;

import org.jsp.springdemo.dto.Hospital;
import org.jsp.springdemo.dto.ResponseStructure;
import org.jsp.springdemo.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hospital")
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseStructure<Hospital> saveHospital(@RequestBody Hospital hospital) {
        return hospitalService.saveHospital(hospital);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Hospital>> findHospitalById(@PathVariable int id) {
        return hospitalService.findHospitalById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteHospital(@PathVariable int id) {
        return hospitalService.deleteById(id);
    }
}

