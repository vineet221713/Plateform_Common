package com.masai.studentManagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.studentManagement.module.Student;

public interface StudentDAO extends JpaRepository<Student, Integer> {
	
	@Query("from Student s where s.name LIKE %:name% ") 
	 public List<Student> getStudentsByName(String name) ;

}
