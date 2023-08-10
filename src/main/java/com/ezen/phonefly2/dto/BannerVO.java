package com.ezen.phonefly2.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BannerVO {
	
    // 배너 정보를 저장하는데 사용되며, @Data 어노테이션으로 인해 getter, setter, toString 등의 메서드가 자동으로 생성됩니다.
	
    private int bseq;          // 배너 일련번호
    private String subject;    // 배너 제목
    private int order_seq;     // 배너 순서
    private String useyn;      // 배너 사용 여부 ("Y" 또는 "N")
    private Timestamp indate;  // 배너 등록일시
    private String video;      // 배너 비디오 URL
    private String btitle;     // 배너 타이틀
    private String btext;      // 배너 텍스트
    private String top;        // 배너 상단 위치
    private String left;       // 배너 좌측 위치
}
