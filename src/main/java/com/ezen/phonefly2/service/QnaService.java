package com.ezen.phonefly2.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.phonefly2.dao.ICommonDao;
import com.ezen.phonefly2.dao.IQnaDao;
import com.ezen.phonefly2.dto.MemberVO;
import com.ezen.phonefly2.dto.NoticeVO;
import com.ezen.phonefly2.dto.QnaVO;
import com.ezen.phonefly2.util.Paging;

@Service
public class QnaService {

    @Autowired
    IQnaDao qdao; // IQnaDao 인터페이스를 구현한 DAO 클래스를 주입받는 필드

    // Q&A 목록 조회 및 페이징 처리 메서드
    public void qnaList(HashMap<String, Object> result) {
        HttpServletRequest request = (HttpServletRequest) result.get("request");
        String id = result.get("id").toString(); // 사용자 아이디
        HttpSession session = request.getSession();
        int page = 1;
        session.removeAttribute("page");
        
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        
        Paging paging = new Paging();
        paging.setPage(page);
        int count = qdao.getAllCountById(id); // 해당 사용자의 Q&A 총 개수 조회
        paging.setTotalCount(count);
        session.setAttribute("page", page);
        List<QnaVO> qnaList = qdao.qnaList(paging, id); // 해당 사용자의 Q&A 목록 조회
        result.put("qnaList", qnaList);
        result.put("paging", paging);
    }

    // 특정 Q&A 내용 조회 메서드
    public QnaVO getQna(int qseq) {
        return qdao.getQna(qseq); // 특정 Q&A 내용 조회
    }

    // Q&A 작성 메서드
    public void qnaWrite(QnaVO qvo) {
        qdao.qnaWrite(qvo); // Q&A 작성
    }

    // Q&A 수정 메서드
    public void qnaUpdate(QnaVO qvo) {
        qdao.qnaUpdate(qvo); // Q&A 수정
    }

    // Q&A 삭제 메서드
    public void qnaDelete(int qseq) {
        qdao.qnaDelete(qseq); // Q&A 삭제
    }
}
