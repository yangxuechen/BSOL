<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.bsol.hss.bean.Book" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍信息</title>
<style type="text/css">      
     body{      
        background-image: url(img/bg.jpg);      
        background-size:cover;    
     }
</style>
</head>
<body style="width:1210px;margin:0 auto;">
<% ArrayList<Book> books=(ArrayList<Book>) request.getAttribute("books"); %>
	<div style="text-align:center;font-family:YouYuan;font-size:42px;margin-top:50px;">
		<big>所有书籍信息</big>
	</div>
	<div style="position:absolute;top:150px;left:550px;font-family:FangSong;font-size:30px;">
		<table border="0" align="center">
			<% for(int i=0;i<books.size();i++){
			Book book=books.get(i); %>
				<tr>
					<td>
						<%= i+1 %>.<%= book.getBookname() %>&nbsp;
					</td>
					<td>
						库存：<%= book.getStock() %>
					</td>
				</tr>
			<% } %>
		</table>
	</div>
	<div style="position:absolute;bottom:50px;left:700px;">
		<Button style="width:150px;height:32px;font-family:FangSong;font-size:20px;" onclick="window.location.href='manager.jsp'">返回管理书店</Button>
	</div>
</body>
</html>