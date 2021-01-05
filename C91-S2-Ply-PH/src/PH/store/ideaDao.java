package PH.store;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import PH.util.DBHelper;
import PH.util.DBHelper.ResultSetMapper;

public class ideaDao {
	private IdeaMapper sMapper=new IdeaMapper();
	
	public List<idea> selectPage(int page) {
		//mysql的分页查询语法:limit 从第几行开始 ，查几行数据
		int begin =(page-1)*10;
		
		String sql="select * from ph_review limit ?,10";
		
		try {
			
			return DBHelper.selectList(sql, sMapper,begin);
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	


	public  int selectCount() 
	
	{
		String sql="select  count(*) cnt from ph_review";
		
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
class IdeaMapper implements ResultSetMapper<idea>{
	public idea map(ResultSet rs) {
		idea ss=new idea();
		try {
			
			
			
			ss.setRid(rs.getInt("rid"));
			ss.setRname(rs.getString("rname"));
			ss.setReview(rs.getString("review"));
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return ss;
	}
	

}