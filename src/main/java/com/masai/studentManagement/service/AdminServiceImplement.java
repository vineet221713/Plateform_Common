package com.masai.studentManagement.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.studentManagement.exception.CourseException;
import com.masai.studentManagement.exception.LoginException;
import com.masai.studentManagement.exception.StudentException;
import com.masai.studentManagement.module.Admin;
import com.masai.studentManagement.module.AdminLoginSession;
import com.masai.studentManagement.module.Course;
import com.masai.studentManagement.module.Student;
import com.masai.studentManagement.module.dto.CourseDTO;
import com.masai.studentManagement.module.dto.StudentCourseDTO;
import com.masai.studentManagement.module.dto.StudentDTO;
import com.masai.studentManagement.repo.AdminDAO;
import com.masai.studentManagement.repo.CourseDAO;
import com.masai.studentManagement.repo.LoginSessionDAO;
import com.masai.studentManagement.repo.StudentDAO;

@Service
public class AdminServiceImplement implements AdminService {
	
	@Autowired
	  private AdminDAO adminDao;
	
	@Autowired
	private LoginSessionDAO loginSessionDao;
	
	@Autowired
	private StudentDAO studentDao;
	
//	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired
	private CourseDAO courseDao;
	
	@Autowired
	private StudentService studentService;
	
	
	  
	@Override
	public Admin adminRegister(Admin admin) {
		
		          Admin saveAdmin= adminDao.save(admin);
		          
		          return saveAdmin;
	}

	@Override
	public Course addCourse(Course course, String key) throws CourseException, LoginException {
		
		Optional<AdminLoginSession> adminLoginSession= loginSessionDao.findByUuid(key);
        if(adminLoginSession.isEmpty())
	     {
	    	 throw new LoginException("Unathrosied access denied.");
	     }
        
           Course courseSave= courseDao.save(course);
           
           return courseSave;
           
	}

	@Override
	public StudentCourseDTO assignCourseToStudent(Integer studentId, Integer courseId, String key)
			throws CourseException, StudentException, LoginException {
		
		Optional<AdminLoginSession> adminLoginSession= loginSessionDao.findByUuid(key);
        if(adminLoginSession.isEmpty())
	     {
	    	 throw new LoginException("Unathrosied access denied.");
	     }
		
		Course course =  courseDao.findById(courseId).orElseThrow(()-> new CourseException("Invalid CourseId "+ courseId)) ;
		Student student = studentDao.getById(studentId);
				
		course.getStudents().add(student);
		Course updatedCourseDetails = courseDao.save(course);
		
		List<Course> studentCourses = getAllCoursesAdminPurpose(studentId) ;
		
		StudentCourseDTO studentCourseDetails = coursesToStudentCourse(studentCourses, student);
		
		   return studentCourseDetails;
	}

	@Override
	public Student getStudentById(Integer studentId) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> getAllCoursesAdminPurpose(Integer studentId) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public StudentCourseDTO coursesToStudentCourse(List<Course> courses, Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudentByName(String name, String key) throws LoginException, StudentException {
		
		Optional<AdminLoginSession> adminLoginSession= loginSessionDao.findByUuid(key);
        if(adminLoginSession.isEmpty())
	     {
	    	 throw new LoginException("Unathrosied access denied.");
	     }
        
           List<Student>  student= studentDao.getStudentsByName(name);
           
           if(student.isEmpty())
           {
        	    throw new StudentException("Student not found..");
           }
		    return student;
	}

	

//	@Override
//	public CourseDTO addCourse(CourseDTO courseDTO, String key) throws CourseException, LoginException {
//		
//		     Optional<AdminLoginSession> adminLoginSession= loginSessionDao.findByUuid(key);
//		     if(adminLoginSession.isEmpty())
//		     {
//		    	 throw new LoginException("Unathrosied access denied.");
//		     }
//		     
//		     Course course = dtoToCourse(courseDTO);
//				course = courseDao.save(course) ;
//				
//				return courseToDTO(course);
//	}
	
//	public Course dtoToCourse(CourseDTO courseDTO) {
//		
//		return this.modelmapper.map(courseDTO, Course.class);
//	}
//	
//	public CourseDTO courseToDTO(Course course) {
//		return this.modelmapper.map(course, CourseDTO.class);
//	}
//	
//	public StudentDTO studentToDTO(Student student) {
//		return this.modelmapper.map(student, StudentDTO.class);
//	}

}
