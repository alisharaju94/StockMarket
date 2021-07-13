package com.stockMarket.model;

import java.util.List;

import lombok.Data;

@Data
public class CompanyList {
	private List<CompanyResponseBean> companies;
}
