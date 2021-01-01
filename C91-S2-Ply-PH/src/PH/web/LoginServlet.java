package PH.web;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import PH.bean.User;
import PH.biz.BizException;
import PH.biz.UserBiz;

@WebServlet("/login.s")
public class LoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserBiz ubiz=new UserBiz();
	public void Login(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		try {
			User Login = ubiz.Login(uname, pwd);
			System.out.println(Login);
			response.getWriter().append("登录成功");
			HttpSession session=request.getSession();
			session.setAttribute("logined", Login);
			System.out.println(session);
		} catch (BizException e) {
			response.getWriter().append("登录失败！！！ 原因:"+e.getMessage());
		}
	}
}
