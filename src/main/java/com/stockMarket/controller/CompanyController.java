package com.stockMarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockMarket.model.Company;
import com.stockMarket.service.intf.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	CompanyService companyService;

	@PostMapping(value = "/add")
	public String addCompany(Company company){
		companyService.addCompany(company);
		return "Hello there!";
	}
	
	@GetMapping("/getAll")
	public String getAllCompany() {
		return "Hello there!";
	}
}
