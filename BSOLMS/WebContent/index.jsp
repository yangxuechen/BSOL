<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<style type="text/css">      
     body{      
        background-image: url(img/bg.jpg);      
        background-size:cover;    
     }
</style>
</head>
<body style="width:1210px;margin:0 auto;">
	<div style="text-align:center;font-family:YouYuan;font-size:42px;margin-top:75px;">
		<big>欢迎使用网上书店！</big>
		<img src="img/book.jpg" width="42" height="42" style="Opacity:0.75;">
	</div>
	<div style="margin:45px;">
		<Form action="LoginServlet" method="post" style="text-align:center;">
			<div style="position:absolute;top:175px;left:550px;font-family:FangSong;font-size:30px;">
				用户名：<br><br>密&nbsp;&nbsp;码：
			</div>
			<div style="position:absolute;top:170px;left:680px;font-family:FangSong;font-size:30px;">
				<input type="text" name="username" style="width:330px;height:35px;"><BR><BR>
				<input type="password" name="password" style="width:330px;height:35px;">
			</div>
			<div style="position:absolute;top:350px;left:600px;">
				<input type="submit" value="登陆" name="login" style="font-family:FangSong;font-size:25px;width:360px;height:40px;"><BR><BR><BR>
				<input type="submit" value="注册" name="register" style="font-family:FangSong;font-size:25px;width:360px;height:40px;">
			</div>
		</Form>
	</div>
</body>
</html>