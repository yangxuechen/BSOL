package com.bsol.hss.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bsol.hss.bean.User;
import com.bsol.hss.service.BusinessService;

/**
 * 用户注册
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BusinessService service=new BusinessService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//数据库出现了乱码  添加以下两条语句
		  request.setCharacterEncoding("UTF-8");  
		  response.setContentType("text/html;charset=UTF-8");  
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		boolean result=service.userRegister(user);
		if(result) {
			request.setAttribute("username", username);
			request.getRequestDispatcher("success.jsp").forward(request, response);
		//	response.sendRedirect("index.jsp");//注册成功，返回首页
		}else {
			response.sendRedirect("register.jsp");//注册失败，返回注册页面
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
