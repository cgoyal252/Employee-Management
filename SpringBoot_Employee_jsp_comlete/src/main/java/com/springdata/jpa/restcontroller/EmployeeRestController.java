package com.springdata.jpa.restcontroller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springdata.jpa.entity.Employee;
import com.springdata.jpa.entity.Skills;
import com.springdata.jpa.exception.ResourceNotFoundException;
import com.springdata.jpa.repository.ProjectRepository;
import com.springdata.jpa.repository.SkillRepository;
import com.springdata.jpa.service.EmployeeService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

/**
 * @author Chirag.Goyal
 *
 */
@RestController
//@RequestMapping(path = "/api")
public class EmployeeRestController {

	static final Logger logger  = LogManager.getLogger(EmployeeRestController.class.getName());
	
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SkillRepository skillRepository;
    
    @Autowired
    private ProjectRepository projectRepository;

    //get all employee list in particular project
    @GetMapping("/project/{projectId}/employee")
    public List<Employee> getEmployeesByProjectId(@PathVariable Long projectId) {
        return employeeService.getEmployeesByProjectId(projectId);
    }
    
    
    // get all employee 
    @GetMapping(value="/employee",produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getEmployee() {
        return employeeService.getEmployee();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.getEmployeeById(id);
    }

    
    // save all employee and setting status true

    @PostMapping("/employee")
    public ResponseEntity<?> createEmployee(@Valid @RequestBody Employee employee) {
           return  employeeService.createEmployee(employee);
          		
       
      
    }


  /* @PostMapping("/employee1")
    public ResponseEntity<?> createEmployeewithSkill(@Valid @RequestBody Employee employee) {
              employee.setStatus(true);
              
            
          		
          		
    }*/
    
    //updating employee
   @PutMapping("/employee/{employeeId}")
    public Employee updateEmployee(@PathVariable Long employeeId,
                                   @Valid @RequestBody Employee employeeRequest) {
        return employeeService.updateEmployee(employeeId, employeeRequest);
  
    }


   
   //delete employee
   @DeleteMapping("/employee/{employeeId}")
    public ResponseEntity<?> deletEmployee(@PathVariable Long employeeId) {
    
   return employeeService.deletEmployee(employeeId);
   }
}
