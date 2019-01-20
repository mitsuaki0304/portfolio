<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>ユーザー登録確認</title>
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
		</div>
		<div id="main">
		<h2>確認画面</h2>
		<h3>ご登録は以下でよろしいですか？</h3>
			<s:form action="CreateUserCompleteAction">
				<table>

					<tr>
						<th>ログインID</th>
						<td><s:property value="userId" escape="false" /></td>
					</tr>

					<tr>
						<th>ログインPASS</th>
						<td><s:property value="userPass" escape="false" /></td>
					</tr>
					<tr>
						<th>メールアドレス</th>
						<td><s:property value="email" escape="false" /></td>
					</tr>
					<tr>
						<th>氏名</th>
						<td><s:property value="familyName" escape="false" /><s:property
								value="firstName" escape="false" /></td>
					</tr>


					<tr>
						<th>氏名(かな)</th>
						<td><s:property value="familyNameKana" escape="false" /><s:property
								value="firstNameKana" escape="false" /></td>

					</tr>

				</table>
					<div class="btn-box">
						<s:submit value="登録する" class="btn" />

					</div>

			</s:form>

		</div>
	</div>
	<div id="footer">
			<jsp:include page="footer.jsp" />
		</div>
</body>
</html>
