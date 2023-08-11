package com.ezen.phonefly2.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.phonefly2.dao.IMainDao;
import com.ezen.phonefly2.dto.BannerVO;
import com.ezen.phonefly2.dto.ColorVO;
import com.ezen.phonefly2.dto.ProductVO;

@Service
public class MainService {
    
    @Autowired
    IMainDao mdao; // IMainDao 인터페이스를 구현한 DAO 클래스를 주입받는 필드

    // 메인 페이지에 표시할 상품 및 배너 정보를 가져오는 메서드
    public void getMainProduct(HashMap<String, Object> result) {
        List<ProductVO> mainBestList = mdao.getBestList(); // 주요 상품 목록 가져오기

        for (ProductVO pvo : mainBestList) {
            List<ColorVO> colorList = mdao.getColorList(pvo.getPseq()); // 상품의 색상 목록 가져오기
            pvo.setColorList(colorList); // 상품 객체에 색상 목록 설정
        }

        List<ProductVO> mainEventList = mdao.getEventList(); // 이벤트 상품 목록 가져오기

        for (ProductVO pvo : mainEventList) {
            List<ColorVO> colorList = mdao.getColorList(pvo.getPseq()); // 상품의 색상 목록 가져오기
            pvo.setColorList(colorList); // 상품 객체에 색상 목록 설정
        }

        List<BannerVO> bannerList = mdao.getBannerList(); // 배너 목록 가져오기

        result.put("mainBestList", mainBestList); // 주요 상품 목록을 결과에 저장
        result.put("mainEventList", mainEventList); // 이벤트 상품 목록을 결과에 저장
        result.put("bannerList", bannerList); // 배너 목록을 결과에 저장
    }
}
