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
	public int countByUname(String uname)throws SQLException{
		String sql = "select count(*) from ph_user where uname=?";
		List<Integer> list = DBHelper.selectList(sql, new ResultSetMapper<Integer>() {
			public Integer map(ResultSet rs) throws SQLException{
				return rs.getInt(1);
			}
		},uname);
		return list.get(0);
	}

}
