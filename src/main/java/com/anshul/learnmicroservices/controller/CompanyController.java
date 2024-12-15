package com.anshul.learnmicroservices.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anshul.learnmicroservices.entities.Company;
import com.anshul.learnmicroservices.services.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@GetMapping
	public ResponseEntity<List<Company>> getAllCompanies() {
		return new ResponseEntity<List<Company>>(companyService.getAllCompanies(), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateCompany(@PathVariable UUID id, @RequestBody Company company){
		Optional<Company> currentCompany = companyService.getCompanyById(id);
		return currentCompany.isPresent() ? new ResponseEntity<String>(companyService.updateCompany(currentCompany.get(), company), HttpStatus.OK)
			: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable UUID id){
		Optional<Company> currentCompany = companyService.getCompanyById(id);
		return currentCompany.isPresent() ? new ResponseEntity<String>(companyService.deleteComapany(currentCompany.get()), HttpStatus.OK)
			: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<String> createCompany(@RequestBody Company company) {
		companyService.createCompany(company);
		return new ResponseEntity<String>("Created", HttpStatus.CREATED);
	} 
	
	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable UUID id){
		Optional<Company> currentCompany = companyService.getCompanyById(id);
		return currentCompany.isPresent() ? new ResponseEntity<Company>(currentCompany.get(), HttpStatus.OK)
			: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	

}
