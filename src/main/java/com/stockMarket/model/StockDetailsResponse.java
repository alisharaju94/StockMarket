/**
 * 
 */
package com.stockMarket.model;

import java.util.List;

/**
 * @author User
 *
 */
public class StockDetailsResponse {

	private List<StockResponseBean> stockDetails;

	/**
	 * @return the stockDetails
	 */
	public List<StockResponseBean> getStockDetails() {
		return stockDetails;
	}

	/**
	 * @param stockDetails the stockDetails to set
	 */
	public void setStockDetails(List<StockResponseBean> stockDetails) {
		this.stockDetails = stockDetails;
	}
	
}
