<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/buy.css">
<link rel="stylesheet" href="./css/mypage.css">
<title>お届け先登録確認</title>
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
				<li>お届け先登録確認</li>
			</ol>
		</div>
		<div id="main">
			<section>
				<h2>お届先情報登録</h2>
				<div class="buyinfo">
					<h3>登録する内容は以下でよろしいですか。</h3>
					<s:form action="CreateDestinationCompleteAction">
						<table>
							<tr>
								<th>氏名</th>
								<td><s:property value="familyName" escape="false" />
									<s:property value="firstName" escape="false" /></td>
							</tr>

							<tr>
								<th>氏名(かな)</th>
								<td><s:property value="familyNameKana" escape="false" />
									<s:property value="firstNameKana" escape="false" /></td>

							</tr>

							<tr>
								<th>電話番号</th>
								<td><s:property value="telNum" escape="false" /></td>
							</tr>

							<tr>
								<th>郵便番号</th>
								<td><s:property value="addressNum" escape="false" /></td>
							<tr>
								<th>都道府県</th>
								<td><s:property value="region" escape="false" />
							</tr>
							<tr>
								<th>市町村</th>
								<td><s:property value="city" escape="false" />
							</tr>
							<tr>
								<th>その他建物</th>
								<td><s:property value="other" escape="false" />
							</tr>

						</table>
						<s:hidden name="userId" value="%{#session.userId}" />
						<s:hidden name="tempId" value="%{#session.tempId}" />
						<div class="btn-box">
							<s:submit value="登録する" class="btn" />
						</div>
					</s:form>
				</div>
			</section>
		</div>
	</div>

	<div id="footer">
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>
