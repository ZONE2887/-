package PH.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import PH.dao.UserDao;

@WebServlet("/login.s")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao udao = new UserDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");

		Map<String, Object> user = udao.login(uname, pwd);

		request.getSession().setAttribute("logined", user);
		
		response.getWriter().print("登录成功");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
