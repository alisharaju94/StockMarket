package com.stockMarket.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.stockMarket.constants.ValidationMessages;
import com.stockMarket.validators.CurrCodeValidity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Stock implements Serializable{

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Stock unique code. Required only for data manipulation ops", example = "S_000000", allowEmptyValue = true)
	private String code;

	@NotEmpty(message = ValidationMessages.STOCK_NAME)
	@ApiModelProperty(notes = "Stock name", example = "XYZ1 stock")
	private String name;

	@NotNull(message = ValidationMessages.STOCK_PRICE)
	@ApiModelProperty(notes = "Price of a unit", example = "30.15")
	private BigDecimal price;

	@CurrCodeValidity
	@ApiModelProperty(notes = "Currency code. This should be a 3 letter code.", example = "INR")
	private String currencyCode;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the currencyCode
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * @param currencyCode the currencyCode to set
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
