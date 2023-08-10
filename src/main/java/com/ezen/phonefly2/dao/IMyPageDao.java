package com.ezen.phonefly2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.phonefly2.dto.OrderDetailVO;
import com.ezen.phonefly2.dto.ReviewVO;
import com.ezen.phonefly2.util.Paging;

@Mapper
public interface IMyPageDao {

    // 마이페이지와 관련된 데이터베이스 연동을 수행하는 메서드들이 선언되어 있습니다. 
	
    // 페이징을 적용한 리뷰 목록 가져오기
    List<ReviewVO> getReviewList(Paging paging);

    // 리뷰 정보 업데이트
    void updateReview(ReviewVO rvo);

    // 특정 리뷰 삭제
    void deleteReview(int rvseq);

    // 페이징과 아이디에 따른 주문 목록 가져오기
    List<OrderDetailVO> getOrderList(Paging paging, String id);

    // 특정 주문 정보와 아이디에 따른 주문 상세 정보 가져오기
    OrderDetailVO getOrderDetail(int odseq, String id);

    // 특정 주문 정보의 관리자용 상세 정보 가져오기
    OrderDetailVO adminOrderDetail(int odseq);

    // 특정 주문 삭제
    void deleteOrder(int odseq);

    // 주문 정보 추가
    void insertOrder(OrderDetailVO ovo);

    // 관리자용 주문 상태 업데이트
    void adminOrderUpdate(int results, int odseq);
}
