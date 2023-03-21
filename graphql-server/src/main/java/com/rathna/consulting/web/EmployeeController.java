package com.rathna.consulting.web;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import com.rathna.consulting.entity.Country;
import com.rathna.consulting.entity.Department;
import com.rathna.consulting.entity.Employee;
import com.rathna.consulting.entity.JobInfo;
import com.rathna.consulting.entity.Location;
import com.rathna.consulting.entity.Region;
import com.rathna.consulting.pojo.EmployeeDetails;
import com.rathna.consulting.service.EmployeeService;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @QueryMapping(name = "employeeDetails")
  public EmployeeDetails getEmployeeDetailsById(@Argument Integer employeeId) {
    return employeeService.getEmployeeDetailsById(employeeId);
  }


  @QueryMapping(name = "employee")
  public Employee getEmployeeById(@Argument Integer employeeId) {
    return employeeService.getEmployeeById(employeeId).get();
  }

  @SchemaMapping
  public JobInfo jobInfo(Employee employee) {
    log.info("Job ID {}", employee.getJobId());
    JobInfo jobInfo = employeeService.getJobDetailsById(employee.getJobId());
    return jobInfo;
  }

  @SchemaMapping(typeName = "Employee", field = "departmentInfo")
  public Department getDepartmentById(Employee employee) {
    log.info("Department ID {}", employee.getDepartmentId());
    Department department = employeeService.getDepartmentDetailsById(employee.getDepartmentId());
    return department;
  }

  @SchemaMapping(typeName = "DepartmentInfo", field = "loctionInfo")
  public Location getLocationById(Department department) {
    log.info("Location ID {}", department.getLocationId());
    Location location = employeeService.getLocationById(department.getLocationId());
    return location;
  }

  @SchemaMapping(typeName = "LoctionInfo", field = "countryInfo")
  public Country getCountryById(Location location) {
    log.info("Country ID {}", location.getCountryId());
    Country country = employeeService.getCountryById(location.getCountryId());
    return country;
  }

  @SchemaMapping(typeName = "CountryInfo", field = "regionInfo")
  public Region getCountryById(Country country) {
    log.info("Region ID {}", country.getRegionId());
    Region region = employeeService.getRegionById(country.getRegionId());
    return region;
  }

  // @SubscriptionMapping
  // public Flux<Employee> allEmployees() {
  // return employeeService.allEmployees();
  // }


  public record EmployeeInput(Integer employeeId, String firstName, String lastName, String email,
      Date hireDate, Integer jobId, Integer managerId, Integer departmentId, Float salary) {

  }

  @MutationMapping
  public Employee addEmployee(@Argument EmployeeInput employeeInput) {
    log.info("{}", employeeInput.toString());
    return employeeService.createUpdateEmployee(employeeInput);
  }



}
