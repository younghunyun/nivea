package kr.bespinlab.nivea.parameter;

import lombok.Data;

/**
 * 페이지 요청 정보와 파라메터 정보
 * @param <T>
 */
@Data
public class PageRequestParameter<T> {
	private MySqlPageRequest pageRequest;
	private T parameter;

	public PageRequestParameter(MySqlPageRequest pageRequest, T parameter) {
		this.pageRequest = pageRequest;
		this.parameter = parameter;
	}
}
