package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connections.DBUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Connection con = DBUtil.getConnection();
		 HttpSession session=request.getSession();  
	     session.setAttribute("email",email); 
	     session.setAttribute("insertAlert", 0);
	     session.setAttribute("acceptOrder", 0);		
		session.setAttribute("OrderId", 0);	
	     session.setAttribute("alertId", 0);
		try {
			Statement st = con.createStatement();
			String sql = "select password,provider,reciever,delivery from user where email = '"+email+"'";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				System.out.println("in if");
				//System.out.println(rs.getString(1));
				if(rs.getString(1).equals(password)){
					int provider = rs.getInt(2);
					int reciever = rs.getInt(3);
					int delivery = rs.getInt(4);
					if(provider==1)
					{
						System.out.println("provider Login successful");
						RequestDispatcher rd = request.getRequestDispatcher("ProviderHome.jsp");
						rd.forward(request, response);
					}
					if(reciever==1)
					{
						System.out.println("reciever Login successful");
						RequestDispatcher rd = request.getRequestDispatcher("RecieverHome.jsp");
						rd.forward(request, response);
					}
					if(delivery==1)
					{
						System.out.println("delivery Login successful");
						RequestDispatcher rd = request.getRequestDispatcher("DeliveryHome.jsp");
						rd.forward(request, response);
					}
					
					 System.out.println("Login successful");
				}
				else {
					PrintWriter pw = response.getWriter();
					pw.println("login failed");
					System.out.println("Login failed");
					RequestDispatcher rd = request.getRequestDispatcher("default.html");
					rd.forward(request, response);
				}
			}
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
