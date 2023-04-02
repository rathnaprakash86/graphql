package com.rathna.consulting.repository;



import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.rathna.consulting.entity.Region;

public interface RegionRepository extends ReactiveCrudRepository<Region, Integer> {

}
