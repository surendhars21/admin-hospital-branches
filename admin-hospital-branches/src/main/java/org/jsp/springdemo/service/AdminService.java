package org.jsp.springdemo.service;

import java.util.List;
import java.util.Optional;

import org.jsp.springdemo.dao.AdminDao;
import org.jsp.springdemo.dto.Admin;
import org.jsp.springdemo.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	
	public ResponseStructure<Admin> saveAdmin(Admin admin){
		ResponseStructure<Admin> structure=new ResponseStructure<>();
		structure.setData(adminDao.saveAdmin(admin));
		structure.setMessage("Admin saved Successfully.....");
		structure.setStatuscode(HttpStatus.CREATED.value());
		return structure;
	}
	
	public ResponseStructure<Admin> updateAdmin(Admin admin){
	ResponseStructure<Admin> structure=new ResponseStructure<>();
	Optional<Admin> recAdmin=adminDao.findById(admin.getId());
	if(recAdmin.isPresent()) {
	Admin admindb=recAdmin.get();
	admindb.setEmail(admin.getEmail());
	admindb.setName(admin.getName());
	admindb.setPassword(admin.getPassword());
	admindb.setPhone(admin.getPhone());
	structure.setData(adminDao.saveAdmin(admindb));
	structure.setMessage("Admin Updated successfully......");
	structure.setStatuscode(HttpStatus.ACCEPTED.value());
	return structure;
	}
	structure.setMessage("Invalid admin id ......");
	structure.setStatuscode(HttpStatus.NOT_FOUND.value());
	return structure;
	}
	
	public ResponseStructure<Admin> findById(int id){
		ResponseStructure<Admin> structure=new ResponseStructure<>();
		Optional<Admin> recAdmin=adminDao.findById(id);
		if(recAdmin.isPresent()) {
			structure.setData(recAdmin.get());
			structure.setMessage("Admin found......");
            structure.setStatuscode(HttpStatus.OK.value());
            return structure;
		}
		structure.setMessage("Invalid admin id......");
        structure.setStatuscode(HttpStatus.NOT_FOUND.value());
        return structure;
	}
	
	public ResponseStructure<List<Admin>> findAll(){
		ResponseStructure<List<Admin>> structure=new ResponseStructure<>();
		structure.setData(adminDao.findAll());
		structure.setMessage("List of all admin.............");
		structure.setStatuscode(HttpStatus.OK.value());
		return structure;
	}
}










