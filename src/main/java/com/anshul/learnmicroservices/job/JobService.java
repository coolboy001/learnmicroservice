package com.anshul.learnmicroservices.job;

import java.util.List;
import java.util.Optional;

public interface JobService {

	public List<Job> findAll();

	public void createJob(Job job);

	public Optional<Job> getJobById(Long id);
}
