package com.anshul.learnmicroservices.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anshul.learnmicroservices.entities.Job;
import com.anshul.learnmicroservices.services.JobService;

@RestController
//@RequestMapping("/jobs")
public class JobController {

	@Autowired
	private JobService jobService;

	@GetMapping("/jobs")
	public ResponseEntity<List<Job>> findAll() {
		return ResponseEntity.ok(jobService.findAll());
	}

	@PostMapping("/jobs")
	public ResponseEntity<String> createJob(@RequestBody Job job) {
		jobService.createJob(job);
		return new ResponseEntity<>("Job added successfully", HttpStatus.CREATED);
	}

	@GetMapping("/jobs/{id}")
	public ResponseEntity<Job> getJobById(@PathVariable UUID id) {
		Optional<Job> job = jobService.getJobById(id);
		return (job.isPresent() ? new ResponseEntity<>(job.get(), HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("/jobs/{id}")
	public ResponseEntity<String> deleteJob(@PathVariable UUID id) {
		Optional<Job> job = jobService.getJobById(id);
		return (job.isPresent() ? new ResponseEntity<>(jobService.deleteJob(job.get()), HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	//@PutMapping("/jobs/{id}")
	@RequestMapping(value="/jobs/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateJob(@PathVariable UUID id, @RequestBody Job updatedJob){
		Optional<Job> job = jobService.getJobById(id);
		return (job.isPresent() ? new ResponseEntity<>(jobService.updateJob(job.get(), updatedJob), HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
