package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.phone=?1 and u.password=?2")
	public Optional<User> verifyPhone(long phone,String password);
	@Query("select u from User u where u.email=?1 and u.password=?2")
	public Optional<User> verifyEmail(String email,String password);
}
