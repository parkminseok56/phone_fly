package com.ezen.phonefly2.dto;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class ProductVO {

   // 상품 정보를 저장하는 데 사용되며, @Data 어노테이션으로 인해 getter, setter, toString 등의 메서드가 자동으로 생성됩니다.
	
    private Integer pseq;     // 상품 일련번호
    private String name;      // 상품명
    private Integer price1;   // 상품 가격1
    private Integer price2;   // 상품 가격2
    private Integer price3;   // 상품 가격3
    private String content;   // 상품 내용
    private String useyn;     // 상품 사용 여부 ("Y" 또는 "N")
    private String eventyn;   // 이벤트 여부 ("Y" 또는 "N")
    private String bestyn;    // 베스트 상품 여부 ("Y" 또는 "N")
    private Timestamp indate; // 상품 등록일시
    private String mfc;       // 제조사명

    private List<ColorVO> colorList; // 컬러 목록
}
