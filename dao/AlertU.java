package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;

import connections.DBUtil;

public class AlertU {
int orderPlates;
int plates;
int orderId;
Connection con = DBUtil.getConnection();
public AlertU(int orderPlates,int plates,int orderId) {
	super();
	this.orderPlates = orderPlates;
	this.plates = plates;
	this.orderId=orderId;
	
	String sql = "update alert set left_plates=? where id=?";
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, plates-orderPlates);
		ps.setInt(2, orderId);
		ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
