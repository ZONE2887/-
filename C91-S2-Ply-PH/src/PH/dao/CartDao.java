package PH.dao;

import java.sql.SQLException;
import java.util.List;

import PH.bean.Cart;
import PH.util.DBHelper;

public class CartDao {
	

	public void insert(Cart cart) throws SQLException {
		String sql = "insert into ph_cart (uid,pid,qty) values(?,?,?)";
		DBHelper.update(sql,cart.getUid(),cart.getPid(),cart.getQty());
	}
	
	
	public List<?> selectByUid(Object uid) throws SQLException{
		String sql="SELECT\n" +
				"	*\n" +
				"FROM\n" +
				"	ph_cart,\n" +
				"	ph_phone\n" +
				"WHERE\n" +
				"	uid = ?\n" +
				"AND ph_cart.pid = ph_phone.pid";
		return DBHelper.selectListMap(sql, uid);
	
	}
}
