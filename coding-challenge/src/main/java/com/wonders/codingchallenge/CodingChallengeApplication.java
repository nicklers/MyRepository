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

@SpringBootApplication
public class CodingChallengeApplication {
	@Value("classpath:json/employee.json")
	private Resource resourceFile;
	
	public static List<Employee> employeeList = new ArrayList<Employee>();

	public static void main(String[] args) {
		SpringApplication.run(CodingChallengeApplication.class, args);
	}
	
	@Bean
	@ConditionalOnProperty("execute-immediately")
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
