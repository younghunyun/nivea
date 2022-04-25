package kr.bespinlab.nivea.parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * MySQL 페이지 요청 및 페이지 내 데이터 수
 */
@Data
public class MySqlPageRequest {

	private int page;
	private int size;

	@JsonIgnore
	@ApiModelProperty(hidden = true)
	private int limit;

	@JsonIgnore
	@ApiModelProperty(hidden = true)
	private int offset;

	public MySqlPageRequest(int page, int size, int limit, int offset) {
		this.page = page;
		this.size = size;
		this.limit = limit;
		this.offset = offset;
	}

}
