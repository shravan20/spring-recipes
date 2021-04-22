package com.practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private ApiInfo metaData() {
		
		return new ApiInfoBuilder()
								    .title("Spring Boot REST API")
									.description("Documentation for Employee Crud Service")
									.license("LGPL licensing")
									.version("1.0")
									.contact(new Contact("SKB", "www.ohmyscript.com", "shravan@ohmyscript.com"))
									.build();
	
	}
	
	private Predicate<String> paths() {
		return Predicates.and(PathSelectors.regex("/employees.*"),
			   Predicates.not(PathSelectors.regex("/error.*"))
				);
	}
	
	
	@Bean 
	public Docket employeeCrudApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.practice.controllers"))
				.paths(paths())
				.build().apiInfo(metaData());
				
	}
}
