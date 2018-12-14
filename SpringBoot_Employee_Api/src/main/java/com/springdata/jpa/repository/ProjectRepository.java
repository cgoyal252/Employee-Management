package com.springdata.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springdata.jpa.entity.Project;


/**
 * @author Chirag.Goyal
 *
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	Project findByProjectName(String projectName);
	
	Project findByProjectId(Long id);
}
