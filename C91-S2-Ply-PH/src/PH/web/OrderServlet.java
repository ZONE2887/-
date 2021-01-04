package PH.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import PH.bean.User;
import PH.dao.OrderDao;


@WebServlet("/order.s")
public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	OrderDao odao = new OrderDao();
       
	public void addorder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
    	
    	HttpSession session=request.getSession();
    	User us = (User) session.getAttribute("logined");
    	Integer uid = us.getUid();
    	
    	String name = request.getParameter("name");
    	String addr = request.getParameter("addr");
    	String phone = request.getParameter("phone");
    	
    	try {
			odao.insert(uid,name,addr,phone);
    		response.getWriter().append("添加订单成功！");
    	} catch(SQLException e) {
    		e.printStackTrace();
    		response.getWriter().append(e.getMessage());
    	}
    	
    }

}
