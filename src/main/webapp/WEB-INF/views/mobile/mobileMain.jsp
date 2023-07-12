<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- MAIN  -->
<!-- 
author : bhs
-->

<!-- 헤더 불러오기 -->
<%@ include file="../mobile/mobileHeader.jsp"%>
<!-- <script src="../script/removeMenuSession.js"></script> -->

<article>

<!-- 메인 배너 불러오기 -->
<%@ include file="../mobile/mobileMainBanner.jsp"%>


<!-- 베스트 상품 -->


<h1>베스트 상품 Mobile</h1>

<div id="main-card-box" class="d-flex justify-content-center">
	<div>
		<c:forEach items="${mainBestList}" var="productVO" varStatus="status">

			<!-- location.href JSTL변수 생성 (onclick="${productDetailLH}" 으로 사용)-->
			<c:set var="productDetailLH" value="javascript:void(0);" />
			
			
			<!-- 제품 아이템 시작 -->
			<div class="card ml-4">


				<input type="hidden" class="pdPseq" value="${productVO.pseq}" />
				<input type="hidden" class="pdImg" value="${productVO.colorList[0].image}" />
				<input type="hidden" class="pdName" value="${productVO.name}" />
				<input type="hidden" class="pdPrice" value="<fmt:formatNumber value='${productVO.price2}' type='number' maxFractionDigits='3' />원" />


				<!-- 이미지 -->
				<div class="card-img card-img-${status.count}" onclick="${productDetailLH}">
					<ul>
 					<c:forEach items="${productVO.colorList}" var="colorVO" varStatus="statusColor">
						<c:choose>
							<c:when test="${statusColor.count == 1}">
								<li style="z-index:10"><img class="cs-p" src="images/productImage/${colorVO.image}" /></li>
							</c:when>
							<c:otherwise>
								<li><img class="cs-p" src="images/productImage/${colorVO.image}" /></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					</ul>
				</div>
				<!-- //이미지 -->
				
				
				<!-- 컬러 리스트 -->
				<div class="card-color-buttons card-color-buttons-${status.count}">
					<ul>
						<c:forEach items="${productVO.colorList}" var="colorVO" varStatus="statusColor">
							<li onclick="colorClick(${status.count}, ${statusColor.count});">
								<div class="color-button" style="background-color:${colorVO.ccode}">
								<c:choose>
									<c:when test="${statusColor.count == 1}">
										<div class="color-button-selector"></div>
									</c:when>
									<c:otherwise>
										<div></div>
									</c:otherwise>
								</c:choose>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
				<!-- //컬러 리스트 -->
				<div class="clear"></div>
				
				
				<!-- 제품명 -->
				<div class="card-name cs-p" onclick="${productDetailLH}">
					<h3>
						${productVO.name}
					</h3>
				</div>
				<!-- //제품명 -->
				
				
				<!-- 가격 -->
				<div class="card-price cs-p" onclick="${productDetailLH}">
					<h3><fmt:formatNumber value="${productVO.price2}" type="number" maxFractionDigits="3" /></h3><h4>원</h4>
				</div>
				<!-- //가격 -->
				
				
				<!-- 구매하기 버튼 -->
				<div class="card_buy" onclick="${productDetailLH}">구매하기</div>
				<!-- //구매하기 버튼 -->
				
				
				<!-- 가격비교 -->
				<div class="card-compare-price" onclick="compareProduct(${productVO.pseq});">
					<div class="plus-button"><span>&nbsp;가격 비교하기</span></div>
				</div>
				<!-- //가격비교 -->
			</div>
			<br /><br />
		</c:forEach>
	</div>
</div>

<!-- //베스트 상품 -->




<!-- 메인 Apple 리스트 -->

