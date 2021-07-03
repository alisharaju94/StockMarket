package com.stockMarket.client.intf;

import com.stockMarket.model.StockDetails;
import com.stockMarket.model.StockDetailsResponse;

public interface StockServiceClient {

	StockDetailsResponse addStock(StockDetails stockDetails, String string);
}
