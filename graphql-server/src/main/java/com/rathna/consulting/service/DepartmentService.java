package com.rathna.consulting.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rathna.consulting.entity.Department;
import com.rathna.consulting.entity.Employee;
import com.rathna.consulting.repository.DepartmentRepository;
import com.rathna.consulting.repository.EmployeeRepository;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;


@Service
@Log4j2
public class DepartmentService {


  @Autowired
  private EmployeeRepository employeeRepository;
  @Autowired
  private DepartmentRepository departmentRepository;


  public Flux<Department> getAllDepartments() {
    return departmentRepository.findAll();
  }


  public Map<Department, List<Employee>> getEmployeesByDepartmentId(List<Department> departments) {
    log.info("Department ID {}", "DepartmentService");



    List<Integer> departmentIds = departments.stream()
        .map(department -> department.getDepartmentId()).collect(Collectors.toList());

    List<Employee> employees = employeeRepository.findByDepartmentIdIn(departmentIds);


    return departments.stream().collect(Collectors.toMap(

        department -> department,
        department -> employees.stream()
            .filter(e -> e.getDepartmentId().equals(department.getDepartmentId()))
            .collect(Collectors.toList())

    ));



    // return departments.stream().collect(Collectors.toMap(department -> department,department ->
    // employeeRepository.findByDepartmentId(department.getDepartmentId())));
  }

}
