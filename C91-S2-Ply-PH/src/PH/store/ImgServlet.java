package PH.store;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;

/**
 * Servlet implementation class ImgServlet
 */
@WebServlet("/imgpath.s")
@MultipartConfig(maxFileSize = 1024*1024*100)
public class ImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StoreBiz ssBiz=new StoreBiz();
	//创建一个dao的对象，用来插入图片位置
	private StoreDao ssDao=new StoreDao();
	private StorePhone ss=new StorePhone();


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//服务器接受中文字符乱码
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				
				response.setContentType("text/html;charset=utf-8");
				
				
				
				String id = request.getParameter("pid");
				
				int pid=Integer.parseInt(id);
				
		
				ss.setPid(pid);
				
				
				
				Part part=request.getPart("myfile");//获取文件上传的封装对象
				
				part.getSubmittedFileName();//获取文件名
				
				part.getSize();//获取文件大小
				
				//文件上传的路经（服务器路径）
				String path=request.getServletContext().getRealPath("/images/");
				path+=part.getSubmittedFileName();
				//文件写入
				part.write(path);
				//将文件名写入到img
				
				
				System.out.println(ss.getPid());
				ss.setImgpath(part.getSubmittedFileName());
				
				try {
					ssDao.updateimg(ss);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
				Gson gson =new Gson();
				Map<String, String> data =new HashMap<>();
				data.put("msg","file upload success!!!");
				response.getWriter().append(gson.toJson(data));
				
				
	}

}
