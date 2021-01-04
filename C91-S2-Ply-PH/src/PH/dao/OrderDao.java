package PH.dao;

import java.sql.SQLException;

import PH.util.DBHelper;

public class OrderDao {
	
	public void insert(Object uid, String name,String addr,String phone) throws SQLException {
		String sql = "insert into ph_order (uid,name,addr,phone) values(?,?,?,?)";
		DBHelper.update(sql,uid,name,addr,phone);
	}

}
