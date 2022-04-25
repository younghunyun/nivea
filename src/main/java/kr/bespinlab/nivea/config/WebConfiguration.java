package kr.bespinlab.nivea.config;

import kr.bespinlab.nivea.handler.BaseHandlerInterceptor;
import kr.bespinlab.nivea.handler.MySQLPageRequestHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

	@Bean
	public BaseHandlerInterceptor baseHandlerInterceptor() {
		return new BaseHandlerInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(baseHandlerInterceptor());
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		// 데이터베이스 페이지 리졸버 등록
		argumentResolvers.add(new MySQLPageRequestHandler());
	}
}
