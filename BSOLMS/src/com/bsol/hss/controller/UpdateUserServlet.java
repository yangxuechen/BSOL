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
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BusinessService service=new BusinessService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=(String)request.getSession().getAttribute("username");
		User user=service.findUserByName(username);
		String oldpwd=request.getParameter("oldpassword");
		String pwd=request.getParameter("password1");
		if(oldpwd.equals(user.getPassword())) {  //确认旧密码
			boolean b=service.updateUser(user.getUserid(), pwd);
			if(b) {
				request.getRequestDispatcher("updateUserSeccess.jsp").forward(request, response);//更新成功
			}else {
				request.getRequestDispatcher("updateUserFail.jsp").forward(request, response);//更新失败
			}
		}else {
			request.getRequestDispatcher("updateUserFail.jsp").forward(request, response);//更新失败
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
