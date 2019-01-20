<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="./css/home.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.2.1/dist/jquery.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script>
$(function(){
    // li要素をマウスオーバー
    $(".select-product li").hover(function(){
        // キャプション部分の追加
        $(this).append("<div><p>" + $(this).children("img").attr("alt") + "</p></div>");

        // キャプション部分の表示：フェードイン
        $(this).children("div").stop().fadeIn(500);

        // キャプションのテキスト位置
        $(this).children("div").children("p").stop().animate({"top" : 0}, 500);

    }, function(){
        // キャプション部分の非表示：フェードアウト
        $(this).children("div").stop().fadeOut(500);

        // キャプションのテキスト位置
        $(this).children("div").children("p").stop().animate({"top":0}, 500, function(){
            $(this).parent("div").remove();
        });

    });

});
</script>


<title>Home画面</title>

</head>
<body id="top">

	<div id="header">
		<jsp:include page="header.jsp" />
	</div>

	<div id="main">

		<div class="box">
			<div class="box-centered">
				<div class="box-contents">
					<p class="box-title">leFigaro</p>
					<P class="box-text">
						三崎町のワインショップ<br>
					</P>
				</div>
			</div>
		</div>

		<div class="about">
			<h4>About</h4>
			<div class="title">
				<hr>
				<p>この文章はダミーです。文字の大きさ、量、字間、行間等を確認するために入れています。この文章はダミーです。文字の大きさ、量、字間、行間等を確認するために入れています。この文章はダミーです。文字の大きさ、量、字間、行間等を確認するために入れています。この文章はダミーです。文字の大きさ、量、字間、行間等を確認するために入れています。この文章はダミーです。文字の大きさ、量、字間、行間等を確認するために入れ</p>
			</div>


			<img src="images/home05.jpg" alt="">
		</div>





		<h4>Menu</h4>
		<div class="title">
			<hr>
			<p>この文章はダミーです。文字の大きさ、量、字間、行間等を確認するために入れています。この文章はダミーです。文字の大きさ、量、字間、行間等を確認するために入れています。</p>
		</div>

		<div class="select-product">
			<ul>
				<a href='<s:url action="OrderAction"><s:param name="categoryId" value="1"/></s:url>'><li><img src="./images/home02.jpg"
						alt="赤ワインを購入する"></li></a>
				<a href='<s:url action="OrderAction"><s:param name="categoryId" value="2"/></s:url>'><li><img src="./images/home03.jpg"
						alt="白ワインを購入する"></li></a>
				<a href='<s:url action="OrderAction"><s:param name="categoryId" value="3"/></s:url>'><li><img src="./images/home04.jpg"
						alt="その他を購入する"></li></a>
			</ul>
		</div>
		<!-- 		<div class="product-list"> -->
		<!-- 			<a href="productDetail.html"> -->
		<!-- 				<figure> -->
		<!-- 					<img src="images/home02.jpg" /> -->
		<!-- 					<figcaption> -->
		<!-- 						<h4>赤ワイン</h4> -->
		<!-- 						<p> -->
		<!-- 							上質で濃厚な風味を<br> 楽しみたいお客様へ -->
		<!-- 						</p> -->
		<!-- 					</figcaption> -->
		<!-- 				</figure> -->
		<!-- 			</a> <a href="productDetail.html"> -->
		<!-- 				<figure> -->
		<!-- 					<img src="images/home03.jpg" /> -->
		<!-- 					<figcaption> -->
		<!-- 						<p>白ワイン</p> -->
		<!-- 					</figcaption> -->
		<!-- 				</figure> -->
		<!-- 			</a> <a href="productDetail.html"> -->
		<!-- 				<figure> -->
		<!-- 					<img src="images/home04.jpg" /> -->
		<!-- 					<figcaption> -->
		<!-- 						<p>その他のワイン</p> -->
		<!-- 					</figcaption> -->
		<!-- 				</figure> -->
		<!-- 			</a> -->
		<!-- 		</div> -->


		<h4>Access</h4>
		<div class="title">
			<hr>
			<p>
				〒102-0075<br> 東京都千代田区三番町1-1 KY三番町ビル 1F<br>
				「半蔵門」駅（半蔵門線）徒歩5分<br> TEL 03–6304–9525<br> OPEN 9:00pm –
				18:00am
			</p>
		</div>
		<div class="ggmap">
			<iframe
				src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3240.4879288781162!2d139.7430675153835!3d35.68960878019232!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x60188d057ea0e63d%3A0x65ef73340480fa25!2z44Kk44Oz44K_44O844OO44Km44K5!5e0!3m2!1sja!2sjp!4v1547276825014"
				width="1000" height="500" frameborder="0" style="border: 0"
				allowfullscreen></iframe>
		</div>
	</div>



	<div id="footer">
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>