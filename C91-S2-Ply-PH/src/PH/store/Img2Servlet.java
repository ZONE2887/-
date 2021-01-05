package PH.store;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;

/**
 * Servlet implementation class Img2Servlet
 */
@WebServlet("/Img.s")
public class Img2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StoreBiz ssBiz=new StoreBiz();   
	private StoreDao ssDao=new StoreDao();
	private StorePhone ss=new StorePhone();


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//服务器接受中文字符乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String part= request.getParameter("myfile");
		
		String id = request.getParameter("myfile1");
		int pid=Integer.parseInt(id);
		
		System.out.println("*********"+pid);

		System.out.println("*********"+part);
		
		ss.setPid(pid);
		ss.setImg(part);
		
		try {
			ssDao.updateimg2(ss);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Gson gson =new Gson();
		Map<String, String> data =new HashMap<>();
		data.put("msg","file upload success!!!");
		response.getWriter().append(gson.toJson(data));
		
		
	}

}
