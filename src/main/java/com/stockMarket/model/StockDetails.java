package com.stockMarket.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import com.stockMarket.constants.ValidationMessages;
import com.stockMarket.validators.CurrCodeValidity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class StockDetails implements Serializable{

	private static final long serialVersionUID = 1L;


	@NotNull(message = ValidationMessages.STOCK_PRICE)
	@ApiModelProperty(notes = "Price of a unit", example = "30.15")
	private BigDecimal price;

	@CurrCodeValidity
	@ApiModelProperty(notes = "Currency code. This should be a 3 letter code.", example = "INR")
	private String currencyCode;

}
