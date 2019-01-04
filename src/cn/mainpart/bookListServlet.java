package cn.mainpart;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bean.Book;

/**
 * Servlet implementation class bookListServlet
 */
@WebServlet("/bookListServlet")
public class bookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//����ҵ���߼�
		BookServiceImpl bs = new BookServiceImpl();
		List<Book> list = bs.findAll();
		//��תҳ��
		//if(list != null) {
			request.setAttribute("books", list);//��list����request��
			request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
		//}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
