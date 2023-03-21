package com.rathna.consulting.entity;



import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
public class Employee {

  @Id

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "employee_id")
  private Integer employeeId;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
  private String email;
  @Column(name = "hire_date")
  private Date hireDate;
  @Column(name = "job_id")
  private Integer jobId;
  private Float salary;
  @Column(name = "manager_id")
  private Integer managerId;
  @Column(name = "department_id")
  private Integer departmentId;

}

