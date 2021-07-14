package com.stockMarket.mapper;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.stockMarket.model.PriceTime;
import com.stockMarket.model.StockDetailsResponse;
import com.stockMarket.model.StockRangeDetails;
import com.stockMarket.model.StockResponseBean;

@Component
public class StockDataMapper {

	public StockRangeDetails mapStockRangeQueryRes(StockDetailsResponse stockRes) {
		if (stockRes != null) {
			StockRangeDetails rangeRes = new StockRangeDetails();
			Collections.sort(stockRes.getStockDetails(), Comparator.comparing(StockResponseBean::getPrice));
			populateStockRangeDetails(rangeRes, stockRes.getStockDetails());
			return rangeRes;
		}
		return null;
	}

	private void populateStockRangeDetails(StockRangeDetails rangeRes, List<StockResponseBean> valueList) {
		int lastIndex = valueList.size();
		StockResponseBean firstElem = valueList.get(0);
		rangeRes.setCurrencyCode(firstElem.getCurrencyCode());
		rangeRes.setMinPrice(firstElem.getPrice());
		rangeRes.setMaxPrice(valueList.get(lastIndex - 1).getPrice());
		BigDecimal avgPrice = (firstElem.getPrice().add(valueList.get(lastIndex - 1).getPrice())
				.divide(BigDecimal.valueOf(2)));
		setPriceList(rangeRes, valueList);
		rangeRes.setAvgPrice(avgPrice);

	}

	private void setPriceList(StockRangeDetails rangeRes, List<StockResponseBean> valueList) {
		List<PriceTime> priceList = Lists.newArrayList();
		valueList.forEach(item -> {
			PriceTime priceTime = new PriceTime();
			priceTime.setPrice(item.getPrice());
			priceTime.setTimeStamp(item.getTimeStamp());
			priceList.add(priceTime);
		});
		rangeRes.setPriceList(priceList);
	}

}
