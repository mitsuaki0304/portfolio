<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/product.css">
<title>商品詳細</title>
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
				<li><a href='<s:url action="ProductListAction"></s:url>'>商品一覧</a></li>
				<li>商品詳細</li>
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
				<h2>商品一覧</h2>
				<div class="detail">
					<figure>
						<img
							src='<s:property value="%{#session.imageFilePath}"/>/<s:property value="%{#session.imageFileName}"/>' />
					</figure>

					<div class="content">
						<h4>
							<s:property value="session.productName" />
						</h4>
						<br>
						<p>
							評価:
							<s:property value="session.reviewStar" />
							(
							<s:property value="session.reviewUserCount" />
							件)
						</p>
						<p class="type">
							生産地：
							<s:property value="session.area" />
						</p>
						<p class="taiste">
							テイスト：
							<s:property value="session.taiste" />
						</p>
						定価:<span><s:property value="session.price" />円(税込)</span>


						<s:form action="CartInAction">
							<select name="productCount">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>

							</select>
							<s:hidden name="tempId" value="%{#session.tempId}" />
							<s:hidden name="userId" value="%{session.userId}" />
							<s:hidden name="productId" value="%{#session.productId}" />
							<s:hidden name="price" value="%{#session.price}" />
							<div class="btn-box">
								<s:submit value="カートに入れる" class="btn" />
							</div>
						</s:form>
					</div>
				</div>

				<div class="productinfo">
					<h3>商品紹介</h3>
					<p>
						<s:property value="session.productDetail" />
					</p>
					<h3>商品詳細</h3>

					<table>
						<tr>
							<th>商品名</th>
							<td><s:property value="session.productName" /></td>
						</tr>
						<tr>
							<th>品種</th>
							<td><s:property value="session.kind" /></td>
						</tr>
						<tr>
							<th>生産地</th>
							<td><s:property value="session.area" /></td>
						</tr>
						<tr>
							<th>テイスト</th>
							<td><s:property value="session.taiste" /></td>
						</tr>
						<tr>
							<th>内容量</th>
							<td><s:property value="session.weight" />ml</td>
						</tr>
						<tr>
							<th>ヴィンテージ</th>
							<td><s:property value="session.vintage" />s</td>
						</tr>

					</table>

				</div>
			</section>
			<section>
				<div class="review-list">

					<s:form action="CreateReviewAction">
						<s:hidden name="userId" value="%{session.userId}" />
						<s:hidden name="productId" value="%{session.productId}" />
						<div class="btn-box">
							<s:submit value="レビューを投稿する" class="btn" />
						</div>
					</s:form>

					<s:if test="message !=null">
						<p>
							<s:property value="message" />
						</p>
					</s:if>
					<s:iterator value="#session.reviewList">
						<div class="review-box">
							<dl>
								<dt>
									<s:property value="familyName" />
									<s:property value="firstName" />
								</dt>
								<dd>
									評価:
									<s:property value="reviewStar" /><s:property value="title" />

								</dd>
							</dl>
							<hr>

							<p class="comment">
								<s:property value="comment" />
							</p>
						</div>
					</s:iterator>

				</div>

			</section>
		</div>
	</div>
	<!--/contents-->

	<div id="footer">
			<jsp:include page="footer.jsp" />
		</div>
</body>
</html>