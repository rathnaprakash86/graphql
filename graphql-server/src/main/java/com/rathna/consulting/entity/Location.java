package com.rathna.consulting.entity;

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
@Table(name = "locations")
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
public class Location {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name = "location_id")
	private Integer locationId;
	@Column(name = "street_address")
	private String streeAddress;
	@Column(name = "postal_code")
	private String postalCode;
	private String city;
	@Column(name = "country_id")
	private String countryId;

	


}
