package com.anshul.learnmicroservices.job;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JobService {

	public List<Job> findAll();

	public void createJob(Job job);

	public Optional<Job> getJobById(UUID id);
	
	public String deleteJob(Job job);
	
	public String updateJob(Job currentJob, Job job);
}
