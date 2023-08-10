package com.ezen.phonefly2.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.phonefly2.dto.MemberVO;
import com.ezen.phonefly2.dto.QnaVO;
import com.ezen.phonefly2.service.QnaService;
import com.ezen.phonefly2.util.Paging;

@Controller
public class QnaController {
	
    //  Q&A 관련 기능을 처리하는 컨트롤러(Controller) 클래스입니다.
    //	Q&A 목록 조회, Q&A 상세 보기, Q&A 작성 및 수정, Q&A 삭제 등의 기능을 처리하고 화면에 데이터를 전달합니다.
    //	Controller 클래스에서는 각 메서드에 따라 요청에 따른 작업을 수행하고, 그 결과를 화면에 나타낼 수 있는 ModelAndView 객체에 데이터를 담아 반환합니다.
	
    @Autowired
    QnaService qs;

    @RequestMapping("qnaList")
    public ModelAndView qnaList(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView(); // 새로운 ModelAndView 객체를 생성합니다.
        HttpSession session = request.getSession(); // HttpSession 객체를 가져옵니다.
        MemberVO mvo = (MemberVO) session.getAttribute("loginUser"); // "loginUser" 속성으로 저장된 MemberVO 객체를 가져옵니다.
        String url = "member/loginForm"; // 로그인 페이지로 이동할 URL을 기본값으로 설정합니다.
        if (mvo != null) {
            HashMap<String, Object> result = new HashMap<>(); // 데이터를 담기 위한 HashMap 객체를 생성합니다.
            result.put("id", mvo.getId()); // 로그인한 회원의 ID를 result에 저장합니다.
            result.put("request", request); // request 객체를 result에 저장합니다.
            qs.qnaList(result); // QnaService를 통해 Q&A 리스트 데이터를 가져옵니다.
            mav.addObject("qnaList", (List<QnaVO>) result.get("qnaList")); // ModelAndView 객체에 Q&A 리스트를 추가합니다.
            mav.addObject("paging", (Paging) result.get("paging")); // ModelAndView 객체에 페이징 정보를 추가합니다.
            url = "qna/qnaList"; // 화면을 "qna/qnaList"라는 view로 설정합니다.
        }
        mav.setViewName(url); // 설정한 URL로 이동합니다.
        return mav; // 설정한 데이터를 가진 ModelAndView 객체를 반환합니다.
    }

    // 다른 메서드들도 비슷한 방식으로 처리합니다.

    @PostMapping("/qnaUpdate")
    public ModelAndView qnaUpdate(@ModelAttribute("dto") QnaVO qvo, BindingResult result, HttpServletRequest request) {
        HttpSession session = request.getSession(); // HttpSession 객체를 가져옵니다.
        ModelAndView mav = new ModelAndView(); // 새로운 ModelAndView 객체를 생성합니다.
        MemberVO mvo = (MemberVO) session.getAttribute("loginUser"); // "loginUser" 속성으로 저장된 MemberVO 객체를 가져옵니다.
        String url = "member/loginForm"; // 로그인 페이지로 이동할 URL을 기본값으로 설정합니다.
        if (mvo != null) {
            qvo.setId(mvo.getId()); // Q&A 작성자의 ID를 설정합니다.
            qs.qnaUpdate(qvo); // QnaService를 통해 Q&A 수정을 처리합니다.
            url = "redirect:/qnaList"; // Q&A 리스트 페이지로 이동합니다.
        }
        mav.setViewName(url); // 설정한 URL로 이동합니다.
        return mav; // 설정한 데이터를 가진 ModelAndView 객체를 반환합니다.
    }
}
