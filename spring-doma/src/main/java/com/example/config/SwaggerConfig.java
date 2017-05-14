package com.example.config;

import java.security.Timestamp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

		@Bean
		public Docket api() {
				return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.any())
					.paths(PathSelectors.regex("/api.*"))
					.build().pathMapping("/")
					.directModelSubstitute(Timestamp .class, Long.class).apiInfo(metadata());
		}

		private ApiInfo metadata() {
				return new ApiInfoBuilder()
					.title("Example API")
					.description("Description write here.")
					.version("1.0")
					.build();
		}

}