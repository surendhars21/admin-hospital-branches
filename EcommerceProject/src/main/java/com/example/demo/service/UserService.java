package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.ResponseStructure;
import com.example.demo.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public ResponseStructure<User> saveUser(User user) {
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setData(userDao.saveUser(user));
		structure.setMessage("User saved Successfully...");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return structure;
	}
	public ResponseStructure<User> updateUser(User user){
		ResponseStructure<User> structure=new ResponseStructure<>();
		Optional<User> recUser=userDao.findById(user.getId());
		if(recUser.isPresent()) {
			User userdb=recUser.get();
			userdb.setAge(user.getAge());
			userdb.setEmail(user.getEmail());
			userdb.setGender(user.getGender());
			userdb.setName(user.getName());
			userdb.setPassword(user.getPassword());
			userdb.setPhone(user.getPhone());
			userdb.setStatus(user.getStatus());
			structure.setData(userDao.saveUser(userdb));
			structure.setMessage("Update successfully.....");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return structure;
		}
		structure.setMessage("Invalid user id.....");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return structure;
	}
	public ResponseStructure<User> findById(int id){
		ResponseStructure<User> structure=new ResponseStructure<>();
		Optional<User> recUser=userDao.findById(id);
		if(recUser.isPresent()) {
			structure.setData(recUser.get());
			structure.setMessage("User Found.........");
			structure.setStatusCode(HttpStatus.OK.value());
			return structure;
		}
		structure.setMessage("Invalid user id.....");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return structure;
	}
	public ResponseStructure<User> verifyPhone(long phone,String password){
		ResponseStructure<User> structure=new ResponseStructure<>();
		Optional<User> recUser=userDao.verifyPhone(phone, password);
		if(recUser.isPresent()) {
			structure.setData(recUser.get());
			structure.setMessage("User Found.........");
			structure.setStatusCode(HttpStatus.OK.value());
			return structure;
		}
		structure.setMessage("Invalid user id.....");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return structure;
	}
	public ResponseStructure<User> verifyEmail(String email,String password){
		ResponseStructure<User> structure=new ResponseStructure<>();
		Optional<User> recUser=userDao.verifyEmail(email, password);
		if(recUser.isPresent()) {
			structure.setData(recUser.get());
			structure.setMessage("User Found.........");
			structure.setStatusCode(HttpStatus.OK.value());
			return structure;
		}
		structure.setMessage("Invalid user id.....");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return structure;
	}
	
	public ResponseStructure<List<User>> findAll(){
		ResponseStructure<List<User>> structure=new ResponseStructure<>();
		List<User> user=userDao.findAll();
		if(user.size()>0) {
			structure.setData(user);
			structure.setMessage("List of All user......");
			structure.setStatusCode(HttpStatus.OK.value());
			return structure;
		}
		structure.setMessage("No data in your database.");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return structure;
		
	}
}
