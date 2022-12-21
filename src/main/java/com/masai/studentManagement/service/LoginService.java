package com.masai.studentManagement.service;

import com.masai.studentManagement.exception.LoginException;
import com.masai.studentManagement.exception.StudentException;
import com.masai.studentManagement.module.Login;
import com.masai.studentManagement.module.StudentLogin;

public interface LoginService {
	
	 public String adminLogin(Login login) throws LoginException;
	 public String studentValidation(StudentLogin studentLogin) throws StudentException;
	 public String StudentLogout(String key);
	 public String adminLogout(String key);
	
	

}
