package com.jumia.validator;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Configuration
@EnableSwagger2
@ComponentScan({"com.*"})
public class ValidatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValidatorApplication.class, args);
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo())
				.directModelSubstitute(LocalDate.class, String.class).genericModelSubstitutes(ResponseEntity.class)
				.useDefaultResponseMessages(false).select()
				.apis(RequestHandlerSelectors.basePackage("com.jumia.validator.controller"))
				.paths(PathSelectors.any()).build();
	}
	

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("APIs implemntation for JUMIA intreview")
				.description("APIs implemntation for JUMIA intreview").license("JUMIA License")
				.licenseUrl("https://www.jumia.com.eg/sp-about_us/?internal=footer").version("1.0").build();
	} 

}
