<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/buy.css">
<title>BuyConfirm画面</title>
<script type="text/javascript">
	function submitAction(url) {
		$('form').attr('action', url);
		$('form').submit();
	}
</script>


</head>
<body>
	<div id="header">
		<jsp:include page="header.jsp" />
	</div>
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
				<li><a
					href='<s:url action="BuyDestinationAction">
						</s:url>'>お届け先選択</a></li>
				<li>お支配方法選択</li>
			</ol>
		</div>
		<div id="main">
			<section>
				<h2>お支払い方法の選択</h2>
				<s:form action="BuyConfirmAction">

					<s:property value="pay" />
					<div class="buyinfo">
						<table>
							<tr>

								<th>

								<label for="pay1"><input type="radio" name="pay" value="1"
									checked="checked" id="pay1">代金引換</label>
									</th>
								<td><p>商品代金は商品発送時、配送員にお支払いください。手数料は無料です<br>
								<span>商品合計（税込）30万円以上のお支払いにはご利用できません。</span></p></td>
							</tr>
							<tr>
								<th>
								<label for="pay2"><input type="radio" name="pay" value="2" id="pay2">クレジット</label></th>
								<td>以下のクレジットカードがご利用可能です。<br>
								<img src="./images/credit.png"></td>
							</tr>
							<s:hidden name="userId" value="%{#session.userId}" />
							<s:hidden name="id" value="%{#session.id}" />
							<s:hidden name="sum" value="%{#session.sum}" />
							<s:hidden name="tempId" value="%{#session.tempId}" />
							<s:hidden name="flg" value="%{#session.flg}" />
						</table>

					</div>
					<div class="btn-box">
						<s:submit value="確認画面へ" class="btn" />
					</div>
				</s:form>
			</section>
		</div>

	</div>


	<div id="footer">
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>

