<div id="main-apple">

			<div id="content2" class="card cs-p">
				<img src="images/main/iphone-card-50-compare-202209.jpg" />
				<div>
					<span>Apple iPhone 모든 모델 보기</span><br />
					어떤 iPhone이<br />
					당신에게 맞을까요?
				</div>
			</div>
			<br />
			<div id="content3" class="card cs-p">
				<img src="images/main/iphone-card-50-whyswitch-202209_GEO_KR.jpg" />
				<div>
					<span>iPhone으로 갈아타기</span><br />
					iPhone으로 갈아타기, 무척<br />
					쉽습니다.
				</div>
 			</div>
</div>
<div class="clear"></div>

<!-- //메인 Apple 리스트 -->





<!-- 이벤트 상품 -->
<h1>이벤트 상품</h1>

<div id="main-card-box" class="d-flex justify-content-center">
	<div>
		<c:forEach items="${mainEventList}" var="productVO" varStatus="status">
			
			<!-- location.href JSTL변수 생성 (onclick="${productDetailLH}" 으로 사용)-->
			<c:set var="productDetailLH" value="javascript:void(0);" />
			
			
			<!-- 제품 아이템 시작 -->
			<div class="card">


				<input type="hidden" class="pdPseq" value="${productVO.pseq}" />
				<input type="hidden" class="pdImg" value="${productVO.colorList[0].image}" />
				<input type="hidden" class="pdName" value="${productVO.name}" />
				<input type="hidden" class="pdPrice" value="<fmt:formatNumber value='${productVO.price2}' type='number' maxFractionDigits='3' />원" />


				<!-- 이미지 -->
				<div class="card-img card-img-${status.count + 4}" onclick="${productDetailLH}">
					<ul>
 					<c:forEach items="${productVO.colorList}" var="colorVO" varStatus="statusColor">
						<c:choose>
							<c:when test="${statusColor.count == 1}">
								<li style="z-index:10"><img class="cs-p" src="images/productImage/${colorVO.image}" /></li>
							</c:when>
							<c:otherwise>
								<li><img class="cs-p" src="images/productImage/${colorVO.image}" /></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					</ul>
				</div>
				<!-- //이미지 -->
				
				
				<!-- 컬러 리스트 -->
				<div class="card-color-buttons card-color-buttons-${status.count + 4}">
					<ul>
						<c:forEach items="${productVO.colorList}" var="colorVO" varStatus="statusColor">
							<li onclick="colorClick(${status.count + 4}, ${statusColor.count});">
								<div class="color-button" style="background-color:${colorVO.ccode}">
								<c:choose>
									<c:when test="${statusColor.count == 1}">
										<div class="color-button-selector"></div>
									</c:when>
									<c:otherwise>
										<div></div>
									</c:otherwise>
								</c:choose>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
				<!-- //컬러 리스트 -->
				<div class="clear"></div>
				
				
				<!-- 제품명 -->
				<div class="card-name cs-p" onclick="${productDetailLH}">
					<h3>
						${productVO.name}
					</h3>
				</div>
				<!-- //제품명 -->
				
				
				<!-- 가격 -->
				<div class="card-price cs-p" onclick="${productDetailLH}">
					<h3><fmt:formatNumber value="${productVO.price2}" type="number" maxFractionDigits="3" /></h3><h4>원</h4>
				</div>
				<!-- //가격 -->
				
				
				<!-- 구매하기 버튼 -->
				<div class="card_buy" onclick="${productDetailLH}">구매하기</div>
				<!-- //구매하기 버튼 -->
				
				
				<!-- 가격비교 -->
				<div class="card-compare-price" onclick="compareProduct(${productVO.pseq});">
					<div class="plus-button"><span>&nbsp;가격 비교하기</span></div>
				</div>
				<!-- //가격비교 -->
			</div>
			<br /><br />
		</c:forEach>
	</div>
</div>
<div class="clear"></div>

<!-- //이벤트 상품 -->


</article>
<!-- //MAIN -->
<br />
<hr style="width:94%;"/>
<br />

<!-- footer 불러오기 -->
<%@ include file="../mobile/mobileFooter.jsp"%>