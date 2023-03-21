package com.rathna.consulting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rathna.consulting.entity.Country;

public interface CountryRepository extends JpaRepository<Country,String> {

}
