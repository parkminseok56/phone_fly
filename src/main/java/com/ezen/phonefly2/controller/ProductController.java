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
	
    // 상품 관련 기능을 처리하는 컨트롤러(Controller) 클래스입니다.
    // 상품 상세 정보 조회, 상품 리스트 조회, 상품 비교, 리뷰 작성 등의 기능을 처리하고 화면에 데이터를 전달합니다. 
    // Controller 클래스에서는 각 메서드에 따라 요청에 따른 작업을 수행하고, 그 결과를 화면에 나타낼 수 있는 ModelAndView 객체에 데이터를 담아 반환합니다.
	
    @Autowired
    ProductService ps;

    //  "/productDetail" 경로로 들어왔을 때 처리하는 메서드입니다.
    @RequestMapping("/productDetail")
    public ModelAndView productDetail(@RequestParam("pseq") int pseq, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView(); // 새로운 ModelAndView 객체를 생성합니다.
        HashMap<String, Object> result = ps.getProduct(pseq); // ProductService를 통해 데이터를 가져옵니다.
        ProductVO pvo = (ProductVO) result.get("productVO"); // "productVO" 키로 저장된 ProductVO 객체를 가져옵니다.
        List<RplanVO> rplanList = (List<RplanVO>) result.get("rplanList"); // "rplanList" 키로 저장된 RplanVO 리스트를 가져옵니다.
        mav.addObject("productVO", pvo); // ModelAndView 객체에 ProductVO 객체를 추가합니다.
        mav.addObject("rplanVO", rplanList); // ModelAndView 객체에 RplanVO 리스트를 추가합니다.
        HttpSession session = request.getSession(); // HttpSession 객체를 가져옵니다.
        MemberVO mvo = (MemberVO) session.getAttribute("loginUser"); // "loginUser" 속성으로 저장된 MemberVO 객체를 가져옵니다.
        int countOrderById = 0;
        if (mvo != null) {
            countOrderById = ps.countOrderById(mvo.getId(), pseq); // 로그인한 회원의 ID와 상품 번호를 통해 주문 수를 가져옵니다.
        }
        List<ReviewVO> reviewList = ps.getReviews(pseq); // 해당 상품에 대한 리뷰 리스트를 가져옵니다.
        if (reviewList.size() > 0) {
            mav.addObject("reviewList", reviewList); // 리뷰가 있다면 ModelAndView 객체에 리뷰 리스트를 추가합니다.
        }
        mav.addObject("countOrderById", countOrderById); // ModelAndView 객체에 주문 수를 추가합니다.
        mav.addObject("countOrderPseq", reviewList.size()); // ModelAndView 객체에 리뷰 수를 추가합니다.
        mav.setViewName("product/productDetail"); // 화면을 "product/productDetail"라는 view로 설정합니다.
        return mav; // 설정한 데이터를 가진 ModelAndView 객체를 반환합니다.
    }

    // 다른 메서드들도 비슷한 방식으로 처리합니다.

    @PostMapping("/reviewWrite")
    public String reviewWrite(ReviewVO rvo, HttpServletRequest request) {
        String url = "redirect:/loginForm"; // 리뷰 작성 후 이동할 URL을 기본값으로 설정합니다.
        HttpSession session = request.getSession(); // HttpSession 객체를 가져옵니다.
        MemberVO mvo = (MemberVO) session.getAttribute("loginUser"); // "loginUser" 속성으로 저장된 MemberVO 객체를 가져옵니다.
        if (mvo != null) {
            rvo.setId(mvo.getId()); // 리뷰 작성자의 ID를 설정합니다.
            ps.reviewWrite(rvo); // ProductService를 통해 리뷰를 작성합니다.
            url = "redirect:/productDetail?pseq=" + rvo.getPseq(); // 작성한 리뷰가 있는 상품 상세 페이지로 이동합니다.
        }
        return url; // 설정한 URL로 이동합니다.
    }
}

