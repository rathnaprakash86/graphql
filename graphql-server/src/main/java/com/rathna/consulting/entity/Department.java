package com.rathna.consulting.entity;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "departments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

  @org.springframework.data.annotation.Id
  @Column("department_id")
  private Integer departmentId;
  @Column("department_name")
  private String departmentName;
  @Column("locationId")
  private Integer locationId;

}
