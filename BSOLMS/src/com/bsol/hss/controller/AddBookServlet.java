package com.bsol.hss.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bsol.hss.bean.Book;
import com.bsol.hss.service.BusinessService;

/**
 *添加书籍
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BusinessService service=new BusinessService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//由于出现了数据库插入数据乱码现象
		  request.setCharacterEncoding("UTF-8");  
		  response.setContentType("text/html;charset=UTF-8");  
		  
		 String bookname=request.getParameter("bookname");
		 String author=request.getParameter("author");
		 String publishing_house=request.getParameter("publishing_house");
		 double price=Double.parseDouble(request.getParameter("price"));
		 String information=request.getParameter("information");
		 int stock=Integer.parseInt(request.getParameter("stock"));
		 Book book=new Book();
		 book.setBookname(bookname);
		 book.setAuthor(author);
		 book.setPublishing_house(publishing_house);
		 book.setInformation(information);
		 book.setPrice(price);
		 book.setStock(stock);
		// System.out.println(book.getBookname());
		 boolean result=service.addBook(book);
		 if(result) {
			 request.getRequestDispatcher("commit.jsp").forward(request, response);
			 //添加成功
		 }else {
			 request.getRequestDispatcher("add.jsp").forward(request, response);
			 //添加失败
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
