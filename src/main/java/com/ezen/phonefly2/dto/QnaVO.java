package com.ezen.phonefly2.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class QnaVO {

   //  Q&A 정보를 저장하는 데 사용되며, @Data 어노테이션으로 인해 getter, setter, toString 등의 메서드가 자동으로 생성됩니다.	
	
    private int qseq;        // Q&A 일련번호
    private String id;       // 작성자 아이디
    private String subject;  // Q&A 제목
    private String content;  // Q&A 내용
    private String reply;    // 관리자 답변 내용
    private String rep;      // 답변 여부 ("Y" 또는 "N")
    private Timestamp indate; // Q&A 등록일시
}
