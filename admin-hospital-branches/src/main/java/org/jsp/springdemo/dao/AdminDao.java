package org.jsp.springdemo.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.springdemo.dto.Admin;
import org.jsp.springdemo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {

	@Autowired
	private AdminRepository repository;
	
	public Admin saveAdmin(Admin admin) {
		return repository.save(admin);
	}
	
	public Optional<Admin> findById(int id){
		return repository.findById(id);
	}
	
	public List<Admin> findAll(){
		return repository.findAll();
	}
}
