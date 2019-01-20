<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規ユーザー登録</title>

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

			<s:if test="errorMassage!=''">
				<s:property value="errorMassage" escape="false" />
			</s:if>
			<s:form action="CreateUserConfirmAction">
				<table>

					<tr>
						<th>ログインID</th>
						<td><input type="text" name="userId" value="" /></td>
					</tr>

					<tr>
						<th>ログインPASS</th>
						<td><input type="text" name="userPass" value="" /></td>
					</tr>
					<tr>
						<th>メールアドレス</th>
						<td><input type="text" name="email" value="" /></td>
					</tr>
					<tr>
						<th>氏名</th>
						<td><input type="text" name="familyName" value="" /><input
							type="text" name="firstName" value="" /></td>
					</tr>


					<tr>
						<th>氏名(かな)</th>
						<td><input type="text" name="familyNameKana" value="" /><input
							type="text" name="firstNameKana" value="" /></td>

					</tr>

				</table>
					<div class="btn-box">
						<s:submit value="登録確認" class="btn" />
						<p><span>TOPページは</span> <a href='<s:url action = "HomeAction" />'>こちら</a></p>
					</div>

			</s:form>

		</div>
	</div>
	<div id="footer">
			<jsp:include page="footer.jsp" />
		</div>
</body>
</html>