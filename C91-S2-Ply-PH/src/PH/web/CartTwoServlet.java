package PH.web;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import PH.bean.User;
import PH.dao.CartDao;


@WebServlet("/cartt.s")
public class CartTwoServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
	private CartDao cdao = new CartDao();
	
	protected void queryByUid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		HttpSession session=request.getSession();
    	User us = (User) session.getAttribute("logined");
    	Integer uid = us.getUid();
    	write(response,cdao.selectByUid(uid));
		
	}
	
	public void deleteById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
    	String id = request.getParameter("id");
    	try {
			cdao.deleteById(id);
    		response.getWriter().append("删除商品成功！");
    	} catch(SQLException e) {
    		e.printStackTrace();
    		response.getWriter().append(e.getMessage());
    	}
    	
    }
}
