<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Online-Learning</title>
</head>
<body>
<form name="loginform" action="LoginServlet" method="post">
用户名：<input type=text name="uname"><br>
密码：  <input type=password name="upassword"><br>

<input type="submit" name="login"    value="登陆">
<input type="button" name="register" value="注册">
</form>
</body>
</html>