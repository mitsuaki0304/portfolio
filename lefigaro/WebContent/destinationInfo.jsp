<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/mypage.css">
<link rel="stylesheet" href="./css/buy.css">
<title>お届け先一覧</title>


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
				<li>商品一覧</li>
			</ol>
			<div id="main">
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
							</p></li>
					</s:iterator>
				</ul>
				<s:form action="CreateDestinationAction">
					<div class="btn-box">
						<s:submit value="お届け先を追加" class="btn" />
						<s:hidden name="userId" value="%{#session.userId}" />
					</div>
				</s:form>


			</div>
		</div>
	</div>
	<div id="footer">
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>
