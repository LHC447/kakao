package com.kakao.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kakao.dao.CouponRepository;
import com.kakao.entity.Coupon;

@SpringBootTest
public class EntityTest {

    @Autowired
    private CouponRepository CouponEntity;
    
    @Test
    public void findAll() throws Exception {
        
        for(Coupon entity : CouponEntity.findAll()) {
            System.out.println(entity.getId());
        }
        
    }
}


