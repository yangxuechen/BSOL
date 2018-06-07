package com.bsol.hss.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bsol.hss.bean.Book;
import com.bsol.hss.bean.Order;
import com.bsol.hss.bean.User;
import com.bsol.hss.service.BusinessService;

/**
 * 购买书籍
 * Servlet implementation class BuyServlet
 */
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BusinessService service=new BusinessService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bookname=request.getParameter("bookname");
		Order order=new Order();
		Book book=service.findBookByName(bookname);
		order.setBookid(book.getBookid());
		order.setDate(new Date());
		User user=(User) request.getSession().getAttribute("user");  //通过session获取user
		order.setUserid(user.getUserid());
		service.addOrder(order);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
