package com.anshul.learnmicroservices.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anshul.learnmicroservices.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, UUID> {
	List<Review> findByCompanyId(UUID comapnyId);
}
