package com.rathna.consulting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rathna.consulting.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {



}
