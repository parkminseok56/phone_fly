package com.ezen.phonefly2.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.phonefly2.dto.ProductVO;
import com.ezen.phonefly2.service.MainService;

@Controller
public class MainController {
	// author : bhs

	@Autowired
	MainService ms;

	@RequestMapping("/")
	public String root() {
		return "index";
	}

	@RequestMapping("/main")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> result = new HashMap<>();
		ms.getMainProduct(result);
		List<ProductVO> mainBestList = (List<ProductVO>)result.get("mainBestList");
		List<ProductVO> mainEventList = (List<ProductVO>)result.get("mainEventList");
		List<ProductVO> bannerList = (List<ProductVO>)result.get("bannerList");
		mav.addObject("mainBestList", mainBestList);
		mav.addObject("mainEventList", mainEventList);
		mav.addObject("bannerList", bannerList);
		mav.addObject("bannerSize", bannerList.size());
		mav.setViewName("main");
		return mav;
	}

}
