package kr.bespinlab.nivea.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger 설정
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket docket() {
		ApiInfoBuilder apiInfo = new ApiInfoBuilder();
		apiInfo.title("nivea 프로젝트의 API 문서:)");
		apiInfo.description("호출 URL이 '/json'으로 끝나는 API만 Swagger UI에서 노출하도록 설정 ");

		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		docket.apiInfo(apiInfo.build());

		ApiSelectorBuilder apis = docket.select().apis(RequestHandlerSelectors.basePackage("kr.bespinlab.nivea.controller"));
		//apis.paths(PathSelectors.ant("/**"));
		apis.paths(PathSelectors.ant("/**/*json"));

		return apis.build();
	}

}
