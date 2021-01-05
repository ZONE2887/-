package PH.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import PH.util.DBHelper;

public class OrderDao {
	
	public Object insert(Object uid, String name,String addr,String phone) throws SQLException {
		String sql = "INSERT INTO ph_order (\n" +
				"	oid,\n" +
				"	uid,\n" +
				"	NAME,\n" +
				"	addr,\n" +
				"	phone,\n" +
				"	money\n" +
				")\n" +
				"VALUES\n" +
				"	(\n" +
				"		NULL ,?,?,?,?, (\n" +
				"			SELECT\n" +
				"				SUM(a.qty * b.price)\n" +
				"			FROM\n" +
				"				ph_cart a\n" +
				"			JOIN ph_phone b ON a.pid = b.pid\n" +
				"			WHERE\n" +
				"				a.uid = ?\n" +
				"		)\n" +
				"	)";
		//DBHelper.update(sql,uid,name,addr,phone);
		System.out.println(uid);
		System.out.println(sql);
		Connection conn = DBHelper.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
		ps.setObject(1, uid);
		ps.setObject(2, name);
		ps.setObject(3, addr);
		ps.setObject(4, phone);
		ps.setObject(5, uid);
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			return rs.getObject(1);
		}else {
			return null;
		}
	}
	
	
	//将购物车表中的商品添加到订单明细中
	public void insertOrderItem(Object uid,Object oid) throws SQLException {
		String sql = "INSERT INTO ph_orderitem SELECT\n" +
				"	NULL,\n" +
				"	a.pid,\n" +
				"	?,\n" +
				"	a.qty,\n" +
				"	b.price\n" +
				"FROM\n" +
				"	ph_cart a\n" +
				"JOIN ph_phone b ON a.pid = b.pid\n" +
				"WHERE\n" +
				"	uid = ?";
		DBHelper.update(sql,oid,uid);
	}
	
	public List<Map<String, Object>> selectByUid(Object uid) throws SQLException{
		String sql="SELECT\n" +
				"	*\n" +
				"FROM\n" +
				"	ph_order\n" +
				"WHERE\n" +
				"	uid = ?";
		return DBHelper.selectListMap(sql,uid);
	}
	
	public void updatByUid(Object uid) throws SQLException{
		String sql ="UPDATE ph_order SET state=1 WHERE uid = ?";
		DBHelper.update(sql, uid);
	}

}
