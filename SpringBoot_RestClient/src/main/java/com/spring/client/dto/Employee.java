package com.spring.client.dto;

import java.util.HashSet;
import java.util.Set;


/**
 * @author chirag.goyal
 *
 */
public class Employee
{

	private Long empId;

	private String employeeName;



	private String email;


	private String employeeRole;


	private Set<Skills> skills = new HashSet<Skills>(0);

	private Double experience;


	private Boolean Status;


	public Long getEmpId() {
		return empId;
	}


	public void setEmpId(Long empId) {
		this.empId = empId;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getEmployeeRole() {
		return employeeRole;
	}


	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}


	public Set<Skills> getSkills() {
		return skills;
	}


	public void setSkills(Set<Skills> skills) {
		this.skills = skills;
	}


	public Double getExperience() {
		return experience;
	}


	public void setExperience(Double experience) {
		this.experience = experience;
	}


	public Boolean getStatus() {
		return Status;
	}


	public void setStatus(Boolean status) {
		Status = status;
	}

	


}
