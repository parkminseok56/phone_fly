package com.ezen.phonefly2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.phonefly2.dto.OrderDetailVO;
import com.ezen.phonefly2.dto.ReviewVO;
import com.ezen.phonefly2.util.Paging;

@Mapper
public interface IMyPageDao {
	// author : bhs

	List<ReviewVO> getReviewList(Paging paging);
	void updateReview(ReviewVO rvo);
	void deleteReview(int rvseq);
	List<OrderDetailVO> getOrderList(Paging paging, String id);
	OrderDetailVO getOrderDetail(int odseq, String id);
	OrderDetailVO adminOrderDetail(int odseq);
	void deleteOrder(int odseq);
	void insertOrder(OrderDetailVO ovo);
	void adminOrderUpdate(int results, int odseq);
	
}
