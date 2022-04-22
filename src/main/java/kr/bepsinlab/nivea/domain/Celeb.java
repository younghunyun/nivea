package kr.bepsinlab.nivea.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Celeb {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int       celebId;
	private String    celebCode;
	private String    stageName;
	private String    stageNameEn;
	private String    realName;
	private String    realNameEn;
	private String    gender;
	private LocalDate birthDate;
	private String    debutYear;
	private String    country;
	private String    countryEn;
	private String    state;
	private String    city;
	private Float     height;
	private Float     weight;
	private String    company;
	private LocalDateTime updated;

}
