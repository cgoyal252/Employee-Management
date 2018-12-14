package com.springdata.jpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

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
import com.springdata.jpa.repository.EmployeeRepository;
import com.springdata.jpa.service.EmployeeService;
import com.springdata.jpa.service.ProjectService;

import ch.qos.logback.classic.Logger;

@Controller
public class Projectcontroller {
	@Autowired
	private ProjectService projectService;

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeRepository e1;
	
	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public String listProjects(Model model) {
		model.addAttribute("project", new Project());
		model.addAttribute("projectList", projectService.getProject());
		return "fetchProject";
	}

	// Same method For both Add and Update project
	@RequestMapping(value = "/project/add", method = RequestMethod.POST)
	public String addproject(@Valid @ModelAttribute("project") Project project,BindingResult result) {

		
		  if (result.hasErrors()) {
	            return "addProject";
	        }
		if (project.getProjectId()==null || project.getProjectId() == 0) {
			// new project, add it
		
			projectService.createproject(project);
		} else {
			// existing project, call update
			projectService.updateProject(project.getProjectId(), project);
		}

		return "redirect:/projects";

	}

	@RequestMapping("/project/remove/{id}")
	public String removeproject(@PathVariable("id") Long id) {

		projectService.deletProject(id);
		return "redirect:/projects";
	}
	
	@RequestMapping("/project/add")
	public String addproject( Model model) {
		 Project project=new Project();
	
	        model.addAttribute("project", project);
		return "addProject";
	}

	@RequestMapping("/project/edit/{id}")
	public String editproject(@PathVariable("id") Long id, Model model) {
		model.addAttribute("project", projectService.getProjectById(id));
		return "addProject";
	}

	@ModelAttribute("employees")
	public List<Employee> viewEmployeeNotAllocatedInAnyProject() {
		
	    return employeeService.getEmployeesListNotAllocatedInProject();
	}
	
	 
	
	
}
