/**
 * 
 */
package com.stockMarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockMarket.client.intf.CompanyServiceClient;
import com.stockMarket.client.intf.StockServiceClient;
import com.stockMarket.model.CompanyResponseBean;
import com.stockMarket.model.MarketResponse;
import com.stockMarket.model.StockDetailsResponse;
import com.stockMarket.model.StockMarketRequest;
import com.stockMarket.service.intf.StockMarketService;

/**
 * @author User
 *
 */
@Service
public class StockMarketServiceImpl implements StockMarketService {

	private CompanyServiceClient companyServiceClient;
	private StockServiceClient stockServiceClient;

	@Autowired
	public StockMarketServiceImpl(CompanyServiceClient companyServiceClient, StockServiceClient stockServiceClient) {
		this.companyServiceClient = companyServiceClient;
		this.stockServiceClient = stockServiceClient;
	}

	@Override
	public MarketResponse addCompany(StockMarketRequest stockMarketRequest) throws Exception {
		MarketResponse marketResponse = new MarketResponse();
		CompanyResponseBean companyRes = companyServiceClient.addCompany(stockMarketRequest.getCompanyDetails());
		if (companyRes == null) {
			throw new Exception();
		}
		marketResponse.setCompanyDetails(companyRes);
		StockDetailsResponse stockDetailsResponse = stockServiceClient.addStock(stockMarketRequest.getStockDetails(), companyRes.getCode());
		if(stockDetailsResponse == null) {
			throw new Exception();
		}
		marketResponse.setStockDetailsResponse(stockDetailsResponse);
		return marketResponse;
	}

}
