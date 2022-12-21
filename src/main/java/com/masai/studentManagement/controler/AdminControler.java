package com.masai.studentManagement.controler;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.studentManagement.exception.CourseException;
import com.masai.studentManagement.exception.LoginException;
import com.masai.studentManagement.exception.StudentException;
import com.masai.studentManagement.module.Admin;
import com.masai.studentManagement.module.Course;
import com.masai.studentManagement.module.Student;
import com.masai.studentManagement.module.dto.CourseDTO;
import com.masai.studentManagement.module.dto.StudentCourseDTO;
import com.masai.studentManagement.service.AdminService;
import com.masai.studentManagement.service.LoginService;
import com.masai.studentManagement.service.StudentService;

@RestController
public class AdminControler {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private StudentService studentService;
	
	
	
	
	
	
	@PostMapping("/admin/register")
	public ResponseEntity<Admin> adminRegisterHandler(@RequestBody Admin admin){
		    
		   return new ResponseEntity<Admin>(adminService.adminRegister(admin), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/courses/add")
	public ResponseEntity<Course> addCourseHandler(@Valid @RequestBody Course course, @RequestParam String key) throws CourseException, LoginException {
		
		Course savedCourse = adminService.addCourse(course, key);
		
		return new ResponseEntity<Course>(savedCourse,HttpStatus.CREATED) ;
	}
	
	@PutMapping("/courses/assgign")
	public ResponseEntity<StudentCourseDTO> assginStudentToCourseHandler(@RequestParam("studentId") Integer sttudentId,
																	@RequestParam("courseId") Integer courseId,@RequestParam String key) throws CourseException, StudentException, LoginException {
		
		StudentCourseDTO assignedCourse =  adminService.assignCourseToStudent(sttudentId, courseId,key) ;
		
		return new ResponseEntity<StudentCourseDTO>(assignedCourse,HttpStatus.OK) ;
	}
	
	@GetMapping("/students/")
	public ResponseEntity<List<Student>> getStudentsByNameHandler(@RequestParam("name") String name, String key)
			throws StudentException, LoginException {

		List<Student> studentsList = adminService.getStudentByName(name,key);

		return new ResponseEntity<List<Student>>(studentsList, HttpStatus.OK);
	}
	
	

}
