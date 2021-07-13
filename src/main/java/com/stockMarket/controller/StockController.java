package com.stockMarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockMarket.model.StockRangeDetails;
import com.stockMarket.service.intf.StockMarketService;

@RestController
@RequestMapping("/market/stock")
public class StockController {

	@Autowired
	private StockMarketService stockMarketService;
	
	@GetMapping(value = "/{companyCode}/{strtDate}/{endDate}")
	public StockRangeDetails getStockForRange(@PathVariable("companyCode") long companyCode,
			@PathVariable("strtDate") String strtDate, @PathVariable("endDate") String endDate) {
			return stockMarketService.getStockInRange(companyCode, strtDate, endDate);
	}
}
