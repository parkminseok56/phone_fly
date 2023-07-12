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
	// 다시 작성 : bhs

	@Autowired
	IQnaDao qdao;

	public void qnaList(HashMap<String, Object> result) {
		HttpServletRequest request = (HttpServletRequest)result.get("request");
		String id = result.get("id").toString();
		HttpSession session = request.getSession();
		int page = 1;
		session.removeAttribute("page");
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		Paging paging = new Paging();
		paging.setPage(page);
		int count = qdao.getAllCountById(id);
		paging.setTotalCount(count);
		session.setAttribute("page", page);
		List<QnaVO> qnaList = qdao.qnaList(paging, id);
		result.put("qnaList", qnaList);
		result.put("paging", paging);
	}

	public QnaVO getQna(int qseq) {
		return qdao.getQna(qseq);
	}

	public void qnaWrite(QnaVO qvo) {
		qdao.qnaWrite(qvo);
	}

	public void qnaUpdate(QnaVO qvo) {
		qdao.qnaUpdate(qvo);
	}

	public void qnaDelete(int qseq) {
		qdao.qnaDelete(qseq);
	}

}
