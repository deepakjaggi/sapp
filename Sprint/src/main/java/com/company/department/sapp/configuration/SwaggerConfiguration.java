package com.company.department.sapp.configuration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	private static final Contact DEFAULT_CONTACT_INFO = new Contact("Mitesh Upadhyay", "MiteshAPI", "upadhyaymitesh91@gmail.com");
	private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("REST API by Mitesh", "Sample REST API with Spring Boot", "1.0", "termsOfServiceUrl", 
			DEFAULT_CONTACT_INFO, "license", "licenseUrl");
	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>(Arrays.asList("application/json","application/xml"));


	//Documentation Type that we needed
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2);
	}
	
//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.apiInfo(DEFAULT_API_INFO)
//				.produces(DEFAULT_PRODUCES_AND_CONSUMES)
//				.consumes(DEFAULT_PRODUCES_AND_CONSUMES);
//	}
	
}
