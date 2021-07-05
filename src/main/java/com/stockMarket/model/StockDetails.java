package com.stockMarket.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.stockMarket.constants.CommonConstants;
import com.stockMarket.constants.ValidationMessages;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class StockDetails implements Serializable{

	private static final long serialVersionUID = 1L;

	@Valid
	@NotNull
	@Size(min = CommonConstants.INT_ONE, message = ValidationMessages.STOCK_LIST)
	@ApiModelProperty(notes = "Stock details of the company. Atleast one stock detail is needed at the time of registration")
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
