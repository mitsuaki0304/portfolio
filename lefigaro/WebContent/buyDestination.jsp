<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/buy.css">
<link rel="stylesheet" href="./css/mypage.css">
<title>お届け先選択</title>
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
				<li>お届け先選択</li>
			</ol>
		</div>
		<div id="main">
			<section>
				<h2>お届け先選択</h2>

				<h3>登録したお届け先に送る</h3>
				<ul class="destination-info">
					<s:iterator value="#session.destinationList">
						<li><p>
								<s:property value="familyName" />
								<s:property value="firstName" />
								<br> 〒
								<s:property value="addressNum" />
								<br>
								<s:property value="region" />
								<br>
								<s:property value="city" />
								<br>
								<s:property value="other" />
								<br> 電話番号:
								<s:property value="telNum" />
							</p>
							<a
							href='<s:url action="BuyPayAction">
								<s:param name="userId" value="%{userId}"/>
								<s:param name="id" value="%{id}"/>
								<s:param name="tempId" value="%{tempId}"/>
								</s:url>'>お支払い方法選択</a></li>
					</s:iterator>
				</ul>

				<s:form action="CreateDestinationAction">
					<s:hidden name="userId" value="%{#session.userId}" />
					<s:hidden name="tempId" value="%{#session.tempId}" />
					<div class="btn-box">
							<s:submit value="お届け先を登録" class="btn" />
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
