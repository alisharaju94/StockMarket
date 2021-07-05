package com.stockMarket.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.stockMarket.constants.CommonConstants;
import com.stockMarket.constants.ValidationMessages;
import com.stockMarket.validators.CurrCodeValidity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "The company unique code. Required only for data manipulation ops", example = "1", allowEmptyValue = true)
	private String companyCode;

	@NotEmpty(message = ValidationMessages.COMPANY_NAME)
	@ApiModelProperty(notes = "The company name", example = "XYZ")
	private String companyName;

	@NotEmpty(message = ValidationMessages.COMPANY_CEO)
	@ApiModelProperty(notes = "Company CEO name", example = "Marc Alderson")
	private String companyCEO;

	@Min(value = CommonConstants.TEN_CR, message = ValidationMessages.COMPANY_TURN_OVER)
	@ApiModelProperty(notes = "The company trun over. Minimum value should be 10 Cr.", example = "100000000")
	private BigInteger companyTurnOver;

	@CurrCodeValidity
	@ApiModelProperty(notes = "Currency code. This should be a 3 letter code.", example = "INR")
	private String currencyCode;

	@NotEmpty(message = ValidationMessages.COMPANY_URL)
	@ApiModelProperty(notes = "The company url", example = "www.xyz.com")
	private String companyUrl;

	@NotEmpty(message = ValidationMessages.COMPANY_STOCK_EXCHANGE)
	@ApiModelProperty(notes = "The stock exchange in which the company is listed in", example = "NSE")
	private String stockExchange;
}
