package PH.store;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


/**
 * Servlet implementation class CreateSqSingerServlet
 */
@WebServlet("/create.s")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StoreBiz sBiz=new StoreBiz();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		
		StorePhone ss=new StorePhone();
		ss.setPname(request.getParameter("pname"));
		ss.setBrand(request.getParameter("brand"));
		ss.setPrice(request.getParameter("price"));
		ss.setNumber(request.getParameter("number"));
		sBiz.create(ss);
		
		//
		response.getWriter().append("商品上架完成");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
