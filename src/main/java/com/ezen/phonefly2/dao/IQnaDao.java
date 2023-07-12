package com.ezen.phonefly2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.phonefly2.dto.MemberVO;
import com.ezen.phonefly2.dto.QnaVO;
import com.ezen.phonefly2.util.Paging;

@Mapper
public interface IQnaDao {

	int getAllCountById(String id);
	List<QnaVO> qnaList(Paging paging, String id);
	QnaVO getQna(int qseq);
	void qnaWrite(QnaVO qvo);
	void qnaUpdate(QnaVO qvo);
	void qnaDelete(int qseq);

}
