package PH.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import PH.bean.User;
import PH.biz.BizException;
import PH.biz.OrderBiz;


@WebServlet("/order.s")
public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	OrderBiz obiz = new OrderBiz();
       
	public void addorder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
    	
    	HttpSession session=request.getSession();
    	User us = (User) session.getAttribute("logined");
    	Integer uid = us.getUid();
    	
    	String name = request.getParameter("name");
    	String addr = request.getParameter("addr");
    	String phone = request.getParameter("phone");
    	
    	try {
			obiz.create(uid, name, addr, phone);
			response.getWriter().append("添加订单成功！");
		} catch (BizException e) {
			e.printStackTrace();
		}
    }
	
	public void zhifu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		HttpSession session=request.getSession();
    	User us = (User) session.getAttribute("logined");
    	Integer uid = us.getUid();
		
    	try {
    		obiz.update(uid);
    		response.getWriter().append("支付成功！");
    	}catch (BizException e) {
			e.printStackTrace();
		}
	}

}
