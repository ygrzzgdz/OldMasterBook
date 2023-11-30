<%@page contentType="text/html; UTF-8"  pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>老夫子旧书网</title>
	<link type="text/css" rel="stylesheet" href="/css/style.css" />
	<script src="../js/jquery-3.6.0.min.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo">老夫子旧书网</div>
	<div id="shuone"></div>
	<div id="navbar"><a href="/backend/managerlogin.html">老夫子旧书网</a>
</div>
<div id="register">
	<div class="title">
		<h2>欢迎注册老夫子旧书网<</h2>
	</div>
	<div class="steps">
		<ul class="clearfix">
			<li class="current">1.填写注册信息</li>
			<li class="unpass">2.注册成功</li>
		</ul>
	</div>

	<input type="hidden" id="isExsit" value=""/>
	<form method="post" action="" onsubmit="return true"  >
		<dl>
			<dt>用 户 名：</dt>
			<dd><input class="input-text" type="text" id="username" name="username"/><span id="usernull"></span><span id="alreadyExsits">${regFailMsg}</span></dd>
			<dt>密　　码：</dt>
			<dd><input class="input-text"  type="password" id="password" name="password"/><span id="nullpassword"><font color=\"green\">密码至少8位</font></span><span id="simplepassword"></span></dd>
			<dt>确认密码：</dt>
			<dd><input class="input-text" type="password" id="rePassword" name="rePassword"/><span id="nullrePassword"></span><span id="uneq"></span></dd>
			<dt>联 系 人：</dt>
			<dd><input class="input-text" type="text" id="contact" name="contact"/><span id="usernull"></span><span id="alreadyExsits"></span></dd>
			<dt>手机号码：</dt>
			<dd><input class="input-text" type="text" id="mobilephone" name="mobilephone"/><span id="usernull"></span><span id="alreadyExsits"></span></dd>
			<dt>联系地址：</dt>
			<dd><input class="input-text" type="text" id="address" name="address"/><span id="usernull"></span><span id="alreadyExsits"></span></dd>
			
			<dt>Email地址：</dt>
			<dd><input class="input-text" type="text" id="email" name="email"/><span id="nullemail"><font color=\"green\">请输入正确格式的邮箱</font></span><span id="errorInput"></span></dd>
			<dt></dt>
			<dd class="button"><input class="input-reg" type="submit" name="register" value="" /></dd>
		</dl>
	</form>
</div>
</div>



<div id="footer" class="wrap">
	老夫子旧书网&copy;版权所有
</div>
	<script>
		<!--非空验证-->
		$(function (){
			$(".input-text").on("blur",function (){
				//获取当前文本框的值
				var text_vale = $(this).val();
					if(text_vale.trim().length>0){
					$(this).next("span").text("");
				}else{
					//定位到当前文本框后的span标签
					$(this).next("span").text("不能为空")
				}
			})

			//验证密码
			$("#rePassword").on("blur",function (){
				let password = $("#password").val();
				let repassword = $("#rePassword").val();

				//判断两次密码是否相等
				if (password==repassword){
					$("#nullrePassword").text("")
				}else {
					$("#nullrePassword").text("密码不一致")
				}
			})

		})
	</script>
</body>
</html>
