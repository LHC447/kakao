package com.kakao.contorller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kakao.dto.CouponDTO;
import com.kakao.entity.Coupon;
import com.kakao.exception.EmailAlreadyUsedException;
import com.kakao.service.CouponService;

@Controller
public class CouponController {
	@Autowired
	private CouponService couponService;

	@GetMapping("/coupon/list")
	public String coupon(Model model,
			@PageableDefault(sort = { "id" }, direction = Sort.Direction.ASC, size = 5) Pageable pageable) {

		Page<Coupon> couponPage = couponService.couponPageable(pageable);
		model.addAttribute("couponPage", couponPage);

		return "coupon/list";
	}

	@PostMapping("/api/coupon/create")
	private ResponseEntity<CouponDTO> create(@Valid CouponDTO dto) {
		if (couponService.existsEmail(dto.getEmail()) == false) {

			String code = couponService.coupnum();
			dto = new CouponDTO(couponService.TheNumberOfCoupons() + 1, dto.getEmail(), code);
			couponService.couponSave(dto);

			return new ResponseEntity<>(dto, HttpStatus.OK);
		} else {

			throw new EmailAlreadyUsedException();
		}

	}

}
