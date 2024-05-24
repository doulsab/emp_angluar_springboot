package com.doulsab.springboot.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.doulsab.springboot.dto.EmployeeDTOMapper;
import com.doulsab.springboot.dto.EmployeeDto;
import com.doulsab.springboot.entity.Employee;
import com.doulsab.springboot.exception.ResourceNotFoundException;
import com.doulsab.springboot.repository.EmployeeRepo;
import com.doulsab.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepo employeeRepo;

	public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	@Override
	public List<EmployeeDto> getEmployees() {

		List<Employee> employees = employeeRepo.findAll();
		return employees.stream().map(EmployeeDTOMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee = EmployeeDTOMapper.toEmployee(employeeDto);
		return EmployeeDTOMapper.toDto(employeeRepo.save(employee));
	}

	@Override
	public EmployeeDto getDetailsById(Long id) {
		Employee employee = employeeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee details not exist" + id));
		return EmployeeDTOMapper.toDto(employee);
	}

	@Override
	public EmployeeDto updateDetails(Long id, EmployeeDto employeeDto) {
		Employee employee = employeeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee details not exist" + id));
		employee.setEmail(employeeDto.getEmail());
		employee.setFirstname(employeeDto.getFirstname());
		employee.setLastname(employeeDto.getLastname());
		return EmployeeDTOMapper.toDto(employeeRepo.save(employee));
	}
	
	@Override
	public void deleteEmployeeById(Long id) {
		Employee employee = employeeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee details not exist" + id));
		employeeRepo.delete(employee);
	}

}
