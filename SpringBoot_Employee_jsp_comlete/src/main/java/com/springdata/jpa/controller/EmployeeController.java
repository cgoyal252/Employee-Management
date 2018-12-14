package com.springdata.jpa.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springdata.jpa.entity.Employee;
import com.springdata.jpa.entity.Project;
import com.springdata.jpa.entity.Skills;
import com.springdata.jpa.restcontroller.EmployeeRestController;
import com.springdata.jpa.service.EmployeeService;
import com.springdata.jpa.service.SkillService;

/**
 * @author chirag.goyal
 *
 */
@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private SkillService skillService;

	static final Logger logger  = LogManager.getLogger(EmployeeController.class.getName());

	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String listemployees(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("employeeList", employeeService.getEmployee());
		return "fetchEmployee";
	}

	// Same method For both Add and Update Employee
	@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
	public String addemployee(@Valid @ModelAttribute("employee") Employee employee,BindingResult result) {


		if (result.hasErrors()) {
			return "addEmployee";
		}
		if (employee.getEmpId()==null || employee.getEmpId() == 0) {
			// new employee, add it
			employeeService.createEmployee(employee);
		} else {
			// existing employee, call update
			employeeService.updateEmployee(employee.getEmpId(), employee);
		}

		return "redirect:/employees";

	}

	@RequestMapping("/employee/remove/{id}")
	public String removeemployee(@PathVariable("id") Long id) {

		employeeService.deletEmployee(id);
		return "redirect:/employees";
	}

	@RequestMapping("/employee/add")
	public String addEmployee( Model model) {
		Employee employee=new Employee();

		model.addAttribute("employee", employee);
		return "addEmployee";
	}

	@RequestMapping("/employee/edit/{id}")
	public String editemployee(@PathVariable("id") Long id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "addEmployee";
	}

	@RequestMapping("/employee/project/{projectId}")
	public String viewEmployeeByProject(@PathVariable("projectId") Long projectId, Model model)

			{
		
		List<Employee> proj1= employeeService.getEmployeesByProjectId(projectId);
		   String name= proj1.get(0).getProject().getProjectName();
		
		logger.info("Employee List who enroll in Project:"+name);
		model.addAttribute("employeeList", proj1);
		return  "fetchEmployee";
			}


	
	
	@ModelAttribute("skills")
	public List<Skills> viewSkill() {
		return skillService.getSkills();
	}

	
	
	
}

