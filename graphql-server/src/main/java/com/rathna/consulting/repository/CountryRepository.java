package com.rathna.consulting.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import com.rathna.consulting.entity.Country;

public interface CountryRepository extends R2dbcRepository<Country, String> {

}
