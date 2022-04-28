package kr.bespinlab.nivea.comm;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * JSON 변환 시 BaseCodeLabelEnum 클래스에 대한 변환을 동일하게 처리
 */
public class BaseCodeLabelEnumJsonSerializer extends JsonSerializer<BaseCodeLabelEnum> {

    @Override
    public void serialize(BaseCodeLabelEnum baseCodeLabelEnum, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("code", baseCodeLabelEnum.code());
        map.put("label", baseCodeLabelEnum.label());
        jsonGenerator.writeObject(map);
    }

}
