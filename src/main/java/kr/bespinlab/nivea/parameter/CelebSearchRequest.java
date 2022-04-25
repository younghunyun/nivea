package kr.bespinlab.nivea.parameter;

import lombok.Data;

@Data
public class CelebSearchRequest {
	private String searchField;
	private String searchKeyword;
}
