<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>老夫子旧书网</title>
	<link type="text/css" rel="stylesheet" href="/css/style.css"/>
	<script src="../js/jquery-3.6.0.min.js"></script>

	<%
		String base = request.getContextPath()+"/";
		String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+base;
	%>
	<base href="<%=url%>">
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"></div>
	<div id="shuone"></div>
	<div id="navbar"><a href="/backend/managerlogin.html">老夫子旧书网</a>
	</div>
</div>
<div id="login">
	<h2>用户登录</h2>
	<form>
		<dl>
			<dt>用户名：</dt>
			<dd>
				<input class="input-text" type="text" id="username" name="username" onblur="isUsernameNull()"/>
				<span id="usernull"></span>
			</dd>
			<dt>密码：</dt>
			<dd>
				<input class="input-text" type="password" id="password" name="password" onblur="isPasswordNull()"/>
				<span id="pwdnull"></span>
			</dd>
			<dt>验证码：</dt>
			<dd>
				<input id="yanzhengma" name="yanzhengma" maxlength="5" style="width: 40px;height: 25px" onblur="checkCode()"/>
				<span id="yzm"></span>
				<img id="codeImg" src="/users?action=getCode" onclick="changeImage(this)" alt="验证码加载中..." style="vertical-align: middle"/>
			</dd>
			<dt>&nbsp;</dt>
			<dd class="button">
				<input id="login-btn" class="input-btn" type="button" name="submit" value=""/>
				<input id="reg-btn" class="input-reg" type="button" name="register" value=""
					   onclick="window.location='/front/register.jsp';"/>
			</dd>
		</dl>
	</form>
</div>
<div id="footer" class="wrap">
	老夫子旧书网&copy;版权所有
</div>
<script>
	// 验证用户名非空
	function isUsernameNull() {
		//获取用户名框的值
		let username = $("#username").val();
		//判断值的长度  trim()去除字符串前后空格
		if (username.trim().length > 0) {
			$.get("users?action=findByName", {"username": username}, function (data) {
				if (data === "true") {
					//设置可用状态
					$("#login-btn").removeAttr("disabled");
					//清除提示语
					$("#usernull").text("");
				} else  {
					$("#usernull").text("用户名不存在");
				}
			})
		} else {
			//登录按钮设置为不用
			$("#login-btn").attr("disabled","disabled");
			//设置提示语
			$("#usernull").text("账号不能为空");
		}
	}


	// 验证密码非空
	function isPasswordNull() {
		//获取用户名框的值
		let password = $("#password").val();
		//判断值的长度  trim()去除字符串前后空格
		if (password.trim().length > 0) {
			//设置可用状态
			$("#login-btn").removeAttr("disabled");
			//清除提示语
			$("#pwdnull").text("");
		} else {
			//登录按钮设置为不用
			$("#login_btn").attr("disabled","disabled");
			//设置提示语
			$("#pwdnull").text("密码不能为空");
		}
	}


	<!--验证码验证-->
	function checkCode() {
		//获取文本框输入验证码的值
		let code = $("#yanzhengma").val();
		if (code.trim().length > 0) {
			$.get("users?action=checkCode", {"code": code}, function (data) {
				if (data === "true") {
					//设置可用状态
					$("#login-btn").removeAttr("disabled");

					$("#yzm").text("");
				} else {
					$("#yzm").text("验证码不一致");
				}
			})
		} else {
			//登录按钮设置为不用
			$("#login-btn").attr("disabled","disabled");
			$("#yzm").text("验证码不能为空");
		}
	}

	<!--验证码刷新-->
	$(function () {
		//图片绑定单击事件
		$("#codeImg").on("click", function () {
			//获取当前时间
			let date = new Date().getTime();
			//改变src请求路径
			$(this).attr("src", "users?action=getCode&time=" + date);
		})
	})
	//ajax登录请求
	$("#login-btn").on("click",function () {
		let username = $("#username").val().replace(/\s+/g,"");
		let password = $("#password").val().replace(/\s+/g,"");
		//发送ajax请求
		$.ajax({
			url: "users?action=login",
			type: "post",
			data: {"username":username,"password":password},
			success: function (data) {
				if(data==="true"){
					//做查询全部图书的请求
					window.open("books?action=findAllPage")
				}else{
					alert("账号密码错误")
				}
			}
		})
	})


</script>
</body>
</html>