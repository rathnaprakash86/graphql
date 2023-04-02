package com.rathna.consulting.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.rathna.consulting.pojo.EmployeeDetails;
import reactor.core.publisher.Mono;

@SpringBootTest
public class EmployeeServiceTest {

  @Autowired
  private EmployeeService employeeService;

  @Test
  void testGetEmployeeDetailsById() {

    Mono<EmployeeDetails> employeeDetails = employeeService.getEmployeeDetailsById(100);
    employeeDetails.subscribe(System.out::print);

  }

}
