package com.masai.studentManagement.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.studentManagement.module.StudentLoginSession;

public interface StudentLoginSessionDAO extends JpaRepository<StudentLoginSession, Integer> {
	  public Optional<StudentLoginSession> findByUuid(String key);
}
