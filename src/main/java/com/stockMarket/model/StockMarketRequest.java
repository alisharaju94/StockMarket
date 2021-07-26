package com.stockMarket.model;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.stockMarket.constants.ValidationMessages;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
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
}
