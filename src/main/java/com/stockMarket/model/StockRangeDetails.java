package com.stockMarket.model;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class StockRangeDetails {

	private BigDecimal minPrice;
	private BigDecimal maxPrice;
	private BigDecimal avgPrice;
	private String currencyCode;
	private List<PriceTime> priceList;
	
	
}
