package cn.mainpart;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.C3P0.C3P0Util;
import cn.bean.Book;
//�������е�ͼ��
public class BookDaoImpl {
	public List<Book> findAllBooks() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from book", new BeanListHandler<Book>(Book.class));
	}
	//���ͼ����Ϣ
	public void addBook(Book book) throws SQLException {
	QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
	qr.update("INSERT into book VALUES(?,?,?,?,?,?)",book.getId(),book.getName(),book.getPrice(),book.getPnum(),book.getCategory(),book.getDescription());	
	}
	//����ͼ�����ID
	public Book findBookByID(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from book where id=?", new BeanHandler<Book>(Book.class),id);
	}
	//�޸�ͼ����Ϣ
	public void updateBook(Book book) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("update book set name=?,price=?,pnum=?,category=?,description=? where id=?",
				book.getName(),book.getPrice(),book.getPnum(),book.getCategory(),book.getDescription(),book.getId());
		
	}
	//����IDɾ��ͼ��
	public void delBook(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("delete from book where id=?",id);	
	}
	//����ɾ��
	public void delAllBooks(String[] ids) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		Object[][] params = new Object[ids.length][];
		for (int i = 0; i < params.length; i++) {
			params[i] = new Object[] {ids[i]};//ѭ����ÿһ��һά�����е�Ԫ�ظ�ֵ��ֵ��id
		}
		qr.batch("delete from  book where id=?", params);
	}
	//��������ѯ
	public List<Book> searchBooks(String id, String category, String name, String minprice, String maxprice) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "select * from book where 1=1";
		List list = new ArrayList();
		if(!"".equals(id.trim())) {
			sql+=" and id like ?"; //id like %'102'%
			list.add("%"+id.trim()+"%");
		}
		if(!"".equals(category.trim())) {
			sql+=" and category=?";
			list.add(category);
		}
		if(!"".equals(name.trim())) {
			sql+=" and name like ?";
			list.add("%"+name+"%");
		}
		if(!"".equals(minprice.trim())) {
			sql+=" and price>?";
			list.add(minprice);
		}
		if(!"".equals(maxprice.trim())) {
			sql+=" and price<?";
			list.add(maxprice);
		}
		return qr.query(sql, new BeanListHandler<Book>(Book.class),list.toArray());
	}
}