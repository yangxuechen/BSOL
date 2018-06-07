<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/validation.css">
<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/jquery.validate.js"></script>
<script type="text/javascript">
	$(function(){
		$('#register').validate({
			rules:{
				username:{
					required:true,
					maxlength:15
				},
				password:{
					required:true,
					maxlength:15
				},
				password_cup:{
					required:true,
					equalTo:"#password"
				}
			},
			messages:{
				username:{
					required:"不能为空",
					maxlength:"最大长度不超过15个字符"
				},
				password:{
					required:"不能为空",
					maxlength:"最大长度不超过15个字符"
				},
				password_cup:{
					required:"重复密码",
					equalTo:"确认失败"
				}
			}
		});
	});
</script>
<style type="text/css">      
     body{      
        background-image: url(img/bg.jpg);      
        background-size:cover;    
     }
</style>
</head>
<body style="width:1210px;margin:0 auto;">
	<div style="text-align:center;font-family:YouYuan;font-size:42px;margin-top:75px;">
		<big>欢迎新用户注册！</big>
	</div>
	<div style="margin:45px;">
		<form action="RegisterServlet" method="post" id="register" >
			<div style="position:absolute;top:185px;left:500px;font-family:FangSong;font-size:30px;">
				请输入用户名：<br><br>输入用户密码：<br><br>再次确认密码：
			</div>
			<div style="position:absolute;top:170px;left:700px;font-family:FangSong;font-size:30px;">
				<input type="text" name="username" style="width:300px;height:30px;"></input>*<BR><BR>
				<input type="password" name="password" id="password" style="width:300px;height:30px;"></input>*<BR><BR>
				<input type="password" name="password_cup" style="width:300px;height:30px;"></input>*
			</div>
			<div style="position:absolute;top:450px;left:600px;">			
				<input type="submit" value="注册" style="font-family:FangSong;font-size:25px;width:360px;height:40px;"></input>
			</div>
		</form>
	</div>
</body>
</html>