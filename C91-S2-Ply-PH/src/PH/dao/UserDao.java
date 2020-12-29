package PH.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import PH.bean.User;
import PH.util.DBHelper;
import PH.util.DBHelper.ResultSetMapper;
import PH.util.DBHelper1;



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
public Map<String,Object> login(String uname,String pwd){
	String sql="select*from ph_user where uname=? and pwd=?";
	DBHelper1 dbh=new DBHelper1();
	List<Map<String,Object>>list=dbh.query(sql, uname,pwd);
	if(list.size()==0){
		return null;
	}else{
		Map<String,Object> user=list.get(0);
		return user;
	}
 }
}
