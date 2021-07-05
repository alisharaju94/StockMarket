/**
 * 
 */
package com.stockMarket.client.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.stockMarket.client.intf.CompanyServiceClient;
import com.stockMarket.model.Company;
import com.stockMarket.model.CompanyResponseBean;

/**
 * @author User
 *
 */

@Component
public class CompanyServiceClientImpl implements CompanyServiceClient {

	@Value("${companyService.addCompanyUrl}")
	private String addCompanyUrl;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public CompanyResponseBean addCompany(Company company) throws Exception {

		CompanyResponseBean responseBean = restTemplate.postForEntity(addCompanyUrl, company, CompanyResponseBean.class)
				.getBody();
		if(responseBean == null) {
			throw new Exception();
		}
		return responseBean;
	}
}
