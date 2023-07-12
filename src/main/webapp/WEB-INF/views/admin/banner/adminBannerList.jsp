<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../admin/header2.jsp"%>
<%@ include file="../../admin/sub_menu2.jsp"%>

<article>

	<h1>배너 리스트</h1>
	<form name="frm" method="post">
	<input type="hidden" name="order_seq_previous" value="${bannerVO.order_seq}">
		<table id="bannerTd">
			<tr>
				<td id="bannertd"><input id="bannerbtn" type="button"
					name="btn_write" value="새배너 등록"
					onClick="location.href='newBannerWrite'"></td>
			</tr>
		</table>
		<table id="productList">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>순위</th>
				<th>사용유무</th>
				<th>등록일</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
			<c:choose>
				<c:when test="${bannerListSize==0}">
					<tr>
						<td width="100%" colspan="6" align="center" height="23">등록된
							상품이 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${bannerList}" var="bannerVO">
						<tr>
							<td height="23" align="center">${bannerVO.bseq}</td>
							
							<td	style="text-align: center;">
								<a href="javascript:;" onClick="go_banner_view('${bannerVO.bseq}');">
									${bannerVO.subject} 
							    </a>
							</td>
							
							<td><select name="order_seq" id="${bannerVO.bseq}"
								onChange="changeOrder('${bannerVO.bseq}');">
									<c:forEach var="cnt" begin="1" end="5" varStatus="status">
										<c:choose>
											<c:when test="${cnt==bannerVO.order_seq}">
												<option value="${cnt}" selected>${cnt}</option>
											</c:when>
											<c:otherwise>
												<option value="${cnt}">${cnt}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
									<c:choose>
										<c:when test="${bannerVO.order_seq==6}">
											<option value="6" selected>사용안함</option>
										</c:when>
										<c:otherwise>
											<option value="6">사용안함</option>
										</c:otherwise>
									</c:choose>
							</select></td>
							<td>${bannerVO.useyn}</td>
							<td width="150"><fmt:formatDate value="${bannerVO.indate}" /></td>
							<td><input type="button" value="수정"
								onClick="go_update_banner(${bannerVO.bseq})"></td>
							<td><input type="button" value="삭제"
								onClick="go_del_b(${bannerVO.bseq})"></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	</form>

</article>

<%@ include file="../../admin/footer.jsp"%>