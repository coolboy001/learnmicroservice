package com.anshul.learnmicroservices.job.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anshul.learnmicroservices.job.Job;
import com.anshul.learnmicroservices.job.JobRepository;
import com.anshul.learnmicroservices.job.JobService;

@Service
public class JobServiceImpl implements JobService {
	
	@Autowired
	private JobRepository jobRepository;
	

	@Override
	public List<Job> findAll() {
		return jobRepository.findAll();
	}

	@Override
	public void createJob(Job job) {
		jobRepository.save(job);
	}

	public Optional<Job> getJobById(UUID id) {
		return jobRepository.findById(id);
	}

	@Override
	public String deleteJob(Job job) {
		jobRepository.delete(job);
		return "Job deleted successfully";
	}

	@Override
	public String updateJob(Job currentjob, Job job) {
		currentjob.setTitle(job.getTitle());
		currentjob.setDescription(job.getDescription());
		currentjob.setCompany(job.getCompany());
		jobRepository.save(currentjob);
		return "updated";
	}

}
