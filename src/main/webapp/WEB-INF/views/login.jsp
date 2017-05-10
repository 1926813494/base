<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
	<form action="login" method="post">
		账号：<input type="text" name="username" /> <br />
		密码：<input type="password" name="password" /> <br />
		验证码：<input type="text" name="randomcode" /> 
		<img id="codeImg" src="code.jpg" width="56" height="20" onclick="refuseCode()" style="cursor:pointer;"/><br />
		<input type="submit" value="登录" />
	</form>
	<p style="color:red;">${tips}</p>
</body>
<script type="text/javascript">
function refuseCode() {
	var codeImg = document.getElementById('codeImg');
	codeImg.src = 'code.jpg?'+Math.random();
}
</script>
</html>