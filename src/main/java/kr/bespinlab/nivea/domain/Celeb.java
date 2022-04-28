package kr.bespinlab.nivea.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Celeb {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int       celebSeq;
	private String    celebCode;
	private String    stageName;
	private String    stageNameEn;
	private String    realName;
	private String    realNameEn;
	private String    gender;
	private Date      birthDate;
	private String    debutYear;
	private String    country;
	private String    countryEn;
	private String    state;
	private String    city;
	private Float     height;
	private Float     weight;
	private String    company;
	private Timestamp updated;

}
