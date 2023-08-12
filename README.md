## Phone fly 팀 프로젝트
![메인페이지2](https://github.com/parkminseok56/phone_fly/assets/133790403/5c53db08-4f51-4a51-877f-ec2f57dfe0a5)

## 주제 및 목적

- 주제
   - 휴대폰 온라인 판매 사이트
- 목적
   - 이용자와 관리자의 편의성 제공
- 주요 기능
   - 요금제 비교 : 제품 상세 페이지의 버튼 선택을 통한 실시간 요금제 계산 기능
   - 제품 가격 비교 : 이용자가 원하는 제품을 선택하여 비교 기능
   - 색상 선택 : 제품마다 상이한 종류의 색상을 선택하여 미리보기 기능

## 밴치마킹 사이트

  - 스마트투데이(http://smatoday.co.kr/main/main.html) : 제품 비교기능 
  - 오늘의 폰(https://www.todayphone.net/) : 제품 상세 페이지, 메뉴 구성
  - 애플(https://www.apple.com/kr/iphone/) : 메인 페이지 디자인  
  - 삼성(https://www.samsung.com/sec/smartphones/) : 제품 컬러 선택 기능/ 비교 선택 및  저장 기능

## 요구 사항 분석

- 주요기능
 1. 상품 상세보기 옵션 선택시 기종마다  다른  통신사 요금제 가격이 계산되는가
 ```java
// getProduct 메서드: 특정 제품 정보와 관련 정보를 조회하여 반환하는 메서드입니다.
public HashMap<String, Object> getProduct(int pseq) {
    // 결과를 담을 해시맵 객체 생성
    HashMap<String, Object> result = new HashMap<>();
    
    // pdao 객체를 통해 특정 pseq에 해당하는 제품 정보를 조회합니다.
    ProductVO pvo = pdao.getProduct(pseq);
    
    // 조회된 제품 정보가 null이 아닌 경우
    if (pvo != null) {
        // mdao 객체를 통해 해당 제품의 색상 정보를 조회합니다.
        List<ColorVO> colorList = mdao.getColorList(pvo.getPseq());
        
        // 조회된 색상 정보를 해당 제품 객체에 설정합니다.
        pvo.setColorList(colorList);
        
        // pdao 객체를 통해 요금제 정보를 조회합니다.
        List<RplanVO> rplanList = pdao.getRplanList();
        
        // 조회된 제품 정보와 요금제 정보를 결과 해시맵에 저장합니다.
        result.put("productVO", pvo);
        result.put("rplanList", rplanList);
    }
    
    // 최종 결과 해시맵 반환
    return result;
}
```
  2. 원하는 상품만 선택하여 비교할 수 있는가
 ```java
   // productCompare 메서드: 주어진 pseqList에 있는 제품들을 비교하고 관련 정보를 조회하는 메서드입니다.
   public void productCompare(HashMap<String, Object> result) {
    // 주어진 결과 맵에서 pseqList를 가져옵니다.
    List<Integer> pseqList = (List<Integer>) result.get("pseqList");
    
    // 비교할 제품 정보들을 담을 리스트를 생성합니다.
    List<ProductVO> productList = new ArrayList<>();
    
    // 제품 비교 플래그를 초기화합니다.
    int compareFlag = 1;

    // pseqList가 null이 아닌 경우에만 제품 정보를 비교 및 조회합니다.
    if (pseqList != null) {
        for (Integer pseq : pseqList) {
            // pdao 객체를 통해 특정 pseq에 해당하는 제품 정보를 조회합니다.
            ProductVO pvo = pdao.getProduct(pseq);
            
            // 조회된 제품 정보가 null이 아닌 경우
            if (pvo != null) {
                // mdao 객체를 통해 해당 제품의 색상 정보를 조회합니다.
                List<ColorVO> colorList = mdao.getColorList(pseq);
                
                // 이후 해당 제품 정보 및 색상 정보를 활용하여 필요한 비교와 조회 작업을 수행할 수 있습니다.
```
- 사이트 기본기능
  
1.회원
 - 관리 (가입, 탈퇴, 정보수정, 아이디 찾기, 비밀번호 찾기)
 - 회원 마이 페이지 (가입신청 내역, 개인 1:1 문의내역, 개인 후기내역)
 - 온라인 가입신청 (구매)
 - 구매후기

------------------------------------------------------------------------------------------------------------------------------------------

2.비회원
 - 회원가입 (ID중복확인, 주소찾기, 약관)
 
------------------------------------------------------------------------------------------------------------------------------------------

3.공통
 - 제조사별 상품 리스트
 - 전체 상품 리스트 (비교 상품 선택 없이 이동시)
 - 자주하는 질문
 - 게시판 (공지사항, 이벤트)

------------------------------------------------------------------------------------------------------------------------------------------

 ## 개발 환경

 프로젝트에서 사용한 기술 스택입니다. 

- 프론트앤드
  
  - <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white">
  - <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white">
  - <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black">
  - <img src="https://img.shields.io/badge/jquery-0769AD?style=for-the-badge&logo=jquery&logoColor=white">
  - <img src="https://img.shields.io/badge/bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white">

- 백앤드
  - <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white">
  - <img src="https://img.shields.io/badge/oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white">
  
  
- 프레임워크 
  - <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
  - <img src="https://oopy.lazyrockets.com/api/v2/notion/image?src=https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F41857ea2-4aa9-4820-983b-9f9fdd329118%2FUntitled.png&blockId=0cf4d07a-6ed8-4680-acba-295b14863c4b" width="100">

## 작업 일정 및 조원 분배

- 2023.05.16 ~ 06.02
<p align="center">
 <img src="https://github.com/parkminseok56/phone_fly/assets/133790403/aba9f6b6-7254-4d03-a02f-71d0eb231ac7"width="1000">
</p>


<p>
 <img src="https://github.com/parkminseok56/phone_fly/assets/133790403/d09ba10b-83ad-422f-a089-34485ae7bdd5"width="30">:협업 준비
</p>

<p>
 <img src="https://github.com/parkminseok56/phone_fly/assets/133790403/001a5df9-41aa-4181-bab3-d8cb0d6b9b3a"width="30">:관리자 페이지 개발
</p>

<p>
 <img src="https://github.com/parkminseok56/phone_fly/assets/133790403/d61fa49b-5ec6-470d-a463-c7c3a7c4062c"width="30">:유저 페이지 개발
</p>

<p>
 <img src="https://github.com/parkminseok56/phone_fly/assets/133790403/9ed7fc52-9101-46ef-834b-1cc22c6d732e"width="30">:디버깅 및 테스트
</p>

<p>
 <img src="https://github.com/parkminseok56/phone_fly/assets/133790403/cba9f018-acdc-4556-ba4a-defc9a6ce3d2"width="30">:발표 준비
</p>

 ------------------------------------------------------------------------------------------------------------------------------------------

- 조원 분배
  
   총 인원 4명으로 프론트앤드,백앤드 큰 구분없이 파트별로 전체적으로 진행됨
  
   - 박민석: 사용자 페이지, 관리자 페이지
   - 이경민: 사용자 페이지, 관리자 페이지
   - 백현성: 사용자 페이지, 모바일 페이지
   - 전지웅: 사용자 페이지, DB 데이터 관리
 
 ------------------------------------------------------------------------------------------------------------------------------------------

## 협업 준비 과정

 - 유스 케이스 다이어그램 , 시퀀스 다이어그램 , 기능정의서로 구분하여 준비하였습니다.
https://github.com/parkminseok56/Communication/blob/main/


   

## DB 설계
<p align="center">
 <img src="https://github.com/parkminseok56/phone_fly/assets/133790403/c7acd141-8e61-4ff9-b7e8-ebaddb73b717"width="1000">
</p>

 - 설계 설명
    - 상품마다 각각 다른 색상 선택을 적용하기 위해, 각 상품의 고유 식별자를 활용하여 color 테이블의 참조값을 활용하였습니다.
    - 회원의 경우에만 1대1 문의 사항과 리뷰를 작성할 수 있게 하였습니다.
    - 상품 테이블을 기반으로 주문 상세 테이블을 통해 요금제 테이블로 연결, 마지막으로 통신사 선택까지의 과정을 설계하여 체계적인 데이터 흐름을 구축하였습니다.
    - 관리자는 공지사항과 이벤트 작성 권한을 가지며, 이를 통해 관리자 기능을 효과적으로 구현하였습니다.


## 화면 구성

   - 사용자 페이지(https://github.com/parkminseok56/phone_fly/issues/16)
   - 관리자 페이지(https://github.com/parkminseok56/phone_fly/issues/17)
 



## 후기
  
- 첫 프로젝트였던 만큼 지식과 경험의 부족으로 인해 애로사항이 있었지만, 프로젝트를 진행하면서 이론을 실전에 적용하며 지속적으로 배우며,
  처음에 미숙한 부분을 다듬고 개선하며 최종 결과물을 잘 마무리 할 수 있었습니다.

  기술적인 측면에서는 스프링 부트, MyBatis, 그리고 AJAX 등을 활용하여 개발 속도가 두 배 이상 빨라진다는 경험을 했습니다.
  이러한 기술들을 적용하면서 웹 페이지 구동에 필요한 기본 지식은 물론, 학습하는 습관과 문제 해결 능력을 향상시키는 데에도 도움을 받았습니다.

  또한, 데이터베이스 설계, 다이어그램 작성, 기능 정의서 작성 등과 같은 협업의 기본 단계들을 배우며 다양한 것들을 습득했습니다.
  프로젝트 개발이 완료된 이후에는 팀원들과 코드 리뷰를 통해 사용한 소스 코드 등을 공유하며 서로 발전할 수 있는 기회가 되었던 좋은 경험의 프로젝트였습니다.








