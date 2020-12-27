package PH.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import PH.bean.User;
import PH.biz.BizException;
import PH.biz.UserBiz;



/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register.s")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UserBiz ubiz = new UserBiz();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		User user = new User();
		user.setUname(req.getParameter("uname"));
		user.setPwd(req.getParameter("pwd"));
		user.setPhonenum(req.getParameter("phonenum"));
		user.setEmail(req.getParameter("email"));
		try {
			ubiz.register(user);
			resp.getWriter().append("注册成功");
		}catch (BizException e) {
			e.printStackTrace();
			resp.getWriter().append("注册失败！原因："+e.getMessage());
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	

}
