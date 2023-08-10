package com.ezen.phonefly2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.phonefly2.dto.BannerVO;
import com.ezen.phonefly2.dto.ColorVO;
import com.ezen.phonefly2.dto.ProductVO;

@Mapper
public interface IMainDao {

    // 메인 페이지와 관련된 데이터베이스 연동을 수행하는 메서드들이 선언되어 있습니다. 
	
    // 베스트 상품 목록 가져오기
    List<ProductVO> getBestList();

    // 이벤트 상품 목록 가져오기
    List<ProductVO> getEventList();

    // 특정 제품의 모든 색상 목록 가져오기
    List<ColorVO> getColorList(int pseq);

    // 배너 목록 가져오기
    List<BannerVO> getBannerList();
}
