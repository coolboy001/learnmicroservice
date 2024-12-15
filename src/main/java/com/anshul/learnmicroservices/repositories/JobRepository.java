package com.anshul.learnmicroservices.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anshul.learnmicroservices.entities.Job;

@Repository
public interface JobRepository  extends JpaRepository<Job, UUID>{

}
