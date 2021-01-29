package com.wonders.codingchallenge.employee;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This service class is where all the business logic will be written. 
 * @author Gino Lontoc
 *
 */
@Service
public class EmployeeService {
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeRepository repository;
	
	/**
	 * Constants for sorting list of employees
	 * @author Gino Lontoc
	 *
	 */
	enum SORT_BY{
		SALARY, NAME, AGE, COMPANY;
	}
	
	/**
	 * Sorts a list of employees based on the value passed on from the calling Class. <br>
	 * For this exercise, <b><i>PLEASE TAKE NOTE</i></b> that this method is expected to return a sorted list of employees based on salary.
	 *  
	 * @param field the value that will be use to sort the list
	 * @return list sorted list of employees
	 */
	public List<Employee> getEmployees(String field) {
		logger.info("executing getEmployeeSalaries()...");
		
		//Getting the list from cache
		List<Employee> list = repository.getEmployeeList();
		
		//Added if condition for possible enhancement
		if(field.equalsIgnoreCase(SORT_BY.SALARY.name()))	{	
			//Use Comparator to sort this collection
			list.sort(Comparator.comparingDouble(Employee::getSalary));
		}

		return list;
	}
	
	/**
	 * Filter a list of employees where age is less that the value passed on from the calling Class. <br>
	 * For this exercise, <b><i>PLEASE TAKE NOTE</i></b> that this method is expected to fileter only employees whose age is below 25 years old.
	 * 
	 * @param age the value that will be use to filter the list
	 * @return list filtered list of employees based on age
	 */
	public List<Employee> getEmployeesWithAgeLessThan(String age) {
		logger.info("executing getEmployeeYoungerThan25()...");
		
		int employeeAge = Integer.parseInt(age);

		//Getting the list from cache and assign to a new List to prevent overwriting due to "PASS BY REFERENCE"
		List<Employee> list = repository.getEmployeeList();

		Iterator<Employee> iterator = list.iterator();
		while (iterator.hasNext()) {
			Employee employee = (Employee) iterator.next();
			if (employee.getAge() > employeeAge) {
				// Remove element from the list if age is > 25
				iterator.remove();
			}
		}

		return list;
	}
}
