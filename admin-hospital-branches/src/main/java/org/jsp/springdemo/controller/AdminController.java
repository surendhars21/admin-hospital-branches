package org.jsp.springdemo.controller;

import java.util.List;

import org.jsp.springdemo.dto.Admin;
import org.jsp.springdemo.dto.ResponseStructure;
import org.jsp.springdemo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService service;
	
	@PostMapping
	public ResponseStructure<Admin> saveAdmin(@RequestBody Admin admin) {
		return service.saveAdmin(admin);
	}
	
	@PutMapping
	public ResponseStructure<Admin> updateAdmin(@RequestBody Admin admin){
		return service.saveAdmin(admin);
	}
	
	@GetMapping("/{id}")
	public ResponseStructure<Admin> findById(@PathVariable(name="id") int id){
		return service.findById(id);
	}
	
	@GetMapping
	public ResponseStructure<List<Admin>> findAll(){
     return service.findAll();		
	}
}







