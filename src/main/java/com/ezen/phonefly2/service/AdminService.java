package com.ezen.phonefly2.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.phonefly2.dao.IAdminDao;
import com.ezen.phonefly2.dto.BannerVO;
import com.ezen.phonefly2.dto.ColorVO;
import com.ezen.phonefly2.dto.EventVO;
import com.ezen.phonefly2.dto.MemberVO;
import com.ezen.phonefly2.dto.NoticeVO;
import com.ezen.phonefly2.dto.OrderDetailVO;
import com.ezen.phonefly2.dto.ProductVO;
import com.ezen.phonefly2.dto.QnaVO;
import com.ezen.phonefly2.util.Paging;

@Service
public class AdminService {
	@Autowired // IAdminDao 인터페이스를 구현한 DAO 클래스를 주입받는 필드
	IAdminDao adao;

 // 직원 로그인 체크 메서드
 public int workerCheck(String workId, String workPwd) {
        System.out.println("id : " + workId); // 작업자 ID 출력
        String pwd = adao.getPwd(workId); // 작업자 ID로부터 비밀번호를 가져옴
        System.out.println("pwd : " + pwd); // 가져온 비밀번호 출력
        int result = 0;

        if (pwd == null) result = -1; // 비밀번호가 없는 경우 결과는 -1
        else if (workPwd.equals(pwd)) result = 1; // 비밀번호가 일치하면 결과는 1
        else if (!workPwd.equals(pwd)) result = 0; // 비밀번호가 일치하지 않으면 결과는 0

        return result;
    }

// 관리자용 상품 목록 조회 메서드
public HashMap<String, Object> getAdminProductList(HttpServletRequest request) {
    // 결과를 담을 HashMap 생성
    HashMap<String, Object> result = new HashMap<String, Object>();
    
    // 현재 세션 가져오기
    HttpSession session = request.getSession();
    
    // 첫 요청 시 페이지와 키 값을 세션에서 제거
    if (request.getParameter("first") != null) {
        session.removeAttribute("page");
        session.removeAttribute("key");
    }
    
    int page = 1; // 초기 페이지 값 설정
    if (request.getParameter("page") != null) { // 요청 파라미터에 페이지 값이 있는 경우
        page = Integer.parseInt(request.getParameter("page")); // 페이지 값을 파라미터에서 읽어와 설정
        session.setAttribute("page", page); // 페이지 값을 세션에 저장
    } else if (session.getAttribute("page") != null) { // 세션에 페이지 값이 있는 경우
        page = (int) session.getAttribute("page"); // 세션에서 페이지 값을 가져와 설정
    } else { // 페이지 값이 없는 경우
        page = 1; // 페이지 값을 1로 설정
        session.removeAttribute("page"); // 세션에서 페이지 값을 제거
    }
    
    String key = ""; // 초기 검색 키워드 값 설정
    if (request.getParameter("key") != null) { // 요청 파라미터에 키 값이 있는 경우
        key = request.getParameter("key"); // 키 값을 파라미터에서 읽어와 설정
        session.setAttribute("key", key); // 키 값을 세션에 저장
    } else if (session.getAttribute("key") != null) { // 세션에 키 값이 있는 경우
        key = (String) session.getAttribute("key"); // 세션에서 키 값을 가져와 설정
    } else { // 키 값이 없는 경우
        session.removeAttribute("key"); // 세션에서 키 값을 제거
        key = ""; // 키 값을 빈 문자열로 설정
    }
    
    Paging paging = new Paging(); // 페이징 객체 생성
    paging.setPage(page); // 페이징 객체에 페이지 값 설정
    
    // "product" 테이블에서 "name" 필드를 키워드로 검색한 총 개수 가져오기
    int count = adao.getAllCount("product", "name", key);
    paging.setTotalCount(count); // 페이징 객체에 총 개수 설정
    paging.paging(); // 페이징 계산 수행
    
    // 페이징 처리된 상품 목록 가져오기
    List<ProductVO> productList = adao.listProduct(paging, key);
    
    // 결과 HashMap에 상품 목록, 페이징 정보, 검색 키워드 저장
    result.put("AdminProductList", productList);
    result.put("paging", paging);
    result.put("key", key);
    
    return result; // 결과 HashMap 반환
}

