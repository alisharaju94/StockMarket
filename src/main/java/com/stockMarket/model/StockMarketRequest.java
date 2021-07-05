package com.stockMarket.model;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.stockMarket.constants.ValidationMessages;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about company and stocks")
public class StockMarketRequest implements Serializable{

	private static final long serialVersionUID = -6709622346269621275L;

	@Valid
	@NotNull(message = ValidationMessages.COMPANY_DETAILS)
	@ApiModelProperty
	private Company companyDetails;
	
	@Valid
	@NotNull(message = ValidationMessages.STOCK_DETAILS)
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
