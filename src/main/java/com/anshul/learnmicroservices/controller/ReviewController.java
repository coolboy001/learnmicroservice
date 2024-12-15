package com.anshul.learnmicroservices.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anshul.learnmicroservices.entities.Review;
import com.anshul.learnmicroservices.services.ReviewService;

@RestController
@RequestMapping("/companies/{companyId}/reviews")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	@GetMapping
	public ResponseEntity<List<Review>> getAllReviews(@PathVariable UUID companyId){
		return new ResponseEntity<List<Review>>(reviewService.getAllReviewByCompany(companyId), HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<String> createReview(@PathVariable UUID companyId, @RequestBody Review review ){
		reviewService.createReview(review, companyId);
		return new ResponseEntity<String>("created successfully", HttpStatus.CREATED);
	}
}