         // // 관리자용 회원 목록 조회 메서드
	public HashMap<String, Object> getMemberList(HttpServletRequest request) {
	    HashMap<String, Object> result = new HashMap<String, Object>();
	    HttpSession session = request.getSession();

	    // 첫 번째 요청인 경우 세션에 저장된 페이지와 키 값을 제거합니다.
	    if (request.getParameter("first") != null) {
	        session.removeAttribute("page");
	        session.removeAttribute("key");
	    }

	    int page = 1;
	    if (request.getParameter("page") != null) {
	        page = Integer.parseInt(request.getParameter("page"));
	        session.setAttribute("page", page);
	    } else if (session.getAttribute("page") != null) {
	        page = (int) session.getAttribute("page");
	    } else {
	        page = 1;
	        session.removeAttribute("page");
	    }

	    String key = "";
	    if (request.getParameter("key") != null) {
	        key = request.getParameter("key");
	        session.setAttribute("key", key);
	    } else if (session.getAttribute("key") != null) {
	        key = (String) session.getAttribute("key");
	    } else {
	        session.removeAttribute("key");
	        key = "";
	    }

	    Paging paging = new Paging();
	    paging.setPage(page);

	    int count = adao.getAllCount("member", "name", key);
	    paging.setTotalCount(count);
	    paging.paging();

	    List<MemberVO> list = adao.listMember(paging, key);
	    result.put("memberList", list);
	    result.put("paging", paging);
	    result.put("key", key);

	    return result;
	}

	// 관리자용 Q&A 목록 조회 메서드
	public HashMap<String, Object> getQnaList(HttpServletRequest request) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		if( request.getParameter("first")!=null ) {
			session.removeAttribute("page");
			session.removeAttribute("key");
		}		
		int page = 1;
		if( request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			session.setAttribute("page", page);
		} else if( session.getAttribute("page")!= null ) {
			page = (int) session.getAttribute("page");
		} else {
			page = 1;
			session.removeAttribute("page");
		}
		String key = "";
		if( request.getParameter("key") != null ) {
			key = request.getParameter("key");
			session.setAttribute("key", key);
		} else if( session.getAttribute("key")!= null ) {
			key = (String)session.getAttribute("key");
		} else {
			session.removeAttribute("key");
			key = "";
		} 
		Paging paging = new Paging();
		paging.setPage(page);		
		int count = adao.getAllCount( "qna", "subject", key );
		paging.setTotalCount(count);
		paging.paging();	
		
		List<QnaVO> list = adao.listQna( paging , key );
		result.put("qnaList" , list);
		result.put("paging", paging);
		result.put("key", key);
	
