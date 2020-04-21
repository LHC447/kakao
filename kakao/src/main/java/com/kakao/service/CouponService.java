package com.kakao.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kakao.dto.CouponDTO;
import com.kakao.entity.Coupon;

public interface CouponService {
	
	public Coupon couponSave(CouponDTO couponDTO);
	
	public Page<Coupon> couponPageable(Pageable pageable);
	
	public CouponDTO couponSaveandReturnDTO(CouponDTO couponDTO);
	
}
