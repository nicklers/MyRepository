package com.wonders.codingchallenge.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Gino Lontoc
 *
 */
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/api/employees/sorted/{field}")
	public List<Employee> getEmployees(@PathVariable String field) {
		return employeeService.getEmployees(field);
	}

	@GetMapping("/api/employees/younger/than/{age}")
	public List<Employee> getEmployeesWithAgeLessThan(@PathVariable String age) {
		return employeeService.getEmployeesWithAgeLessThan(age);
	}
}
