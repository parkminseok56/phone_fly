package com.ezen.phonefly2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.phonefly2.dao.IMemberDao;
import com.ezen.phonefly2.dto.MemberVO;

@Service
public class MemberService {
    
    @Autowired
    IMemberDao mdao; // IMemberDao 인터페이스를 구현한 DAO 클래스를 주입받는 필드

    // 멤버 정보 조회 메서드
    public MemberVO getMember(String id) {
        return mdao.getMember(id);
    }

    // 카카오 회원 가입 메서드
    public void joinKakao(MemberVO mvo) {
        mdao.joinKakao(mvo);
    }

    // 일반 회원 가입 메서드
    public void join(MemberVO mvo) {
        mdao.join(mvo);
    }

    // 멤버 정보 업데이트 메서드
    public void memberUpdate(MemberVO mvo) {
        mdao.memberUpdate(mvo);
    }

    // 멤버 삭제 메서드
    public void deleteMember(String id) {
        mdao.deleteMember(id);
    }

    // 아이디 찾기 메서드
    public MemberVO findId(String name, String phone) {
        return mdao.findId(name, phone);
    }

    // 회원 정보 확인 메서드
    public int findMember(String id, String name, String phone) {
        return mdao.findMember(id, name, phone);
    }

    // 새로운 비밀번호 설정 메서드
    public void setNewPwd(String id, String pwd) {
        mdao.setNewPwd(id, pwd);
    }
}
