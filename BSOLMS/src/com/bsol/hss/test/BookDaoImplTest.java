package com.bsol.hss.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.bsol.hss.bean.Book;
import com.bsol.hss.dao.BookDao;
import com.bsol.hss.dao.impl.BookDaoImpl;
import com.bsol.hss.service.BusinessService;

public class BookDaoImplTest {
	@Test
	void findAllBooks() {
		BookDao bookDao=new BookDaoImpl();
		List<Book> books=bookDao.findAllBooks();
		if(books!=null) {
			for(Book b:books) {
				System.out.println(b.getBookname());
			}
		}else {
			System.out.println("null");
		}
	}
	
	@Test
	void findBookById() {
		BookDao bookDao=new BookDaoImpl();
		Book book=bookDao.findBookById(1);
		if(book!=null) {
			System.out.println(book.getBookname());
		}else {
			System.out.println("null");
		}
	}

	@Test
	void service() {
		BusinessService service=new BusinessService();
		boolean b=service.updateBookStock(1);
		if(b) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
	}
	@Test
	void getPageDatesTest() {
		BookDao bookDao=new BookDaoImpl();
		List<Book> books=bookDao.getPageDates(0, 5);
		if(books!=null) {
			for(Book b:books) {
				System.out.println(b.getBookname());
			}
		}else {
			System.out.println("null");
		}
	}
	
	@Test
	void getCountTest() {
		BookDao bookDao=new BookDaoImpl();
		int n=bookDao.getBookCount();
		System.out.println(n);
	}
	

}
