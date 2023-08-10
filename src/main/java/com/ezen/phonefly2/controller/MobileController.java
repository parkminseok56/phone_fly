package com.ezen.phonefly2.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.phonefly2.dto.ProductVO;
import com.ezen.phonefly2.service.MainService;

@Controller
public class MobileController {

	// 모바일 화면에 대한 기능을 처리하는 컨트롤러(Controller) 클래스입니다. 
	// 모바일 홈페이지의 메인 화면 및 소개 화면에 대한 기능을 처리하고 화면에 데이터를 전달합니다.
	// Controller 클래스에서는 각 메서드에 따라 요청에 따른 작업을 수행하고, 그 결과를 화면에 나타낼 수 있는 ModelAndView 객체에 데이터를 담아 반환합니다.

    @Autowired
    MainService ms;

    //  "/mobileMain" 경로로 들어왔을 때 처리하는 메서드입니다.
    @RequestMapping("/mobileMain")
    public ModelAndView mobileMain() {
        ModelAndView mav = new ModelAndView(); // 새로운 ModelAndView 객체를 생성합니다.
        HashMap<String, Object> result = new HashMap<>(); // 데이터를 담기 위한 HashMap 객체를 생성합니다.
        ms.getMainProduct(result); // MainService를 통해 메인 상품 데이터를 가져옵니다.
        List<ProductVO> mainBestList = (List<ProductVO>) result.get("mainBestList"); // "mainBestList" 키로 저장된 메인 베스트 상품 리스트를 가져옵니다.
        List<ProductVO> mainEventList = (List<ProductVO>) result.get("mainEventList"); // "mainEventList" 키로 저장된 메인 이벤트 상품 리스트를 가져옵니다.
        mav.addObject("mainBestList", mainBestList); // ModelAndView 객체에 메인 베스트 상품 리스트를 추가합니다.
        mav.addObject("mainEventList", mainEventList); // ModelAndView 객체에 메인 이벤트 상품 리스트를 추가합니다.
        mav.setViewName("mobile/mobileMain"); // 화면을 "mobile/mobileMain"라는 view로 설정합니다.
        return mav; // 설정한 데이터를 가진 ModelAndView 객체를 반환합니다.
    }

    // 다른 메서드도 비슷한 방식으로 처리합니다.

    @RequestMapping("/mobileIntro")
    public String mobileIntro() {
        return "mobile/mobileIntro"; // "mobile/mobileIntro"라는 view로 이동합니다.
    }
}
