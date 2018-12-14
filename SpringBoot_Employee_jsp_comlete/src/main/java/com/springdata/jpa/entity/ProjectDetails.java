/**
 * copyright � 2018 Infogain It Solutions Private Limited
 */
package com.springdata.jpa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Chirag.Goyal
 *
 */
@Entity
@Table(name = "ProjectDetails")
public class ProjectDetails extends AuditModel {

	/**
	 * long
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PROJ_DET_ID")
	private Long projectDetailId;

	public Long getProjectDetailId() {
		return projectDetailId;
	}

	public void setProjectDetailId(Long projectDetailId) {
		this.projectDetailId = projectDetailId;
	}

	@NotBlank(message="Please provide department name")
	@Column(name = "PROJ_OWNER")
	private String projectOwner;

	
	@Temporal(TemporalType.DATE)
	@Column(name = "START_DATE")
	private Date startDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "END_DATE")
	private Date endDate;

	public String getProjectOwner() {
		return projectOwner;
	}

	public void setProjectOwner(String projectOwner) {
		this.projectOwner = projectOwner;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public ProjectDetails() {

	}

	public ProjectDetails(Long projectDetailId, String projectOwner, Date startDate, Date endDate) {
		super();
		this.projectDetailId = projectDetailId;
		this.projectOwner = projectOwner;
		this.startDate = startDate;
		this.endDate = endDate;
	}

}
