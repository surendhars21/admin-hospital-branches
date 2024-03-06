package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Merchant;
import com.example.demo.repository.MerchantRepository;

@Repository
public class MerchantDao {

	@Autowired
	private MerchantRepository repository;
	
	public Merchant saveMarchant(Merchant merchant) {
		return repository.save(merchant);
	}
	
	public Optional<Merchant> findById(int id) {
		return repository.findById(id);
	}
	public boolean deleteById(int id){
		Optional<Merchant> recMerchant=repository.findById(id);
		 if(recMerchant.isPresent()) {
			 repository.delete(recMerchant.get());
			 return true;
		 }
		 return false;
	}
	public List<Merchant> findAll(){
		return repository.findAll();
	}
	
	public Optional<Merchant> verifyPhone(long phone,String password){
		return repository.verifyPhone(phone, password);
	}
	public Optional<Merchant> verifyEmail(String email,String password){
		return repository.verifyEmail(email, password);
	}
}
