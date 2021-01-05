package PH.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import PH.bean.User;
import PH.util.DBHelper;
import PH.util.DBHelper.ResultSetMapper;




public class UserDao {
	public void insert(User user) throws SQLException{
		String sql = "insert into ph_user values(null,?,?,?,?)";
		DBHelper.update(sql,
			  user.getUname(),
			  user.getPwd(),
			  user.getPhonenum(),
			  user.getEmail());
	}
	public int countByName(String name)throws SQLException{
		String sql = "select count(*) from ph_user where uname=?";
		List<Integer> list = DBHelper.selectList(sql, new ResultSetMapper<Integer>() {
			public Integer map(ResultSet rs) throws SQLException{
				return rs.getInt(1);
			}
		},name);
		return list.get(0);
	}

	public List<User> Login(String uname,String pwd) throws SQLException{
		String sql="select * from ph_user where uname=? and pwd=?";
		
		return DBHelper.selectList(sql, new ResultSetMapper<User>() {
			@Override
			public User map(ResultSet rs) throws SQLException {
				User us=new User();
				us.setUid(rs.getInt("uid"));
				us.setUname(rs.getString("uname"));
				us.setPwd(rs.getString("pwd"));
				us.setEmail(rs.getString("email"));
				us.setPhonenum(rs.getString("phonenum"));
				return us;
			}
		}, uname,pwd);
	}
  
  public User selectByUid(String uid) throws SQLException{
		String sql="select * from ph_user where uid=?";
		List<User> list;
		list = DBHelper.selectList(sql, new ResultSetMapper<User>() {

			@Override
			public User map(ResultSet rs) throws SQLException {
				User us = new User();
				us.setUid(rs.getInt("uid"));
				us.setUname(rs.getString("uname"));
				return us;
			}
		}, uid);
		return list.get(0);
	}
  
  public void selectUname(Object uid) throws SQLException{
	  String sql="select uname from ph_user where uid=?";
	  DBHelper.query(sql, uid);
  }
}
