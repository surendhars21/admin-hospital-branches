package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseStructure;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseStructure<User> saveUser(@RequestBody User user){
		return service.saveUser(user);
	}
	
	@PutMapping
	public ResponseStructure<User> updateUser(@RequestBody User user){
		return service.updateUser(user);
	}
	
	@GetMapping("/{id}")
	public ResponseStructure<User> findById(@PathVariable int id){
		return service.findById(id);
	}
	@GetMapping
    public ResponseStructure<List<User>> findAll(){
    	return service.findAll();
    }
}