		return result;
	
}

	 // 관리자용 공지사항 목록 조회 메서드
	public HashMap<String, Object> getNoticeList(HttpServletRequest request) {
	    HashMap<String, Object> result = new HashMap<String, Object>();
	    HttpSession session = request.getSession();
	    
	    // 첫 번째 요청인 경우 세션에 저장된 페이지와 키 값을 제거합니다.
	    if (request.getParameter("first") != null) {
	        session.removeAttribute("page");
	        session.removeAttribute("key");
	    }
	    
	    int page = 1;
	    if (request.getParameter("page") != null) {
	        page = Integer.parseInt(request.getParameter("page"));
	        session.setAttribute("page", page);
	    } else if (session.getAttribute("page") != null) {
	        page = (int) session.getAttribute("page");
	    } else {
	        page = 1;
	        session.removeAttribute("page");
	    }
	    
	    String key = "";
	    if (request.getParameter("key") != null) {
	        key = request.getParameter("key");
	        session.setAttribute("key", key);
	    } else if (session.getAttribute("key") != null) {
	        key = (String) session.getAttribute("key");
	    } else {
	        session.removeAttribute("key");
	        key = "";
	    }
	    
	    Paging paging = new Paging();
	    paging.setPage(page);
	    
	    // 공지사항 테이블에서 키워드로 검색한 결과의 총 개수를 가져옵니다.
	    int count = adao.getAllCount("notice", "subject", key);
	    paging.setTotalCount(count);
	    paging.paging();
	    
	    // 페이징 처리된 공지사항 목록을 가져옵니다.
	    List<NoticeVO> list = adao.listNotice(paging, key);
	    result.put("noticeList", list);
	    result.put("paging", paging);
	    result.put("key", key);
	    
	    return result;
	}


	// 관리자용 이벤트 목록 조회 메서드
	public HashMap<String, Object> getEventList(HttpServletRequest request) {
	    HashMap<String, Object> result = new HashMap<String, Object>();
	    HttpSession session = request.getSession();

	    // 첫 번째 요청인 경우 세션에 저장된 페이지와 키 값을 제거합니다.
	    if (request.getParameter("first") != null) {
	        session.removeAttribute("page");
	        session.removeAttribute("key");
	    }

	    int page = 1;
	    if (request.getParameter("page") != null) {
	        page = Integer.parseInt(request.getParameter("page"));
	        session.setAttribute("page", page);
	    } else if (session.getAttribute("page") != null) {
	        page = (int) session.getAttribute("page");
	    } else {
	        page = 1;
	        session.removeAttribute("page");
	    }

	    String key = "";
	    if (request.getParameter("key") != null) {
	        key = request.getParameter("key");
	        session.setAttribute("key", key);
	    } else if (session.getAttribute("key") != null) {
	        key = (String) session.getAttribute("key");
	    } else {
	        session.removeAttribute("key");
	        key = "";
	    }

	    Paging paging = new Paging();
	    paging.setPage(page);

	    // 이벤트 테이블에서 키워드로 검색한 결과의 총 개수를 가져옵니다.
	    int count = adao.getAllCount("event", "subject", key);
	    paging.setTotalCount(count);
	    paging.paging();

	    // 페이징 처리된 이벤트 목록을 가져옵니다.
	    List<EventVO> list = adao.listEvent(paging, key);
	    result.put("eventList", list);
	    result.put("paging", paging);
	    result.put("key", key);

	    return result;
	}


	// 관리자용 주문 목록 조회 메서드
	public HashMap<String, Object> getOrderList(HttpServletRequest request) {
	    HashMap<String, Object> result = new HashMap<String, Object>();
	    HttpSession session = request.getSession();

	    // 첫 번째 요청인 경우 세션에 저장된 페이지와 키 값을 제거합니다.
	    if (request.getParameter("first") != null) {
	        session.removeAttribute("page");
	        session.removeAttribute("key");
	    }

	    int page = 1;
	    if (request.getParameter("page") != null) {
	        page = Integer.parseInt(request.getParameter("page"));
	        session.setAttribute("page", page);
	    } else if (session.getAttribute("page") != null) {
	        page = (int) session.getAttribute("page");
	    } else {
	        page = 1;
	        session.removeAttribute("page");
	    }

	    String key = "";
	    if (request.getParameter("key") != null) {
	        key = request.getParameter("key");
	        session.setAttribute("key", key);
	    } else if (session.getAttribute("key") != null) {
	        key = (String) session.getAttribute("key");
	    } else {
	        session.removeAttribute("key");
	        key = "";
	    }

	    Paging paging = new Paging();
	    paging.setPage(page);

	    // 주문 테이블에서 키워드로 검색한 결과의 총 개수를 가져옵니다.
	    int count = adao.getAllCount("ORDER_DETAIL_VIEW2", "id", key);
	    paging.setTotalCount(count);
	    paging.paging();

	    // 페이징 처리된 주문 목록을 가져옵니다.
	    List<OrderDetailVO> list = adao.listOrder(paging, key);
	    result.put("orderList", list);
	    result.put("paging", paging);
	    result.put("key", key);

	    return result;
	}

	 // 배너 목록 조회 메서드
	public List<BannerVO> getBannerList() {
		return adao.getBannerList();
	}

	// 배너 추가 메서드
    public void insertBanner(HashMap<String, Object> paramMap) {
        adao.insertBanner(paramMap);
    }

    // 배너 순서 업데이트 메서드
    public void updateSeq(int changeval, String useyn, int bseq) {
        adao.updateSeq(changeval, useyn, bseq);
    }

    // 배너 삭제 메서드
    public void deleteBanner(int bseq) {
        adao.deleteBanner(bseq);
    }

    // Q&A 답변 작성 메서드
    public void qnaReply(int qseq, String reply) {
        adao.qnaReply(qseq, reply);
    }

    // 상품 추가 메서드
    public ProductVO insertProduct(ProductVO productvo) {
        adao.insertProduct(productvo);
        return productvo;
    }

    // 상품 색상 추가 메서드
    public void insertColor(HashMap<String, Object> paramMap) {
        adao.insertColor(paramMap);
    }

	// 상품 색상 목록 조회 메서드
	public HashMap<String, Object> getColorList(int pseq) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		
	    List<ColorVO> list = adao.listColor(pseq);
	    result.put("ProductColorList", list);
	    
	    return result;
	}


	// 배너 정보 조회 메서드
    public BannerVO getBanner(int bseq) {
        return adao.getBanner(bseq);
    }

    // 상품 삭제 메서드
    public void deleteProduct(int pseq) {
        adao.deleteProduct(pseq);
    }

    // 상품 정보 업데이트 메서드
    public void updateProduct(ProductVO pvo) {
        adao.updateProduct(pvo);
    }

    // 상품 색상 정보 조회 메서드
    public ColorVO getColor(int cseq) {
        return adao.getColor(cseq);
    }

    // 상품 색상 정보 업데이트 메서드
    public void updateColor(ColorVO cvo) {
        adao.updateColor(cvo);
    }

    // 배너 정보 업데이트 메서드
    public void updateBanner(BannerVO bannervo) {
        adao.updateBanner(bannervo);
    }

    // 상품 색상 삭제 메서드
    public void deleteColor(int cseq) {
        adao.deleteColor(cseq);
    }
}
