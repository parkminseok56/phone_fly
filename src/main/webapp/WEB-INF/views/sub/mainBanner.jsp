<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>





<!-- 메인 배너 -->
<!--
 author : BHS
 -->

<div class="clear"></div>
<div class="wrap_main_banner">
	<div class="main_banner">
		<ul>
			<c:forEach items="${bannerList}" var="banner" varStatus="status">
				<li>
					<video class="movie_object" src="videos/${banner.video}" autoplay muted loop preload="auto" ></video>
					<div id="banner_text${status.count}" style="top:${banner.top}px;left:${banner.left}px;">
						<h1>${banner.btitle}</h1>
						${banner.btext}
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
	<ul id="banner_btns">
		<li id="lbutton">&lt;</li>
		<li id="play_btn">▶</li>
		<li id="rbutton">&gt;</li>
	</ul>
</div>


<!-- //메인 배너 -->




