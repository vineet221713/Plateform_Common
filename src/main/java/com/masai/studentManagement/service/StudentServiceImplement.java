package com.masai.studentManagement.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.studentManagement.exception.StudentException;
import com.masai.studentManagement.module.Student;
import com.masai.studentManagement.module.dto.StudentDTO;
import com.masai.studentManagement.repo.AddressDAO;
import com.masai.studentManagement.repo.CourseDAO;
import com.masai.studentManagement.repo.LoginSessionDAO;
import com.masai.studentManagement.repo.StudentDAO;


@Service
public class StudentServiceImplement implements StudentService{

	   @Autowired
       private StudentDAO  studentDao;
	   
	   @Autowired
	   private CourseDAO courseDao;
	   
	   @Autowired
	   private AddressDAO addressDao;
	   
	   @Autowired
	   private LoginSessionDAO loginSessionDao;
	   
	 
//	@Autowired (required = true)
//		private ModelMapper modelMapper;// have to look about this
	   
	   
	@Override
	public Student registerStudent(Student student) throws StudentException {
		   
//		    Student student= dtoToStudent(studentDto);
//		    student = studentDao.save(student);
//		    
//		    return studentToDTO(student);
		
		Student studentSave= studentDao.save(student);
		return studentSave;
		    
		          
	}
	
//	public Student dtoToStudent(StudentDTO studentDTO) {
//		 
//		return this.modelMapper.map(studentDTO, Student.class);
//	}
//	
//	public StudentDTO studentToDTO(Student student) {
//		return this.modelMapper.map(student, StudentDTO.class);
//	}
	
//	public Student dtoToStudent(StudentDTO studentDTO) {
//		return this.modelMapper.map(studentDTO, Student.class);
//	}
//	
//	public StudentDTO studentToDTO(Student student) {
//		return this.modelMapper.map(student, StudentDTO.class);
//	}

}
