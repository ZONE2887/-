package PH.web;


import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import PH.dao.CartDao;


@WebServlet("/cartt.s")
public class CartTwoServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
	private CartDao cdao = new CartDao();
	
	public void queryByUid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String uid = request.getParameter("uid");
		write(response, cdao.selectByUid(uid));
	}
	

}
