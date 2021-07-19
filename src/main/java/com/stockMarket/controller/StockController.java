package com.stockMarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stockMarket.constants.CommonConstants;
import com.stockMarket.model.StockRangeDetails;
import com.stockMarket.service.intf.StockMarketService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/market/stock")
public class StockController {

	@Autowired
	private StockMarketService stockMarketService;

	@GetMapping(value = "/{companyCode}")
	@ApiOperation(value = "Get Stock details", notes = "Fetches the stock details of a company as a whole or for a given range", response = StockRangeDetails.class)
	public StockRangeDetails getStockForRange(
			@ApiParam(value = "companyCode", required = true) @PathVariable("companyCode") String companyCode,
			@ApiParam(value = "strtDate", format = CommonConstants.DATE_FORMAT) @RequestParam("strtDate") String strtDate,
			@ApiParam(value = "endDate", format = CommonConstants.DATE_FORMAT) @RequestParam("endDate") String endDate) {
		return stockMarketService.getStockInRange(companyCode, strtDate, endDate);
	}
}
