package com.stockMarket.model;

import java.util.List;

import lombok.Data;

@Data
public class StockDetailsResponse {

	private List<StockResponseBean> stockDetails;
}
