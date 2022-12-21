package com.masai.studentManagement.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.studentManagement.module.AdminLoginSession;

public interface LoginSessionDAO extends JpaRepository<AdminLoginSession, Integer>{
	
	  public Optional<AdminLoginSession> findByUuid(String key);

}
