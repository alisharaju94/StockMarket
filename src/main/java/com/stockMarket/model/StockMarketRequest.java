package com.stockMarket.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about company and stocks")
public class StockMarketRequest {

	@ApiModelProperty
	private Company companyDetails;
	@ApiModelProperty
	private StockDetails stockDetails;

	/**
	 * @return the companyDetails
	 */
	public Company getCompanyDetails() {
		return companyDetails;
	}

	/**
	 * @param companyDetails the companyDetails to set
	 */
	public void setCompanyDetails(Company companyDetails) {
		this.companyDetails = companyDetails;
	}

	/**
	 * @return the stockDetails
	 */
	public StockDetails getStockDetails() {
		return stockDetails;
	}

	/**
	 * @param stockDetails the stockDetails to set
	 */
	public void setStockDetails(StockDetails stockDetails) {
		this.stockDetails = stockDetails;
	}

}
