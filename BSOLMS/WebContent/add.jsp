<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加书籍</title>
<style type="text/css">      
     body{      
        background-image: url(img/bg.jpg);      
        background-size:cover;    
     }
</style>
</head>
<body style="width:1210px;margin:0 auto;">
	<div style="text-align:center;font-family:YouYuan;font-size:42px;margin-top:50px;">
		<big>添加书籍信息</big>
	</div>
	<div style="margin-top:50px;font-family:FangSong;font-size:30px;">
		<Form action="AddBookServlet" method="post">
			<div style="position:absolute;top:150px;left:500px;font-family:FangSong;font-size:30px;">
				书名：<br><br>作者：<br><br>出版社：<br><br>简介：<br><br><br><br>价格：<br><br>库存：
			</div>
		<div style="position:absolute;top:150px;left:700px;font-family:FangSong;font-size:30px;">
			<input type="text" name="bookname" style="width:330px;height:30px;"></input><BR><BR>
			<input type="text" name="author" style="width:330px;height:30px;"></input><BR><BR>
			<input type="text" name="publishing_house" style="width:330px;height:30px;"></input><BR><BR>
			<textarea name="information" style="width:330px;height:90px;"></textarea><BR><BR>
			<input type="text" name="price" style="width:330px;height:30px;"></input><BR><BR>
			<input type="text" name="stock" style="width:330px;height:30px;"></input>
		</div>
		<div style="position:absolute;bottom:50px;left:700px;">
			<input type="submit" value="添加"/ style="width:150px;height:32px;font-family:FangSong;font-size:20px;">
		</div>
		</Form>
	</div>
</body>
</html>