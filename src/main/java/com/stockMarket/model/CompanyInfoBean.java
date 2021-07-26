package com.stockMarket.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import lombok.Data;

@Data
public class CompanyInfoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String comCode;
	private String name;
	private String ceo;
	private BigInteger turnOver;
	private BigDecimal latestStockPrice;
	private String currencyCode;
	private String url;
	private String stockExchange;
}
