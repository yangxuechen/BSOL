package com.bsol.hss.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bsol.hss.bean.Order;
import com.bsol.hss.bean.User;
import com.bsol.hss.service.BusinessService;

/**
 * Servlet implementation class PurchaseServlet
 */
@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BusinessService service=new BusinessService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setHeader("content-type", "text/html;charset=UTF-8");  
		response.setCharacterEncoding("UTF-8");  
		request.setCharacterEncoding("UTF-8"); 
		String username=(String) request.getSession().getAttribute("username");
		User user=service.findUserByName(username);
		String bookid=request.getParameter("bookid");
		int bookId=Integer.parseInt(bookid);
		Order order=new Order();
		order.setBookid(bookId);
		order.setUserid(user.getUserid());
		order.setDate(new Date());
		boolean b=service.addOrder(order);
		boolean b2=service.updateBookStock(bookId);
		if(b&&b2) {
			request.getRequestDispatcher("deal.jsp").forward(request, response);//¹ºÂò³É¹¦
		}else {
			//¹ºÂòÊ§°Ü
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
