package com.rathna.consulting.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.rathna.consulting.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


  public List<Employee> findByDepartmentId(Integer departmentId);

  public List<Employee> findByDepartmentIdIn(List<Integer> departmentId);
}
