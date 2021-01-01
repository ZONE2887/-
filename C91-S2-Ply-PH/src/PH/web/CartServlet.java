package PH.web;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import PH.bean.Cart;
import PH.bean.User;
import PH.biz.BizException;
import PH.dao.CartDao;

@WebServlet("/cart.s")
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    private CartDao cdao = new CartDao();
	
    public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
    	
    	HttpSession session=request.getSession();
    	User us = (User) session.getAttribute("logined");
    	System.out.println(us);
    	System.out.println(session);
    	
    	Integer pid = Integer.valueOf(request.getParameter("pid"));
		Integer qty = Integer.valueOf(request.getParameter("qty"));
		Object uid = us.getUid();
		
		try {
			cdao.insert(uid , pid, qty);
			write(response, uid);
		} catch(SQLException e){
			e.printStackTrace();
			
		}
		
    }
}
