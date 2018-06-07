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
	<div style="text-align:center;font-family:YouYuan;font-size:36px;margin-top:75px;">
		书单
	</div>
	<div style="position:absolute;top:10px;left:10px;font-family:FangSong;font-size:30px;">
		用户名：<%= username %>
	</div>
	<div style="position:absolute;top:250px;left:550px;font-family:FangSong;font-size:30px;">
		<table border="0" align="center">
		<% for(int i=0;i<books.size();i++){
			Book book=books.get(i); %>
				<tr>
					<td>
						<%= i+1 %>.<a href="ShowBooksServlet?bookname=<%= book.getBookname()%>"><%= book.getBookname() %></a>
					</td>
				</tr>
				<tr></tr>
			<% } %>
		</table>
	</div>
</body>
</html>