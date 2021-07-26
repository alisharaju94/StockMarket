/**
 * 
 */
package com.stockMarket.model;

import java.io.Serializable;

import lombok.Data;

/**
 * @author ALISH
 *
 */
@Data
public class StockRangeQueryParams implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String companyCode;
	private long start;
	private long end;

}
