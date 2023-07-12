<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../admin/headerE.jsp"%>
<%@ include file="../../admin/sub_menu2.jsp"%>

<article>
	<h1>이벤트 등록</h1>
	<form name="frm" method="post" enctype="multipart/form-data">
		<table id="EIList">


			<tr>
				<th>이벤트 제목</th>
				<td width="343" colspan="5"><input type="text" name="subject"
					size="47" maxlength="100"></td>
			</tr>

			<tr>
				<th>이벤트 이미지</th>
				<td width="343" colspan="5">
				<input type="hidden" name="image" id="image">
				<div id="filename"></div>
				</td>
			</tr>
		</table>
	</form>
	
	 <div style="position: relative; border: 1px solid black; width: 500px; margin: 0 auto;">
		<form name="form" id="fileupForm" method="post" enctype="multipart/form-data">
			<input type="file" name="fileimage"> 
			<input type="button" id="myButton" value="추가">
		</form>
		</div>	
		
		<div id = "EventInsertButton" style="position: relative; left:800px; top:5px;">
	    <input class="btn" type="button" value="이벤트등록" onClick="go_save_insert()"> 
		<input class="btn" type="button" value="목록으로" onClick="go_mov_e()">
        </div>
</article>

<%@ include file="../../admin/footer.jsp"%>




