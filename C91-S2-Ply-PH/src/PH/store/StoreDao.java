package PH.store;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import PH.util.DBHelper;
import PH.util.DBHelper.ResultSetMapper;





public class StoreDao {
	private StoreMapper sMapper=new StoreMapper();
	//
	public List<StorePhone> selectPage(int page) {
		//mysql的分页查询语法:limit 从第几行开始 ，查几行数据
		int begin =(page-1)*10;
		
		String sql="select * from ph_phone limit ?,10";
		
		try {
			
			return DBHelper.selectList(sql, sMapper,begin);
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	


	public  int selectCount() 
	
	{
		String sql="select  count(*) cnt from ph_phone";
		
		try {
			List<Integer> list =DBHelper.selectList(sql, 
					new ResultSetMapper<Integer>() 
					{
						@Override
						public Integer map(ResultSet rs) throws SQLException 
						{
							return rs.getInt("cnt");
						}
					});
			return list.get(0);
		} catch (SQLException e) {
		
			throw new RuntimeException(e);
		}
	}
	
	
	
	//写入图片路径
	public void updateimg(StorePhone ss) throws SQLException {
		DBHelper dbh=new DBHelper();
		
		String sql="update ph_phone set imgpath=? where pid=?";
		
		dbh.update(sql,ss.getImgpath(),ss.getPid());
		
	}
	
	//写入网络图片路径
	public void updateimg2(StorePhone ss) throws SQLException {
		DBHelper dbh=new DBHelper();
		
		String sql="update ph_phone set img=? where pid=?";
		
		dbh.update(sql,ss.getImg(),ss.getPid());
		
	}
	

	public List<StorePhone> selectPage1(int page) {
		//mysql的分页查询语法:limit 从第几行开始 ，查几行数据
		int begin =(page-1)*10;
		
		String sql="select * from ph_user limit ?,10";
		
		try {
			
			return DBHelper.selectList(sql, sMapper,begin);
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	



	
	

	

	
	
	//添加记录方法
	public void insert(StorePhone ss) throws SQLException {
		DBHelper dbh=new DBHelper();
		
		String sql="insert into ph_phone (pname,brand,price,number) values(?,?,?,?)";
		dbh.update(sql,ss.getPname(),ss.getBrand(),ss.getPrice(),ss.getNumber());
		
	}



		public void deleteById(String pid) throws SQLException {
		DBHelper dbh=new DBHelper();
		String sql=" delete from ph_phone where pid=?" ;
		dbh.update(sql, pid);

	}

}
class StoreMapper implements ResultSetMapper<StorePhone>{
	public StorePhone map(ResultSet rs) {
		StorePhone ss=new StorePhone();
		try {
			
			
			ss.setPid(rs.getInt("pid"));
			ss.setPname(rs.getString("pname"));
			ss.setBrand(rs.getString("brand"));
			ss.setPrice(rs.getString("price"));
			ss.setNumber(rs.getString("number"));
			
			
			
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return ss;
	}
	

}




