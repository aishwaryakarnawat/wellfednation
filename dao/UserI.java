package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import beans.UserBean;
import connections.DBUtil;

public class UserI {
	Connection con = DBUtil.getConnection();
	UserBean user;
	
	UserI(){
		user = new UserBean();
	}
	
	public UserI(UserBean user){
		
		this.user=user;
	
		try {
			PreparedStatement ps = con.prepareStatement("insert into user(email,password,mobile,address,postal,city,pan,provider,reciever,delivery)"
				+ " values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setLong(3, user.getMobile());
			ps.setString(4, user.getAddress());
			ps.setLong(5, user.getPostal());
			ps.setString(6, user.getCity());
			ps.setString(7, user.getPancard());
			ps.setInt(8, user.getProvider());
			ps.setInt(9, user.getReciever());
			ps.setInt(10, user.getDelivery());
			ps.executeUpdate();
			
			System.out.println("User Added successfully");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
