package com.rathna.consulting.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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


  public EmployeeDetails getEmployeeDetailsById(Integer empId) {

    EmployeeDetails employeeDetails = EmployeeDetails.builder().build();
    Optional<Employee> employee = getEmployeeById(empId);

    if (!employee.isEmpty()) {
      employeeDetails.setEmployee(employee.get());
      employeeDetails.setDependents(getDependentsByEmployeeId(empId));
      employeeDetails.setJob(getJobDetailsById(employee.get().getJobId()));
      employeeDetails.setDepartment(getDepartmentDetailsById(employee.get().getDepartmentId()));
      if (employeeDetails.getDepartment() != null
          && employeeDetails.getDepartment().getLocationId() != null) {
        employeeDetails
            .setLocation(getLocationById(employeeDetails.getDepartment().getLocationId()));
        employeeDetails.setCountry(getCountryById(employeeDetails.getLocation().getCountryId()));
        employeeDetails.setRegion(getRegionById(employeeDetails.getCountry().getRegionId()));

      }
    }

    return employeeDetails;

  }

  public Optional<Employee> getEmployeeById(Integer empId) {
    Optional<Employee> employee = employeeRepository.findById(empId);
    return employee;
  }

  public Region getRegionById(Integer regionId) {
    return regionRepository.findById(regionId).get();
  }

  public Country getCountryById(String countryId) {
    return countryRepository.findById(countryId).get();
  }

  public Location getLocationById(Integer locationId) {
    return locationRepository.findById(locationId).get();
  }

  public Department getDepartmentDetailsById(Integer departmentId) {

    Optional<Department> department = departmentRepository.findById(departmentId);

    return (department.isPresent()) ? department.get() : null;
  }

  public JobInfo getJobDetailsById(Integer jobId) {

    Optional<JobInfo> job = jobRepository.findById(jobId);

    return job.get();
  }

  public List<Dependent> getDependentsByEmployeeId(Integer empId) {

    List<Dependent> dependents = dependentRepository.findByEmployeeId(empId);

    return dependents;

  }

  // public Flux<Employee> allEmployees() {
  // return employeeReactiveRepository.findAll().delayElements(Duration.ofSeconds(3));
  //
  // }

  public Employee createUpdateEmployee(EmployeeInput input) {

    Employee employee = Employee.builder().employeeId(input.employeeId())
        .firstName(input.firstName()).lastName(input.lastName()).email(input.email())
        .hireDate(input.hireDate()).jobId(input.jobId()).salary(input.salary())
        .managerId(input.managerId()).departmentId(input.departmentId()).build();
    return employeeRepository.save(employee);
  }



}
