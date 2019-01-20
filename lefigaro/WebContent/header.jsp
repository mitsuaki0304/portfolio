<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
 <link rel="stylesheet" href="./css/header.css">
 <link rel="stylesheet" href="./css/common.css">
 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<script type="text/javascript" src="./js/footerFixed.js"></script>
<meta name="keyword" content="">
 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script>
        (function($) {
    $(function() {
        var $header = $('#top-head');
        // Nav Fixed
        $(window).scroll(function() {
            if ($(window).scrollTop() > 350) {
                $header.addClass('fixed');
            } else {
                $header.removeClass('fixed');
            }
        });
        // Nav Toggle Button
        $('#nav-toggle').click(function(){
            $header.toggleClass('open');
        });
    });
})(jQuery);
</script>
</head>
<body>

<header id="top-head">
        <div class="inner">
            <div id="mobile-head">
                <h1 class="logo"> <a
						href='<s:url action="HomeAction"><s:param name="tempId" value="%{#session.tempId}"/>
						<s:param name="userId" value="%{#session.userId}"/>
						</s:url>'>leFigaro</a></h1>
                <div id="nav-toggle">
                    <div>
                        <span></span>
                        <span></span>
                        <span></span>
                    </div>
                </div>
            </div>

            <nav id="global-nav">
                <ul>
                    <li>
                     <a
						href='<s:url action="HomeAction">
						<s:param name="tempId" value="%{#session.tempId}"/>
						<s:param name="userId" value="%{#session.userId}"/>
						</s:url>'>HOME</a>
			</li>
                    <li>
                    <a
						href='<s:url action="ProductListAction">
						<s:param name="tempId" value="%{#session.tempId}"/>
						<s:param name="userId" value="%{#session.userId}"/>
						</s:url>'>PRODUCT</a>
			</li>
		<li>
		  <a
						href='<s:url action="CartAction">
						<s:param name="tempId" value="%{#session.tempId}"/>
						<s:param name="userId" value="%{#session.userId}"/>
						</s:url>'>CART</a>
		</li>
		<s:if test="#session.userId==null">
			<li>
			  <a href='<s:url action="GoLoginAction">
						</s:url>'>LOGIN</a>
				</li>
		</s:if>
		<s:if test="#session.userId!=null">
			<li>
			  <a
						href='<s:url action="MyPageAction">
						<s:param name="tempId" value="%{#session.tempId}"/>
						<s:param name="userId" value="%{#session.userId}" />
						<s:param name="userPass" value="%{#session.userPass}"  />
						</s:url>'>MYPAGE</a>
				</li>
			<li>
			  <a
						href='<s:url action="LogoutAction">

						</s:url>'>LOGOUT</a>
				</li>
		</s:if>

                </ul>
            </nav>
        </div>
    </header>


</body>
<script type="text/javascript">
    $(function() {
        $('#nav_toggle').click(function() {
            $("header").toggleClass('open');
            $("nav").slideToggle(500);
        });
    });
</script>
</html>