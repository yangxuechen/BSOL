<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bsol.hss.bean.Book" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购书</title>
<style type="text/css">      
     body{      
        background-image: url(img/bg.jpg);      
        background-size:cover;    
     }
</style>
</head>
<body style="width:1210px;margin:0 auto;">
<% Book book=(Book) request.getAttribute("book"); %>
	<div style="position:absolute;top:100px;left:525px;font-family:FangSong;font-size:30px;">
		书名：<br><br>作者：<br><br>出版社：<br><br>简介：<br><br><br><br>价格：<br><br>库存：
	</div>
	<div style="position:absolute;top:100px;left:700px;font-family:FangSong;font-size:30px;">
		<%= book.getBookname() %><BR><BR>
		<%= book.getAuthor() %><BR><BR>
		<%= book.getPublishing_house() %><BR><BR>
		<%= book.getInformation() %><BR><BR><BR><BR>
		<%= book.getPrice() %><BR><BR>
		<%= book.getStock() %>
	</div>
	<div style="position:absolute;bottom:50px;left:525px;">
		<Button style="width:150px;height:32px;font-family:FangSong;font-size:20px;" onclick="window.location.href='UserShowBooksServlet'">返回</Button>		
	</div>
	<div style="position:absolute;bottom:50px;left:900px;">
		<Button style="width:150px;height:32px;font-family:FangSong;font-size:20px;" onclick="window.location.href='PurchaseServlet?bookid=<%= book.getBookid() %>'">购买</Button>
	</div>
</body>
</html>