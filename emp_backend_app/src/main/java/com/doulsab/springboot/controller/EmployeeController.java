package com.doulsab.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doulsab.springboot.dto.EmployeeDto;
import com.doulsab.springboot.service.impl.EmployeeServiceImpl;

@RestController
@RequestMapping("api/v1/")
public class EmployeeController {

	private final EmployeeServiceImpl employeeServiceImpl;

	public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
		this.employeeServiceImpl = employeeServiceImpl;
	}

//	1. Get list of employees
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmployeeDto>> getEmployees() {
		List<EmployeeDto> employees = employeeServiceImpl.getEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

//	2. Store Employee to database
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
		return new ResponseEntity<>(employeeServiceImpl.createEmployee(employeeDto), HttpStatus.CREATED);
	}

//	3. Find by Id
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeDetailsById(@PathVariable Long id) {
		return new ResponseEntity<>(employeeServiceImpl.getDetailsById(id), HttpStatus.OK);
	}

//	4.Update Employee
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployeeDetailsById(@PathVariable Long id,
			@RequestBody EmployeeDto employeeDto) {
		return new ResponseEntity<>(employeeServiceImpl.updateDetails(id, employeeDto), HttpStatus.OK);
	}

//	5.Delete by Id
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
		employeeServiceImpl.deleteEmployeeById(id);
		return ResponseEntity.ok("Deleted Successfully!");
	}

}
