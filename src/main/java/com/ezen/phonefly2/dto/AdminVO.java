package com.ezen.phonefly2.dto;

import lombok.Data;

@Data
public class AdminVO {

    // 관리자의 정보를 저장하는데 사용되며, @Data 어노테이션으로 인해 getter, setter, toString 등의 메서드가 자동으로 생성됩니다.	
	
    private String id;   // 관리자 아이디
    private String pwd;  // 관리자 비밀번호
    private String name; // 관리자 이름
}
