package com.rathna.consulting.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "dependents")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dependent {

  @Id
  private Integer dependent_id;

  @Column("first_name")
  private String firstName;
  @Column("last_name")
  private String lastName;
  private String relationship;
  @Column("employee_id")
  private Integer employeeId;

}
