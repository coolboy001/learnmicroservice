package com.anshul.learnmicroservices.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anshul.learnmicroservices.entities.Review;
import com.anshul.learnmicroservices.repositories.ReviewRepository;
import com.anshul.learnmicroservices.services.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;

	@Override
	public List<Review> getAllReviewByCompany(UUID companyId) {
		// TODO Auto-generated method stub
		return reviewRepository.findByCompanyId(companyId);
	}

}
