package com.rathna.consulting.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.rathna.consulting.entity.Dependent;
import com.rathna.consulting.entity.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
public class GeneralRepositoryTest {

  @Autowired
  private CountryRepository countryRepository;

  @Autowired
  private DependentRepository dependentRepository;

  @Autowired
  private EmployeeRepository employeeRepository;



  void dependentRepositoryTest() {

    Flux<Dependent> xDependents = dependentRepository.findByEmployeeId(206);

    assertNotNull(xDependents);
  }



  void saveEmployeeTest() {

    Employee employee = Employee.builder().employeeId(300).firstName("Rathna").lastName("Prakash")
        .email("Test@test.com").jobId(9).salary(500f).departmentId(9).build();

    employeeRepository.save(employee);

    Mono<Employee> emMono = employeeRepository.findById(300);

    System.out.println(emMono.block().getEmployeeId());


  }
}
