package kr.bespinlab.nivea.parameter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
public class CelebUpdateParam {

	@ApiModelProperty(name = "celebSeq", value = "셀럽ID - 신규등록 시 빈 값으로 설정", dataType = "int", example = "")
	private int       celebSeq;
	@ApiModelProperty(name = "celebCode", value = "셀럽코드", dataType = "String", required = true, example = "ACT")
	private String    celebCode;
	@ApiModelProperty(name = "stageName", value = "활동이름", dataType = "String", required = true, example = "유해진")
	private String    stageName;
	@ApiModelProperty(name = "stageNameEn", value = "활동이름(영문)", dataType = "String", example = "Haejin You")
	private String    stageNameEn;
	@ApiModelProperty(name = "realName", value = "실제이름", dataType = "String", example = "유해진")
	private String    realName;
	@ApiModelProperty(name = "realNameEn", value = "실제이름(영문)", dataType = "String", example = "Haejin You")
	private String    realNameEn;
	@ApiModelProperty(name = "gender", value = "성별", dataType = "String", example = "M")
	private String    gender;
	@ApiModelProperty(name = "birthDate", value = "생년월일", dataType = "Date", example = "1970-01-04")
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	private Date      birthDate;
	private String    birthDate;
	@ApiModelProperty(name = "debutYear", value = "데뷔년도", dataType = "String", example = "1997")
	private String    debutYear;
	@ApiModelProperty(name = "country", value = "국가", dataType = "String", example = "대한민국")
	private String    country;
	@ApiModelProperty(name = "countryEn", value = "국가(영문)", dataType = "String", example = "South Korea")
	private String    countryEn;
	@ApiModelProperty(name = "state", value = "시/도", dataType = "String", example = "충북")
	private String    state;
	@ApiModelProperty(name = "city", value = "시/군/구", dataType = "String", example = "청주시")
	private String    city;
	@ApiModelProperty(name = "height", value = "키", dataType = "Float", example = "174.9")
	private Float     height;
	@ApiModelProperty(name = "weight", value = "무게", dataType = "Float", example = "65.2")
	private Float     weight;
	@ApiModelProperty(name = "company", value = "소속사", dataType = "String", example = "키이스트")
	private String    company;
}
