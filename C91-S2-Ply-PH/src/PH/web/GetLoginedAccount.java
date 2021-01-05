package PH.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import PH.bean.User;
import PH.dao.UserDao;

/**
 * Servlet implementation class GetLoginedAccount
 */
@WebServlet("/gla.s")
public class GetLoginedAccount extends BaseServlet {
	
	private static final long serialVersionUID = 1L;
	private UserDao udao = new UserDao();
       
	  public void xianshi(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException, SQLException {
	    	
	    	HttpSession session=request.getSession();
	    	User us = (User) session.getAttribute("logined");
	    	Integer uid = us.getUid();
	    	udao.selectUname(uid);
	  }
}
