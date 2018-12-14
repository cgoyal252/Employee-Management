/**
 * copyright � 2018 Infogain It Solutions Private Limited
 */
package com.springdata.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;



/**
 * @author Chirag.Goyal
 *
 */
@Entity
@Table(name = "Skills")
public class Skills extends AuditModel {

	/**
	 * long
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SKILL_ID")
	private Long skillId;


@NotBlank(message="Please insert name")
	@Column(name = "SKILL_NAME",unique=true,nullable=false)
	private String skillName;

	@Override
	public String toString() {
		return  skillName;
	}

	public Long getSkillId() {
		return skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}


	public Skills() {

	}

	public Skills(Long skillId, String skillName) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
	}

}
