package kr.bespinlab.nivea.parameter;

import lombok.Data;

/**
 * 페이지 요청 정보와 파라메터 정보
 * @param <T>
 */
@Data
public class CelebSearchParameter<T> {
	private MySqlPageRequest pageRequest;
	private T searchRequest;

	public CelebSearchParameter(MySqlPageRequest pageRequest, T searchRequest) {
		this.pageRequest = pageRequest;
		this.searchRequest = searchRequest;
	}
}
