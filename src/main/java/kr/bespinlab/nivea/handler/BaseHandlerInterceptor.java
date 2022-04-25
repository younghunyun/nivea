package kr.bespinlab.nivea.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class BaseHandlerInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		//log.debug("preHandle | Request URI {}: ", request.getRequestURI());
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			log.info("handlerMethod: {}", handlerMethod);
			RequestHandler requestHandler = handlerMethod.getMethodAnnotation(RequestHandler.class);

			// 조회 메소드에서는 requestConfig null 발생
			if (requestHandler != null) {
				// 로그인 체크가 필수인 경우
				if (requestHandler.loginCheck()) {
					log.debug("RequestHandler.loginCheck() true");
//					throw new BaseException(BaseResponseCode.LOGIN_REQUIRED, new String[] { request.getRequestURI() });
				}
			}
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
//		if (handler instanceof HandlerMethod) {
//			if (modelAndView != null) {
//				modelAndView.addObject("menuTypes", MenuType.values());
//			}
//		}
	}
}
