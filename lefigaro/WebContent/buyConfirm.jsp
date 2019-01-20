<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/buy.css">
<link rel="stylesheet" href="./css/cart.css">
<title>購入確認</title>
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
					href='<s:url action="BuyDestinationAction">
						</s:url>'>お届け先選択</a></li>
						<li><a
					href='<s:url action="BuyPayAction">
						</s:url>'>お支払い方法選択</a></li>
				<li>お支払確認</li>
			</ol>
		</div>
		<div id="main">

			<section>
				<h2>注文確認</h2>

				<s:form action="BuyCompleteAction">
					<div class="buyconfirm">

					<div class="cartinfo">
								<table>
									<tr>
										<th class="img"></th>
										<th class="product-name">商品名</th>

										<th>個数</th>
										<th>小計</th>

									</tr>
									<s:iterator value="#session.cartList">
									<tr>
										<td><img
											src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' /></td>
										<td><s:property value="productName" /></td>
										<td><s:property value="productCount" /></td>
										<td><s:property value="totalPrice" /></td>
									</tr>
									</s:iterator>
								</table>

						</div>

						<div class="buyinfo">
							<s:iterator value="#session.destinationList">
								<table>
									<tr>
										<th>氏名</th>
										<td><s:property value="familyName" /> <s:property
												value="firstName" /></td>
									</tr>
									<tr>
										<th>氏名(かな)</th>
										<td><s:property value="familyNameKana" /> <s:property
												value="firstNameKana" /></td>
									</tr>
									<tr>
										<th>郵便番号</th>
										<td><s:property value="addressNum" /></td>
									</tr>
									<tr>
										<th>都道府県</th>
										<td><s:property value="region" /></td>
									</tr>
									<tr>
										<th>市町村</th>
										<td><s:property value="city" /></td>
									</tr>
									<tr>
										<th>その他</th>
										<td><s:property value="other" /></td>
									</tr>
								</table>
							</s:iterator>
						</div>


						<div class="buyinfo priceinfo">

							<table>
								<tr>
									<th>商品合計</th>
									<td><s:property value="session.sum" /></td>
								</tr>
								<tr>
									<th>支払い方法</th>
									<td><s:property value="session.pay" /></td>
								</tr>

							</table>

						</div>
						<s:hidden name="userId" value="%{#session.userId}" />
						<s:hidden name="tempId" value="%{#session.tempId}" />
						<s:hidden name="pay" value="%{#session.pay}" />
						<s:hidden name="id" value="%{#session.id}" />
						<div class="btn-box">
							<s:submit value="完了" class="btn" />
						</div>
					</div>
				</s:form>

			</section>
		</div>
	</div>

	<div id="footer">
			<jsp:include page="footer.jsp" />
		</div>
</body>
</html>

























