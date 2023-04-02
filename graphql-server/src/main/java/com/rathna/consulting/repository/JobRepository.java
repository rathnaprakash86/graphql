package com.rathna.consulting.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.rathna.consulting.entity.JobInfo;

public interface JobRepository extends ReactiveCrudRepository<JobInfo, Integer> {

}
