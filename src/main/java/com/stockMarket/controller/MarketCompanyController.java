package com.stockMarket.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockMarket.model.CompanyInfoBean;
import com.stockMarket.model.CompanyList;
import com.stockMarket.model.MarketResponse;
import com.stockMarket.model.StockMarketRequest;
import com.stockMarket.service.intf.StockMarketService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/market/company")
public class MarketCompanyController {
	public static final Logger LOGGER = LogManager.getLogger(MarketCompanyController.class);

	@Autowired
	StockMarketService marketService;

	@PostMapping(value = "/register")
	@ApiOperation(value = "Register a company", notes = "Endpoint to register a company and it's stock details.", response = MarketResponse.class)
	public MarketResponse registerCompany(
			@ApiParam(value = "stockMarketRequest", required = true) @RequestBody @Valid StockMarketRequest stockMarketRequest)
			throws Exception {
		LOGGER.info("Register company request intiated {}", stockMarketRequest);
		return marketService.addCompany(stockMarketRequest);
	}

	@GetMapping(value = "/getAll")
	@ApiOperation(value = "Get details of all companies", response = CompanyList.class)
	public CompanyList getAllCompany() throws Exception {
		LOGGER.info("Get all company details API invoked");
		return marketService.getAll();
	}

	@GetMapping(value = "/info/{companyCode}")
	@ApiOperation(value = "Get details of all companies", response = CompanyList.class)
	public CompanyInfoBean getAllCompany(@ApiParam(value = "companyCode", required = true) @PathVariable String companyCode)
			throws Exception {
		LOGGER.info("Get company details for companyID = {} invoked", companyCode);
		return marketService.getCompanyInfo(companyCode);
	}

	@DeleteMapping(value = "/{companyCode}")
	@ApiOperation(value = "Delete a company")
	public ResponseEntity deleteCompany(
			@ApiParam(value = "companyCode", required = true) @PathVariable String companyCode) throws Exception {
		LOGGER.info("Delete company with companyID = {} invoked", companyCode);
		marketService.deleteCompany(companyCode);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
