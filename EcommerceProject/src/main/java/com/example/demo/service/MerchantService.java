package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.dao.MerchantDao;
import com.example.demo.dto.ResponseStructure;
import com.example.demo.model.Merchant;

@Service
public class MerchantService {

	@Autowired
	private MerchantDao merchantDao;
	
	public ResponseStructure<Merchant> saveMerchant(Merchant merchant) {
		ResponseStructure<Merchant> structure=new ResponseStructure<>();
		structure.setData(merchantDao.saveMarchant(merchant));
		structure.setMessage("Merchant saved successfully....");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return structure;
	}
	
	public ResponseStructure<Merchant> updateMerchant(Merchant merchant){
		ResponseStructure<Merchant> structure=new ResponseStructure<>();
		Optional<Merchant> recMerchant=merchantDao.findById(merchant.getId());
		if(recMerchant.isPresent()) {
			Merchant merchantdb=recMerchant.get();
			merchantdb.setEmail(merchant.getEmail());
			merchantdb.setGstNo(merchant.getGstNo());
			merchantdb.setName(merchant.getName());
			merchantdb.setPassword(merchant.getPassword());
			merchantdb.setStatus(merchant.getStatus());
			structure.setData(merchantDao.saveMarchant(merchantdb));
			structure.setMessage("Updated merchant..........");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return structure;
		}
		structure.setMessage("Invalid merchant id.....");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return structure;	
	}
	
	public ResponseStructure<Merchant> findById(int id){
		ResponseStructure<Merchant> structure=new ResponseStructure<>();
		Optional<Merchant> recMerchant=merchantDao.findById(id);
		if(recMerchant.isPresent()) {
           structure.setData(recMerchant.get());
           structure.setMessage("Merchant found...........");
           structure.setStatusCode(HttpStatus.OK.value());
           return structure;
		}
		structure.setMessage("Invalid merchant id.........");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return structure;
	}
	
	public ResponseEntity<ResponseStructure<Merchant>> deleteById(int id) {
		ResponseStructure<Merchant> structure=new ResponseStructure<>();
		Optional<Merchant> recMerchant=merchantDao.findById(id);
		if(recMerchant.isPresent())
		{
			merchantDao.deleteById(id);
			structure.setMessage("Deleted successfully.......");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.OK);
		}
		structure.setMessage("Invalid merchant id.......");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.NOT_FOUND);
	}
   public ResponseStructure<List<Merchant>> findAll(){
	   ResponseStructure<List<Merchant>> structure=new ResponseStructure<>();
	   List<Merchant> merchant=merchantDao.findAll();
	   if(merchant.size()>0) {
		   structure.setData(merchant);
		   structure.setMessage("List of all the merchant");
		   structure.setStatusCode(HttpStatus.OK.value());
		   return structure;
	   }
	   structure.setMessage("No data of your database");
	   structure.setStatusCode(HttpStatus.NOT_FOUND.value());
	   return structure;
   }
   
   public ResponseStructure<Merchant> verifyPhone(long phone,String password){
	 ResponseStructure<Merchant> structure=new ResponseStructure<>();
	   Optional<Merchant> recMerchant=merchantDao.verifyPhone(phone, password);
	   if(recMerchant.isPresent()) {
		   structure.setData(recMerchant.get());
		   structure.setMessage("Merchant found......");
		   structure.setStatusCode(HttpStatus.OK.value());
		   return structure;
	   }
	   structure.setMessage("Invalid phone or password......");
	   structure.setStatusCode(HttpStatus.NOT_FOUND.value());
	   return structure;
   }
   public ResponseStructure<Merchant> verifyEmail(String email,String password){
		 ResponseStructure<Merchant> structure=new ResponseStructure<>();
		   Optional<Merchant> recMerchant=merchantDao.verifyEmail(email, password);
		   if(recMerchant.isPresent()) {
			   structure.setData(recMerchant.get());
			   structure.setMessage("Merchant found......");
			   structure.setStatusCode(HttpStatus.OK.value());
			   return structure;
		   }
		   structure.setMessage("Invalid phone or password......");
		   structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		   return structure;
	   }

}



