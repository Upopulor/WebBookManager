package cn.mainpart;

import java.sql.SQLException;
import java.util.List;

import cn.bean.Book;

public class BookServiceImpl {
	//����һ��Dao����
	BookDaoImpl bookDao = new BookDaoImpl();
	public List<Book> findAll(){
		try {
			return bookDao.findAllBooks();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//���ͼ��
	public void addBook(Book book) {
		try {
			bookDao.addBook(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//����ID����ͼ��
	public Book findBookById(String id) {
		try {
			return bookDao.findBookByID(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void updateBook(Book book) {
		try {
			bookDao.updateBook(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void deleteBook(String id) {
		try {
			bookDao.delBook(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public void deleteAllBooks(String[] ids) {
		try {
			bookDao.delAllBooks(ids);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public List<Book> searchBooks(String id, String category, String name, String minprice, String maxprice) {
		try {
			return bookDao.searchBooks(id,category,name,minprice,maxprice);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
