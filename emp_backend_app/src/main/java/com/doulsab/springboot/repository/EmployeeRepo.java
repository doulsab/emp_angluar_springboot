package com.doulsab.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doulsab.springboot.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

}
