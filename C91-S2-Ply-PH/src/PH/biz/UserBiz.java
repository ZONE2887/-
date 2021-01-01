package PH.biz;

import java.sql.SQLException;
import java.util.List;

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
			int cnt = udao.countByName(user.getUname());
			if(cnt > 0) {
				throw new BizException("该用户名已被注册");
			}
			udao.insert(user);
		}catch (SQLException e) {
			throw new BizException("系统繁忙，请稍后再试",e);
		}
	}

	public User Login(String uname, String pwd) throws BizException {
		if (uname == null || uname.trim().isEmpty()) {
			throw new BizException("用户名不能为空");
		}
		if (pwd == null || pwd.trim().isEmpty()) {
			throw new BizException("密码不能为空");
		}
		try {
			List<User> list = udao.Login(uname,pwd);
			if (list.size() == 0) {
				throw new BizException("用户名或密码错误");
			}
			System.out.println(list.get(0));
			return list.get(0);
		} catch (SQLException e) {
			throw new BizException("系统繁忙 请联系管理员");
		}
	}
}
