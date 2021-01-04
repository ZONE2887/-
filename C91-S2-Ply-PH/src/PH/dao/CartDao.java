package PH.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import PH.util.DBHelper;

public class CartDao {
	

	public void insert(Object uid, Integer pid,Integer qty) throws SQLException {
		String sql = "insert into ph_cart (uid,pid,qty) values(?,?,?)";
		DBHelper.update(sql,uid,pid,qty);
	}
	
	
	public List<Map<String, Object>> selectByUid(Object uid) throws SQLException{
		String sql="SELECT\n" +
				"	id,uid,qty,ph_phone.*\n" +
				"FROM\n" +
				"	ph_cart,\n" +
				"	ph_phone\n" +
				"WHERE\n" +
				"	uid = ?\n" +
				"AND ph_cart.pid = ph_phone.pid";
		return DBHelper.selectListMap(sql,uid);
	}
	
	public void deleteById(String id) throws SQLException {
		String sql = "DELETE FROM ph_cart WHERE id=?";
		DBHelper.update(sql,id);
	}
}
