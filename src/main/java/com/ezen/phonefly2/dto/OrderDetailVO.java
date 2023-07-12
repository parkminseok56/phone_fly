package com.ezen.phonefly2.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class OrderDetailVO {
	
	private int odseq;			// 주문상세 번호 [PK]
	private int pseq;			// 상품 번호 [product FK]
	private int rseq;			// 요금제 번호 [rplan FK]
	private String id;			// 회원 아이디 [member FK]
	private String result;		// 처리결과 {1: '접수중(default)', 2: '발송중', 3: '완료' }
	private int discount;		// 할인방법 {1: '공시지원할인', 2: '선택약정할인'}
	private int buyplan;		// 구매방법 {1, 24, 30, 36}
	private int dcmonth;		// 할부금 (금액: front-end에서 계산됨)
	private int dctotal;		// 할부원금 (금액: front-end에서 계산됨)
	private int mmonth;			// 통신요금 (금액: front-end에서 계산됨)
	private int mtotal;			// 월 총 납부금액 (금액: front-end에서 계산됨)
	private String cc;			// 가입 종류 {0: 통신사이동, 1: 기기변경}
	private Timestamp indate;	// 신청일 [SYSDATE(default)]
	private int cseq;			// 컬러 시퀀스 번호 [color: cseq]


	// join으로 다른 테이블에서 가져오는 parameter
	private String pname;		// 제품명 [product: name]
	private String cname;		// 통신사명 [comm : name]
	private String ccname;		// 컬러명 [color: name]
	private String rname;		// 요금제명 [rplan: name]
	private String mname;		// 회원명 [member: mame]
	private String image;		// 제품 이미지 파일명 [color: image]

	private int price;			// 제품 가격 [product: price2]
	private String mfc;			// 제조사 명 [product: mfc]
	private int charge;			// 요금 [rplan: charge]
	private String dataplan;	// 데이터제공량 [rplan: dataplan]
	private String timeplan;	// 통화제공량 [rplan: timeplan]
	private String textplan;	// 문자제공량 [rplan: textplan]

}
