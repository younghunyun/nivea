package kr.bespinlab.nivea.comm;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@Data
public class BaseResponse<T> {

    private BaseResponseCode code;
    private String message;
    private T data;

    public BaseResponse(T data) {
        this.code = BaseResponseCode.SUCCESS;
        this.data = data;
    }

    public BaseResponse(BaseResponseCode responseCode, String message) {
        this.code = responseCode;
        this.message = message;
    }
}
