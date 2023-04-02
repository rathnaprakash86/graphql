package com.rathna.consulting.repository;

import java.util.List;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import com.rathna.consulting.entity.Employee;

public interface EmployeeRepository extends R2dbcRepository<Employee, Integer> {


  public List<Employee> findByDepartmentId(Integer departmentId);

  public List<Employee> findByDepartmentIdIn(List<Integer> departmentId);
}
