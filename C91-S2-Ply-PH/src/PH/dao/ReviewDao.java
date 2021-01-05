package PH.dao;

import java.sql.SQLException;

import PH.bean.Message;
import PH.bean.Review;
import PH.util.DBHelper;

public class ReviewDao {
	
		public void advise(Review review) throws SQLException{
			String sql = "insert into ph_review values(null,?,?,?)";
			DBHelper.update(sql,
					review.getUid(),
					review.getRname(),
					review.getReview());
					
		}
}
