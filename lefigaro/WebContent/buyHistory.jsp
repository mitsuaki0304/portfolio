<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/cart.css">
<title>購入履歴</title>
</head>
<body>
	<div id="header">
		<jsp:include page="header.jsp" />
	</div>
	<div class="mainvisual"></div>
	<div id="contents" class="inner">
		<div id="breadcrumb">
			<ol>
				<li><a
					href='<s:url action="HomeAction">
						<s:param name="tempId" value="%{#session.tempId}"/>
						<s:param name="userId" value="%{#session.userId}"/>
						</s:url>'>HOME</a></li>
				<li><a
					href='<s:url action="MyPageAction">
						<s:param name="tempId" value="%{#session.tempId}"/>
						<s:param name="userId" value="%{#session.userId}"/>
						</s:url>'>マイページ</a></li>
				<li>購入履歴</li>
			</ol>
		</div>
	<div id="main">
	<section>
	 <h2>購入履歴</h2>
		<div class="cartinfo">
			<s:if test="#session.buyHistoryList.isEmpty()">
				<h3>ご購入情報はありません。</h3>
			</s:if>
			<s:elseif test="message==null">
				<h3>ご購入は以下になります。</h3>
				<table class="cartinfo">
					<tr>
						<th class="image"></th>
						<th class="product-name">商品名</th>
						<th>お届け先</th>
						<th>個数</th>
						<th>小計</th>
						<th>購入日</th>
					</tr>
					<s:iterator value="#session.buyHistoryList">
						<tr>
							<td><img
								src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>'
								width="120px" height="120px" /></td>
							<td><s:property value="productName" /></td>
							<td><s:property value="addressNum" /><br>
							<s:property value="region" /><br>
							<s:property value="city" /><br>
							<s:property value="other" /></td>
							<td><s:property value="productCount" /></td>
							<td><s:property value="totalPrice" /><span>円</span></td>
							<td><s:property value="insertDate" /></td>
						</tr>
					</s:iterator>
				</table>

				<s:form action="BuyHistoryAction">
					<input type="hidden" name="deleteFlg" value="1">
					<div class="btn-box">
					<s:submit value="削除" method="delete" class="btn" />
					</div>
				</s:form>
			</s:elseif>


			<s:if test="message !=null">
				<h3>
					<s:property value="message" />
				</h3>
			</s:if>

		</div>
		</section>
	</div>

		</div>
	<div id="footer">
			<jsp:include page="footer.jsp" />
		</div>


</body>
</html>