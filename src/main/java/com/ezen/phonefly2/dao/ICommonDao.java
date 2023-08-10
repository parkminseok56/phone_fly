package com.ezen.phonefly2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.phonefly2.dto.EventVO;
import com.ezen.phonefly2.dto.NoticeVO;
import com.ezen.phonefly2.util.Paging;

@Mapper
public interface ICommonDao {

    // 공통적인 데이터베이스 연동을 수행하는 메서드들이 선언되어 있습니다.	

    // 특정 테이블의 모든 데이터 개수 가져오기
    int getAllCount(String tableName);

    // 페이징을 적용한 공지사항 목록 가져오기
    List<NoticeVO> getNoticeList(Paging paging);

    // 특정 공지사항 정보 가져오기
    NoticeVO getNotice(int nseq);

    // 페이징을 적용한 이벤트 목록 가져오기
    List<EventVO> getEventList(Paging paging);

    // 특정 이벤트 정보 가져오기
    EventVO getEvent(int eseq);

    // 공지사항 추가
    void insertNotice(NoticeVO noticevo);

    // 공지사항 업데이트
    void updateNotice(NoticeVO noticeVO);

    // 특정 공지사항 삭제
    void deleteNotice(int nseq);

    // 이벤트 추가
    void insertEvent(EventVO eventvo);

    // 이벤트 업데이트
    void updateEvent(EventVO eventvo);

    // 특정 이벤트 삭제
    void deleteEvent(int eseq);
}
