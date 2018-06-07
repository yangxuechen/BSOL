package com.bsol.hss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bsol.hss.bean.Order;
import com.bsol.hss.bean.TrueOrder;
import com.bsol.hss.dao.OrderDao;
import com.bsol.hss.utils.DbUtils;

public class OrderDaoImpl implements OrderDao {

	@Override
	public boolean addOrder(Order order) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		con=DbUtils.getConnection();
		int n=0;
		if(con!=null) {
			try {
				ps=con.prepareStatement("insert into `order`(userID,bookID,date) values(?,?,?)");
				//ps.setInt(1, order.getOrderid());
				ps.setInt(1, order.getUserid());
				ps.setInt(2, order.getBookid());
				ps.setDate(3, new java.sql.Date(order.getDate().getTime()));
				n=ps.executeUpdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				DbUtils.close(con, ps);
			}
		}
		if(n>0)
		return true;
		return false;
	}

	@Override
	public List<TrueOrder> findAllOrders() {
		// TODO Auto-generated method stub
		List<TrueOrder> orderList=new ArrayList<TrueOrder>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql=" select  u.userName,b.bookName,o.date " + 
				" from user u,book b,`order` o " + 
				" where o.userID=u.userID AND o.bookID=b.bookID ";
		con=DbUtils.getConnection();
		if(con!=null) {
			try {
	    		ps=con.prepareStatement(sql);
	    		rs=ps.executeQuery();
	    		int i=1;
	    		while(rs.next()) {
	    			TrueOrder o1=new TrueOrder();
	    			o1.setId(i);i++;
	    			o1.setUsername(rs.getString(1));
	    			o1.setBookname(rs.getString(2));
	    			o1.setDate(rs.getDate(3));
	    			orderList.add(o1);
	    		}
	    		
	    	}catch(Exception e) {
	    		return null;
	    	}finally {
	    		DbUtils.close(con, ps, rs);
	    	}
			
		}
		return orderList;
	}

	@Override
	public int getOrderCount() {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		con=DbUtils.getConnection();
		String sql=" select count(orderID) from `order` ";
		int n=0;
    	try {
    		ps=con.prepareStatement(sql);
    		rs= ps.executeQuery();
    		if(rs.next()) {
    			n=rs.getInt(1);
    		}
    	}catch(Exception e) {
    			e.printStackTrace();
    		}
    	finally {
    		DbUtils.close(con, ps);
    	}
    	return n;
	}

	@Override
	public List<TrueOrder> getPageDates(int startindex, int endindex) {
		List<TrueOrder> orderList=new ArrayList<TrueOrder>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql=" select  u.userName,b.bookName,o.date " + 
				" from user u,book b,`order` o " + 
				" where o.userID=u.userID AND o.bookID=b.bookID "+
				" limit ?,? ";
		con=DbUtils.getConnection();
		if(con!=null) {
			try {
	    		ps=con.prepareStatement(sql);
	    		ps.setInt(1, startindex);
	    		ps.setInt(2, endindex);
	    		rs=ps.executeQuery();
	    		int i=1;
	    		while(rs.next()) {
	    			TrueOrder o1=new TrueOrder();
	    			o1.setId(i);i++;
	    			o1.setUsername(rs.getString(1));
	    			o1.setBookname(rs.getString(2));
	    			o1.setDate(rs.getDate(3));
	    			orderList.add(o1);
	    		}
	    		
	    	}catch(Exception e) {
	    		return null;
	    	}finally {
	    		DbUtils.close(con, ps, rs);
	    	}
			
		}
		return orderList;
	}

	@Override
	public List<TrueOrder> getUserOrders(int startindex, int endindex,int userID) {
		List<TrueOrder> orderList=new ArrayList<TrueOrder>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql=" select  u.userName,b.bookName,o.date " + 
				" from user u,book b,`order` o " + 
				" where o.userID=u.userID AND o.bookID=b.bookID And o.userID=? "+
				" limit ?,? ";
		con=DbUtils.getConnection();
		if(con!=null) {
			try {
	    		ps=con.prepareStatement(sql);
	    		ps.setInt(1, userID);
	    		ps.setInt(2, startindex);
	    		ps.setInt(3, endindex);
	    		rs=ps.executeQuery();
	    		int i=1;
	    		while(rs.next()) {
	    			TrueOrder o1=new TrueOrder();
	    			o1.setId(i);i++;
	    			o1.setUsername(rs.getString(1));
	    			o1.setBookname(rs.getString(2));
	    			o1.setDate(rs.getDate(3));
	    			orderList.add(o1);
	    		}
	    		
	    	}catch(Exception e) {
	    		return null;
	    	}finally {
	    		DbUtils.close(con, ps, rs);
	    	}
			
		}
		return orderList;
	}

	@Override
	public int getUserOrderCount(int userID) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		con=DbUtils.getConnection();
		String sql=" select count(orderID) from `order` where userID=? ";
		int n=0;
    	try {
    		ps=con.prepareStatement(sql);
    		ps.setInt(1, userID);
    		rs= ps.executeQuery();
    		if(rs.next()) {
    			n=rs.getInt(1);
    		}
    	}catch(Exception e) {
    			e.printStackTrace();
    		}
    	finally {
    		DbUtils.close(con, ps);
    	}
    	return n;
	}

}
