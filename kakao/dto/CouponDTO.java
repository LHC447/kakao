package com.kakao.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kakao.entity.Coupon;


public class CouponDTO {

	
	@JsonProperty
	private Long id;

	@JsonProperty
	@Email(message = "Email should be valid")
	@NotBlank
	private String email;
	
	@JsonProperty
	private String code;
	
	private LocalDateTime createDate;
	
	public CouponDTO() {}
	
	public CouponDTO(Long id, String email, String code) {
		super();
		this.id = id;
		this.email = email;
		this.code = code;
		this.createDate = LocalDateTime.now();
	}
	
	public Coupon toEntity(){
        Coupon coupon = new Coupon(this.email, this.code);
        return coupon;
    }
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	public String getFormattedCreateDate() {
		if (createDate==null) {
			return "";
		}
		return createDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
	}
	
	
}
