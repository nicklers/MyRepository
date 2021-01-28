package com.wonders.codingchallenge.employee;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wonders.codingchallenge.CodingChallengeApplication;

@Service
public class EmployeeService {
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	public List<Employee> getEmployeeSalaries() {
		logger.info("executing getEmployeeSalaries()...");
		List<Employee> list = new LinkedList<Employee>(CodingChallengeApplication.employeeList);
		list.sort(Comparator.comparingDouble(Employee::getSalary));

		return list;
	}
	
	public List<Employee> getEmployeeYoungerThan25() {
		logger.info("executing getEmployeeYoungerThan25()...");

		List<Employee> list = new LinkedList<Employee>(CodingChallengeApplication.employeeList);

		Iterator<Employee> iterator = list.iterator();
		while (iterator.hasNext()) {
			Employee employee = (Employee) iterator.next();
			if (employee.getAge() > 24) {
				iterator.remove();
			}
		}

		return list;
	}
}
