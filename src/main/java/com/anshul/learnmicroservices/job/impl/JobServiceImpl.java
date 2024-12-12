package com.anshul.learnmicroservices.job.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anshul.learnmicroservices.job.Job;
import com.anshul.learnmicroservices.job.JobService;

@Service
public class JobServiceImpl implements JobService {

	private List<Job> jobs = new ArrayList<Job>();
	private Long nextId = 1L;

	@Override
	public List<Job> findAll() {
		return jobs;
	}

	@Override
	public void createJob(Job job) {
		job.setId(nextId++);
		jobs.add(job);
	}
	
	public Optional<Job> getJobById(Long id) {
		return jobs.stream().
				filter(i -> i.getId().equals(id)).findFirst();
	}

}
