package PH.store;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DelSqSingerServlet
 */
@WebServlet("/del.s")
public class DelStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StoreBiz ssBiz=new StoreBiz();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//获取商品的编号
		String pid = request.getParameter("pid");
		
		System.out.println("打印pid="+pid);
		ssBiz.delete(pid);
		response.getWriter().append("下架成功！");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
