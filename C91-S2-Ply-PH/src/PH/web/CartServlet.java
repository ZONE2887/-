package PH.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import PH.bean.Cart;
import PH.bean.User;
import PH.dao.CartDao;

@WebServlet("/cart.s")
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    private CartDao cdao = new CartDao();
	
    public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
    	Cart cart = new Cart();
    	try{
    		cart.setPid(Integer.valueOf(request.getParameter("pid")));
        	cart.setQty(Integer.valueOf(request.getParameter("qty")));
    		}catch(Exception e){
    		System.out.println();
    		}
    	
    	HttpSession session=request.getSession();
    	User us = (User) session.getAttribute("logined");
    	System.out.println(us);
    	System.out.println(session);
    	Integer uid = us.getUid();
    	System.out.println(uid);
    	
    	try {
    		cdao.insert(cart);
    		response.getWriter().append("加入购物车成功！");
    	} catch(SQLException e) {
    		e.printStackTrace();
    		response.getWriter().append(e.getMessage());
    	}
    	
    	
    	Gson gson = new Gson();
    	String json = gson.toJson(cart);
    	response.getWriter().append(json);
    }
    
    public void queryUid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
    	
    	HttpSession session=request.getSession();
    	User us = (User) session.getAttribute("logined");
    	Integer uid = us.getUid();
		System.out.println(uid);
    	
    }
}
