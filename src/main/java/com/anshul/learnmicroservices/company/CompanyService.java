package com.anshul.learnmicroservices.company;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface CompanyService {
	
	public List<Company> getAllCompanies();
	public String updateCompany(Company currCompany, Company company);
	public Optional<Company> getCompanyById(UUID id);
	public String deleteComapany(Company company);
	public void createCompany(Company company);
}
