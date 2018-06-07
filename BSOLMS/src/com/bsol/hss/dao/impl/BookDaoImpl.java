package com.bsol.hss.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bsol.hss.bean.Book;
import com.bsol.hss.dao.BookDao;
import com.bsol.hss.utils.DbUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class BookDaoImpl implements BookDao {

	@Override
	public boolean addBook(Book book) {
		Connection con=null;
		PreparedStatement ps=null;
		int n=0;
		con=DbUtils.getConnection();
		if(con!=null) {
			try {
				ps=con.prepareStatement("insert into book(bookname,author,publishing_house,price,information,stock) values(?,?,?,?,?,?)");
			//	ps.setInt(1, book.getBookid());
				ps.setString(1, book.getBookname());
				ps.setString(2, book.getAuthor());
				ps.setString(3, book.getPublishing_house());
				ps.setDouble(4, book.getPrice());
				ps.setString(5, book.getInformation());
				ps.setInt(6, book.getStock());
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
	public boolean updateStockById(Integer stock, Integer bookid) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		con=DbUtils.getConnection();
    	try {
    		ps=con.prepareStatement("update book set stock=? where bookID=?");
    		ps.setInt(1, stock);
    		ps.setInt(2,bookid);
    		int result= ps.executeUpdate();
    		if(result>0) {
    			return true;
    		}
    		else 
    			return false;
    	}catch(Exception e) {
    			return false;
    		}
    	finally {
    		DbUtils.close(con, ps);
    	}
		
	}

	@Override
	public Book findBookByName(String bookname) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		con=DbUtils.getConnection();
		ResultSet rs=null;
		Book book=null;
		
		if(con!=null) {
			try {
				ps=con.prepareStatement("select * from book where bookName=?");
				ps.setString(1, bookname);
				rs=ps.executeQuery();	
				if(rs.next()) {
					book=new Book();
					book.setBookid(rs.getInt(1));
					book.setBookname(rs.getString(2));
					book.setAuthor(rs.getString(3));
					book.setPublishing_house(rs.getString(4));
					book.setPrice(rs.getDouble(5));
					book.setInformation(rs.getString(6));
					book.setStock(rs.getInt(7));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				DbUtils.close(con, ps);
			}
		}
		return book;

			
		

    }			
    public Book findBookById(int id) {
    	
    	Connection con=null;
		PreparedStatement ps=null;
		con=DbUtils.getConnection();
		ResultSet rs=null;
		Book book=null;
		
		if(con!=null) {
			try {
				ps=con.prepareStatement("select * from book where bookID=?");
				ps.setInt(1, id);
				rs=ps.executeQuery();	
				if(rs.next()) {
					book=new Book();
					book.setBookid(rs.getInt(1));
					book.setBookname(rs.getString(2));
					book.setAuthor(rs.getString(3));
					book.setPublishing_house(rs.getString(4));
					book.setPrice(rs.getDouble(5));
					book.setInformation(rs.getString(6));
					book.setStock(rs.getInt(7));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				DbUtils.close(con, ps);
			}
		}
		return book;

    }
	@Override
	public List<Book> findAllBooks() {
		// TODO Auto-generated method stub
		List<Book> bookList=new ArrayList<Book>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		con=DbUtils.getConnection();
    	try {
    		ps=con.prepareStatement("select * from book order by bookName");
    		rs=ps.executeQuery();
    		while(rs.next()) {
    			Book b1=new Book();
    			b1.setBookid(rs.getInt(1));
    			b1.setBookname(rs.getString(2));
    			b1.setAuthor(rs.getString(3));
    			b1.setPublishing_house(rs.getString(4));
    			b1.setPrice(rs.getDouble(5));
    			b1.setInformation(rs.getString(6));
    			b1.setStock(rs.getInt(7));
    			bookList.add(b1);
    		}
    		return bookList;
    	}catch(Exception e) {
    		return null;
    	}finally {
    		DbUtils.close(con, ps, rs);
    	}
    }

	@Override
	public List<Book> getPageDates(int startindex, int endindex) {
		// TODO Auto-generated method stub
				List<Book> bookList=new ArrayList<Book>();
				Connection con=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
				String sql="select * " + 
						"from book " + 
						"limit ?,? ";
				con=DbUtils.getConnection();
		    	try {
		    		ps=con.prepareStatement(sql);
		    		ps.setInt(1,startindex);
		    		ps.setInt(2, endindex);
		    		rs=ps.executeQuery();
		    		while(rs.next()) {
		    			Book b1=new Book();
		    			b1.setBookid(rs.getInt(1));
		    			b1.setBookname(rs.getString(2));
		    			b1.setAuthor(rs.getString(3));
		    			b1.setPublishing_house(rs.getString(4));
		    			b1.setPrice(rs.getDouble(5));
		    			b1.setInformation(rs.getString(6));
		    			b1.setStock(rs.getInt(7));
		    			bookList.add(b1);
		    		}
		    		return bookList;
		    	}catch(Exception e) {
		    		return null;
		    	}finally {
		    		DbUtils.close(con, ps, rs);
		    	}
	}

	@Override
	public int getBookCount() {
		// TODO Auto-generated method stub
				Connection con=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
				con=DbUtils.getConnection();
				String sql=" select count(bookID) from book ";
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
	
}
