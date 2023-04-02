package com.rathna.consulting.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "countries")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Country {
  @Id
  @Column("country_id")
  private String countryId;
  @Column("country_name")
  private String countryName;
  @Column("region_id")
  private Integer regionId;

}
