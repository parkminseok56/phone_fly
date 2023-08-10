package com.ezen.phonefly2.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.phonefly2.dto.ProductVO;
import com.ezen.phonefly2.dto.ReviewVO;
import com.ezen.phonefly2.dto.RplanVO;

@Mapper
public interface IProductDao {

    // 제품 정보와 관련된 데이터베이스 연동을 수행하는 메서드들이 선언되어 있습니다. 	
	
    // 특정 제품 정보 가져오기
    ProductVO getProduct(int pseq);

    // 특정 제조사에 해당하는 제품 목록 가져오기
    List<ProductVO> getMfcList(String mfc);

    // 요금제 목록 가져오기
    List<RplanVO> getRplanList();

    // 특정 아이디와 제품 번호에 해당하는 주문 수량 가져오기
    int countOrderById(String id, int pseq);

    // 특정 제품의 리뷰 목록 가져오기
    ArrayList<ReviewVO> getReviews(int pseq);

    // 모든 제품 목록 가져오기
    List<ProductVO> getProductList();

    // 리뷰 작성하기
    void writeReview(ReviewVO rvo);
}
