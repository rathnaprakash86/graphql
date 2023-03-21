package com.rathna.consulting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rathna.consulting.entity.JobInfo;

public interface JobRepository extends JpaRepository<JobInfo, Integer> {

}
