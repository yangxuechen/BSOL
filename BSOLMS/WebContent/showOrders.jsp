<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.bsol.hss.bean.TrueOrder" %>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单信息</title>
<style type="text/css">      
     body{      
        background-image: url(img/bg.jpg);      
        background-size:cover;    
     }
</style>
</head>
<body style="width:1210px;margin:0 auto;">
<% ArrayList<TrueOrder> orders=(ArrayList<TrueOrder>) request.getAttribute("orders"); %>
<% Calendar calendar = Calendar.getInstance(); %>
	<div style="position:absolute;top:50px;left:350px;font-family:FangSong;font-size:30px;">
		<table border="0" align="center">
			<% for(int i=0;i<orders.size();i++){
				TrueOrder order=orders.get(i);
				calendar.setTime(order.getDate());%>
					<tr>
						<td>
							订单号<%= order.getId() %>：
						</td>
						<td>
							用户（ID：<%= order.getUsername() %>）
						</td>
						<td>
							购买了书籍（ID：<%= order.getBookname() %>）
						</td>
						<td>
							于<%= calendar.get(Calendar.YEAR) %>年<%= calendar.get(Calendar.MONTH)+1 %>月<%= calendar.get(Calendar.DATE) %>日
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