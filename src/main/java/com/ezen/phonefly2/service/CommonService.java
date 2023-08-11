package com.ezen.phonefly2.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.phonefly2.dao.ICommonDao;
import com.ezen.phonefly2.dto.EventVO;
import com.ezen.phonefly2.dto.NoticeVO;
import com.ezen.phonefly2.util.Paging;

@Service
public class CommonService {
    
    @Autowired
    ICommonDao cdao; // ICommonDao 인터페이스를 구현한 DAO 클래스를 주입받는 필드

    // 공지사항 목록 조회 메서드
    public void getNoticeList(HashMap<String, Object> result) {
        HttpServletRequest request = (HttpServletRequest) result.get("request");
        HttpSession session = request.getSession();
        int page = 1;
        session.removeAttribute("page");

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        Paging paging = new Paging();
        paging.setPage(page);

        int count = cdao.getAllCount("notice"); // "notice" 테이블의 총 개수 가져오기
        paging.setTotalCount(count);

        session.setAttribute("page", page);

        List<NoticeVO> noticeList = cdao.getNoticeList(paging); // 페이징 처리된 공지사항 목록 가져오기
        result.put("noticeList", noticeList);
        result.put("paging", paging);
    }

    // 공지사항 내용 조회 메서드
    public NoticeVO getNotice(int nseq) {
        return cdao.getNotice(nseq);
    }

    // 이벤트 목록 조회 메서드
    public void getEventList(HashMap<String, Object> result) {
        HttpServletRequest request = (HttpServletRequest) result.get("request");
        HttpSession session = request.getSession();
        int page = 1;
        session.removeAttribute("page");

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        Paging paging = new Paging();
        paging.setPage(page);

        int count = cdao.getAllCount("event"); // "event" 테이블의 총 개수 가져오기
        paging.setTotalCount(count);

        session.setAttribute("page", page);

        List<EventVO> eventList = cdao.getEventList(paging); // 페이징 처리된 이벤트 목록 가져오기
        result.put("eventList", eventList);
        result.put("paging", paging);
    }

    // 이벤트 내용 조회 메서드
    public EventVO getEvent(int eseq) {
        return cdao.getEvent(eseq);
    }

    // 공지사항 추가 메서드
    public void insertNotice(NoticeVO noticevo) {
        cdao.insertNotice(noticevo);
    }

    // 공지사항 수정 메서드
    public void updateNotice(NoticeVO noticeVO) {
        cdao.updateNotice(noticeVO);
    }

    // 공지사항 삭제 메서드
    public void deleteNotice(int nseq) {
        cdao.deleteNotice(nseq);
    }

    // 이벤트 추가 메서드
    public void insertEvent(EventVO eventvo) {
        cdao.insertEvent(eventvo);
    }

    // 이벤트 수정 메서드
    public void updateEvent(EventVO eventvo) {
        cdao.updateEvent(eventvo);
    }

    // 이벤트 삭제 메서드
    public void deleteEvent(int eseq) {
        cdao.deleteEvent(eseq);
    }
}
