package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.AlertBean;
import connections.DBUtil;

/**
 * Servlet implementation class ShowAlertServlet
 */
@WebServlet("/ShowAlertServlet")
public class ShowAlertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAlertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = DBUtil.getConnection();
		List<AlertBean> alerts = new ArrayList<>();
		int alertCount = 0;
		ResultSet rs;
		HttpSession session = request.getSession();
		String email = request.getParameter("remail");
		System.out.println("email : "+email);

		Statement st;
		String sql = "select * from alert where email in"
		 		+ "(select email from user where city in"
		 		+ "(select city from user where email='"+email+"')) and left_plates!=0";
	
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			System.out.println("alert query exe");
			while(rs.next())
			{
				AlertBean alert = new AlertBean();
				System.out.println("in alerts while");
				alert.setId(rs.getInt(1));
				alert.setEmail(rs.getString(2));
				alert.setFoodOption(rs.getString(3));
				alert.setFoodType(rs.getString(4));
				alert.setPlates(rs.getInt(8));
				alert.setReqDate(rs.getDate(6));
				alert.setReqTime(rs.getTime(7));
				alert.setLeft_plates(rs.getInt(1));
				alerts.add(alert);
			}
			session.setAttribute("alerts", alerts);
			request.setAttribute("alerts", alerts);
			RequestDispatcher rd = request.getRequestDispatcher("RecieverOrderList.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
