package PH.store;

import java.sql.SQLException;





public class StoreBiz {
	
	private StoreDao sDao=new StoreDao();
	private UserDao ssDao=new UserDao();
	
	//添加商品工具方法
	public void create(StorePhone ss) 
	{
		if(ss.getPname()==null) 
		{
			//****验证****
		}
		try {
			sDao.insert(ss);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	public void delete(String id) 
	{
		if(id==null) 
		{
			//如果没有该pid 就提示不删除
		}
		try {
			sDao.deleteById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	

	public void update(StorePhone ss) {
		try {
			sDao.updateimg(ss);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(User ss) {
		try {
			ssDao.updauser(ss);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
