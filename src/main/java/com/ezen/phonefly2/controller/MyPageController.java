package com.ezen.phonefly2.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.phonefly2.dto.MemberVO;
import com.ezen.phonefly2.dto.OrderDetailVO;
import com.ezen.phonefly2.dto.ReviewVO;
import com.ezen.phonefly2.service.MyPageService;

@Controller
public class MyPageController {
	// author : bhs

	@Autowired
	MyPageService mps;

	@RequestMapping("/memberReviewList")
	public ModelAndView memberReviewList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String url = "redirect:/loginForm";
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if (mvo != null) {
			HashMap<String, Object> result = new HashMap<>();
			result.put("request", request);
			mps.memberReviewList(result);
			mav.addObject("reviewList", result.get("reviewList"));
			mav.addObject("paging", result.get("paging"));
			url = "review/reviewList";
		}
		mav.setViewName(url);
		return mav;
	}

	@PostMapping("/memberReviewUpdate")
	public ModelAndView memberReviewUpdate(ReviewVO rvo, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String url = "redirect:/loginForm";
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if (mvo != null) {
			mps.memberReviewUpdate(rvo);
			url ="redirect:/memberReviewList";
		}
		mav.setViewName(url);
		return mav;
	}

	@GetMapping("/memberReviewDelete")
	public String memberReviewDelete(@RequestParam("rvseq") int rvseq) {
		mps.memberReviewDelete(rvseq);
		return "redirect:/memberReviewList";
	}

	@RequestMapping("/orderList")
	public ModelAndView orderList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String url = "redirect:/loginForm";
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if (mvo != null) {
			HashMap<String, Object> result = new HashMap<>();
			result.put("request", request);
			result.put("id", mvo.getId());
			mps.orderList(result);
			mav.addObject("orderList", result.get("orderList"));
			mav.addObject("paging", result.get("paging"));
			url = "order/orderList";
		}
		mav.setViewName(url);
		return mav;
	}

	@GetMapping("/orderDetail")
	public ModelAndView orderDetail(@RequestParam("odseq") int odseq, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String url = "redirect:/loginForm";
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if (mvo != null) {
			OrderDetailVO ovo = mps.orderDetail(odseq, mvo.getId());
			mav.addObject("orderVO", ovo);
			url = "order/orderDetail";
		}
		mav.setViewName(url);
		return mav;
	}

	@GetMapping("/orderCancel")
	public String orderCancel(@RequestParam("odseq") int odseq, HttpServletRequest request) {
		String url = "redirect:/loginForm";
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if (mvo != null) {
			mps.orderCancel(odseq);
			url = "redirect:/orderList";
		}
		return url;
	}

	@PostMapping("/order")
	public String order(OrderDetailVO ovo, HttpServletRequest request) {
		String url = "redirect:/loginForm";
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if (mvo != null) {
			ovo.setId(mvo.getId());
			mps.order(ovo);
			url = "redirect:/orderList";
		}
		return url;
	}

}
