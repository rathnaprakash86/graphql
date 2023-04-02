package com.rathna.consulting.service;

import java.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import com.rathna.consulting.entity.Country;
import com.rathna.consulting.entity.Department;
import com.rathna.consulting.entity.Dependent;
import com.rathna.consulting.entity.Employee;
import com.rathna.consulting.entity.JobInfo;
import com.rathna.consulting.entity.Location;
import com.rathna.consulting.entity.Region;
import com.rathna.consulting.pojo.EmployeeDetails;
import com.rathna.consulting.repository.CountryRepository;
import com.rathna.consulting.repository.DepartmentRepository;
import com.rathna.consulting.repository.DependentRepository;
import com.rathna.consulting.repository.EmployeeRepository;
import com.rathna.consulting.repository.JobRepository;
import com.rathna.consulting.repository.LocationRepository;
import com.rathna.consulting.repository.RegionRepository;
import com.rathna.consulting.web.EmployeeController.EmployeeInput;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;
  @Autowired
  private DependentRepository dependentRepository;
  @Autowired
  private JobRepository jobRepository;
  @Autowired
  private DepartmentRepository departmentRepository;
  @Autowired
  private LocationRepository locationRepository;
  @Autowired
  private CountryRepository countryRepository;
  @Autowired
  private RegionRepository regionRepository;

  /**
   * Blocking way
   * 
   * @param empId
   * @return
   */
  public Mono<EmployeeDetails> getEmployeeDetailsById(Integer empId) {

    EmployeeDetails employeeDetails = EmployeeDetails.builder().build();
    Mono<Employee> employeeMono = getEmployeeById(empId);


    Employee employee = employeeMono.block();

    if (!ObjectUtils.isEmpty(employee)) {
      employeeDetails.setEmployee(employee);
      employeeDetails.setDependents(getDependentsByEmployeeId(empId).collectList().block());
      employeeDetails.setJob(getJobDetailsById(employee.getJobId()).block());
      employeeDetails.setDepartment(getDepartmentDetailsById(employee.getDepartmentId()).block());
      if (employeeDetails.getDepartment() != null
          && employeeDetails.getDepartment().getLocationId() != null) {
        employeeDetails
            .setLocation(getLocationById(employeeDetails.getDepartment().getLocationId()).block());
        employeeDetails
            .setCountry(getCountryById(employeeDetails.getLocation().getCountryId()).block());
        employeeDetails
            .setRegion(getRegionById(employeeDetails.getCountry().getRegionId()).block());

      }
    }

    return Mono.just(employeeDetails);

  }

  public Mono<Employee> getEmployeeById(Integer empId) {
    Mono<Employee> employee = employeeRepository.findById(empId);
    return employee;
  }

  public Mono<Region> getRegionById(Integer regionId) {
    return regionRepository.findById(regionId);
  }

  public Mono<Country> getCountryById(String countryId) {
    return countryRepository.findById(countryId);
  }

  public Mono<Location> getLocationById(Integer locationId) {
    return locationRepository.findById(locationId);
  }

  public Mono<Department> getDepartmentDetailsById(Integer departmentId) {
    return departmentRepository.findById(departmentId);
  }

  public Mono<JobInfo> getJobDetailsById(Integer jobId) {

    return jobRepository.findById(jobId);

  }

  public Flux<Dependent> getDependentsByEmployeeId(Integer empId) {

    Flux<Dependent> dependents = dependentRepository.findByEmployeeId(empId);

    return dependents;

  }

  public Flux<Employee> allEmployees() {
    return employeeRepository.findAll().delayElements(Duration.ofSeconds(3));

  }

  public Mono<Employee> createUpdateEmployee(EmployeeInput input) {

    Employee employee = Employee.builder().employeeId(input.employeeId())
        .firstName(input.firstName()).lastName(input.lastName()).email(input.email())
        .hireDate(input.hireDate()).jobId(input.jobId()).salary(input.salary())
        .managerId(input.managerId()).departmentId(input.departmentId()).build();
    return employeeRepository.save(employee);
  }



}
