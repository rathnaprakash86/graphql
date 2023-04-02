package com.rathna.consulting.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "locations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {

  @Id
  @Column("location_id")
  private Integer locationId;
  @Column("street_address")
  private String streeAddress;
  @Column("postal_code")
  private String postalCode;
  private String city;
  @Column("country_id")
  private String countryId;



}
