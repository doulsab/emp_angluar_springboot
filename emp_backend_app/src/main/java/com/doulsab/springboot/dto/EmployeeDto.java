package com.doulsab.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	private Long employeeId;
	private String firstname;
	private String lastname;
	private String email;
}
