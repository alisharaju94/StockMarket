package com.stockMarket.model;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class StockDetails {

	@ApiModelProperty(notes = "Stoc details of the company. Atleast one stock detail is needed at the time of registration")
	private List<Stock> stocks;

	/**
	 * @return the stocks
	 */
	public List<Stock> getStocks() {
		return stocks;
	}

	/**
	 * @param stocks the stocks to set
	 */
	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

}
