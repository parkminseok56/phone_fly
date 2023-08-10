package com.ezen.phonefly2.dto;

import lombok.Data;

@Data
public class AddressVO {

    // 주소 정보를 담는 데이터 객체입니다.
    // @Data 어노테이션은 Lombok 라이브러리를 사용하여 getter, setter, toString 등의 메서드를 자동으로 생성하도록하였습니다.
	
    private String zipnum;   // 우편번호
    private String sido;     // 시도
    private String gugun;    // 구군
    private String zipcode;  // 우편번호 전체
    private String bunji;    // 번지
    private String dong;     // 동 (동읍면리)
}
