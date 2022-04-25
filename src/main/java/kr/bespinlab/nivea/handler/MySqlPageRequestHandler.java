package kr.bespinlab.nivea.handler;

import kr.bespinlab.nivea.parameter.MySqlPageRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * MySQL 쿼리 페이징 LIMIT, OFFSET 값을 계산하여
 * 해당 값을 MySQLPageRequest 클래스로 저장하여 컨트롤러로 전달
 */
@Slf4j
public class MySqlPageRequestHandler implements HandlerMethodArgumentResolver {

	private static final String DEFAULT_PARAMETER_PAGE = "page";
	private static final int DEFAULT_PAGE = 1;
	private static final String DEFAULT_PARAMETER_SIZE = "size";
	private static final int DEFAULT_SIZE = 5;

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();

		// 조회할 페이지
		int page = NumberUtils.toInt(request.getParameter(DEFAULT_PARAMETER_PAGE), DEFAULT_PAGE);

		// 페이지당 데이터 수
		int offset = NumberUtils.toInt(request.getParameter(DEFAULT_PARAMETER_SIZE), DEFAULT_SIZE);

		// 조회할 데이터 수 계산
		int limit = (offset * page) - offset;

		return new MySqlPageRequest(page, offset, limit, offset);
	}

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return MySqlPageRequest.class.isAssignableFrom(parameter.getParameterType());
	}

}
