package com.springdata.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springdata.jpa.entity.Employee;
import com.springdata.jpa.entity.Skills;

import java.util.List;

import javax.transaction.Transactional;

/**
 * @author Chirag.Goyal
 *
 */
@Repository
@Transactional
public interface SkillRepository extends JpaRepository<Skills, Long> {
   Skills findBySkillName(String name);
   
   Skills findBySkillId(Long id);
}
