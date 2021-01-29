package com.wonders.codingchallenge.employee;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wonders.codingchallenge.CodingChallengeApplication;

/**
 * Open for enhancement if decided to use database instead of JSON file in the future just add @Repository annotation and implement JPA.
 * @author Gino Lontoc
 *
 */
@Service
public class EmployeeRepository {

	/**
	 * Retrieves list of employees from a JSON file. <br>
	 * For this exercise, <b><i>PLEASE TAKE NOTE</i></b> that this method is getting the list from cache.
	 * 
	 * @return
	 */
	public List<Employee> getEmployeeList(){
		//Getting the list from cache and assign to a new List to prevent overwriting due to "PASS BY REFERENCE"
		List<Employee> list = new LinkedList<Employee>(CodingChallengeApplication.employeeList);
		
		return list;
	}
}
