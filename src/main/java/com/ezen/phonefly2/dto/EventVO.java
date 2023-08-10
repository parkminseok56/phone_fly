package com.ezen.phonefly2.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class EventVO {

   // 이벤트 정보를 저장하는데 사용되며, @Data 어노테이션으로 인해 getter, setter, toString 등의 메서드가 자동으로 생성됩니다. 	
	
    private int eseq;           // 이벤트 일련번호
    private String id;          // 작성자 아이디
    private String subject;     // 이벤트 제목
    private String image;       // 이벤트 이미지
    private Timestamp indate;   // 이벤트 등록일시
}
