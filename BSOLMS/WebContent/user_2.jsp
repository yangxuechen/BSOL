<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.bsol.hss.bean.Book" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网上书店</title>
<style type="text/css">      
     body{      
        background-image: url(img/bg.jpg);      
        background-size:cover;    
     }
</style>
</head>
<body style="width:1210px;margin:0 auto;">
<% String username=(String) session.getAttribute("username");
   ArrayList<Book> books=(ArrayList<Book>) session.getAttribute("books"); %>
	<div style="text-align:center;font-family:YouYuan;font-size:42px;margin-top:50px;">
		<big>欢迎使用网上书店！</big>
		<img src="img/book.jpg" width="42" height="42" style="Opacity:0.75;">
	</div>
	<div style="position:absolute;top:10px;left:10px;font-family:FangSong;font-size:30px;">
		用户名：<%= username %>
	</div>
	<div style="position:absolute;top:10px;left:10px;font-family:FangSong;font-size:30px;">
		<Button onclick="window.location.href='LogOutServlet'">退出</Button>
	</div>
	<div style="position:absolute;top:250px;left:650px;font-family:FangSong;font-size:30px;">
		1.<a href="UserShowBooksServlet">购买书籍</a><BR><BR>
		2.<a href="updateUser.jsp">修改信息</a><BR><BR>
		3.<a href="UserShowOrdersServlet">查看订单</a>
	</div>
</body>
</html>