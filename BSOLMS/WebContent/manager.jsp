<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网上书店管理系统</title>
<style type="text/css">      
     body{      
        background-image: url(img/bg.jpg);      
        background-size:cover;    
     }
</style>
</head>
<body style="width:1210px;margin:0 auto;">
	<div style="text-align:center;font-family:YouYuan;font-size:42px;margin-top:100px;">
		<big>管理书店&nbsp;</big>
	</div>
	<div style="position:absolute;top:10px;left:10px;font-family:FangSong;font-size:30px;">
		<Button onclick="window.location.href='LogOutServlet'">退出</Button>
	</div>
	<div style="position:absolute;top:250px;left:650px;font-family:FangSong;font-size:30px;">
		1.<a href="ShowBooksByPageServlet">查看书籍信息</a><BR><BR>
		2.<a href="add.jsp">添加书籍信息</a><BR><BR>
		3.<a href="ShowOrdersServlet">查看订单信息</a>
	</div>
</body>
</html>