package com.rathna.consulting.web;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import com.rathna.consulting.entity.Department;
import com.rathna.consulting.entity.Employee;
import com.rathna.consulting.entity.Location;
import com.rathna.consulting.service.DepartmentService;
import com.rathna.consulting.service.EmployeeService;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class DepartmentController {

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private DepartmentService departmentService;


  @QueryMapping(name = "departments")
  public List<Department> getDepartmentsAll() {
    return departmentService.getAllDepartments();
  }


  @QueryMapping(name = "departmentEmployees")
  public List<Department> getDepartmentEmployee() {
    return departmentService.getAllDepartments();
  }

  /**
   * 
   * N+1 or more problems
   */
  @SchemaMapping(typeName = "DepartmentEmployees", field = "loctionInfo")
  public Location getLocationById(Department department) {

    Location location = employeeService.getLocationById(department.getLocationId());
    return location;
  }

  @BatchMapping(typeName = "DepartmentEmployees", field = "employee")
  public Map<Department, List<Employee>> getEmployeesByDepartmentId(List<Department> departments) {
    log.info("Department ID {}", "getEmployeesByDepartmentId");
    return departmentService.getEmployeesByDepartmentId(departments);

  }
}
