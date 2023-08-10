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
	
    // 마이페이지와 관련된 기능을 처리하는 컨트롤러(Controller) 클래스입니다. 
    // 리뷰 관리, 주문 내역 조회, 주문 취소 등의 기능을 처리하고 화면에 데이터를 전달합니다. 
    // Controller 클래스에서는 각 메서드에 따라 요청에 따른 작업을 수행하고, 그 결과를 화면에 나타낼 수 있는 ModelAndView 객체에 데이터를 담아 반환합니다.
	
    @Autowired
    MyPageService mps;

    //  "/memberReviewList" 경로로 들어왔을 때 처리하는 메서드입니다.
    @RequestMapping("/memberReviewList")
    public ModelAndView memberReviewList(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView(); // 새로운 ModelAndView 객체를 생성합니다.
        String url = "redirect:/loginForm"; // 리뷰 리스트 페이지로 이동할 URL을 기본값으로 설정합니다.
        HttpSession session = request.getSession(); // HttpSession 객체를 가져옵니다.
        MemberVO mvo = (MemberVO) session.getAttribute("loginUser"); // "loginUser" 속성으로 저장된 MemberVO 객체를 가져옵니다.
        if (mvo != null) {
            HashMap<String, Object> result = new HashMap<>(); // 데이터를 담기 위한 HashMap 객체를 생성합니다.
            result.put("request", request); // request 객체를 result에 저장합니다.
            mps.memberReviewList(result); // MyPageService를 통해 리뷰 리스트 데이터를 가져옵니다.
            mav.addObject("reviewList", result.get("reviewList")); // ModelAndView 객체에 리뷰 리스트를 추가합니다.
            mav.addObject("paging", result.get("paging")); // ModelAndView 객체에 페이징 정보를 추가합니다.
            url = "review/reviewList"; // 화면을 "review/reviewList"라는 view로 설정합니다.
        }
        mav.setViewName(url); // 설정한 URL로 이동합니다.
        return mav; // 설정한 데이터를 가진 ModelAndView 객체를 반환합니다.
    }

    // 다른 메서드들도 비슷한 방식으로 처리합니다.

    @PostMapping("/order")
    public String order(OrderDetailVO ovo, HttpServletRequest request) {
        String url = "redirect:/loginForm"; // 주문 후 이동할 URL을 기본값으로 설정합니다.
        HttpSession session = request.getSession(); // HttpSession 객체를 가져옵니다.
        MemberVO mvo = (MemberVO) session.getAttribute("loginUser"); // "loginUser" 속성으로 저장된 MemberVO 객체를 가져옵니다.
        if (mvo != null) {
            ovo.setId(mvo.getId()); // 주문자의 ID를 설정합니다.
            mps.order(ovo); // MyPageService를 통해 주문을 처리합니다.
            url = "redirect:/orderList"; // 주문 내역 페이지로 이동합니다.
        }
        return url; // 설정한 URL로 이동합니다.
    }
}
