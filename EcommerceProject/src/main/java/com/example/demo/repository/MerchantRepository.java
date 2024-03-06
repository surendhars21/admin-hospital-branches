package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Merchant;

public interface MerchantRepository extends JpaRepository<Merchant, Integer>{

	@Query("select m from Merchant m where m.phone=?1 and m.password=?2")
	public Optional<Merchant> verifyPhone(long phone,String password);
	
	@Query("select m from Merchant m where m.email=?1 and m.password=?2")
	public Optional<Merchant> verifyEmail(String email,String password);
}
