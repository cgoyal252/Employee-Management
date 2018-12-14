package com.springdata.jpa.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.springdata.jpa.entity.ProjectDetails;
import com.springdata.jpa.exception.ResourceNotFoundException;
import com.springdata.jpa.repository.ProjectDetailRepository;

import java.util.List;

import javax.validation.Valid;

/**
 * @author Chirag.Goyal
 *
 */
@Service
public class ProjectDetailsService {

    @Autowired
    private ProjectDetailRepository projectDetailRepository;

    public List<ProjectDetails> getProjectDetail() {
        return projectDetailRepository.findAll();
    }


    public ProjectDetails createProjectDetail( ProjectDetails projectDetail) {
  
        return projectDetailRepository.save(projectDetail);
    }

    public ProjectDetails updateProjectDetail( Long projectDetailId,
                                    ProjectDetails projectDetailRequest) {
        return projectDetailRepository.findById(projectDetailId)
                .map(projectDetail -> {
                    projectDetail.setProjectOwner(projectDetailRequest.getProjectOwner());
                    projectDetail.setStartDate(projectDetailRequest.getStartDate());                    
                    projectDetail.setEndDate(projectDetailRequest.getEndDate());
                    return projectDetailRepository.save(projectDetail);
                }).orElseThrow(() -> new ResourceNotFoundException("ProjectDetail not found with id " + projectDetailId));
    }


    public ResponseEntity<?> deletProjectDetail( Long projectDetailId) {
        return projectDetailRepository.findById(projectDetailId)
                .map(projectDetail -> {
                    projectDetailRepository.delete(projectDetail);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("ProjectDetail not found with id " + projectDetailId));
    }
}
