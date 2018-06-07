package com.bsol.hss.service;

import java.util.List;

import com.bsol.hss.bean.Book;
import com.bsol.hss.bean.Order;
import com.bsol.hss.bean.Page;
import com.bsol.hss.bean.TrueOrder;
import com.bsol.hss.bean.User;
import com.bsol.hss.dao.BookDao;
import com.bsol.hss.dao.OrderDao;
import com.bsol.hss.dao.UserDao;
import com.bsol.hss.dao.impl.BookDaoImpl;
import com.bsol.hss.dao.impl.OrderDaoImpl;
import com.bsol.hss.dao.impl.UserDaoImpl;

public class BusinessService {
	
	UserDao userDao= new UserDaoImpl();
	BookDao bookDao=new BookDaoImpl();
    OrderDao orderDao=new OrderDaoImpl();
    
 
    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    public boolean userLogin(String username,String password) {
    	User u=userDao.findUserByName(username);
    	if(u!=null) {
    		if(u.getPassword().equals(password)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * 判断是否是管理员
     * @param username
     * @return
     */
    public boolean isManager(String username) {
    	User u=userDao.findUserByName(username);
    		if(u!=null) {
    			if(u.getManagement()==1) {
    				return true;
    			}
    		}
    	return false;
    }
    
    /**
     * 用户注册
     * @param user
     * @return
     */
    public boolean userRegister(User user) {
    	return userDao.addUser(user);
    }
    
    /**
     * 添加书籍
     * @param book
     * @return
     */
    public boolean addBook(Book book) {
    	return bookDao.addBook(book);
    }
    
    /**
     * 通过名字查找书籍
     * @param bookname
     * @return
     */
    public Book findBookByName(String bookname) {
    	return bookDao.findBookByName(bookname);
    }
    
    /**
     * 查找所有书籍
     * @return
     */
    public List<Book> findAllBooks(){
    	return bookDao.findAllBooks();
    }
    
    /**
     * 添加订单
     * @param order
     * @return
     */
    public boolean addOrder(Order order) {
    	return orderDao.addOrder(order);
    }
    
    /**
     * 查找所有订单
     * @return
     */
    public List<TrueOrder> findAllOrders(){
    	return orderDao.findAllOrders();
    }
    /**
     * 通过用户姓名查找用户
     * @param username
     * @return
     */
    public User findUserByName(String username) {
    	return userDao.findUserByName(username);
    }
    /**
     * 更新书籍库存
     * @param bookid
     * @return
     */
    public boolean updateBookStock(int bookid) {
    	Book book=bookDao.findBookById(bookid);
    	return bookDao.updateStockById(book.getStock()-1, bookid);
    }
    
    /**
     * 得到页面信息(manager)
     * @param startindex  起始索引
     * @param endindex    数据量
     * @return
     */
    public Page getPageDates(int startindex,int endindex) {
    	Page page=new Page();
    	page.setList(bookDao.getPageDates(startindex, endindex));
    	return page;
    }
    
    /**
     * 得到书籍的总数
     * @return
     */
    public int getBookCount() {
    	
    	return bookDao.getBookCount();
    }
    
    /**
     * 得到订单总数
     * @return
     */
    public int getOrderCount() {
    	return orderDao.getOrderCount();
    }
    
    public int getUserOrderCount(int userID) {
    	return orderDao.getUserOrderCount(userID);
    }
    
    /**
     * 得到订单的页面信息(manager)
     * @param startindex
     * @param endindex
     * @return
     */
    public Page getOrderPageDates(int startindex,int endindex) {
    	Page page=new Page();
    	page.setList(orderDao.getPageDates(startindex, endindex));
    	return page;
    }
    
    /**
     * 通过用户ID得到用户订单页面信息
     * @param startindex
     * @param endindex
     * @param userID
     * @return
     */
    public Page getUserOrerPageDates(int startindex,int endindex,int userID) {
    	Page page=new Page();
    	page.setList(orderDao.getUserOrders(startindex, endindex, userID));
    	return page;
    }
    
  
  /**
   * 通过用户ID修改密码  
   * @param userID
   * @param password
   * @return
   */
    public boolean updateUser(int userID,String password) {
    	return userDao.updateUserById(userID, password);
    }

}
