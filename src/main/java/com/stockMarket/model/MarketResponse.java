/**
 * 
 */
package com.stockMarket.model;

/**
 * @author User
 *
 */
public class MarketResponse {

	private CompanyResponseBean companyDetails;
	private StockDetailsResponse stockDetailsResponse;

	/**
	 * @return the companyDetails
	 */
	public CompanyResponseBean getCompanyDetails() {
		return companyDetails;
	}

	/**
	 * @param companyDetails the companyDetails to set
	 */
	public void setCompanyDetails(CompanyResponseBean companyDetails) {
		this.companyDetails = companyDetails;
	}

	/**
	 * @return the stockDetailsResponse
	 */
	public StockDetailsResponse getStockDetailsResponse() {
		return stockDetailsResponse;
	}

	/**
	 * @param stockDetailsResponse the stockDetailsResponse to set
	 */
	public void setStockDetailsResponse(StockDetailsResponse stockDetailsResponse) {
		this.stockDetailsResponse = stockDetailsResponse;
	}

}
