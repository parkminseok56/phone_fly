package com.ezen.phonefly2.dto;

import lombok.Data;

@Data
public class CommVO {

    // 공통적인 데이터 정보를 저장하는데 사용됩니다. @Data 어노테이션으로 인해 getter, setter, toString 등의 메서드가 자동으로 생성됩니다. 
    // 데이터의 공통 필드를 표현할 때 사용됩니다.
	
    private int mseq;    // 일련번호 (멤버 일련번호)
    private String name; // 이름 (멤버 이름)
}
