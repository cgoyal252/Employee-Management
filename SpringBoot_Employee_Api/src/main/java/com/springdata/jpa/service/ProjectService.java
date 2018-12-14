package com.springdata.jpa.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.ProjectedPayload;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.springdata.jpa.entity.Employee;
import com.springdata.jpa.entity.Project;
import com.springdata.jpa.exception.ResourceNotFoundException;
import com.springdata.jpa.repository.EmployeeRepository;
import com.springdata.jpa.repository.ProjectRepository;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

/**
 * @author Chirag.Goyal
 *
 */
@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
@Autowired
EmployeeRepository employeeRepository;
    public List<Project> getProject() {
        return projectRepository.findAll();
    }
    public Project getProjectById(Long id) {
        return projectRepository.findByProjectId(id);
    }


    @Transactional
    public ResponseEntity<?> createproject(Project project) {
//System.out.println(id);
  		if (projectRepository.findByProjectName(project.getProjectName()) == null  ) {
  			projectRepository.save(project);
  	List<Long> employeeIds =project.getEmployee().stream().map(Employee::getEmpId).collect(Collectors.toList());
  			System.out.println(employeeIds);
  			for(Long id1:employeeIds)
  			{
  				employeeRepository.updateByProjectProjectId(id1,projectRepository.findByProjectName(project.getProjectName()));

  			}
  			return new ResponseEntity<String>("Successfully Saved project with id : " +project.getProjectId(), HttpStatus.OK);
  		}
  		else {
  			return new ResponseEntity<String>("Project already exist",HttpStatus.INTERNAL_SERVER_ERROR);
  		}
    }

    public Project updateProject( Long projectId,
                                  Project projectRequest) {
        return projectRepository.findById(projectId)
                .map(project -> {
                    project.setProjectName(projectRequest.getProjectName());
                    return projectRepository.save(project);
                }).orElseThrow(() -> new ResourceNotFoundException("Project not found with id " + projectId));
    }


    public ResponseEntity<?> deletProject( Long projectId) {
        return projectRepository.findById(projectId)
                .map(project -> {
                    projectRepository.delete(project);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Project not found with id " + projectId));
    }
}
