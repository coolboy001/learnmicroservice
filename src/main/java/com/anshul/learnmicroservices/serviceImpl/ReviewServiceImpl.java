package com.anshul.learnmicroservices.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anshul.learnmicroservices.entities.Company;
import com.anshul.learnmicroservices.entities.Review;
import com.anshul.learnmicroservices.repositories.ReviewRepository;
import com.anshul.learnmicroservices.services.CompanyService;
import com.anshul.learnmicroservices.services.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private CompanyService companyService;

	@Override
	public List<Review> getAllReviewByCompany(UUID companyId) {
		// TODO Auto-generated method stub
		return reviewRepository.findByCompanyId(companyId);
	}

	@Override
	public void createReview(Review review, UUID companyId) {
		Optional<Company> company = companyService.getCompanyById(companyId);
		review.setCompany(company.orElse(null));
		reviewRepository.save(review);
		
	}

}
