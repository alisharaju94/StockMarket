package com.stockMarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockMarket.model.Company;
import com.stockMarket.model.MarketResponse;
import com.stockMarket.model.StockMarketRequest;
import com.stockMarket.service.intf.StockMarketService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/market/company")
public class MarketCompanyController {

	@Autowired
	StockMarketService marketService;

	@PostMapping(value = "/add")
	@ApiOperation(value = "Register a company", notes = "Endpoint to register a company and it's stock details.", response = MarketResponse.class)
	public MarketResponse addCompany(@RequestBody @ApiParam StockMarketRequest stockMarketRequest) throws Exception {
		return marketService.addCompany(stockMarketRequest);
	}

	@GetMapping("/getAll")
	public String getAllCompany() {
		return "Hello there!";
	}
}
