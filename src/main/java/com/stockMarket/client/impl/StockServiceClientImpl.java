package com.stockMarket.client.impl;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import com.stockMarket.client.intf.StockServiceClient;
import com.stockMarket.model.StockDetails;
import com.stockMarket.model.StockDetailsResponse;
import com.stockMarket.model.StockRangeQueryParams;
import com.stockMarket.model.StockResponseBean;

@Component
public class StockServiceClientImpl implements StockServiceClient {

	@Value("${stockService.addStockUrl}")
	private String addStockUrl;

	@Value("${stockService.getStockUrl}")
	private String getStockUrl;

	@Value("${stockService.deleteUrl}")
	private String deleteUrl;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public StockResponseBean addStock(StockDetails stockDetails, String companyCode) {
		UriTemplate uriTemplate = new UriTemplate(addStockUrl);
		URI uri = uriTemplate.expand(companyCode);
		StockResponseBean stockDetailsResponse = restTemplate
				.postForEntity(uri, stockDetails, StockResponseBean.class).getBody();
		if (stockDetailsResponse == null) {
			// throw Exception
		}
		return stockDetailsResponse;
	}

	@Override
	public StockDetailsResponse getStockInRange(StockRangeQueryParams params) {
		StockDetailsResponse stockDetailsResponse = restTemplate
				.postForEntity(getStockUrl, params, StockDetailsResponse.class).getBody();
		return stockDetailsResponse;
	}

	@Override
	public void deleteStocks(String companyCode) {
		UriTemplate uriTemplate = new UriTemplate(deleteUrl);
		URI uri = uriTemplate.expand(companyCode);
		restTemplate.delete(uri);
	}
}
