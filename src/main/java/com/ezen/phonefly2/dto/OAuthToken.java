package com.ezen.phonefly2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OAuthToken {

   // OAuth 인증 토큰 정보를 저장하는데 사용되며, @Data 어노테이션으로 인해 getter, setter, toString 등의 메서드가 자동으로 생성됩니다. 
   // @AllArgsConstructor 어노테이션으로 모든 필드를 매개변수로 받는 생성자를 생성하여 편의성을 높였습니다.
   // 이 클래스는 OAuth 인증 과정에서 발급되는 토큰 정보를 저장하는 데 사용됩니다.

    private String access_token; // 접근 토큰
    private String token_type;   // 토큰 타입
    private String refresh_token; // 리프레시 토큰
    private int expires_in;       // 토큰 만료 시간 (초)
    private String scope;         // 스코프
    private int refresh_token_expires_in; // 리프레시 토큰 만료 시간 (초)
}
