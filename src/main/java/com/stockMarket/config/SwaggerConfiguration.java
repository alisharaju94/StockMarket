package com.stockMarket.config;

import java.sql.Timestamp;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.stockMarket.controller"))
				.paths(PathSelectors.regex("/api/v1.0/market.*")).build().apiInfo(apiInfo())
				.ignoredParameterTypes(Timestamp.class, ResponseEntity.class);
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("StockMarket API", "API's for E-Stock Market application", "0.0.1-SNAPSHOT", "Free to use",
				new Contact("Alisha Raju", null, "Alisha.Raju@cognizant.com"), null, null, Collections.emptyList());

	}
}