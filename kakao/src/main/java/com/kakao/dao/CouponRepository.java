package com.kakao.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kakao.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long>{
	Coupon findByEmail(String email);
	boolean existsByEmail(String email);
}
