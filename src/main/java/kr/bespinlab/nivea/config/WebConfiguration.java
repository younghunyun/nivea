package kr.bespinlab.nivea.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import kr.bespinlab.nivea.comm.BaseCodeLabelEnum;
import kr.bespinlab.nivea.comm.BaseCodeLabelEnumJsonSerializer;
import kr.bespinlab.nivea.handler.BaseHandlerInterceptor;
import kr.bespinlab.nivea.handler.MySqlPageRequestHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;
import java.util.Locale;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
		source.setBasename("classpath:/messages/message");
		source.setDefaultEncoding("UTF-8");
		source.setCacheSeconds(60);
		source.setDefaultLocale(Locale.KOREAN);
		source.setUseCodeAsDefaultMessage(true);
		return source;
	}

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		SimpleModule simpleModule = new SimpleModule();
		simpleModule.addSerializer(BaseCodeLabelEnum.class, new BaseCodeLabelEnumJsonSerializer());
		objectMapper.registerModule(simpleModule);
		return objectMapper;
	}

	@Bean
	public PropertyConfiguration config() {
		return new PropertyConfiguration();
	}

	@Bean
	public MappingJackson2JsonView mappingJackson2JsonView() {
		MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
		jsonView.setContentType(MediaType.APPLICATION_JSON_VALUE);
		jsonView.setObjectMapper(objectMapper());
		return jsonView;
	}

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
		// MySQL ????????? ?????? ????????? ??????
		argumentResolvers.add(new MySqlPageRequestHandler());
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// ????????? ????????? static ????????? ?????? ??????
		String resourcePattern = config().getUploadResourcePath() + "**";

		// local (????????? ??????)
		if (config().isLocal()) {
			registry.addResourceHandler(resourcePattern).addResourceLocations(
					"file:///" + config().getUploadServerPath()
			);

		// ????????? ?????? ????????? ??????
		} else {
			registry.addResourceHandler(resourcePattern).addResourceLocations(
					"file:" + config().getUploadServerPath()
			);
		}

	}

}
