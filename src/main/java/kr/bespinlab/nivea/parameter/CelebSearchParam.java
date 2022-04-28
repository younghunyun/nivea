package kr.bespinlab.nivea.parameter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CelebSearchParam {

	@ApiModelProperty(name = "field", value = "검색조건 필드", dataType = "String", example = "")
	private String field;
	@ApiModelProperty(name = "keyword", value = "검색조건 키워드", dataType = "String",  example = "")
	private String keyword;

}
