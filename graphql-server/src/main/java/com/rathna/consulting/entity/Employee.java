package com.rathna.consulting.entity;



import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

  @Id
  @Column("employee_id")
  private Integer employeeId;
  @Column("first_name")
  private String firstName;
  @Column("last_name")
  private String lastName;
  private String email;
  @Column("hire_date")
  private Date hireDate;
  @Column("job_id")
  private Integer jobId;
  private Float salary;
  @Column("manager_id")
  private Integer managerId;
  @Column("department_id")
  private Integer departmentId;

}

