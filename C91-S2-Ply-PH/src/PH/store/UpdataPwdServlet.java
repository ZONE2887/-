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

import com.google.gson.Gson;

/**
 * Servlet implementation class UpdataPwdServlet
 */
@WebServlet("/pwd.s")
public class UpdataPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StoreBiz ssBiz=new StoreBiz(); 
	private UserDao ssDao=new UserDao();
	private User ss=new User();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//服务器接受中文字符乱码
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				
				String part= request.getParameter("myfile");
				
				String id = request.getParameter("myfile1");
				int uid=Integer.parseInt(id);
				
				System.out.println("*********uid"+uid);

				
				
				ss.setUid(uid);
				ss.setPwd(part);
				
				try {
					ssDao.updauser(ss);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				Gson gson =new Gson();
				Map<String, String> data =new HashMap<>();
				data.put("msg","file upload success!!!");
				response.getWriter().append(gson.toJson(data));
	}

}
