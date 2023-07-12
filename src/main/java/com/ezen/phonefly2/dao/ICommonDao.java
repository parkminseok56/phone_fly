package com.ezen.phonefly2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.phonefly2.dto.EventVO;
import com.ezen.phonefly2.dto.NoticeVO;
import com.ezen.phonefly2.util.Paging;
@Mapper
public interface ICommonDao {
	// 다시작성 : bhs
	
	int getAllCount(String tableName);
	List<NoticeVO> getNoticeList(Paging paging);
	NoticeVO getNotice(int nseq);
	List<EventVO> getEventList(Paging paging);
	EventVO getEvent(int eseq);
	void insertNotice(NoticeVO noticevo);
	void updateNotice(NoticeVO noticeVO);
	void deleteNotice(int nseq);
	void insertEvent(EventVO eventvo);
	void updateEvent(EventVO eventvo);
	void deleteEvent(int eseq);
	
}
