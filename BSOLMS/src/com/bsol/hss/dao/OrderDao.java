package com.bsol.hss.dao;

import java.util.List;

import com.bsol.hss.bean.Book;
import com.bsol.hss.bean.Order;
import com.bsol.hss.bean.TrueOrder;

public interface OrderDao {
	
	public boolean addOrder(Order order);
	
	public List<TrueOrder> findAllOrders();
	
//	多表连接查询
//	select  u.userName,b.bookName,o.date
//	from user u,book b,`order` o
//	where o.userID=u.userID AND o.bookID=b.bookID;
	
	//查询订单总数
	public int getOrderCount();
	
	//分页查询
	public List<TrueOrder> getPageDates(int startindex,int endindex);
	
	//通过用户ID查询用户订单
	public List<TrueOrder> getUserOrders(int startindex,int endindex,int userID);
	
	//通过用户ID得到用户订单总数
	public int getUserOrderCount(int userID);
}
