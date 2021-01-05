package PH.store;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import PH.util.DBHelper;
import PH.util.DBHelper.ResultSetMapper;

public class UserDao {
	private UserMapper sMapper=new UserMapper();
	//
	public List<User> selectPage(int page) {
		//mysql的分页查询语法:limit 从第几行开始 ，查几行数据
		int begin =(page-1)*10;
		
		String sql="select * from ph_user limit ?,10";
		
		try {
			
			return DBHelper.selectList(sql, sMapper,begin);
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	


	public  int selectCount() 
	
	{
		String sql="select  count(*) cnt from ph_user";
		
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
	

	//修改密码的语句

	public void updauser(User ss) throws SQLException {
		DBHelper dbh=new DBHelper();
		
		String sql="update ph_user set pwd=? where uid=?";
		
		dbh.update(sql,ss.getUid(),ss.getPwd());
		
	}
	
	
	
	
	



	



	
	

	





	
	
	

}
class UserMapper implements ResultSetMapper<User>{
	public User map(ResultSet rs) {
		User ss=new User();
		try {
			
			
			
			
			ss.setUid(rs.getInt("uid"));
			ss.setUname(rs.getString("uname"));
			ss.setPhonenum(rs.getString("phonenum"));
			ss.setEmail(rs.getString("email"));
			ss.setPwd(rs.getString("pwd"));
			
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return ss;
	}
	

}



