package PH.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import PH.util.DBHelper;

public class XxDao {
	
	public List<Map<String, Object>> selectByPid(String pid) throws SQLException {
		String sql = "";
		return DBHelper.selectListMap(sql, pid);
	}

}
