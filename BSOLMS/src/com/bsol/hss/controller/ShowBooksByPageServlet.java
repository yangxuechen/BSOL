package com.bsol.hss.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bsol.hss.bean.Page;
import com.bsol.hss.service.BusinessService;

/**
 * Servlet implementation class ShowBooksByPageServlet
 */
@WebServlet("/ShowBooksByPageServlet")
public class ShowBooksByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BusinessService businessService=new BusinessService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBooksByPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pagenum=(String)request.getParameter("pagenum");
		int pageSize=businessService.getBookCount();//得到书籍总数
		int startindex=0;
		int endindex=0;
		Integer page_num;
		if(pagenum==null) {   //刚开始进入页面，无法获取页面大小
			page_num=0;
			startindex=0;
			endindex=5;
		}else {
			 page_num=Integer.parseInt(pagenum);
				if(page_num<=0) {  //页面大小小于0  ，点击上一页无数据
					 page_num=0;
						startindex=0;
						endindex=5;
				 }else if(page_num*5>=pageSize) {  //页面显示数据超出数据库数据范围，点击下一页无数据
					 page_num=page_num-1;
					 if(pageSize%5==0)
					 startindex=pageSize-5;
					 else
						 startindex=pageSize-(pageSize%5);
					 endindex=5;
				 }else{    //正常显示数据
					 startindex=5*page_num;
						endindex=5;
				 }
			}
			 
		Page page=businessService.getPageDates(startindex, endindex);
		page.setPagenum(page_num);
		request.setAttribute("page", page);
		request.getRequestDispatcher("showBookByPage.jsp").forward(request, response);
		}
		
 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
