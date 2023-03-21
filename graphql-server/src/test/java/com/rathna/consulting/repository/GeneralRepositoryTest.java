package com.rathna.consulting.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rathna.consulting.entity.Country;
import com.rathna.consulting.entity.Dependent;

@SpringBootTest
public class GeneralRepositoryTest {

	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private DependentRepository dependentRepository;
	

	@Test
	void saveCountry() {

		Country india = Country.builder().countryId("IND").countryName("India").regionId(3).build();
		Optional<Country> country;
		
		countryRepository.save(india);
		country = countryRepository.findById("IND");
		assertEquals(country.get().getCountryName(), "India");

		countryRepository.deleteById("IND");
		country = countryRepository.findById("IND");
		assertTrue(country.isEmpty());

	}

	@Test
	void dependentRepositoryTest() {
		
		List<Dependent> xDependents=	dependentRepository.findByEmployeeId(206);
		
		assertNotNull(xDependents);
	}
	
	
}
