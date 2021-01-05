package PH.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import PH.bean.Review;
import PH.dao.MessageDao;
import PH.dao.ReviewDao;

@WebServlet("/review.s")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewDao rdao=new ReviewDao();  
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); 
		Review review=new Review();
		review.setUid(1);
		review.setRname(request.getParameter("rname"));
		review.setReview(request.getParameter("review"));
		
		try {
			rdao.advise(review);
			response.getWriter().append("评论成功");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
