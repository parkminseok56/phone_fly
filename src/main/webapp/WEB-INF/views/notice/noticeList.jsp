<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- MAIN  -->



<!-- 헤더 불러오기 -->
<%@ include file="../sub/header.jsp"%>


<article>

<!-- 서브 배너 불러오기 -->
<%@ include file="../sub/sub_image_menu6.jsp"%>

 
<!-- 공지사항 리스트 -->

	<!-- 게시판 페이지 왼쪽 메뉴 -->
	<div class="support-left-menu board-menu card-normal" id="sub-scroll-box">

	<%@ include file="../sub/sub_board_menu.jsp"%>

	</div>
	<!-- //게시판 페이지 왼쪽 메뉴 -->


	<!-- 게시판 페이지 오른쪽 내용 -->
	<div class="support-right-content card-normal">
		<div class="support-inner-wrap">


		<!-- <div class="board-inner-wrap card-normal"> -->
		<div id="board-anchor"></div>
		<h1>공지사항</h1>
		
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">제목</th>
					<th scope="col">작성일자</th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
				<c:forEach items="${noticeList}" var="board" varStatus="status">
					<tr class="cs-p" onclick="location.href='/noticeDetail?nseq=${board.nseq}';">
						<th scope="row">${board.nseq}</th>
						<td>${board.subject}</td>
						<td><fmt:formatDate value="${board.indate}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div id="board-bottom"></div>

		<!-- 페이징 -->
		<div class="clear"></div>
		<div class="paging">
			<div id="board-paging">
				<jsp:include page="../paging/paging.jsp">
				<jsp:param name="command" value="/noticeList" />
				</jsp:include>
			</div>
		</div>
		<!-- //페이징 -->
		<div id="board-list-paging-bottom-margin"></div>




	</div>
	<div class="clear"></div>
	<!-- //게시판 페이지 오른쪽 내용 -->

<!-- //공지사항 리스트 -->



</div>





<div class="clear"></div>
</article>
<!-- //MAIN -->




<!-- footer 불러오기 -->
<%@ include file="../sub/footer.jsp"%>
