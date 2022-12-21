package com.masai.studentManagement.module.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDTO {
	private Integer courseId;
	
	@NotNull(message = "course name can't be Null")
	@NotBlank(message = "course name can't be blank")
	@NotEmpty(message = "course name can't be empty")
	@Size(min = 2,max = 40,message = "course name size should be of 2-40")
	private String courseName;
	
	@NotNull(message = "description can't be Null")
	@NotBlank(message = "description can't be blank")
	@NotEmpty(message = "description can't be empty")
	@Size(min = 10,max = 500,message = "description size should be of 10-500")
	private String description;
	
	@NotNull(message = "course type can't be Null")
	@NotBlank(message = "course type can't be blank")
	@NotEmpty(message = "course type can't be empty")
	private String courseType;
	
	@NotNull(message = "duration can't be Null")
	@NotBlank(message = "duration can't be blank")
	@NotEmpty(message = "duration can't be empty")
	private String duration;
	
	@NotNull(message = "topic can't be Null")
	@NotBlank(message = "topic can't  be blank")
	@NotEmpty(message = "topic can't  be empty")
	private String topics;

}
