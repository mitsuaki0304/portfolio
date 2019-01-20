<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>ユーザー登録完了</title>
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

				<li>登録完了</li>
			</ol>
		</div>
		<div id="main">
			<section>

				<h2>登録完了</h2>
				<h3>登録が完了致しました。</h3>
				<div class="btn-box">
					<p>
						<a href='<s:url action = "HomeAction"/>'>ホームへ</a>
					</p>
				</div>
			</section>
		</div>
	</div>
	<div id="footer">
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>