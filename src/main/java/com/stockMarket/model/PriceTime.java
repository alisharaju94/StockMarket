package com.stockMarket.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class PriceTime {
	private BigDecimal price;
	private Timestamp timeStamp;

}
