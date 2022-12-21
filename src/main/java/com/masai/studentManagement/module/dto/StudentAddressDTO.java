package com.masai.studentManagement.module.dto;

import java.time.LocalDate;

import com.masai.studentManagement.module.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentAddressDTO {
      
	private Integer studentId;
	private LocalDate dob;
	private Address address;
}
