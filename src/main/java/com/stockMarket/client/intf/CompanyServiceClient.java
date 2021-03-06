package com.stockMarket.client.intf;

import com.stockMarket.model.Company;
import com.stockMarket.model.CompanyList;
import com.stockMarket.model.CompanyResponseBean;

public interface CompanyServiceClient {

	CompanyResponseBean addCompany(Company company) throws Exception;

	CompanyList getAll() throws Exception;

	void deleteCompany(String companyCode);

	CompanyResponseBean getCompanyInfo(String companyCode) throws Exception;
}
