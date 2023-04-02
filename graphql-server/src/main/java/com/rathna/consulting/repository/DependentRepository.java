package com.rathna.consulting.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.rathna.consulting.entity.Dependent;
import reactor.core.publisher.Flux;

public interface DependentRepository extends ReactiveCrudRepository<Dependent, Integer> {

  public Flux<Dependent> findByEmployeeId(Integer emp_id);


}
