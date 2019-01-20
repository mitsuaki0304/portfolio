<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>ログイン</title>

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
				<li>ログイン</li>
			</ol>
		</div>
	<div id="main">

		<div>
			 <section>
                <h2>ログイン情報</h2>
                <div id="form">

                    <s:form action="LoginAction" method="post">
                         <p>ユーザーID</p>
                        <p class="id"><s:textfield name="userId" /></p>
                        <p>パスワード</p>
                      <p class="pass"><s:password name="userPass" /></p>
                        <p class="submit"><s:submit value="ログイン" class="btn"/></p>
                        <p>新規ユーザー登録は <a href='<s:url action="CreateUserAction" />'>こちら</a></p>
					<s:hidden name="type" value="%{type}" />
					<s:hidden name="tempId" value="%{tempId}" />
                    </s:form>
                </div>
            </section>
<%-- 			<s:form action="LoginAction"> --%>
<%-- 				<s:textfield name="userId" /> --%>
<%-- 				<s:password name="userPass" /> --%>
<%-- 				<s:submit value="ログイン" /> --%>
<%-- 				<s:if test="type!= null"> --%>
					<s:hidden name="type" value="%{type}" />
					<s:hidden name="tempId" value="%{tempId}" />
<%-- 				</s:if> --%>
<%-- 			</s:form> --%>





<!-- 			<br /> -->
<!-- 			<div id="text-link"> -->
<!-- 				<p> -->
<%-- 					新規ユーザー登録は <a href='<s:url action="UserCreateAction" />'>こちら</a> --%>
<!-- 				</p> -->
<!-- 				<p> -->
<%-- 					Homeへ戻る場合は <a href='<s:url action="GoHomeAction" />'>こちら</a> --%>
<!-- 				</p> -->
<!-- 			</div> -->
		</div>
	</div>
</div>

	<div id="footer">
			<jsp:include page="footer.jsp" />
		</div>



</body>
</html>