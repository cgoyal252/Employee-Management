package com.springdata.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springdata.jpa.entity.Employee;
import com.springdata.jpa.entity.Project;

import java.util.List;

import javax.transaction.Transactional;

/**
 * @author Chirag.Goyal
 *
 */
@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	//find employee on the basis of project id
	List<Employee> findByProjectProjectId(Long projectId);

	Employee findByEmail(String email);
	Employee findByEmpId(Long id);

	@Query("Select e from Employee e where e.project=null")
	List<Employee> findAllByProject();

	@Modifying
	@Query("update Employee e  set e.project = :project_id"
			+ " where e.empId in :emp_id")
	void updateByProjectProjectId(@Param("emp_id")Long emp_id,@Param("project_id")Project project_id);
}
