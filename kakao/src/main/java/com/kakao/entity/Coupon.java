package com.kakao.entity;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;


@Entity
public class Coupon {
	
	@ApiModelProperty(example="1")
	@Id
	@GeneratedValue
	@JsonProperty
	private Long id;
	
	@ApiModelProperty(example="1@gmail.com")
	@Column(nullable = false, unique = true)
	@JsonProperty
	private String email;
	
	@ApiModelProperty(example="AuSV-uFNI-uP6U-Hb5F")
	@JsonProperty
	private String code;
	
	private LocalDateTime createDate;
	
	@ApiModelProperty(example="2020.04.07 13:42:26")
	private String formattedCreateDate;
	
	public Coupon() {}
	
	public Coupon(String email, String code) {
		super();
		this.email = email;
		this.code = code;
		this.createDate = LocalDateTime.now();
	}
	
	
	public String getFormattedCreateDate() {
		if (createDate==null) {
			return "";
		}
		return createDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
	}


	public Long getId() {
		return id;
	}


	public String getEmail() {
		return email;
	}


	public String getCode() {
		return code;
	}

	
}
