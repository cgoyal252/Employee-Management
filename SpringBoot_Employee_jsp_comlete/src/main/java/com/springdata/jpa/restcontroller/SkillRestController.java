package com.springdata.jpa.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springdata.jpa.entity.Skills;
import com.springdata.jpa.exception.ResourceNotFoundException;
import com.springdata.jpa.service.SkillService;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

/**
 * @author Chirag.Goyal
 *
 */
@RestController
@RequestMapping(path = "/api")
public class SkillRestController {

	@Autowired
	private SkillService skillService;

	@GetMapping("/skills")
	public List<Skills> getSkills() {
		return skillService.getSkills();
	}

	@PostMapping("/skills")
	public ResponseEntity<?> createSkills(@Valid @RequestBody Skills skills) {
		return skillService.createSkills(skills);
	}

	@GetMapping("/skills/{skillsId}")
	public ResponseEntity<?> getSkillsById(@PathVariable Long skillsId) {

		return  skillService.getSkillsById(skillsId);
	}

	@PutMapping("/skills/{skillsId}")
	public Skills updateSkills(@PathVariable Long skillsId, @Valid @RequestBody Skills skillsRequest) {
	return skillService.updateSkills(skillsId, skillsRequest);
	
	}

	@DeleteMapping("/skills/{skillsId}")
	public ResponseEntity<?> deletSkills(@PathVariable Long skillsId) {
	
	return skillService.deletSkills(skillsId);
	}
}
