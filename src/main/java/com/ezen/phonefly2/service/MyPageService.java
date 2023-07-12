package com.ezen.phonefly2.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.phonefly2.dao.ICommonDao;
import com.ezen.phonefly2.dao.IMyPageDao;
import com.ezen.phonefly2.dao.IQnaDao;
import com.ezen.phonefly2.dto.OrderDetailVO;
import com.ezen.phonefly2.dto.ReviewVO;
import com.ezen.phonefly2.util.Paging;

@Service
public class MyPageService {
	// author : bhs

	@Autowired
	IMyPageDao mpdao;

	@Autowired
	ICommonDao cdao;
	
	@Autowired
	IQnaDao qdao;

	public void memberReviewList(HashMap<String, Object> result) {
		HttpServletRequest request = (HttpServletRequest)result.get("request");
		HttpSession session = request.getSession();
		int page = 1;
		session.removeAttribute("page");
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		Paging paging = new Paging();
		paging.setPage(page);
		int count = cdao.getAllCount("review");
		paging.setTotalCount(count);
		session.setAttribute("page", page);
		List<ReviewVO> reviewList = mpdao.getReviewList(paging);
		result.put("reviewList", reviewList);
		result.put("paging", paging);
	}

	public void memberReviewUpdate(ReviewVO rvo) {
		mpdao.updateReview(rvo);
	}

	public void memberReviewDelete(int rvseq) {
		mpdao.deleteReview(rvseq);
	}

	public void orderList(HashMap<String, Object> result) {
		HttpServletRequest request = (HttpServletRequest)result.get("request");
		HttpSession session = request.getSession();
		int page = 1;
		session.removeAttribute("page");
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		Paging paging = new Paging();
		paging.setPage(page);
		int count = qdao.getAllCountById("order_detail_view2");
		paging.setTotalCount(count);
		session.setAttribute("page", page);
		String id = result.get("id").toString();
		List<OrderDetailVO> orderList = mpdao.getOrderList(paging, id);
		result.put("orderList", orderList);
		result.put("paging", paging);
	}

	public OrderDetailVO orderDetail(int odseq, String id) {
		return mpdao.getOrderDetail(odseq, id);
	}
	
	public OrderDetailVO adminOrderDetail(int odseq) {
		return mpdao.adminOrderDetail(odseq);
	}

	public void orderCancel(int odseq) {
		mpdao.deleteOrder(odseq);
	}

	public void order(OrderDetailVO ovo) {
		mpdao.insertOrder(ovo);
	}

	public void adminOrderUpdate( int results,int odseq) {
		mpdao.adminOrderUpdate(results,odseq);
	}
}
