<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/cart.css">
<title>カートの中身</title>

</head>
<body>
	<header>
		<jsp:include page="header.jsp" />
	</header>

	<div class="mainvisual"></div>
	<div id="contents" class="inner">
		<div id="breadcrumb">
			<ol>
				<li><a href="index.html">HOME</a></li>
				<li>カート</li>
			</ol>
		</div>
		<div id="main">
			<section>

				<h2>カートの中身</h2>

				<s:if test="#session.cartList.isEmpty()">
					<h3>カートは空です。</h3>
				</s:if>
				<s:else>
					<h3>カートの中身</h3>
					<s:form action="BuyDestinationAction">
						<div class="cartinfo">
							<table>
								<tr>
									<th class="img"></th>
									<th class="product-name">商品名</th>
									<th>単価</th>
									<th>個数</th>
									<th>小計</th>
									<th>購入日</th>
								</tr>
								<s:iterator value="#session.cartList">
									<tr>
										<td><img
											src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' /></td>
										<td><s:property value="productName" /></td>
										<td><s:property value="price" /><span>円</span></td>
										<td><s:property value="productCount" /><span>個</span></td>
										<td><s:property value="totalPrice" /><span>円</span></td>
										<td><s:property value="registDate" /></td>
									</tr>
								</s:iterator>

							</table>
							<a
								href='<s:url action="CartAction">
						<s:param name="deleteFlg" value="1"/>
						<s:param name="tempId" value="%{#session.tempId}"/>
						</s:url>'>カートを削除する</a>

							<div class="sum">
								<table>
									<tr>
										<th>合計</th>
										<td><s:property value="session.sum" />円</td>
									</tr>

								</table>
							</div>

						</div>
						<s:hidden name="userId" value="%{#session.userId}" />
						<s:hidden name="tempId" value="%{#session.tempId}" />
						<s:hidden name="productCount" value="%{#session.productCount}" />
						<s:hidden name="toalPrice" value="%{#session.totalPrice}" />
						<s:hidden name="sum" value="%{#session.sum}" />

						<div class="btn-box">
							<s:submit value="購入する" class="btn" />
							<p>
								<a href='<s:url action="ProductListAction">

						</s:url>'>お買い物を続ける</a>
							</p>
						</div>
					</s:form>
					<%-- 					<s:form action="CartAction"> --%>
					<!-- 						<input type="hidden" name="deleteFlg" value="1"> -->
					<!-- 						<div class="btn-box"> -->
					<%-- 						<s:hidden name="userId" value="%{#session.userId}" /> --%>
					<%-- 						<s:hidden name="tempId" value="%{#session.tempId}" /> --%>
					<%-- 						<s:hidden name="productCount" value="%{#session.productCount}" /> --%>
					<%-- 						<s:hidden name="toalPrice" value="%{#session.totalPrice}" /> --%>
					<%-- 						<s:hidden name="sum" value="%{#session.sum}" /> --%>
					<%-- 							<s:submit value="削除" class="btn" /> --%>
					<!-- 						</div> -->
					<%-- 					</s:form> --%>
				</s:else>
			</section>
		</div>


	</div>


	<div id="footer">
		<jsp:include page="footer.jsp" />
	</div>




</body>
</html>