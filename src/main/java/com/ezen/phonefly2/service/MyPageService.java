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
    
    @Autowired
    IMyPageDao mpdao; // IMyPageDao 인터페이스를 구현한 DAO 클래스를 주입받는 필드

    @Autowired
    ICommonDao cdao; // ICommonDao 인터페이스를 구현한 DAO 클래스를 주입받는 필드
    
    @Autowired
    IQnaDao qdao; // IQnaDao 인터페이스를 구현한 DAO 클래스를 주입받는 필드

    // 멤버의 리뷰 목록 조회 메서드
    public void memberReviewList(HashMap<String, Object> result) {
        HttpServletRequest request = (HttpServletRequest) result.get("request");
        HttpSession session = request.getSession();
        int page = 1;
        session.removeAttribute("page");

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        Paging paging = new Paging();
        paging.setPage(page);

        int count = cdao.getAllCount("review"); // "review" 테이블의 총 개수 가져오기
        paging.setTotalCount(count);

        session.setAttribute("page", page);

        List<ReviewVO> reviewList = mpdao.getReviewList(paging); // 페이징 처리된 리뷰 목록 가져오기
        result.put("reviewList", reviewList);
        result.put("paging", paging);
    }

    // 멤버의 리뷰 업데이트 메서드
    public void memberReviewUpdate(ReviewVO rvo) {
        mpdao.updateReview(rvo);
    }

    // 멤버의 리뷰 삭제 메서드
    public void memberReviewDelete(int rvseq) {
        mpdao.deleteReview(rvseq);
    }

    // 멤버의 주문 목록 조회 메서드
    public void orderList(HashMap<String, Object> result) {
        HttpServletRequest request = (HttpServletRequest) result.get("request");
        HttpSession session = request.getSession();
        int page = 1;
        session.removeAttribute("page");

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        Paging paging = new Paging();
        paging.setPage(page);

        int count = qdao.getAllCountById("order_detail_view2"); // "order_detail_view2" 테이블의 총 개수 가져오기
        paging.setTotalCount(count);

        session.setAttribute("page", page);

        String id = result.get("id").toString();
        List<OrderDetailVO> orderList = mpdao.getOrderList(paging, id); // 페이징 처리된 주문 목록 가져오기
        result.put("orderList", orderList);
        result.put("paging", paging);
    }

    // 주문 상세 정보 조회 메서드
    public OrderDetailVO orderDetail(int odseq, String id) {
        return mpdao.getOrderDetail(odseq, id);
    }
    
    // 관리자용 주문 상세 정보 조회 메서드
    public OrderDetailVO adminOrderDetail(int odseq) {
        return mpdao.adminOrderDetail(odseq);
    }

    // 주문 취소 메서드
    public void orderCancel(int odseq) {
        mpdao.deleteOrder(odseq);
    }

    // 주문 메서드
    public void order(OrderDetailVO ovo) {
        mpdao.insertOrder(ovo);
    }

    // 관리자용 주문 업데이트 메서드
    public void adminOrderUpdate(int results, int odseq) {
        mpdao.adminOrderUpdate(results, odseq);
    }
}
