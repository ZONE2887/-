package PH.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import PH.bean.Phone;
import PH.util.DBHelper;
import PH.util.DBHelper.ResultSetMapper;


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
	
	public List<Phone> selectIndex() throws SQLException{
		String sql="select * from ph_phone";
		List<Phone> list;
		list = DBHelper.selectList(sql, new ResultSetMapper<Phone>() {

			@Override
			public Phone map(ResultSet rs) throws SQLException {
				Phone ph = new Phone();
				ph.setPid(rs.getInt("pid"));
				ph.setPname(rs.getString("pname"));
				ph.setBrand(rs.getString("brand"));
				ph.setPrice(rs.getString("price"));
				ph.setImgpath(rs.getString("imgpath"));
				return ph;
			}
		});
		return list;
	}
	
	public Phone selectByPid(String pid) throws SQLException{
		String sql="select * from ph_phone where pid=?";
		List<Phone> list;
		list = DBHelper.selectList(sql, new ResultSetMapper<Phone>() {

			@Override
			public Phone map(ResultSet rs) throws SQLException {
				Phone ph = new Phone();
				ph.setPid(rs.getInt("pid"));
				ph.setPname(rs.getString("pname"));
				ph.setBrand(rs.getString("brand"));
				ph.setPrice(rs.getString("price"));
				ph.setImg(rs.getString("img"));
				return ph;
			}
		}, pid);
		return list.get(0);
	}
}
