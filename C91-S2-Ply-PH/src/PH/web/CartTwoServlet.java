package PH.web;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import PH.bean.User;
import PH.dao.CartDao;


@WebServlet("/cartt.s")
public class CartTwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private CartDao cdao = new CartDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
    	User us = (User) session.getAttribute("logined");
    	Integer uid = us.getUid();
		try {
			 us =  (User) cdao.selectByUid(uid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String json = gson.toJson(us);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append(json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	

}
