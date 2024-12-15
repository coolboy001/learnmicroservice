package com.anshul.learnmicroservices.services;

import java.util.List;
import java.util.UUID;

import com.anshul.learnmicroservices.entities.Review;

public interface ReviewService {
	public List<Review> getAllReviewByCompany(UUID companyId);
	public void createReview(Review review, UUID companyId);
}
