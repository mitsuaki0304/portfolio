<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/mypage.css">
<title>マイページ</title>


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
				<li>マイページ</li>
			</ol>
		</div>

		<div id="main">
			<section>

				<ul class="mypage">

					<li>
						<div class="icon">
							<a
								href='<s:url action="UserInfoAction">
						<s:param name="userPass" value="%{#session.userPass}"/>
						<s:param name="userId" value="%{#session.userId}"/>
						</s:url>'><i
								class="fas fa-user"></i></a>
							<p>登録情報の確認</p>
						</div>
					</li>

					<li>
						<div class="icon">
							<a
								href='<s:url action="DestinationInfoAction">
						<s:param name="userId" value="%{#session.userId}"/>
						</s:url>'><i
								class="fas fa-clipboard-check"></i></a>
							<p>お届け先の確認</p>
						</div>
					</li>

					<li>
						<div class="icon">
							<a
								href='<s:url action="BuyHistoryAction">
						<s:param name="productId" value="%{#session.productId}"/>
						<s:param name="userId" value="%{#session.userId}"/>
						</s:url>'><i
								class="fas fa-map-marked-alt"></i></a>
							<p>購入履歴の確認</p>
						</div>
					</li>
				</ul>

			</section>


		</div>
	</div>
	<div id="footer">
			<jsp:include page="footer.jsp" />
		</div>
</body>
</html>
