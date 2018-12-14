package com.springdata.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.springdata.jpa.entity.Skills;
import com.springdata.jpa.exception.ResourceNotFoundException;
import com.springdata.jpa.repository.SkillRepository;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

/**
 * @author Chirag.Goyal
 *
 */
@Service
public class SkillService {

	@Autowired
	private SkillRepository skillRepository;

	public List<Skills> getSkills() {
		return skillRepository.findAll();
	}

	public ResponseEntity<?> createSkills( Skills skills) {
if(!skills.getSkillName().isEmpty()) {
		if (skillRepository.findBySkillName(skills.getSkillName()) == null  ) {
			skillRepository.save(skills);
			return new ResponseEntity<String>("Successfully Saved", HttpStatus.OK);
		}
		else {
			
		return new ResponseEntity<String>("Skill already exist",HttpStatus.INTERNAL_SERVER_ERROR);
		}}
		else  {
			return new ResponseEntity<String>("Skill name cannot be null",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	public ResponseEntity<?> getSkillsById(Long skillsId) {
		
		if(skillRepository.findBySkillId(skillsId)!=null) {
		 skillRepository.findBySkillId(skillsId);
		 return new ResponseEntity<Skills>(skillRepository.findBySkillId(skillsId), HttpStatus.OK);
		 }
		else
				throw new ResourceNotFoundException("Skills not found with id " + skillsId);
	}

	@PutMapping("/skills/{skillsId}")
	public Skills updateSkills(Long skillsId, Skills skillsRequest) {
		return skillRepository.findById(skillsId).map(skills -> {
			skills.setSkillName(skillsRequest.getSkillName());
			return skillRepository.save(skills);
		}).orElseThrow(() -> new ResourceNotFoundException("Skills not found with id " + skillsId));
	}

	
	public ResponseEntity<?> deletSkills(Long skillsId) {
		return skillRepository.findById(skillsId).map(skills -> {
			skillRepository.delete(skills);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Skills not found with id " + skillsId));
	}
}
