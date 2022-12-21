package com.masai.studentManagement.module.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AdminDTO {
	

	private Integer adminId;
	
	@NotNull(message = "name can't be null")
	@NotBlank(message = "name can't be blank")
	@NotEmpty(message = "name can't be empty")
	@Size(min = 3, max = 35, message = "name size should be between 3 to 35 char")
	private String name;
	
	@Pattern(regexp = "[6-9][0-9]{9}",message = "Mobile number should start with 6-9 and of size 10")
	private String mobileNumber;
	
	@Size(min = 8, max = 12, message = "password must be between 8-12")
	private String password;
	
	@NotNull(message = "role can't be null")
	private String role;

}
