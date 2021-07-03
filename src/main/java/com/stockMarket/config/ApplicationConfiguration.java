package com.stockMarket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {
	
	@Bean()
	public RestTemplate restTesmplate() {
		return new RestTemplate();
	}

}
