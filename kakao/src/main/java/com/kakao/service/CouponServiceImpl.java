package com.kakao.service;

import java.security.SecureRandom;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kakao.dao.CouponRepository;
import com.kakao.dto.CouponDTO;
import com.kakao.entity.Coupon;
import com.kakao.exception.EmailAlreadyUsedException;

@Service
public class CouponServiceImpl implements CouponService{
	@Autowired
	private CouponRepository couponRepository;

	
	@Override
	public Page<Coupon> couponPageable(Pageable pageable) {
		
		return couponRepository.findAll(pageable);
	}

	@Override
	public Coupon couponSave(CouponDTO couponDTO) {
		if (couponRepository.existsByEmail(couponDTO.getEmail())) {
            throw new EmailAlreadyUsedException();
        }
		String code = coupnum();
		Coupon coupon = new Coupon(couponDTO.getEmail(), code);
		return couponRepository.save(coupon);
	}
	
	@Override
	public CouponDTO couponSaveandReturnDTO(CouponDTO couponDTO) {
		if (couponRepository.existsByEmail(couponDTO.getEmail())) {
            throw new EmailAlreadyUsedException();
        }
		String code = coupnum();
		couponDTO = new CouponDTO(TheNumberOfCoupons() + 1, couponDTO.getEmail(), code);
		couponRepository.save(couponDTO.toEntity());
		
		return couponDTO;
	}

	private Long TheNumberOfCoupons() {
		Long Total = (long) couponRepository.findAll().size();
		return Total;
	}
	
	private String generate(String data, int length) {
		SecureRandom random = new SecureRandom();
		
        if (length < 1) throw new IllegalArgumentException("길이는 1이상이어야 합니다.");
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append( data.charAt(random.nextInt(data.length())
            		));
        }
        return sb.toString();
	}

	private String coupnum() {
    	String English_Lower = "abcdefghijklmnopqrstuvwxyz";
        String English_Upper = English_Lower.toUpperCase();
        String Number = "0123456789";
        
        String Random_String = English_Lower + English_Upper + Number;
        
        String CouponNumber = generate(Random_String, 4)+"-"+generate(Random_String, 4)
        +"-"+generate(Random_String, 4)+"-"+generate(Random_String, 4);
        
        return CouponNumber;
	}
	
}
