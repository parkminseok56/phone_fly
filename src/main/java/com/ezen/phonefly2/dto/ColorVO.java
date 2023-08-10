package com.ezen.phonefly2.dto;

import lombok.Data;

@Data
public class ColorVO {

    // 제품의 색상 정보를 저장하는데 사용되며, @Data 어노테이션으로 인해 getter, setter, toString 등의 메서드가 자동으로 생성됩니다.
	
    private int cseq;       // 색상 일련번호
    private int pseq;       // 제품 일련번호
    private String name;    // 색상 이름
    private String ccode;   // 색상 코드
    private String image;   // 색상 이미지
}
