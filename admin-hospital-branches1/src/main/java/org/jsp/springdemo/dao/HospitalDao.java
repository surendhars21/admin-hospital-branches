package org.jsp.springdemo.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.springdemo.dto.Hospital;
import org.jsp.springdemo.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HospitalDao {
	@Autowired
	private HospitalRepository hospitalRepository;

	public Hospital saveHospital(Hospital hospital) {
		return hospitalRepository.save(hospital);
	}

	public Optional<Hospital> findHospitalById(int id) {
		return hospitalRepository.findById(id);
	}

	public boolean deleteById(int id) {
		Optional<Hospital> recHospital = findHospitalById(id);
		if (recHospital.isPresent()) {
			hospitalRepository.delete(recHospital.get());
			return true;
		}
		return false;
	}

}
