package com.rathna.consulting.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.rathna.consulting.pojo.EmployeeDetails;

@SpringBootTest
public class EmployeeServiceTest {

  @Autowired
  private EmployeeService employeeService;

  @Test
  void testGetEmployeeDetailsById() {

    EmployeeDetails employeeDetails = employeeService.getEmployeeDetailsById(100);

    System.out.println(employeeDetails.toString());
  }

}
