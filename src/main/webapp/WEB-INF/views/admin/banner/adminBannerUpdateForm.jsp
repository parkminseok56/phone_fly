<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../admin/header2.jsp"%>
<%@ include file="../../admin/sub_menu2.jsp"%>
<article>
	<h1>배너수정</h1>
	<form action="/bannerUpdate" name="frm" method="post" onsubmit="return validateForm()">
		<input type="hidden" name="bseq" value="${bannerVO.bseq}">
		<input type="hidden" name="oldfilename" value="${bannerVO.video}">
        <input type="hidden" name="order_seq_previous" value="${bannerVO.order_seq}">
		<table id="BannerUpdateList">
			<tr>
				<th>배너 제목</th>
				<td width="10" colspan="5" >
				<input type="text" name="subject" size="10" value="${bannerVO.subject}">
				</td>
			</tr>


           <!-- 배너 디스플레이 순위 선택 -->
			<tr>
				<th>순위</th>
				<td id="BannerOrder"width="40">
				<select  name="order_seq" onchange="savePreviousValue(this)">
					   <option value="">디스플레이될 순서를 선택하세요</option>
					   
					 <!-- 배너의 현재 순위를 기준으로 선택 옵션을 생성 -->
					<c:choose>
						<c:when test="${bannerVO.order_seq == '1'}">
							<option value="1" selected>1</option>
						</c:when>
						<c:otherwise>
							<option value="1">1</option>
						</c:otherwise>
					</c:choose>
					
					<c:choose>
						<c:when test="${bannerVO.order_seq == '2'}">
							<option value="2" selected>2</option>
						</c:when>
						<c:otherwise>
							<option value="2">2</option>
						</c:otherwise>
					</c:choose>
					
					<c:choose>
						<c:when test="${bannerVO.order_seq == '3'}">
							<option value="3" selected>3</option>
						</c:when>
						<c:otherwise>
							<option value="3">3</option>
						</c:otherwise>
					</c:choose>
					
					<c:choose>
						<c:when test="${bannerVO.order_seq == '4'}">
							<option value="4" selected>4</option>
						</c:when>
						<c:otherwise>
							<option value="4">4</option>
						</c:otherwise>
					</c:choose>
					
					<c:choose>
						<c:when test="${bannerVO.order_seq == '5'}">
							<option value="5" selected>5</option>
						</c:when>
						<c:otherwise>
							<option value="5">5</option>
						</c:otherwise>
					</c:choose>
					
					<c:choose>
						<c:when test="${bannerVO.order_seq == '6'}">
							<option value="6" selected>사용 안 함</option>
						</c:when>
						<c:otherwise>
							<option value="6">사용 안 함</option>
						</c:otherwise>
					</c:choose>
				</select>
				</td>
			</tr>
			<tr>
				<th>배너 타이틀 수정</th>
				<td width="343" colspan="5">
				<input type="text" name="btitle" size="47" value="${bannerVO.btitle}">
				</td>
			</tr>
			<tr>
				<th>배너 내용 수정</th>
				<td width="343" colspan="5">
				<textarea name="btext" rows="8" cols="50" > ${bannerVO.btext}</textarea>
							
				</td>
			</tr>

			<tr>
				<th>텍스트 위치 수정</th>
				<td width="130" colspan="5">X축:
				<input type="text" name="top" size="5" value="${bannerVO.top}">px <br>Y축:
				<input	type="text" name="left" size="5" value="${bannerVO.left}">px
				</td>
			</tr>

			<tr>
				<th>배너 비디오</th>
				<td width="343" colspan="5" style="vertical =align: top;">현재
					비디오 : <video src="../videos/${bannerVO.video}" width="200px;"></video><br>
					<!--  <input type="file" name="image"> --> * 주의 : 비디오를 수정할때에만	선택해주세요.
					 <input type="hidden" name="video" id="video">
					<div id="filename"></div>
				</td>
			</tr>
		</table>		  
    <div id = "BannerUpdateButton" style="position: relative; left:800px; top:5px;">
	    <input class="btn" type="submit" value="수정" />
		<input class="btn" type="button" value="취소" onClick="go_mov()">
     </div>
	</form>

	<div style="position: relative; border: 1px solid black; width: 500px; margin: 0 auto;">
		<form name="fromm" id="fileupForm" method="post" enctype="multipart/form-data">
			<input type="file" name="fileimage"> 
			<input type="button" id="myButton" value="추가">
		</form>
	</div>

  



</article>
<%@ include file="../../admin/footer.jsp"%> 

