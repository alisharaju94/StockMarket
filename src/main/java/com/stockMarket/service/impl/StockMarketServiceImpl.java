/**
 * 
 */
package com.stockMarket.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockMarket.client.intf.CompanyServiceClient;
import com.stockMarket.client.intf.StockServiceClient;
import com.stockMarket.constants.CommonConstants;
import com.stockMarket.mapper.StockDataMapper;
import com.stockMarket.model.CompanyList;
import com.stockMarket.model.CompanyResponseBean;
import com.stockMarket.model.MarketResponse;
import com.stockMarket.model.StockDetailsResponse;
import com.stockMarket.model.StockMarketRequest;
import com.stockMarket.model.StockRangeDetails;
import com.stockMarket.model.StockRangeQueryParams;
import com.stockMarket.model.StockResponseBean;
import com.stockMarket.service.intf.StockMarketService;

/**
 * @author User
 *
 */
@Service
public class StockMarketServiceImpl implements StockMarketService {

	private CompanyServiceClient companyServiceClient;
	private StockServiceClient stockServiceClient;
	private StockDataMapper stockDataMapper;

	@Autowired
	public StockMarketServiceImpl(CompanyServiceClient companyServiceClient, StockServiceClient stockServiceClient,
			StockDataMapper stockDataMapper) {
		this.companyServiceClient = companyServiceClient;
		this.stockServiceClient = stockServiceClient;
		this.stockDataMapper = stockDataMapper;
	}

	@Override
	public MarketResponse addCompany(StockMarketRequest stockMarketRequest) throws Exception {
		CompanyResponseBean companyRes = companyServiceClient.addCompany(stockMarketRequest.getCompanyDetails());
		if (companyRes != null) {
			MarketResponse marketResponse = new MarketResponse();
			marketResponse.setCompanyDetails(companyRes);
			StockResponseBean stockDetailsResponse = stockServiceClient.addStock(stockMarketRequest.getStockDetails(),
					companyRes.getComCode());
			marketResponse.setStockDetails(stockDetailsResponse);
			return marketResponse;
		}

		return null;
	}

	@Override
	public CompanyList getAll() throws Exception {
		return companyServiceClient.getAll();
	}

	@Override
	public StockRangeDetails getStockInRange(String comCode, String strtDate, String endDate) {
		StockRangeQueryParams params = new StockRangeQueryParams();
		params.setCompanyCode(comCode);
		params.setStart(getTimeStamp(strtDate, CommonConstants.START));
		params.setEnd(getTimeStamp(endDate, CommonConstants.END));
		StockDetailsResponse stockRes = stockServiceClient.getStockInRange(params);
		return stockDataMapper.mapStockRangeQueryRes(stockRes);
	}

	private Timestamp getTimeStamp(String date, String identifier) {
		Timestamp timeStamp = null;
		Date parsedDate = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(CommonConstants.DATE_FORMAT);
			parsedDate = dateFormat.parse(date);
			if (DateUtils.isSameDay(parsedDate, CommonConstants.today())) {
				timeStamp = Timestamp.from(Instant.now());
				int field = StringUtils.equals(CommonConstants.START, identifier) ? Calendar.DATE : Calendar.MINUTE;
				parsedDate = DateUtils.truncate(timeStamp, field);
			}
			timeStamp = new Timestamp(parsedDate.getTime());

		} catch (Exception e) {
			// look the origin of excption
		}

		return timeStamp;
	}

	@Override
	public void deleteCompany(long companyCode) {
		companyServiceClient.deleteCompany(companyCode);
		stockServiceClient.deleteStocks(companyCode);
	}

}