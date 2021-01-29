package com.wonders.codingchallenge;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wonders.codingchallenge.employee.Employee;

/**
 * 
 * @author Gino Lontoc
 *
 */
@SpringBootApplication
public class CodingChallengeApplication {
	@Value("classpath:json/employee.json")
	private Resource resourceFile;
	
	//Static field that will hold the list of employees until application shut down
	public static List<Employee> employeeList = new ArrayList<Employee>();

	public static void main(String[] args) {
		SpringApplication.run(CodingChallengeApplication.class, args);
	}
	
	/**
	 * This method is designed to run on start-up. Purpose is to create a list of employees from a JSON file then store it in cache/memory.
	 */
	@Bean
	@ConditionalOnProperty("execute-immediately") //"execute-immediately" is configure inside the application.properties
	public void cacheEmployees() {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			employeeList = objectMapper.readValue(resourceFile.getFile(),
					objectMapper.getTypeFactory().constructCollectionType(List.class, Employee.class));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
