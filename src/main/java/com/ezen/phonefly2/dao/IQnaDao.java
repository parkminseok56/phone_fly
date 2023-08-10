package com.ezen.phonefly2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.phonefly2.dto.MemberVO;
import com.ezen.phonefly2.dto.QnaVO;
import com.ezen.phonefly2.util.Paging;

@Mapper
public interface IQnaDao {

    // Q&A 정보와 관련된 데이터베이스 연동을 수행하는 메서드들이 선언되어 있습니다.
	
    // 특정 아이디에 해당하는 모든 Q&A 개수 가져오기
    int getAllCountById(String id);

    // 페이징과 아이디에 따른 Q&A 목록 가져오기
    List<QnaVO> qnaList(Paging paging, String id);

    // 특정 Q&A 정보 가져오기
    QnaVO getQna(int qseq);

    // Q&A 작성하기
    void qnaWrite(QnaVO qvo);

    // Q&A 업데이트하기
    void qnaUpdate(QnaVO qvo);

    // 특정 Q&A 삭제하기
    void qnaDelete(int qseq);
}
