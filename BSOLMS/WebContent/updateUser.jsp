<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<style type="text/css">      
     body{      
        background-image: url(img/bg.jpg);      
        background-size:cover;    
     }
</style>
</head>
<body style="width:1210px;margin:0 auto;">
	<div style="text-align:center;font-family:YouYuan;font-size:42px;margin-top:50px;">
		<big>修改密码</big>
	</div>
	<div style="margin-top:50px;font-family:FangSong;font-size:30px;">
		<Form action="UpdateUserServlet" method="post">
			<div style="position:absolute;top:150px;left:500px;font-family:FangSong;font-size:30px;">
			    旧的密码：<br><br>新的密码：<br><br>确认密码：<br><br>
			</div>
		<div style="position:absolute;top:150px;left:700px;font-family:FangSong;font-size:30px;">
			<input type="password" name="oldpassword" style="width:330px;height:30px;"></input><BR><BR>
			<input type="password" name="password1" style="width:330px;height:30px;"></input><BR><BR>
			<input type="password" name="password2" style="width:330px;height:30px;"></input><BR><BR>
		</div>
		<div style="position:absolute;bottom:50px;left:700px;">
			<input type="submit" value="确认"/ style="width:150px;height:32px;font-family:FangSong;font-size:20px;">
		</div>
		</Form>
	</div>
</body>
</html>