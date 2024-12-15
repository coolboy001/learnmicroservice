package com.anshul.learnmicroservices.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anshul.learnmicroservices.entities.Company;


public interface CompanyRepository extends JpaRepository<Company, UUID>{

}
