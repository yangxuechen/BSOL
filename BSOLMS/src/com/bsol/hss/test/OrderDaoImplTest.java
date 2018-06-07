package com.bsol.hss.test;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.bsol.hss.bean.Order;
import com.bsol.hss.bean.TrueOrder;
import com.bsol.hss.dao.OrderDao;
import com.bsol.hss.dao.impl.OrderDaoImpl;

public class OrderDaoImplTest {
	@Test
	void addOrder() {
		Order order =new Order();
		OrderDao orderDao=new OrderDaoImpl();
		order.setBookid(1);
		order.setUserid(1);
		order.setDate(new Date());
		boolean b=orderDao.addOrder(order);
		if(b) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
	}
	
	@Test
	void findAllOrders() {
		OrderDao orderDao=new OrderDaoImpl();
		List<TrueOrder> orders=orderDao.findAllOrders();
		if(orders!=null) {
			for(TrueOrder o:orders) {
				System.out.println(o.getId()+" "+o.getUsername()+" "+o.getBookname());
			}
		}else {
			System.out.println("false");
		}
	}
	
	@Test
	void getCountTest() {
		OrderDao orderDao=new OrderDaoImpl();
		int n=orderDao.getOrderCount();
		System.out.println(n);
	}
	@Test
	void findAllOrders2() {
		OrderDao orderDao=new OrderDaoImpl();
		List<TrueOrder> orders=orderDao.getPageDates(0, 5);
		if(orders!=null) {
			for(TrueOrder o:orders) {
				System.out.println(o.getId()+" "+o.getUsername()+" "+o.getBookname());
			}
		}else {
			System.out.println("false");
		}
	}
	
	@Test
	void findUserOrder() {
		OrderDao orderDao=new OrderDaoImpl();
		List<TrueOrder> orders=orderDao.getUserOrders(0, 10, 1);
		if(orders!=null) {
			for(TrueOrder o:orders) {
				System.out.println(o.getId()+" "+o.getUsername()+" "+o.getBookname());
			}
		}else {
			System.out.println("false");
		}
	}
	@Test
	void getUserOrderCountTest() {
		OrderDao orderDao=new OrderDaoImpl();
		int n=orderDao.getUserOrderCount(1);
		System.out.println(n);
	}
	
	

}
