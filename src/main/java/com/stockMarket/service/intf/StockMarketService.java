/**
 * 
 */
package com.stockMarket.service.intf;

import com.stockMarket.model.CompanyList;
import com.stockMarket.model.MarketResponse;
import com.stockMarket.model.StockMarketRequest;
import com.stockMarket.model.StockRangeDetails;

/**
 * @author User
 *
 */
public interface StockMarketService {

	MarketResponse addCompany(StockMarketRequest stockMarketRequest) throws Exception;

	CompanyList getAll() throws Exception;
	
	StockRangeDetails getStockInRange(String comCode, String strtDate, String endDate);

	void deleteCompany(long companyCode);
}
