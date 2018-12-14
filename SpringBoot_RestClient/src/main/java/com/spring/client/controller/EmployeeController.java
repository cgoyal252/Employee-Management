package com.spring.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.client.dto.Employee;
import com.spring.client.service.EmployeeClient;

@Controller
public class EmployeeController
{

	@Autowired
	EmployeeClient employeeClient;
	
	@GetMapping("/get")
	public String displayEmployee(ModelMap map)
	{
		List<Employee>employeeList =employeeClient.getAllEmployee();
	map.addAttribute("employeeList",employeeList);
		 return "fetchEmployee";
	}
	
	
}
