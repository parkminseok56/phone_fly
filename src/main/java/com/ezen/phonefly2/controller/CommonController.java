package com.ezen.phonefly2.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.phonefly2.dto.EventVO;
import com.ezen.phonefly2.dto.NoticeVO;
import com.ezen.phonefly2.service.CommonService;
import com.ezen.phonefly2.util.Paging;

@Controller
public class CommonController {

    @Autowired
    CommonService cs;

    //  "/intro" 경로로 들어왔을 때 처리하는 메서드입니다.
    @RequestMapping("/intro")
    public String intro() {
        return "guide/intro"; // "guide/intro"라는 view를 반환하여 화면을 표시합니다.
    }

    //  "/noticeList" 경로로 들어왔을 때 처리하는 메서드입니다.
    @RequestMapping("/noticeList")
    public ModelAndView noticeList(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView(); // 새로운 ModelAndView 객체를 생성합니다.
        HashMap<String, Object> result = new HashMap<>(); // 데이터를 담기 위한 HashMap 객체를 생성합니다.
        result.put("request", request); // request 객체를 result에 저장합니다.
        cs.getNoticeList(result); // CommonService 타입의 객체 cs를 통해 getNoticeList 메서드를 호출하여 데이터를 가져옵니다.

        // ModelAndView 객체에 데이터를 추가합니다.
        mav.addObject("noticeList", (List<NoticeVO>) result.get("noticeList"));
        mav.addObject("paging", (Paging) result.get("paging"));
        mav.setViewName("notice/noticeList"); // 화면을 "notice/noticeList"라는 view로 설정합니다.
        return mav; // 설정한 데이터를 가진 ModelAndView 객체를 반환합니다.
    }

    //  "/noticeDetail" 경로로 들어왔을 때 처리하는 메서드입니다.
    @RequestMapping("/noticeDetail")
    public ModelAndView noticeDetail(@RequestParam("nseq") int nseq) {
        ModelAndView mav = new ModelAndView(); // 새로운 ModelAndView 객체를 생성합니다.
        mav.addObject("noticeVO", cs.getNotice(nseq)); // noticeVO 객체를 ModelAndView에 추가합니다.
        mav.setViewName("notice/noticeDetail"); // 화면을 "notice/noticeDetail"라는 view로 설정합니다.
        return mav; // 설정한 데이터를 가진 ModelAndView 객체를 반환합니다.
    }

    // 다른 메서드들도 비슷한 방식으로 처리합니다.

    @RequestMapping("/FAQList")
    public String faqList() {
        return "faq/faq"; // "faq/faq"라는 view를 반환하여 화면을 표시합니다.
    }

    @RequestMapping("/guide1")
    public String guide1() {
        return "guide/guide1"; // "guide/guide1"라는 view를 반환하여 화면을 표시합니다.
    }

    @RequestMapping("/guide2")
    public String guide2() {
        return "guide/guide2"; // "guide/guide2"라는 view를 반환하여 화면을 표시합니다.
    }

    @RequestMapping("/guide3")
    public String guide3() {
        return "guide/guide3"; // "guide/guide3"라는 view를 반환하여 화면을 표시합니다.
    }
}
