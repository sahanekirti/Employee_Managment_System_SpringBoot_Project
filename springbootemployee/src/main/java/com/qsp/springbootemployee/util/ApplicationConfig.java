package com.qsp.springbootemployee.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfig {

	//url of swagger--->http://localhost:8080/swagger-ui.html# 
	
	@Bean
	public Docket getDocket() {

		Contact contact = new Contact("qspides", "https:///qspiders.com", "qspiders@gmail.com");

		List<VendorExtension> list = new ArrayList<>();

		ApiInfo apiInfo = new ApiInfo("employee managmnet system", "used tomanage details of the employee",
				"version 1.0", "1 year free service", contact, "www.ems.com", "www.ems.com", list);
		
		//docket is class so we write new in return to return docket obj

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.qsp.springbootemployee")).build().apiInfo(apiInfo)
				.useDefaultResponseMessages(false);

	}

}
