package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.AlertBean;
import connections.DBUtil;

public class DeliveryAlertsAll {
	Connection con = DBUtil.getConnection();
	AlertBean alert;
	List<AlertBean> allAlerts = new ArrayList<>();
	public List<AlertBean> allAlerts() {
		try {
			Statement st = con.createStatement();
			String sql = "select id,email,req_date,req_time from alert where id not in (select id from accepted_orders)";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				alert.setId(rs.getInt(1));
				alert.setEmail(rs.getString(2));
				alert.setReqDate((rs.getDate(3)));
				alert.setReqTime(rs.getTime(4));
				allAlerts.add(alert);
				alert=null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allAlerts;
	}
}
