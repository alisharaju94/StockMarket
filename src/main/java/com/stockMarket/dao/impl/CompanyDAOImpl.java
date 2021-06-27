/**
 * 
 */
package com.stockMarket.dao.impl;

import org.springframework.web.client.RestTemplate;

import com.stockMarket.dao.intf.CompanyDAO;
import com.stockMarket.model.Company;

/**
 * @author User
 *
 */
public class CompanyDAOImpl implements CompanyDAO{

	@Override
	public void addCompany(Company company) {
		new RestTemplate().getForEntity(url, responseType)
	}
}
