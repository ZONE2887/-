package PH.store;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import PH.util.DBHelper;
import PH.util.DBHelper.ResultSetMapper;

public class OrderDao {
	private OrderMapper sMapper=new OrderMapper();
	
	//查询订单
		public List<Order> selectOrdet(int page) {
			String sql="select name ,o.oid,p.pid, p.pname,qty,phone,addr,state from ph_order o left join ph_orderitem i on o.oid=i.oid left join ph_phone p on i.pid=p.pid limit ?,10 ";
			int begin =(page-1)*10;
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
		

		//修改状态
		public void updatestate(Order ss) throws SQLException {
			DBHelper dbh=new DBHelper();
			
			String sql="update ph_order set state=2 where oid=?";
			
			dbh.update(sql,ss.getOid());
			
		}
}
class OrderMapper implements ResultSetMapper<Order>{
	public Order map(ResultSet rs) {
		Order ss=new Order();
		try {
			
			ss.setOid(rs.getInt("oid"));
			ss.setName(rs.getString("name"));
			ss.setPid(rs.getInt("pid"));
			ss.setPhone(rs.getString("phone"));
			  ss.setAddr(rs.getString("addr"));
			
			ss.setQty(rs.getInt("qty"));
			ss.setState(rs.getString("state"));
			
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return ss;
	}
	

}