package com.moodle.integration.commons.configuration;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class BeanConfiguration {

    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/moodle/**"))
                .build();
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Moodle Service").description("Moodle Service").build();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
