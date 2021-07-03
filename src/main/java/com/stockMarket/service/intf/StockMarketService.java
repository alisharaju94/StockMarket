/**
 * 
 */
package com.stockMarket.service.intf;

import com.stockMarket.model.MarketResponse;
import com.stockMarket.model.StockMarketRequest;

/**
 * @author User
 *
 */
public interface StockMarketService {

	MarketResponse addCompany(StockMarketRequest stockMarketRequest) throws Exception;
}
