package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

import beans.AlertBean;
import connections.DBUtil;

public class AlertI {
	Connection con = DBUtil.getConnection();
	AlertBean alert;
	
	public AlertI(AlertBean alert) {
		super();
		this.alert = alert;
	}
	
	public int insert() {
		int success = 0;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select max(id) from alert");
			int id;
			
			if(rs.next())
			{
				id = rs.getInt(1)+1;
				alert.setId(id);
			}
			else {
				id=1;
				alert.setId(id);
			}
			String sql = "insert into alert(id,email,food_option,food_type,plates,req_date,req_time,left_plates) values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, alert.getEmail());
			ps.setString(3, alert.getFoodOption());
			ps.setString(4, alert.getFoodType());
			ps.setInt(5, alert.getPlates());
			ps.setDate(6, alert.getReqDate());
			System.out.println("working");
			ps.setTime(7, alert.getReqTime());
			ps.setInt(8, alert.getPlates());
			System.out.println("still working");
			success=ps.executeUpdate();
			
			System.out.println("Alert inserted successfully");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
	public int getAlertId() {
		return alert.getId();
	}
	
}
