/**
 * 
 */
package com.stockMarket.model;

import java.io.Serializable;

import lombok.Data;

/**
 * @author User
 *
 */
@Data
public class MarketResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private CompanyResponseBean companyDetails;
	private StockResponseBean stockDetails;

}
