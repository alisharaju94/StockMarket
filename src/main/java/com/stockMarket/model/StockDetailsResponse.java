/**
 * 
 */
package com.stockMarket.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author User
 *
 */
public class StockDetailsResponse implements Serializable {

	private static final long serialVersionUID = 1L;
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
