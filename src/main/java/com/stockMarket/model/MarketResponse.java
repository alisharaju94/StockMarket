/**
 * 
 */
package com.stockMarket.model;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.Data;

/**
 * @author User
 *
 */
@Data
@ApiResponse
public class MarketResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private CompanyResponseBean companyDetails;
	private StockResponseBean stockDetails;

}
