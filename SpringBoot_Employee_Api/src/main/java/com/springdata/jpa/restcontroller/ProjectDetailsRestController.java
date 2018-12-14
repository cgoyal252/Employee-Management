package com.springdata.jpa.restcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springdata.jpa.entity.ProjectDetails;
import com.springdata.jpa.exception.ResourceNotFoundException;
import com.springdata.jpa.repository.ProjectDetailRepository;
import com.springdata.jpa.service.ProjectDetailsService;

import java.util.List;

import javax.validation.Valid;

/**
 * @author Chirag.Goyal
 *
 */
@RestController
@RequestMapping(path = "/api")
public class ProjectDetailsRestController {

    @Autowired
    private ProjectDetailsService projectDetailService;

    @GetMapping("/projectDetail")
    public List<ProjectDetails> getProjectDetail() {
        return projectDetailService.getProjectDetail();
    }


    @PostMapping("/projectDetail")
    public ProjectDetails createProjectDetail(@Valid @RequestBody ProjectDetails projectDetail) {
  
        return projectDetailService.createProjectDetail(projectDetail);
    }

   @PutMapping("/projectDetail/{projectDetailId}")
    public ProjectDetails updateProjectDetail(@PathVariable Long projectDetailId,
                                   @Valid @RequestBody ProjectDetails projectDetailRequest) {
        return projectDetailService.updateProjectDetail(projectDetailId, projectDetailRequest);
    }


    @DeleteMapping("/projectDetail/{projectDetailId}")
    public ResponseEntity<?> deletProjectDetail(@PathVariable Long projectDetailId) {
        return projectDetailService.deletProjectDetail(projectDetailId);
    }
}
