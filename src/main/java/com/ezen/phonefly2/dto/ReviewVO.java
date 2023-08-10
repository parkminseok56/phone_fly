package com.ezen.phonefly2.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ReviewVO {

   // 리뷰 정보를 저장하는 데 사용되며, @Data 어노테이션으로 인해 getter, setter, toString 등의 메서드가 자동으로 생성됩니다.	
	
    private int rvseq;      // 리뷰 일련번호
    private String id;      // 작성자 아이디
    private String subject; // 리뷰 제목
    private String content; // 리뷰 내용
    private Timestamp indate; // 리뷰 등록일시
    private int pseq;       // 상품 번호 [product FK]
    private String name;    // 작성자 이름 (join으로 가져옴)
    private String pname;   // 상품명 (join으로 가져옴)
}
