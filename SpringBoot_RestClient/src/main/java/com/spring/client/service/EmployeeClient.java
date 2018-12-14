package com.spring.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.client.dto.Employee;



/**
 * @author chirag.goyal
 *
 */
@Service
public class EmployeeClient 
{
	
	@Autowired
	RestTemplate restTemplate;
	 private static final String baseURL = "http://localhost:8089/api/";

	
	public List<Employee> getAllEmployee()
	{
		 List<Employee> employees = restTemplate.getForObject(baseURL+"employee", List.class);
		  System.out.println("Total Employees: ");
		  for(Object acct : employees){
		   System.out.println(acct);
		  }
	return employees;
	}
}
