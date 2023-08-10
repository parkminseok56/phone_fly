package com.ezen.phonefly2.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.phonefly2.dto.MemberVO;

@Mapper
public interface IMemberDao {

    // 회원 정보와 관련된 데이터베이스 연동을 수행하는 메서드들이 선언되어 있습니다. 
	
    // 특정 아이디에 해당하는 회원 정보 가져오기
    MemberVO getMember(String id);

    // 카카오 회원 가입 처리
    void joinKakao(MemberVO mvo);

    // 회원 가입 처리
    void join(MemberVO mvo);

    // 회원 정보 업데이트 처리
    void memberUpdate(MemberVO mvo);

    // 특정 아이디에 해당하는 회원 정보 삭제
    void deleteMember(String id);

    // 이름과 휴대폰 번호로 아이디 찾기
    MemberVO findId(String name, String phone);

    // 아이디, 이름, 휴대폰 번호로 회원 정보 찾기
    int findMember(String id, String name, String phone);

    // 새로운 비밀번호 설정
    void setNewPwd(String id, String pwd);
}
