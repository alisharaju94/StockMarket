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

@Component
public class StockServiceClientImpl implements StockServiceClient {

	@Value("${stockService.addStockUrl}")
	private String addStockUrl;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public StockDetailsResponse addStock(StockDetails stockDetails, long companyCode) {
		UriTemplate uriTemplate = new UriTemplate(addStockUrl);
		URI uri = uriTemplate.expand(companyCode);
		StockDetailsResponse stockDetailsResponse = restTemplate
				.postForEntity(uri, stockDetails, StockDetailsResponse.class).getBody();
		return stockDetailsResponse;
	}

}
