/**
 * 
 */
package com.stockMarket.model;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

/**
 * @author ALISH
 *
 */
@Data
public class StockRangeQueryParams implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long companyCode;
	private Timestamp start;
	private Timestamp end;

}
