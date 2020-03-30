package com.kakao.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kakao.dto.CouponDTO;
import com.kakao.entity.Coupon;

public interface CouponService {
	public String generate(String data, int length);
	
	public String coupnum();
	
	public boolean existsEmail(String email);
	
	public Coupon couponSave(CouponDTO couponDTO);
	
	public Page<Coupon> couponPageable(Pageable pageable);
	
	public Long TheNumberOfCoupons();
	
}
