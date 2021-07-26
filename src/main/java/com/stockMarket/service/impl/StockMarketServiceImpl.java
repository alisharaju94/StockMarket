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
import com.stockMarket.model.CompanyInfoBean;
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

	@Override
	public void deleteCompany(String companyCode) {
		companyServiceClient.deleteCompany(companyCode);
		stockServiceClient.deleteStocks(companyCode);
	}

	private long getTimeStamp(String date, String identifier) {
		if (!StringUtils.isEmpty(date)) {
			Date parsedDate = null;
			try {
				parsedDate = DateUtils.parseDate(date, CommonConstants.DATE_FORMAT);
				if (StringUtils.equals(CommonConstants.END, identifier)) {
					parsedDate = processEndDate(parsedDate);
				}
				return parsedDate.getTime();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	private Date processEndDate(Date parsedDate) {
		if (DateUtils.isSameDay(parsedDate, CommonConstants.today())) {
			Timestamp timeStamp = Timestamp.from(Instant.now());
			parsedDate = DateUtils.truncate(timeStamp, Calendar.MINUTE);
			return parsedDate;
		}
		parsedDate = DateUtils.addHours(parsedDate, 23);
		parsedDate = DateUtils.addMinutes(parsedDate, 59);
		parsedDate = DateUtils.addSeconds(parsedDate, 59);
		return parsedDate;
	}

	@Override
	public CompanyInfoBean getCompanyInfo(String companyCode) throws Exception {
		companyServiceClient.getCompanyInfo(companyCode);
		return null;
	}

}