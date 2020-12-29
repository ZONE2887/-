package PH.dao;

import java.sql.SQLException;
import java.util.List;

import PH.util.DBHelper;


public class PhDao {
	
	public List<?>query(){
		String sql = "select * from ph_phone";
		try {
			return DBHelper.selectListMap(sql);
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
