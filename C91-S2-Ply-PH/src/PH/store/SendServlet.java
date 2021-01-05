package PH.store;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendServlet
 */
@WebServlet("/send.s")
public class SendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private OrderDao ssDao =new OrderDao();
	private Order ss =new Order();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//获取商品的编号
		String id = request.getParameter("oid");
		int oid=Integer.parseInt(id);
		
		System.out.println("打印oid="+oid);
		ss.setOid(oid);
		
		try {
			ssDao.updatestate(ss);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		response.getWriter().append("发货成功！");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	

}
