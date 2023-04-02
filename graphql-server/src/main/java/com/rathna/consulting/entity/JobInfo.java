package com.rathna.consulting.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobInfo {

  @Id
  @Column("job_id")
  private Integer jobId;
  @Column("job_title")
  private String jobTitle;
  @Column("min_salary")
  private Double minSalary;
  @Column("max_salary")
  private Double maxSalary;

}
