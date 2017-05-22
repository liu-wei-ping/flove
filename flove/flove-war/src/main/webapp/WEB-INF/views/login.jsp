<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ielt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ielt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<title>登录页面</title>
<link rel='stylesheet' type='text/css'
	href="${pageContext.request.contextPath}/css/login.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/base.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/cookie.js"></script>

</head>
<body>
	<div class="container">
		<section id="content"> <%-- 		<input type="text" id="code"  value="${sessionScope['login_code']}"/> --%>
		<form id="login-form" onSubmit="return false;" method="post">
			<h1>Flove Site</h1>
			<em id="err"></em>
			<div>
				<input type="text" class="login-input" id="username"
					oninput="errorFun('',false)" name="username" placeholder="用户名"
					value="Planning" required />
			</div>
			<div>
				<input type="password" class="login-input" id="password"
					name="password" oninput="errorFun('',false)" placeholder="密码"
					value="lwp123" required />
			</div>
			<div>
				<input type="text" class="code-input" id="code" name="code"
					placeholder="验证码" oninput="errorFun('',false)"
					onBlur="if (this.value == '') {this.placeholder = '验证码';}"
					onFocus="this.placeholder = '';" value="q12g" required /><a
					href="#" id="code-link"><img class="refresh-code" id="code-img"
					src="code.shtml" alt="点击刷新"></a>
			</div>
			<div>
				<!-- 				<input style="display: block;" id="submit" type="submit" /> -->
				<a href="#" class="login-btn" id="login-btn">登 录</a> <a href="retrieve.html"
					class="link-btn" target="_blank">找回密码</a><a href="register.html"
					class="link-btn" target="_blank">注册</a>
			</div>
		</form>
		<!-- form -->
		<div class="button">
			<a href="#">Download source file</a>
		</div>
		<!-- button --> </section>
		<!-- content -->
	</div>
	<!-- container -->
</body>
<script type="text/javascript">
	var login_url = "sign.shtml";
	var return_url = "../core/index.html"
	function getPicCode() {
		$("#code-img").attr("src", "code.shtml?rnd=" + Math.random());
	}
	$('#code-link').on("click", function() {
		getPicCode();
	})
	$('#login-btn').on('click', function() {
		login();
	});
<%-- 	var id = '<%=Session["login_code"] %>'; --%>

document.onkeydown = function(e){ 
    var ev = document.all ? window.event : e;
    if(ev.keyCode==13) {
    	login();
     }
}
function login() {
		if (!checkParams()) {
			return
		} 
		var params = {};
		var fields = $('#login-form').serializeArray();
		$.each(fields, function(i, field) {
			var key = field['name'];
		//	console.log(field);
/* 			var value = key != "password" ? $.trim(field.value) : RSAUtils
					.encryptedString(publicKey, $.trim(field.value));
			console.log(key + "=" + value); */
			params[key] = field['value'];
		});
		$.ajax({
			url : login_url,
			async: true,
			type : 'POST',
			data : JSON.stringify(params),
			contentType : 'application/json;charset=utf-8',
			dataType : 'json',
			beforeSend:function() { 
				 $("<div class=\"modelWrap\"></div>").appendTo("body"); 
				 $("<p class=\"loginwait\"></p").appendTo(".modelWrap");
				 $("<img class=\"loginwaitImg\"/>").attr({src:"${pageContext.request.contextPath}/images/loading2.gif"}).appendTo(".loginwait");
/* 				 $("<p class=\"modelInn\"></p>").html("正在登录，请稍候。。。").appendTo(".loginwait"); */
				 $("<span id='time'></span>").css({color: "#ffac48" }).appendTo(".modelInn");
			},
			success : function(data) {
				if (data.success) {
					failCount=true;
					loginSuccessCallback(1,return_url);
				} else {
					loginFailCallback(data.msg,2);
				}
			},
			error : function(data) {
				loginFailCallback("系统故障!");
			}
		});
	}
var timer = null;
var t = 0;
function loginSuccessCallback(num,url){
    if(t){
        $('#time').empty().html((num - t) + '秒');
    }else{
        $('#time').empty().html(num + '秒');
    }
    if(timer){
        clearTimeout(timer);
    }
    if(t>=num){
    	    location.href = url;
    }else{
        timer = setTimeout(function(){
            t++;
            loginSuccessCallback(num,url);
        },1000)
    }
}
function loginFailCallback(msg,num){
	num=(num||3)*1000;
    setTimeout(function(){
			$("#password").val('');
			$("#code").val(''); 
		    getPicCode();
			errorFun(msg,true);
		    $(".modelWrap").remove();
        },num)
}
function checkParams() {
		var f1, f2, f3,f4=true;
		var username = $("#username").val();
		f1 = errorFun("请填写用户名！", username == "")
		if (!f1) {
			return f1;
		}
		var password = $("#password").val();
		f2 = errorFun("请填写密码！", password == "")
		if (!f2) {
			return f2;
		}
		var code = $("#code").val();
		f3 = errorFun("请填写验证码！", code == "")
		if (!f3) {
			return f3;
		}
		return f1 && f2 && f3 && f4;
}
function errorFun(errorMsg, flag) {
		if (flag) {
			$("#err").html("<font>" + errorMsg + "</font>");
			return false;
		} else {
			$("#err").html("");
			return true;
		}
	}
</script>

</html>