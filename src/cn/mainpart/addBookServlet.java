package cn.mainpart;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.C3P0.UUIDUtil;
import cn.bean.Book;

/**
 * Servlet implementation class addBookServlet
 */
@WebServlet("/addBookServlet")
public class addBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//获取表单数据,注意输入没有id的，需要自己添加
		Book book = new Book();
		try {
			BeanUtils.populate(book, request.getParameterMap());
			book.setId(UUIDUtil.getUUID());//手动生成随机ID
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//调用业务逻辑
		BookServiceImpl bs = new BookServiceImpl();
		bs.addBook(book);
		//分发转向
		request.getRequestDispatcher("bookListServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
