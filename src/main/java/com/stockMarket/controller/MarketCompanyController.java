package com.stockMarket.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockMarket.model.CompanyList;
import com.stockMarket.model.MarketResponse;
import com.stockMarket.model.StockMarketRequest;
import com.stockMarket.service.intf.StockMarketService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/market/company")
public class MarketCompanyController {

	@Autowired
	StockMarketService marketService;

	@PostMapping(value = "/register")
	@ApiOperation(value = "Register a company", notes = "Endpoint to register a company and it's stock details.", response = MarketResponse.class)
	public MarketResponse registerCompany(
			@ApiParam(value = "stockMarketRequest", required = true) @RequestBody @Valid StockMarketRequest stockMarketRequest)
			throws Exception {
		return marketService.addCompany(stockMarketRequest);
	}

	@GetMapping(value = "/getAll")
	public CompanyList getAllCompany() throws Exception {
		return marketService.getAll();
	}
	
	@DeleteMapping(value = "/{companyCode}")
	public ResponseEntity deleteCompany(@PathVariable long companyCode) throws Exception {
		marketService.deleteCompany(companyCode);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
