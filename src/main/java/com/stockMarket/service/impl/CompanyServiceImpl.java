/**
 * 
 */
package com.stockMarket.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockMarket.dao.intf.CompanyDAO;
import com.stockMarket.model.Company;
import com.stockMarket.service.intf.CompanyService;

/**
 * @author User
 *
 */
@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	CompanyDAO companyDAO;

	@Override
	public void addCompany(Company company) {
		companyDAO.addCompany(company);
	}

}
