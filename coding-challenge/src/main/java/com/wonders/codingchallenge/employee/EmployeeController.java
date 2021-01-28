package com.wonders.codingchallenge.employee;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/api/employees/sorted/salary")
	public List<Employee> getEmployeeSalaries() {
		return employeeService.getEmployeeSalaries();
	}

	@GetMapping("/api/employees/younger/than/25")
	public List<Employee> getEmployeeYoungerThan25() {
		return employeeService.getEmployeeYoungerThan25();
	}
}
