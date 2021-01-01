package PH.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import PH.bean.Phone;
import PH.dao.PhDao;


@WebServlet("/phone.s")
public class PhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	private PhDao pdao = new PhDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		Phone ph = null;
		try {
			ph = pdao.selectByPid(pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String json = gson.toJson(ph);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append(json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
