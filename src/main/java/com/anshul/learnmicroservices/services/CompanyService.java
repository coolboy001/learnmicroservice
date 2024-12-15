package com.anshul.learnmicroservices.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.anshul.learnmicroservices.entities.Company;


public interface CompanyService {
	
	public List<Company> getAllCompanies();
	public String updateCompany(Company currCompany, Company company);
	public Optional<Company> getCompanyById(UUID id);
	public String deleteComapany(Company company);
	public void createCompany(Company company);
}
