/**
 * 
 */
package com.stockMarket.model;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * @author User
 *
 */
public class CompanyResponseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private long code;
	private String name;
	private String ceo;
	private BigInteger turnOver;
	private String currencyCode;
	private String url;
	private String stockExchange;

	/**
	 * @return the code
	 */
	public long getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(long code) {
		this.code = code;
	}

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
	 * @return the ceo
	 */
	public String getCeo() {
		return ceo;
	}

	/**
	 * @param ceo the ceo to set
	 */
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	/**
	 * @return the turnOver
	 */
	public BigInteger getTurnOver() {
		return turnOver;
	}

	/**
	 * @param turnOver the turnOver to set
	 */
	public void setTurnOver(BigInteger turnOver) {
		this.turnOver = turnOver;
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
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the stockExchange
	 */
	public String getStockExchange() {
		return stockExchange;
	}

	/**
	 * @param stockExchange the stockExchange to set
	 */
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

}
