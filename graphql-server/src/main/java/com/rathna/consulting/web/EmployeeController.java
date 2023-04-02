package com.rathna.consulting.web;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@Log4j2
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @QueryMapping(name = "employeeDetails")
  public Mono<EmployeeDetails> getEmployeeDetailsById(@Argument Integer employeeId) {
    return employeeService.getEmployeeDetailsById(employeeId);
  }


  @QueryMapping(name = "employee")
  public Mono<Employee> getEmployeeById(@Argument Integer employeeId) {
    return employeeService.getEmployeeById(employeeId);
  }

  @SchemaMapping
  public Mono<JobInfo> jobInfo(Employee employee) {
    log.info("Job ID {}", employee.getJobId());
    Mono<JobInfo> jobInfo = employeeService.getJobDetailsById(employee.getJobId());
    return jobInfo;
  }

  @SchemaMapping(typeName = "Employee", field = "departmentInfo")
  public Mono<Department> getDepartmentById(Employee employee) {
    log.info("Department ID {}", employee.getDepartmentId());
    Mono<Department> department =
        employeeService.getDepartmentDetailsById(employee.getDepartmentId());
    return department;
  }

  @SchemaMapping(typeName = "DepartmentInfo", field = "loctionInfo")
  public Mono<Location> getLocationById(Department department) {
    log.info("Location ID {}", department.getLocationId());
    Mono<Location> location = employeeService.getLocationById(department.getLocationId());
    return location;
  }

  @SchemaMapping(typeName = "LoctionInfo", field = "countryInfo")
  public Mono<Country> getCountryById(Location location) {
    log.info("Country ID {}", location.getCountryId());
    Mono<Country> country = employeeService.getCountryById(location.getCountryId());
    return country;
  }

  @SchemaMapping(typeName = "CountryInfo", field = "regionInfo")
  public Mono<Region> getCountryById(Country country) {
    log.info("Region ID {}", country.getRegionId());
    Mono<Region> region = employeeService.getRegionById(country.getRegionId());
    return region;
  }

  @SubscriptionMapping
  public Flux<Employee> allEmployees() {
    return employeeService.allEmployees();
  }


  public record EmployeeInput(Integer employeeId, String firstName, String lastName, String email,
      Date hireDate, Integer jobId, Integer managerId, Integer departmentId, Float salary) {

  }

  @MutationMapping
  public Mono<Employee> addEmployee(@Argument EmployeeInput employeeInput) {
    log.info("{}", employeeInput.toString());
    return employeeService.createUpdateEmployee(employeeInput);
  }



}
