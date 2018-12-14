package com.springdata.jpa.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.springdata.jpa.entity.Employee;
import com.springdata.jpa.entity.Skills;
import com.springdata.jpa.exception.ResourceNotFoundException;
import com.springdata.jpa.repository.EmployeeRepository;
import com.springdata.jpa.repository.ProjectRepository;
import com.springdata.jpa.repository.SkillRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.Valid;

/**
 * @author Chirag.Goyal
 *
 */
@Service
@Transactional
public class EmployeeService {

	static final Logger logger  = LogManager.getLogger(EmployeeService.class.getName());
	
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SkillRepository skillRepository;
    
    @Autowired
    private ProjectRepository projectRepository;
    
    //get all employee list in particular project

    public List<Employee> getEmployeesByProjectId(Long projectId) {
        return employeeRepository.findByProjectProjectId(projectId);
    }
    
    
    // get all employee 
    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(@PathVariable("id") Long id) {
        return employeeRepository.findByEmpId(id);
    }
    
    // save all employee and setting status true

    public ResponseEntity<?> createEmployee(Employee employee) {
              employee.setStatus(true);
              
            
          		if (employeeRepository.findByEmail(employee.getEmail()) == null  ) {
          			logger.info("Employee is successfully saved");
          			employeeRepository.save(employee);
          			return new ResponseEntity<String>("Successfully Saved employee with id : " +employee.getEmpId(), HttpStatus.OK);
          		}
          		else {
          			logger.error("Duplicate email is passing");
          			return new ResponseEntity<String>("Email already exist",HttpStatus.INTERNAL_SERVER_ERROR);
          		}
          		
       
      
    }

    public ResponseEntity<?> createEmployeewithSkill( Employee employee) {
              employee.setStatus(true);
              
            
          		if (employeeRepository.findByEmail(employee.getEmail()) == null  ) {
          /*			System.out.println("sdsds");
          			System.out.println(employee.getSkills());
          			
          			Set<Skills> ss=employee.getSkills();
          			
          			for(Skills s:ss)
          			{
          				if(skillRepository.findBySkillName(s.getSkillName())!=null)
              			{
              				employee.getSkills().add(skillRepository.findBySkillName(s.getSkillName()));
              			}
          				else
          				{
System.out.println("erere");          				}
          			}*/
          			//String name=ss.getClass();
          			/*System.out.println(name);
          	
          			if(skillRepository.findBySkillName(name)!=null)
          			{
          				employee.setSkills(ss.getClass().get);
          			}*/
          			
          			logger.info("Employee is successfully saved");
          			employeeRepository.save(employee);
          			return new ResponseEntity<String>("Successfully Saved employee with id : " +employee.getEmpId(), HttpStatus.OK);
          		}
          		else {
          			logger.error("Duplicate email is passing");
          			return new ResponseEntity<String>("Email already exist",HttpStatus.INTERNAL_SERVER_ERROR);
          		}
          		
    }
    
    //updating employee
    public Employee updateEmployee(Long employeeId,
                                   Employee employeeRequest) {
        return employeeRepository.findById(employeeId)
                .map(employee -> {
                    employee.setEmployeeName(employeeRequest.getEmployeeName());
                    employee.setEmployeeRole(employeeRequest.getEmployeeRole());
                    employee.setExperience(employeeRequest.getExperience());                    
                    return employeeRepository.save(employee);
                }).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + employeeId));
    }


   
   //delete employee
    public ResponseEntity<?> deletEmployee(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .map(employee -> {
                	employee.setStatus(false);
                    employeeRepository.delete(employee);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + employeeId));
    }
    
    
    //get all employee list of employee which are not allocated into any project

    public List<Employee> getEmployeesListNotAllocatedInProject() {
    	logger.info("This employees are not allocated in any project "+employeeRepository.findAllByProject());
        return employeeRepository.findAllByProject();
    }
    
}
