package com.springdata.jpa.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

/**
 * @author Chirag.Goyal
 *
 */
@Entity
@Table(name = "Employee")
public class Employee extends AuditModel {

	/**
	 * long
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMP_ID")
	private Long empId;

	@NotBlank(message="Employee name cannot be null")
	@Column(name = "EMP_NAME")
	private String employeeName;

	@NotBlank(message="Please provide email")
	@Email(message = "Please provide valid email")
	@Column(nullable=false,unique=true)
	private String email;

	@NotBlank(message="Please provide employee Role")
	@Column(name = "EMP_ROLE")
	private String employeeRole;

	@NotEmpty(message="Please Select Skill")
	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST},fetch=FetchType.LAZY)
	@JoinTable(name = "Employee_Skills", joinColumns = { @JoinColumn(name = "EMP_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "SKILL_ID") })
	private Set<Skills> skills = new HashSet<Skills>(0);

	@ManyToOne( fetch = FetchType.LAZY,cascade={CascadeType.MERGE,CascadeType.PERSIST} )
	@JoinColumn(name = "project_id" )
	private Project project;

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", employeeName=" + employeeName + ", email=" + email + ", employeeRole="
				+ employeeRole + ", skills=" + skills + ", project=" + project + ", experience=" + experience
				+ ", Status=" + Status + "]";
	}

	@NotNull(message="Please provide employee experience")
	@Column(name = "EXPERIENCE")
	private Double experience;

	@Column(name = "EMP_STATUS")
	private Boolean Status;



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public Boolean getStatus() {
		return Status;
	}

	public void setStatus(Boolean status) {
		Status = status;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return
	 */
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Double getExperience() {
		return experience;
	}

	public void setExperience(Double experience) {
		this.experience = experience;
	}

	public Employee() {

	}

	public Employee(Long empId, String employeeName, String employeeRole, Set<Skills> skills, Project project,
			Double experience) {
		super();
		this.empId = empId;
		this.employeeName = employeeName;
		this.employeeRole = employeeRole;
		this.skills = skills;
		this.project = project;
		this.experience = experience;
	}

}
