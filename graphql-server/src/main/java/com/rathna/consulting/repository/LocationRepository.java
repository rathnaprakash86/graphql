package com.rathna.consulting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rathna.consulting.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
