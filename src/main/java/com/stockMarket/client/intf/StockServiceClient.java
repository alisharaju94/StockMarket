package com.stockMarket.client.intf;

import com.stockMarket.model.StockDetails;
import com.stockMarket.model.StockDetailsResponse;
import com.stockMarket.model.StockRangeQueryParams;
import com.stockMarket.model.StockResponseBean;

public interface StockServiceClient {

	StockResponseBean addStock(StockDetails stockDetails, String companyCode);
	
	StockDetailsResponse getStockInRange(StockRangeQueryParams params);

	void deleteStocks(String companyCode);

	StockResponseBean getLatestStockPriceForComCode(String companyCode);
}
