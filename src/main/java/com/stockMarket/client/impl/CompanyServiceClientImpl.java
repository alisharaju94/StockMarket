/**
 * 
 */
package com.stockMarket.client.impl;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import com.stockMarket.client.intf.CompanyServiceClient;
import com.stockMarket.model.Company;
import com.stockMarket.model.CompanyInfoBean;
import com.stockMarket.model.CompanyList;
import com.stockMarket.model.CompanyResponseBean;

/**
 * @author User
 *
 */

@Component
public class CompanyServiceClientImpl implements CompanyServiceClient {

	@Value("${companyService.add}")
	private String addCompanyUrl;

	@Value("${companyService.getAll}")
	private String getAllUrl;
	
	@Value("${companyService.info}")
	private String infoUrl;

	@Value("${companyService.delete}")
	private String deleteUrl;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public CompanyResponseBean addCompany(Company company) throws Exception {

		CompanyResponseBean responseBean = restTemplate.postForEntity(addCompanyUrl, company, CompanyResponseBean.class)
				.getBody();
		if (responseBean == null) {
			throw new Exception();
		}
		return responseBean;
	}

	@Override
	public CompanyList getAll() throws Exception {
		CompanyList res = restTemplate.getForEntity(getAllUrl, CompanyList.class).getBody();
		if (res == null) {
			throw new Exception();
		}
		return res;
	}

	@Override
	public void deleteCompany(String companyCode) {
		UriTemplate uriTemplate = new UriTemplate(deleteUrl);
		URI uri = uriTemplate.expand(companyCode);
		restTemplate.delete(uri);
	}

	@Override
	public CompanyInfoBean getCompanyInfo(String companyCode) throws Exception {
		CompanyInfoBean res = restTemplate.getForEntity(infoUrl, CompanyInfoBean.class).getBody();
		if (res == null) {
			throw new Exception();
		}
		 return res;
	}
}
