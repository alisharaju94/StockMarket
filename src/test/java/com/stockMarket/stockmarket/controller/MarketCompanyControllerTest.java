package com.stockMarket.stockmarket.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.stockMarket.controller.MarketCompanyController;
import com.stockMarket.model.Company;
import com.stockMarket.model.CompanyResponseBean;
import com.stockMarket.model.MarketResponse;
import com.stockMarket.model.StockDetails;
import com.stockMarket.model.StockMarketRequest;
import com.stockMarket.model.StockResponseBean;
import com.stockMarket.service.intf.StockMarketService;

@RunWith(MockitoJUnitRunner.class)
public class MarketCompanyControllerTest {

	@InjectMocks
	private MarketCompanyController marketCompanyController;
	
	@Mock
	private StockMarketService stockMarketService;
	
	@Test
	public void testRegisterCompany() throws Exception {
		StockMarketRequest request = getStockMarketRequest();
		when(stockMarketService.addCompany(Mockito.any(StockMarketRequest.class))).thenReturn(getRegComResponse());
		MarketResponse response =  marketCompanyController.registerCompany(request);
		assertEquals("C_000000", response.getCompanyDetails().getComCode());
	}

	private MarketResponse getRegComResponse() {
		MarketResponse repsonse = new MarketResponse();
		CompanyResponseBean companyDetails = new CompanyResponseBean();
		companyDetails.setCeo("fname lname");
		companyDetails.setComCode("C_000000");
		companyDetails.setCurrencyCode("INR");
		companyDetails.setName("XYZ");
		companyDetails.setStockExchange("NSE");
		companyDetails.setTurnOver(BigInteger.valueOf(100000000));
		companyDetails.setUrl("www.xyz.com");
		repsonse.setCompanyDetails(companyDetails);
		StockResponseBean stockDetails = new StockResponseBean();
		stockDetails.setPrice(BigDecimal.valueOf(30.18));
		stockDetails.setCurrencyCode("INR");
		stockDetails.setTimeStamp(Timestamp.from(Instant.now()));
		repsonse.setStockDetails(stockDetails);
		return repsonse;
	}

	private StockMarketRequest getStockMarketRequest() {
		StockMarketRequest request = new StockMarketRequest();
		request.setCompanyDetails(getCompanyDetails());
		request.setStockDetails(getStockDetails());
		return request;
	}

	private StockDetails getStockDetails() {
		StockDetails stockDetails = new StockDetails();
		stockDetails.setPrice(BigDecimal.valueOf(30.18));
		stockDetails.setCurrencyCode("INR");
		return stockDetails;
	}

	private Company getCompanyDetails() {
		Company companyDetails = new Company();
		companyDetails.setCompanyName("XYZ");
		companyDetails.setCompanyCEO("fname lname");
		companyDetails.setCompanyTurnOver(BigInteger.valueOf(100000000));
		companyDetails.setCompanyUrl("www.xyz.com");
		companyDetails.setStockExchange("NSE");
		return companyDetails;
	}
}
