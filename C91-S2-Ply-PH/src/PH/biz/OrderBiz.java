package PH.biz;

import java.sql.SQLException;

import PH.dao.CartDao;
import PH.dao.OrderDao;

public class OrderBiz {
	
	private OrderDao odao = new OrderDao();
	private CartDao cdao = new CartDao();
	
	public void create(Integer uid, String name, String addr,String phone) throws BizException {
		
		/**
		 * 判断省略
		 * 
		 *
		 * */
		
		try {
			Object oid = odao.insert(uid,name, addr, phone);
			odao.insertOrderItem(uid, oid);
			cdao.deleteByUid(uid);
		} catch (SQLException e) {
			throw new BizException("提交订单失败！",e);
		}
		
	}
	
	public void update(Integer uid) throws BizException {
		try {
			odao.updatByUid(uid);
		} catch(SQLException e) {
			throw new BizException("支付失败！",e);
		}
		
	}
}
