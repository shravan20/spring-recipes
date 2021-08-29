/* (C)2021 */
package com.example.employee.commons.configurations;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Collections;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableJpaAuditing(auditorAwareRef = "aware")
public class BeanConfiguration<T> implements WebMvcConfigurer {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.employee"))
                .paths(regex("/.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        return new ApiInfo(
                "Swagger documentation for Employee API",
                "Employee's API for UI developers",
                "1.0",
                "Terms of Service",
                new Contact(
                        "Employee Service", "https://www.ohmyscript.com", "shravan@ohmyscript.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html",
                Collections.emptyList());
    }

    @Bean
    public AuditorAware<String> aware() {
        return () -> Optional.of("Administrator");
    }
}
