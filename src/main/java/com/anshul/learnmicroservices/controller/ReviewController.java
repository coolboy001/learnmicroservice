package com.anshul.learnmicroservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ResponseEntity<List<Review>> getAllReviews(){
		
	}
}
