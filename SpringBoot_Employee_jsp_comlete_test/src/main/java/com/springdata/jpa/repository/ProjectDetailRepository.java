package com.springdata.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springdata.jpa.entity.Employee;
import com.springdata.jpa.entity.ProjectDetails;

import java.util.List;

/**
 * @author Chirag.Goyal
 *
 */
@Repository
public interface ProjectDetailRepository extends JpaRepository<ProjectDetails, Long> {
  
	
}
