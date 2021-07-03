package com.stockMarket.client.intf;

import com.stockMarket.model.Company;
import com.stockMarket.model.CompanyResponseBean;

public interface CompanyServiceClient {

	CompanyResponseBean addCompany(Company company);
}
