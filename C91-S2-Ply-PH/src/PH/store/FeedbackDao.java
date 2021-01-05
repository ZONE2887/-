package PH.store;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import PH.util.DBHelper;
import PH.util.DBHelper.ResultSetMapper;

public class FeedbackDao {
	private FeedbackMapper sMapper=new FeedbackMapper();
	public List<Feedback> selectPage(int page) {
		//mysql的分页查询语法:limit 从第几行开始 ，查几行数据
		int begin =(page-1)*10;
		
		String sql="select * from ph_talk limit ?,10";
		
		try {
			
			return DBHelper.selectList(sql, sMapper,begin);
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	


	public  int selectCount() 
	
	{
		String sql="select  count(*) cnt from ph_talk";
		
		try {
			List<Integer> list =DBHelper.selectList(sql, 
					new ResultSetMapper<Integer>() 
					{
						@Override
						public Integer map(ResultSet rs) throws SQLException 
						{
							return rs.getInt("cnt");
						}
					});
			return list.get(0);
		} catch (SQLException e) {
		
			throw new RuntimeException(e);
		}
	}
}
class FeedbackMapper implements ResultSetMapper<Feedback>{
	public Feedback map(ResultSet rs) {
		Feedback ss=new Feedback();
		try {
			
			
			
			ss.setTid(rs.getInt("tid"));
			ss.setUname(rs.getString("uname"));
			ss.setEmail(rs.getString("email"));
			ss.setPhonenum(rs.getString("phonenum"));
			ss.setMessage(rs.getString("message"));
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return ss;
	}
}