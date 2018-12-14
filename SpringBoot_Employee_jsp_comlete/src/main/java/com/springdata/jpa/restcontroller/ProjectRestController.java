package com.springdata.jpa.restcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springdata.jpa.entity.Project;
import com.springdata.jpa.exception.ResourceNotFoundException;
import com.springdata.jpa.repository.ProjectRepository;
import com.springdata.jpa.service.ProjectService;

import java.util.List;

import javax.validation.Valid;

/**
 * @author Chirag.Goyal
 *
 */
@RestController
@RequestMapping(path = "/api")
public class ProjectRestController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/project")
    public List<Project> getProject() {
        return projectService.getProject();
    }


    @PostMapping("/project")
    public ResponseEntity<?> createproject(@Valid @RequestBody Project project) {
    
    return projectService.createproject(project);
    
    }

   @PutMapping("/project/{projectId}")
    public Project updateProject(@PathVariable Long projectId,
                                   @Valid @RequestBody Project projectRequest) {
        return projectService.updateProject(projectId, projectRequest);
    }


@DeleteMapping("/project/{projectId}")
    public ResponseEntity<?> deletProject(@PathVariable Long projectId) {
        return projectService.deletProject(projectId);
    }
}
