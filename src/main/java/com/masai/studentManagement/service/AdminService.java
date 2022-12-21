package com.masai.studentManagement.service;

import java.util.List;

import com.masai.studentManagement.exception.CourseException;
import com.masai.studentManagement.exception.LoginException;
import com.masai.studentManagement.exception.StudentException;
import com.masai.studentManagement.module.Admin;
import com.masai.studentManagement.module.Course;
import com.masai.studentManagement.module.Student;
import com.masai.studentManagement.module.dto.AdminDTO;
import com.masai.studentManagement.module.dto.CourseDTO;
import com.masai.studentManagement.module.dto.CourseStudent;
import com.masai.studentManagement.module.dto.StudentCourseDTO;

public interface AdminService {
	
	public Admin adminRegister(Admin admin);
//	public CourseDTO addCourse(CourseDTO courseDTO, String key) throws CourseException, LoginException;
	public Course addCourse(Course course, String key) throws CourseException, LoginException;
	
	public StudentCourseDTO assignCourseToStudent(Integer studentId,Integer courseId, String key) throws CourseException, StudentException, LoginException;
	
   public Student getStudentById(Integer studentId) throws StudentException ;

	public List<Course> getAllCoursesAdminPurpose(Integer studentId) throws StudentException ;
	
	
	public StudentCourseDTO coursesToStudentCourse(List<Course> courses,Student student) ;
	
	  public List<Student> getStudentByName(String name, String key) throws StudentException, LoginException;
	  
	  public CourseStudent getStudentsFromCourse(Integer courseId, String key) throws CourseException;

}
