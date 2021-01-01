package PH.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import PH.bean.Cart;
import PH.util.DBHelper;

public class CartDao {
	
	public void insert(Object uid, Integer pid, Integer qty) throws SQLException {
		String sql = "insert into ph_cart (uid,pid,qty) values(?,?,?)";
		DBHelper.update(sql,uid,pid,qty);
	}
	
	public List<Map<String,Object>> selectByUid(String uid) throws SQLException{
		String sql="SELECT\n" +
				"	id,\n" +
				"	uid,\n" +
				"	ph_phone.pid,\n" +
				"	pname,\n" +
				"	brand,\n" +
				"	price,\n" +
				"	qty\n" +
				"FROM\n" +
				"	ph_cart,\n" +
				"	ph_phone\n" +
				"WHERE\n" +
				"	ph_phone.pid = ph_cart.pid and uid=9528";
		return DBHelper.selectListMap(sql, uid);
	
	}
}
