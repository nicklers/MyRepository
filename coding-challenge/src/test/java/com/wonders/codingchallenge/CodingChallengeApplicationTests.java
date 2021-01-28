package com.wonders.codingchallenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wonders.codingchallenge.employee.Employee;
import com.wonders.codingchallenge.employee.EmployeeController;

@SpringBootTest
class CodingChallengeApplicationTests {

	@Autowired
	private EmployeeController controller;

	@Test
	void getEmployeeSalaries() {
		List<Employee> list = controller.getEmployeeSalaries();
		assertEquals(list.isEmpty(), list);
	}

	@Test
	void getEmployeeYoungerThan25() {
		List<Employee> list = controller.getEmployeeYoungerThan25();
		assertEquals(list.isEmpty(), list);
	}

}
