package com.anshul.learnmicroservices.job.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anshul.learnmicroservices.company.Company;
import com.anshul.learnmicroservices.company.CompanyRepository;
import com.anshul.learnmicroservices.company.CompanyService;

@Service
public class CompanyServiceImpls implements CompanyService {

	@Autowired
	public CompanyRepository companyRepository;

	@Override
	public List<Company> getAllCompanies() {
		// TODO Auto-generated method stub
		return companyRepository.findAll();
	}

	@Override
	public String updateCompany(Company current, Company company) {
		current.setName(company.getName());
		current.setDescriptions(company.getDescriptions());
		companyRepository.save(current);
		return "resource updated successfully";

	}

	@Override
	public Optional<Company> getCompanyById(UUID id) {
		return companyRepository.findById(id);
	}

	@Override
	public String deleteComapany(Company company) {
		companyRepository.delete(company);
		return "resource deleted successfuly";
	}

	@Override
	public void createCompany(Company company) {
		companyRepository.save(company);
		
	}

}
