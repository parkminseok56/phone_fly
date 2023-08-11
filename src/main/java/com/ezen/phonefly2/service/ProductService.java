package com.ezen.phonefly2.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.ListModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.phonefly2.dao.IMainDao;
import com.ezen.phonefly2.dao.IProductDao;
import com.ezen.phonefly2.dto.ColorVO;
import com.ezen.phonefly2.dto.ProductVO;
import com.ezen.phonefly2.dto.ReviewVO;
import com.ezen.phonefly2.dto.RplanVO;

@Service
public class ProductService {

    @Autowired
    IProductDao pdao; // IProductDao 인터페이스를 구현한 DAO 클래스를 주입받는 필드

    @Autowired
    IMainDao mdao; // IMainDao 인터페이스를 구현한 DAO 클래스를 주입받는 필드

    // 제품 정보 및 관련 정보 조회 메서드
    public HashMap<String, Object> getProduct(int pseq) {
        HashMap<String, Object> result = new HashMap<>();
        ProductVO pvo = pdao.getProduct(pseq); // 특정 제품 정보 조회
        List<ColorVO> colorList = mdao.getColorList(pvo.getPseq()); // 제품의 색상 정보 조회
        pvo.setColorList(colorList);
        List<RplanVO> rplanList = pdao.getRplanList(); // 요금제 정보 조회
        result.put("productVO", pvo);
        result.put("rplanList", rplanList);
        return result;
    }

    // 특정 제조사의 제품 목록 조회 메서드
    public List<ProductVO> getMfcList(String mfc) {
        List<ProductVO> mfcList = pdao.getMfcList(mfc); // 특정 제조사의 제품 목록 조회
        for (ProductVO pvo : mfcList) {
            List<ColorVO> colorList = mdao.getColorList(pvo.getPseq()); // 제품의 색상 정보 조회
            pvo.setColorList(colorList);
        }
        return mfcList;
    }

    // 특정 제품의 주문 수량 조회 메서드
    public int countOrderById(String id, int pseq) {
        return pdao.countOrderById(id, pseq); // 특정 제품의 주문 수량 조회
    }

    // 특정 제품의 리뷰 목록 조회 메서드
    public List<ReviewVO> getReviews(int pseq) {
        return pdao.getReviews(pseq); // 특정 제품의 리뷰 목록 조회
    }

    // 제품 비교 및 관련 정보 조회 메서드
    public void productCompare(HashMap<String, Object> result) {
        List<Integer> pseqList = (List<Integer>) result.get("pseqList");
        List<ProductVO> productList = new ArrayList<>();
        int compareFlag = 1;

        if (pseqList != null) {
            for (Integer pseq : pseqList) {
                ProductVO pvo = pdao.getProduct(pseq); // 특정 제품 정보 조회
                if (pvo != null) {
                    List<ColorVO> colorList = mdao.getColorList(pseq); // 제품의 색
