<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>user page</title>
</head>
<body>
	<h2>user page</h2>
	<div>
		<ul>		
		<c:forEach items="${users}" var="user">
			<li>${user.id}:${user.usercode}：${user.username}</li>
		</c:forEach>
		</ul>
	</div>
	<div>
		<shiro:hasPermission name="user:create">
		<h2>创建用户</h2>
		<form action="" method="post">
			账号：<input type="text" name="usercode" /> <br />
			用户姓名：<input type="text" name="username" /><br />
			<input type="submit" value="创建" />
		</form>
		</shiro:hasPermission>
	</div>
</body>
</html>