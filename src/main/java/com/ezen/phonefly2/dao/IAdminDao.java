package com.ezen.phonefly2.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.phonefly2.dto.BannerVO;
import com.ezen.phonefly2.dto.ColorVO;
import com.ezen.phonefly2.dto.EventVO;
import com.ezen.phonefly2.dto.MemberVO;
import com.ezen.phonefly2.dto.NoticeVO;
import com.ezen.phonefly2.dto.OrderDetailVO;
import com.ezen.phonefly2.dto.ProductVO;
import com.ezen.phonefly2.dto.QnaVO;
import com.ezen.phonefly2.util.Paging;

@Mapper
public interface IAdminDao {
   
   //  관리자 기능을 위한 데이터베이스 연동을 수행하는 메서드들이 선언되어 있습니다. 
	
    // 작업자 ID를 이용하여 비밀번호 가져오기
    String getPwd(String workId);

    // 특정 조건에 맞는 모든 데이터의 개수를 가져오기
    int getAllCount(String string, String string2, String key);

    // 페이징과 키워드에 따라 제품 목록 가져오기
    List<ProductVO> listProduct(Paging paging, String key);

    // 페이징과 키워드에 따라 회원 목록 가져오기
    List<MemberVO> listMember(Paging paging, String key);

    // 페이징과 키워드에 따라 Q&A 목록 가져오기
    List<QnaVO> listQna(Paging paging, String key);

    // 페이징과 키워드에 따라 공지사항 목록 가져오기
    List<NoticeVO> listNotice(Paging paging, String key);

    // 페이징과 키워드에 따라 이벤트 목록 가져오기
    List<EventVO> listEvent(Paging paging, String key);

    // 페이징과 키워드에 따라 주문 목록 가져오기
    List<OrderDetailVO> listOrder(Paging paging, String key);

    // 배너 목록 가져오기
    List<BannerVO> getBannerList();
    
    // 배너 정보 추가
    void insertBanner(HashMap<String, Object> paramMap);
    
    // 배너 순서 변경 및 사용 여부 업데이트
    void updateSeq(int changeval, String useyn, int bseq);

    // 특정 배너 삭제
    void deleteBanner(int bseq);

    // 특정 Q&A에 답변 추가
    void qnaReply(int qseq, String reply);

    // 제품 정보 추가
    void insertProduct(ProductVO productvo);

    // 제품 색상 정보 추가
    void insertColor(HashMap<String, Object> paramMap);
    
    // 특정 제품의 모든 색상 개수 가져오기
    int getAllCountColor(String string, String string2, String key, int pseq);

    // 특정 제품의 모든 색상 목록 가져오기
    List<ColorVO> listColor(int pseq);

    // 특정 배너 정보 가져오기
    BannerVO getBanner(int bseq);

    // 특정 제품 삭제
    void deleteProduct(int pseq);

    // 제품 정보 업데이트
    void updateProduct(ProductVO pvo);

    // 특정 색상 정보 가져오기
    ColorVO getColor(int cseq);

    // 색상 정보 업데이트
    void updateColor(ColorVO cvo);

    // 배너 정보 업데이트
    void updateBanner(BannerVO bannervo);

    // 특정 색상 삭제
    void deleteColor(int cseq);

}
