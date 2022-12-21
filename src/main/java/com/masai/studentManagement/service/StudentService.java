package com.masai.studentManagement.service;

import javax.validation.Valid;

import com.masai.studentManagement.exception.StudentException;
import com.masai.studentManagement.module.Student;
import com.masai.studentManagement.module.dto.StudentDTO;

public interface StudentService {
	
	public Student registerStudent(Student student) throws StudentException;

	

}
