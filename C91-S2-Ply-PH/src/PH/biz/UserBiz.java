package PH.biz;

import java.sql.SQLException;

import PH.bean.User;
import PH.dao.UserDao;



public class UserBiz {
	private UserDao udao = new UserDao();
	
	public void register(User user) throws BizException{
		if(user.getUname() ==null || user.getUname().isEmpty()) {
			throw new BizException("请填写用户名");
		}
		if(user.getPhonenum() ==null || user.getPhonenum().isEmpty()) {
			throw new BizException("请填写电话");
		}
		
		try {
			int cnt = udao.countByUname(user.getUname());
			if(cnt > 0) {
				throw new BizException("该用户名已被注册");
			}
			udao.insert(user);
		}catch (SQLException e) {
			throw new BizException("系统繁忙，请稍后再试",e);
		}
	}

}
