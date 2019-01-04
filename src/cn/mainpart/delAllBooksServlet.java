package cn.mainpart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class delAllBooksServlet
 */
@WebServlet("/delAllBooksServlet")
public class delAllBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//得到所有id
		String[] ids = request.getParameterValues("ids");
		//调用删除业务
		BookServiceImpl bs = new BookServiceImpl();
		bs.deleteAllBooks(ids);
		request.getRequestDispatcher("bookListServlet").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
