package org.jsp.springdemo.repository;

import org.jsp.springdemo.dto.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
