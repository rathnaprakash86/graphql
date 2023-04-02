package com.rathna.consulting.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.rathna.consulting.entity.Location;

public interface LocationRepository extends ReactiveCrudRepository<Location, Integer> {

}
