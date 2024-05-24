package com.doulsab.springboot.dto;

import com.doulsab.springboot.entity.Employee;

public class EmployeeDTOMapper {

	private EmployeeDTOMapper() {
		throw new UnsupportedOperationException("To hide the Mapper bcz all are static class");
	}

	public static EmployeeDto toDto(Employee employee) {
		return new EmployeeDto(employee.getEmployeeId(), employee.getFirstname(), employee.getLastname(),
				employee.getEmail());
	}

	public static Employee toEmployee(EmployeeDto employeeDto) {
		return new Employee(employeeDto.getEmployeeId(), employeeDto.getFirstname(), employeeDto.getLastname(),
				employeeDto.getEmail());
	}

}
