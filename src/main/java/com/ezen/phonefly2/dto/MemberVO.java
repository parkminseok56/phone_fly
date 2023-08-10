package com.ezen.phonefly2.dto;

import lombok.Data;

@Data
public class MemberVO {

    // 회원 정보를 저장하는데 사용되며, @Data 어노테이션으로 인해 getter, setter, toString 등의 메서드가 자동으로 생성됩니다. 


	
    private String id;        // 회원 아이디
    private String pwd;       // 회원 비밀번호
    private String name;      // 회원 이름
    private String email;     // 회원 이메일
    private String zipnum;    // 우편번호
    private String address1;  // 주소 (시도)
    private String address2;  // 주소 (구군)
    private String address3;  // 주소 (상세)
    private String phone;     // 회원 전화번호
    private String useyn;     // 회원 사용 여부 ("Y" 또는 "N")
    private String provider;  // 회원 가입 제공자 (ex: "kakao", "naver", "local")
}
