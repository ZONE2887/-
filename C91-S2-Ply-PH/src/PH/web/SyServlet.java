package PH.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import PH.bean.Phone;
import PH.dao.PhDao;

/**
 * Servlet implementation class IndexPhServlet
 */
@WebServlet("/sy.s")
public class SyServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private PhDao pdao = new PhDao();

	protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		write(response,pdao.query());
	}

}
