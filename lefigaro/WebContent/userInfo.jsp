<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/mypage.css">
<title>ユーザー情報</title>


</head>
<body>
	<header>
		<jsp:include page="header.jsp" />
	</header>
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
				<li>ユーザー登録情報</li>
			</ol>
		</div>
		<div id="main">
			<section>
				<h2>お客様登録情報</h2>
				<div class="userinfo">
					<table>
						<tr>
							<th>氏名</th>
							<td><s:property value="session.familyName" /> <s:property
									value="session.firstName" /></td>

						</tr>
						<tr>
							<th>氏名(かな)</th>
							<td><s:property value="session.familyNameKana" /> <s:property
									value="session.firstNameKana" /></td>
						</tr>
						<tr>
							<th>ご登録メールアドレス</th>
							<td><s:property value="session.email" /></td>
						</tr>
						<tr>
							<th>ユーザーID</th>
							<td><s:property value="session.userId" /></td>
						</tr>
						<tr>
							<th>ご登録日</th>
							<td><s:property value="session.registDate" /></td>
						</tr>
					</table>


				</div>
			</section>




		</div>

	</div>
	<div id="footer">
		<jsp:include page="footer.jsp" />
	</div>


</body>
</html>