package kr.bespinlab.nivea.comm;

import kr.bespinlab.nivea.comm.BaseException;
import kr.bespinlab.nivea.comm.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class BaseControllerAdvice {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(value={BaseException.class})
    @ResponseBody
    private BaseResponse<?> handleBaseException(BaseException e, WebRequest request) {
        return new BaseResponse<String>(e.getResponseCode(), messageSource.getMessage(e.getResponseCode().name(), e.getArgs(), null));
    }

}
