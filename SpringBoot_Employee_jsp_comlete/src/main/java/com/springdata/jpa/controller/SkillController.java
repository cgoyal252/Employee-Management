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
public class SkillController {
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private SkillService skillService;

	static final Logger logger  = LogManager.getLogger(SkillController.class.getName());

	
	@RequestMapping(value = "/skill", method = RequestMethod.GET)
	public String listemployees(Model model) {
		model.addAttribute("skill", new Skills());
		model.addAttribute("skillList", skillService.getSkills());
		return "addSkill";
	}

	// Same method For both Add and Update Employee
	@RequestMapping(value = "/skill/add", method = RequestMethod.POST)
	public String addemployee(@Valid @ModelAttribute("skill") Skills skill,BindingResult result) {


		if (result.hasErrors()) {
			return "addSkill";
		}
		if (skill.getSkillId()==null || skill.getSkillId() == 0) {
			// new employee, add it
			skillService.createSkills(skill);
		} else {
			// existing employee, call update
			skillService.updateSkills(skill.getSkillId(), skill);
		}

		return "redirect:/skill";

	}

	@RequestMapping("/skill/remove/{id}")
	public String removeemployee(@PathVariable("id") Long id) {

		skillService.deletSkills(id);
		return "redirect:/skill";
	}

	@RequestMapping("/skill/add")
	public String addEmployee( Model model) {
		Skills skill=new Skills();

		model.addAttribute("skill", skill);
		return "addSkill";
	}

	@RequestMapping("/skill/edit/{id}")
	public String editemployee(@PathVariable("id") Long id, Model model) {
		model.addAttribute("skill",skillService.getSkillsById(id));
		return "addSkill";
	}

	

	
	
	
}

