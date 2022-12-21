package com.masai.studentManagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.studentManagement.module.Course;

public interface CourseDAO extends JpaRepository<Course, Integer>{
	
	@Query("from Course c where c.topics LIKE %:topic% OR c.courseName LIKE %:topic% ")
	   public List<Course> getCoursesByTopic(String topic) ;

}
