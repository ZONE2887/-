package PH.store;

import java.io.IOException;
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


import javafx.animation.ParallelTransition;


@WebServlet("/Upload.s")
@MultipartConfig(maxFileSize = 1024*1024*10)//文件大小的限定
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/***
		 * 解决乱码的设置，要尽量靠前
		 */
		
		//服务器接收中文乱码
		request.setCharacterEncoding("utf-8");
		//服务器发送中文乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		/*---------------------------------------------------------*/
		
		Part part =request.getPart("myfile");//获取文件上传的字段，封装字段
		part.getSubmittedFileName();//获取上传文件名
		
		
		part.getSize();//获取文件大小
		
		String path=request.getServletContext().getRealPath("/StorePhoneImg"); //文件写入的地址
		
		System.out.println(path);
		
		path +=part.getSubmittedFileName();
		part.write(path);
		
		
		
		Gson gson=new Gson();
		Map<String,String> data=new HashMap();
		data.put("msg", "file upload success!!");
		
		data.put("path", "/headimgs/"+part.getSubmittedFileName());
		
		response.getWriter().append(gson.toJson(data));
	}
}
