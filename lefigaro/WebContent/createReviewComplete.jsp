<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="css/product.css">
    <link rel="stylesheet" href="css/review.css">
<title>レビュー投稿完了</title>
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
					href='<s:url action="ProductDetailAction">
						<s:param name="tempId" value="%{#session.tempId}"/>
						</s:url>'>商品詳細</a></li>
				<li>レビュー投稿</li>
			</ol>
		</div>
		<div id="sub">

			<nav class="box">
				<div class="accbox">
					<!--ラベル1-->
					<label for="label1">タイプで探す</label> <input type="checkbox"
						id="label1" class="cssacc" />
					<div class="accshow">
						<!--ここに隠す中身-->
						<p>
							<a
								href='<s:url action="OrderAction"><s:param name="categoryId" value="1"/></s:url>'>赤ワイン</a>
						</p>
						<p>
							<a
								href='<s:url action="OrderAction"><s:param name="categoryId" value="2"/></s:url>'>白ワイン</a>
						</p>
						<p>
							<a
								href='<s:url action="OrderAction"><s:param name="categoryId" value="3"/></s:url>'>その他</a>
						</p>
					</div>
					<!--//ラベル1-->
					<!--ラベル2-->
					<label for="label2">生産地で探す</label> <input type="checkbox"
						id="label2" class="cssacc" />
					<div class="accshow">
						<!--ここに隠す中身-->
						<p>
							<a
								href='<s:url action="OrderAction"><s:param name="area" value="1"/></s:url>'>フランス</a>
						</p>
						<p>
							<a
								href='<s:url action="OrderAction"><s:param name="area" value="2"/></s:url>'>イタリア</a>
						</p>
						<p>
							<a
								href='<s:url action="OrderAction"><s:param name="area" value="3"/></s:url>'>チリ</a>
						</p>
						<p>
							<a
								href='<s:url action="OrderAction"><s:param name="area" value="4"/></s:url>'>アメリカ</a>
						</p>
						<p>
							<a
								href='<s:url action="OrderAction"><s:param name="area" value="5"/></s:url>'>日本</a>
						</p>
					</div>
					<!--ラベル1-->
					<label for="label3">品種で探す</label> <input type="checkbox"
						id="label3" class="cssacc" />
					<div class="accshow">
						<!--ここに隠す中身-->
						<p>
							<a
								href='<s:url action="OrderAction"><s:param name="kind" value="1"/></s:url>'>カベルネソーヴィニヨン</a>
						</p>
						<p>
							<a
								href='<s:url action="OrderAction"><s:param name="kind" value="2"/></s:url>'>メルロー</a>
						</p>
						<p>
							<a
								href='<s:url action="OrderAction"><s:param name="kind" value="3"/></s:url>'>ピノ・ノワール</a>
						</p>
						<p>
							<a
								href='<s:url action="OrderAction"><s:param name="kind" value="4"/></s:url>'>リースリング</a>
						</p>
						<p>
							<a
								href='<s:url action="OrderAction"><s:param name="kind" value="5"/></s:url>'>甲州</a>
						</p>
					</div>

				</div>
			</nav>

		</div>

	<div id="main">
<section>

		<h2>投稿完了</h2>
		<h3>投稿が完了致しました。</h3>
			<div class="btn-box">
			<p><a
								href='<s:url action="ProductDetailAction">
					<s:param name="productId" value="%{session.productId}"/>
					<s:param name="userId" value="%{session.userId}"/>
					</s:url>'>商品TOPに戻る</a></p>

		</div>
		</section>
	</div>

	</div>
	<div id="footer">
			<jsp:include page="footer.jsp" />
		</div>
</body>
</html>