package PH.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import PH.bean.Message;
import PH.dao.MessageDao;

@WebServlet("/message.s")
public class AddMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MessageDao mdao=new MessageDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8"); 	
			Message message=new Message();
	        message.setUid(1);
	        message.setUname(request.getParameter("uname"));
	        message.setEmail(request.getParameter("email"));
	        message.setPhonenum(request.getParameter("phonenum"));
	        message.setMessage(request.getParameter("message"));
	       
	        try {
				mdao.insert(message);
				response.getWriter().append("留言成功");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	      
	      
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
