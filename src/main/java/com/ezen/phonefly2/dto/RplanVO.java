package com.ezen.phonefly2.dto;

import lombok.Data;

@Data
public class RplanVO {

    //  통신 요금제 정보를 저장하는 데 사용되며, @Data 어노테이션으로 인해 getter, setter, toString 등의 메서드가 자동으로 생성됩니다
	
    private int rseq;       // 요금제 일련번호
    private int mseq;       // 회원 일련번호 [member FK]
    private String name;    // 요금제명
    private int charge;     // 요금
    private String dataplan; // 데이터 제공량
    private String timeplan; // 통화 제공량
    private String textplan; // 문자 제공량
}
