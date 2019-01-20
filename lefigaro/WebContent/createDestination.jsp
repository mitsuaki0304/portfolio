<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/buy.css">
<link rel="stylesheet" href="./css/mypage.css">
<title>お届け先登録</title>
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
				<li>お届け先登録</li>
			</ol>
		</div>
		<div id="main">
		<section>
		<h2>お届先情報登録</h2>

		<s:form action="CreateDestinationConfirmAction">
          <div class="buyinfo">
			<table>
					<tr>
						<th>氏名</th>
						<td><input type="text" name="familyName" value="" /><input
							type="text" name="FirstName" value="" /></td>
					</tr>

					<tr>
						<th>氏名(かな)</th>
						<td><input type="text" name="familyNameKana" value="" /><input
							type="text" name="FirstNameKana" value="" /></td>
					</tr>

					<tr>
						<th>電話番号</th>
						<td><input type="text" name="telNum" value="" /></td>
					</tr>

					<tr>
						<th>郵便番号</th>
						<td><input type="text" name="addressNum" value="" /></td>
					</tr>
					<tr>
						<th>都道府県</th>
						<td><select name="region">
								<option value="" selected>都道府県</option>
								<option value="北海道">北海道</option>
								<option value="青森県">青森県</option>
								<option value="岩手県">岩手県</option>
								<option value="宮城県">宮城県</option>
								<option value="秋田県">秋田県</option>
								<option value="山形県">山形県</option>
								<option value="福島県">福島県</option>
								<option value="茨城県">茨城県</option>
								<option value="栃木県">栃木県</option>
								<option value="群馬県">群馬県</option>
								<option value="埼玉県">埼玉県</option>
								<option value="千葉県">千葉県</option>
								<option value="東京都">東京都</option>
								<option value="神奈川県">神奈川県</option>
								<option value="新潟県">新潟県</option>
								<option value="富山県">富山県</option>
								<option value="石川県">石川県</option>
								<option value="福井県">福井県</option>
								<option value="山梨県">山梨県</option>
								<option value="長野県">長野県</option>
								<option value="岐阜県">岐阜県</option>
								<option value="静岡県">静岡県</option>
								<option value="愛知県">愛知県</option>
								<option value="三重県">三重県</option>
								<option value="滋賀県">滋賀県</option>
								<option value="京都府">京都府</option>
								<option value="大阪府">大阪府</option>
								<option value="兵庫県">兵庫県</option>
								<option value="奈良県">奈良県</option>
								<option value="和歌山県">和歌山県</option>
								<option value="鳥取県">鳥取県</option>
								<option value="島根県">島根県</option>
								<option value="岡山県">岡山県</option>
								<option value="広島県">広島県</option>
								<option value="山口県">山口県</option>
								<option value="徳島県">徳島県</option>
								<option value="香川県">香川県</option>
								<option value="愛媛県">愛媛県</option>
								<option value="高知県">高知県</option>
								<option value="福岡県">福岡県</option>
								<option value="佐賀県">佐賀県</option>
								<option value="長崎県">長崎県</option>
								<option value="熊本県">熊本県</option>
								<option value="大分県">大分県</option>
								<option value="宮崎県">宮崎県</option>
								<option value="鹿児島県">鹿児島県</option>
								<option value="沖縄県">沖縄県</option>
						</select></td>
					</tr>
					<tr>
						<th>市町村</th>
						<td><input type="text" name="city" value="" /></td>
					</tr>
					<tr>
						<th>その他建物</th>
						<td><input type="text" name="other" value="" /></td>
					</tr>
			</table>

			</div>
			<s:hidden name="userId" value="%{#session.userId}" />
					<s:hidden name="tempId" value="%{#session.tempId}" />
					<div class="btn-box">
					<s:submit value="登録確認" class="btn" />
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