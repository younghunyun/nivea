package kr.bespinlab.nivea.parameter;

import lombok.Data;

/**
 * 페이지 요청 정보와 파라메터 정보
 * @param <T>
 */
@Data
public class CelebPageParam<T> {
	private MySqlPageRequest pageRequest;
	private T searchParam;

	public CelebPageParam(MySqlPageRequest pageRequest, T searchParam) {
		this.pageRequest = pageRequest;
		this.searchParam = searchParam;
	}
}
