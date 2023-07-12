<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../admin/headerP.jsp"%>
<%@ include file="../../admin/sub_menu2.jsp"%>

<article>
	<h1>상품 색상 등록</h1>
	<form name="frm" method="post" enctype="multipart/form-data">

		<table id="PCIList">
			<tr>
				<th>색상 이름</th>
				<td width="343" colspan="5"><input type="text" name="name"
					size="47" maxlength="100"></td>
			</tr>

			<tr>
				<th>색상 코드</th>
				<td width="343" colspan="5"><input type="text" name="ccode"
					size="47" maxlength="100"></td>
			</tr>

			<tr>
				<th>색상 이미지</th>
				<td width="343" colspan="5">
				<input type="hidden" name="image" id="image">
                <div id="filename"></div></td>
			</tr>
		</table>
	</form>
	
	<div
		style="position: relative; border: 1px solid black; width: 500px; margin: 0 auto;">
		<form name="fromm" id="fileupForm" method="post" enctype="multipart/form-data">
			<input type="file" name="fileimage">
			<input type="button" id="myButton" value="추가">
		</form>
	</div>

	<div id="colorInsertButton"
		style="position: relative; left: 800px; top: 5px;">
		<input class="btn" type="button" value="색상등록" onClick="go_save_c(${ProductVO.pseq})"> 
		<input class="btn"type="button" value="목록으로" onClick="go_mov()">
	</div>

</article>

<%@ include file="../../admin/footer.jsp"%>




