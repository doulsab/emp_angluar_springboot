package com.doulsab.springboot.service;

import java.util.List;

import com.doulsab.springboot.dto.EmployeeDto;

public interface EmployeeService {
	
	List<EmployeeDto> getEmployees();

	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getDetailsById(Long id);

	EmployeeDto updateDetails(Long id, EmployeeDto employeeDto);

	void deleteEmployeeById(Long id);
	

}
