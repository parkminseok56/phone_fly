<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../admin/headerE.jsp"%>
<%@ include file="../../admin/sub_menu2.jsp"%>

<article>
	<h1>이벤트 수정</h1>
	<form name="frm" method="post" enctype="multipart/form-data">
		<input type="hidden" name="eseq" value="${eventVO.eseq}"> 
		<input type="hidden" name="oldImage" value="${eventVO.image}">

		<table id="EUList">
			<tr>
				<th>이벤트 제목</th>
				<td width="343" colspan="5"><input type="text" name="subject"
					size="47" maxlength="100" value="${eventVO.subject}"></td>
			</tr>

			<tr>
				<th>이벤트 이미지</th>
				<td colspan="5"><img src="images/event/${eventVO.image}"
					width="600"><br> 
					<input type="hidden" name="image" id="image">
					<div id="filename"></div>					
				</td>
		</table>
	</form>
	
	 <div style="position: relative; border: 1px solid black; width: 500px; margin: 0 auto;">
		<form name="fromm" id="fileupForm" method="post" enctype="multipart/form-data">
			<input type="file" name="fileimage"> 
			<input type="button" id="myButton" value="추가">
		</form>
		</div>	
		
		<div id = "EventUpdateButton" style="position: relative; left:800px; top:5px;">
	    <input class="btn" type="button" value="수정" onClick="go_mod_save_e(${eventVO.eseq});"> 
		<input class="btn" type="button" value="취소" onClick="location.href='adminEventDetail?eseq=${eventVO.eseq}'">
        </div>
</article>

<%@ include file="../../admin/footer.jsp"%>