package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.AcceptedOrdersBean;
import connections.DBUtil;

public class AcceptedOrdersI {
	Connection con=DBUtil.getConnection();
	AcceptedOrdersBean aobean;
	
	public AcceptedOrdersI(AcceptedOrdersBean aobean) {
		super();
		this.aobean = aobean;
		System.out.println(aobean.getRecieverEmail());
		
	}


	public int insert() {
		int accepted_orders_id = 0;

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select max(accepted_order_id) from accepted_orders");
						
			if(rs.next())
			{
				accepted_orders_id = rs.getInt(1)+1;
				aobean.setAccepted_order_id(accepted_orders_id);
			}
			else {
				accepted_orders_id=1;
				aobean.setAccepted_order_id(accepted_orders_id);
			}
			String sql = "insert into accepted_orders(accepted_order_id,order_id,provider_email,reciever_email,accepted_plates) values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, accepted_orders_id);
			ps.setInt(2, aobean.getOrder_id());
			ps.setString(3, aobean.getProviderEmail());
			ps.setString(4, aobean.getRecieverEmail());
			ps.setInt(5, aobean.getAccepted_plates());
			ps.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return accepted_orders_id;
	}
	
	
}
