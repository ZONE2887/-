package PH.store;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/Idea.s")
public class IdeaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ideaDao ssDao=new ideaDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html;charset=utf-8");
		
		String page = request.getParameter("page");
		int iPage = page ==null ? 1:Integer.parseInt(page); 
		List<idea> rows = ssDao.selectPage(iPage);
		
		int total = ssDao.selectCount();
		
		Map<String,Object> data = new HashMap<>();
		data.put("rows", rows);
		data.put("total", total);
		
		String json = new Gson().toJson(data);
		response.getWriter().append(json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
