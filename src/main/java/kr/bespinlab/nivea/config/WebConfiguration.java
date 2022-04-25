package kr.bespinlab.nivea.config;

import kr.bespinlab.nivea.interceptor.BaseHandlerInterceptor;
import kr.bespinlab.nivea.temp.CelebSearchRequestHandler;
import kr.bespinlab.nivea.handler.MySqlPageRequestHandler;
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
		// MySQL 페이지 요청 리졸버 등록
		argumentResolvers.add(new MySqlPageRequestHandler());
	}
}
