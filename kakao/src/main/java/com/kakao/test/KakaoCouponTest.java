package com.kakao.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class KakaoCouponTest {

	@Autowired
	MockMvc mockMvc;

	@SuppressWarnings("deprecation")
	@Test
	public void list() throws Exception {
        mockMvc.perform(get("/api/coupon/list"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void createCoupon() throws Exception {
        ResultActions actions = 
        		mockMvc.perform(post("/api/coupon/create")
        				.param("email", "5@gmail.com")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        ).andDo(print());
        
        actions.andExpect(status().isOk());
	}
}
