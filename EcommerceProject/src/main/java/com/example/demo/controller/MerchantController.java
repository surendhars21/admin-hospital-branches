package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseStructure;
import com.example.demo.model.Merchant;
import com.example.demo.service.MerchantService;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

	@Autowired
	private MerchantService service;
	
	@PostMapping
	public ResponseStructure<Merchant> saveMerchant(@RequestBody Merchant merchant){
		return service.saveMerchant(merchant);
	}
	@PutMapping
	public ResponseStructure<Merchant> updateMerchant(@RequestBody Merchant merchant){
		return service.updateMerchant(merchant);
	}
	
	@GetMapping("{id}")
	public ResponseStructure<Merchant> findById(@PathVariable(name="id") int id){
		return service.findById(id);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ResponseStructure<Merchant>> deleteById(@PathVariable(name="id") int id){
		return service.deleteById(id);
	}
	
	@GetMapping
	public ResponseStructure<List<Merchant>> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/by-verifyPhone")
	public ResponseStructure<Merchant> verifyPhone(@RequestParam long phone,@RequestParam String password){
		return service.verifyPhone(phone, password);
	}
	

	@GetMapping("/by-verifyEmail")
	public ResponseStructure<Merchant> verifyEmail(@RequestParam String email,@RequestParam String password){
		return service.verifyEmail(email, password);
	}
}
