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
@Table(name = "departments")
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name= "department_id")
	private Integer departmentId;
	@Column(name= "department_name")
	private String departmentName;
	@Column(name= "locationId")
	private Integer locationId;

}
