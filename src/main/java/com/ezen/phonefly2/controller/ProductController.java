package com.ezen.phonefly2.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.phonefly2.dto.MemberVO;
import com.ezen.phonefly2.dto.ProductVO;
import com.ezen.phonefly2.dto.ReviewVO;
import com.ezen.phonefly2.dto.RplanVO;
import com.ezen.phonefly2.service.ProductService;

@Controller
public class ProductController {
	// 다시작성 : bhs
	@Autowired
	ProductService ps;

	@RequestMapping("/productDetail")
	public ModelAndView productDetail(@RequestParam("pseq") int pseq, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> result = ps.getProduct(pseq);
		ProductVO pvo = (ProductVO) result.get("productVO");
		List<RplanVO> rplanList = (List<RplanVO>) result.get("rplanList");
		mav.addObject("productVO", pvo);
		mav.addObject("rplanVO", rplanList);
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		int countOrderById = 0;
		if (mvo != null) {
			countOrderById = ps.countOrderById(mvo.getId(), pseq);
		}
		List<ReviewVO> reviewList = ps.getReviews(pseq);
		if (reviewList.size() > 0) {
			mav.addObject("reviewList", reviewList);
		}
		mav.addObject("countOrderById", countOrderById);
		mav.addObject("countOrderPseq", reviewList.size());
		mav.setViewName("product/productDetail");
		return mav;
	}

	@RequestMapping("/productList")
	public ModelAndView productList(@RequestParam("mfc") String mfc) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("productList", ps.getMfcList(mfc));
		mav.setViewName("product/productList");
		return mav;
	}

	@RequestMapping("/productCompare")
	public ModelAndView productCompare(@RequestParam(value = "pseq", required = false) List<Integer> pseqList) {
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> result = new HashMap<>();
		result.put("pseqList", pseqList);
		ps.productCompare(result);
		mav.addObject("productList", result.get("productList"));
		mav.addObject("compareFlag", result.get("compareFlag"));
		mav.setViewName("product/productCompare");
		return mav;
	}

	@PostMapping("/reviewWrite")
	public String reviewWrite(ReviewVO rvo, HttpServletRequest request) {
		String url = "redirect:/loginForm";
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if (mvo != null) {
			rvo.setId(mvo.getId());
			ps.reviewWrite(rvo);
			url = "redirect:/productDetail?pseq=" + rvo.getPseq();
		}
		return url;
	}
}
