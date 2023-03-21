package com.rathna.consulting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rathna.consulting.entity.Dependent;

public interface DependentRepository extends JpaRepository<Dependent,Integer> {
	
	public List<Dependent> findByEmployeeId(Integer emp_id);


}
