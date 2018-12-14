package com.springdata.jpa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Chirag.Goyal
 *
 */
@Entity
@Table(name = "Project")
public class Project extends AuditModel {

	/**
	 * long
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PROJ_ID")
	private Long projectId;

	@NotBlank(message="Please insert project name")
	@Column(name = "PROJ_NAME",unique=true)
	private String projectName;

@NotNull(message="Please select status ")
	@Column(name = "PROJ_STATUS")
	private String projectStatus;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="proj_detail_id")
	private ProjectDetails projectDetails;
 
	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE }, mappedBy = "project")
	private List<Employee> employee=new ArrayList<>();
	
	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public ProjectDetails getProjectDetails() {
		return projectDetails;
	}

	public void setProjectDetails(ProjectDetails projectDetails) {
		this.projectDetails = projectDetails;
	}



	public Project() {

	}

	public Project(Long projectId, String projectName, String projectStatus,
			ProjectDetails projectDetails) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectStatus = projectStatus;
		this.projectDetails = projectDetails;
	}

}
