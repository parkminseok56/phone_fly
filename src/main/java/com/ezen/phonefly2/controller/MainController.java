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

    // 메인 컨트롤러(Controller) 역할을 하는 클래스입니다.
    // 클라이언트 요청을 받아서 필요한 작업을 처리하고, 화면에 보여줄 데이터를 준비하는 역할을 합니다.
    
    @Autowired
    MainService ms;

    //  "/" 경로로 들어왔을 때 처리하는 메서드입니다.
    @RequestMapping("/")
    public String root() {
        return "index"; // "index"라는 view를 반환하여 화면을 표시합니다.
    }

    //  "/main" 경로로 들어왔을 때 처리하는 메서드입니다.
    @RequestMapping("/main")
    public ModelAndView main() {
        ModelAndView mav = new ModelAndView(); // 새로운 ModelAndView 객체를 생성합니다.

        // 데이터를 담기 위한 HashMap 객체를 생성합니다.
        HashMap<String, Object> result = new HashMap<>();

        // MainService 타입의 객체 ms를 통해 getMainProduct 메서드를 호출하여 데이터를 가져옵니다.
        ms.getMainProduct(result);

        // result 객체에서 "mainBestList", "mainEventList", "bannerList" 키로 저장된 값을 가져옵니다.
        List<ProductVO> mainBestList = (List<ProductVO>) result.get("mainBestList");
        List<ProductVO> mainEventList = (List<ProductVO>) result.get("mainEventList");
        List<ProductVO> bannerList = (List<ProductVO>) result.get("bannerList");

        // 가져온 데이터를 ModelAndView 객체에 추가합니다.
        mav.addObject("mainBestList", mainBestList);
        mav.addObject("mainEventList", mainEventList);
        mav.addObject("bannerList", bannerList);
        mav.addObject("bannerSize", bannerList.size()); // bannerList의 크기를 추가합니다.

        mav.setViewName("main"); // 화면을 "main"이라는 view로 설정합니다.

        return mav; // 설정한 데이터를 가진 ModelAndView 객체를 반환합니다.
    }
}
