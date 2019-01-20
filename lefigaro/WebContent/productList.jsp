<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/product.css">
<title>商品一覧</title>

</head>
<body>
	<div id="header">
		<jsp:include page="header.jsp" />
	</div>
	<div class="mainvisual"></div>
	 <div id="contents" class="inner">
        <div id="breadcrumb">
            <ol>
                <li> <a
						href='<s:url action="HomeAction">
						<s:param name="tempId" value="%{#session.tempId}"/>
						<s:param name="userId" value="%{#session.userId}"/>
						</s:url>'>HOME</a></li>
                <li>商品一覧</li>
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
				<label for="label3">品種で探す</label> <input type="checkbox" id="label3"
					class="cssacc" />
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


		<!--並び替え -->
		<h3>商品一覧</h3>

		<s:form action="OrderAction">
			<select name="sort" class="sort">
				<option value="0">--------</option>
				<option value="1">価格の高い順から選ぶ</option>
				<option value="2">価格の低い順から選ぶ</option>
				<option value="3">レビュー評価の高い順から選ぶ</option>
			</select>
			<s:submit value="並び替え" />
		</s:form>

		<!--アイテム情報 -->

			<s:iterator value="#session.productList">
			<div class="list">
				<s:form action="ProductDetailAction">

					<figure><a
						href='<s:url action="ProductDetailAction"><s:param name="productId" value="%{productId}"/></s:url>'>
							<img
								src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' />
						</a></figure>
					<h4>
						<a
						href='<s:url action="ProductDetailAction"><s:param name="productId" value="%{productId}"/></s:url>'><s:property value="productName" /></a>
					<br>

					</h4>
					<p>評価:
					<s:property value="reviewStar" />

					(<s:property value="reviewUserCount" />件)</p>
					<p>生産国:<s:property value="area" /></p>
					<p class="taiste">
						テイスト:<span><s:property value="taiste" /></span>
					</p>

                        <p>定価<s:property value="price" />円（税込み)</p>
					<s:hidden name="productId" value="%{productId}" />
					<s:hidden name="userId" value="%{userId}" />
					<s:submit value="商品詳細" class="btn" />
				</s:form>
				</div>
			</s:iterator>

</section>
	</div>
</div>

	<div id="footer">
			<jsp:include page="footer.jsp" />
		</div>




















</body>
</html>