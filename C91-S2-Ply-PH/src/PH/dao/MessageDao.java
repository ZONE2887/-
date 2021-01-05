package PH.dao;

import java.sql.SQLException;

import PH.bean.Message;
import PH.bean.User;
import PH.util.DBHelper;

public class MessageDao {
	public void insert(Message message) throws SQLException{
		String sql = "insert into ph_talk values(null,?,?,?,?,?)";
		DBHelper.update(sql,
				message.getUid(),
				message.getUname(),
				message.getEmail(),
				message.getPhonenum(),
				message.getMessage());
			  
	}
}	
