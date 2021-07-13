/**
 * 
 */
package com.stockMarket.model;

import java.io.Serializable;
import java.math.BigInteger;

import lombok.Data;

/**
 * @author User
 *
 */
@Data
public class CompanyResponseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String comCode;
	private String name;
	private String ceo;
	private BigInteger turnOver;
	private String currencyCode;
	private String url;
	private String stockExchange;
}
