package org.jsp.springdemo.service;

import java.util.Optional;

import org.jsp.springdemo.dao.HospitalDao;
import org.jsp.springdemo.dto.Hospital;
import org.jsp.springdemo.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
    @Autowired
    private HospitalDao hospitalDao;

    public ResponseStructure<Hospital> saveHospital(Hospital hospital) {
        ResponseStructure<Hospital> structure = new ResponseStructure<>();
        structure.setMessage("Hospital saved");
        structure.setData(hospitalDao.saveHospital(hospital));
        structure.setStatuscode(HttpStatus.CREATED.value());
        return structure;
    }

    public ResponseEntity<ResponseStructure<Hospital>> findHospitalById(int id) {
        Optional<Hospital> recHospital = hospitalDao.findHospitalById(id);
        ResponseStructure<Hospital> structure = new ResponseStructure<>();
        if (recHospital.isPresent()) {
            structure.setData(recHospital.get());
            structure.setMessage("Hospital Found");
            structure.setStatuscode(HttpStatus.OK.value());
            return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
        } else {
            structure.setMessage("Hospital not found");
            structure.setStatuscode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<ResponseStructure<String>> deleteById(int id) {
        Optional<Hospital> recHospital = hospitalDao.findHospitalById(id);
        ResponseStructure<String> structure = new ResponseStructure<>();
        if (recHospital.isPresent()) {
            structure.setMessage("Hospital found");
            structure.setData("Hospital deleted");
            structure.setStatuscode(HttpStatus.OK.value());
            hospitalDao.deleteById(id);
            return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
        } else {
            structure.setMessage("Hospital not found");
            structure.setData("Cannot delete hospital as ID is invalid");
            structure.setStatuscode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
        }
    }
    
 
}
