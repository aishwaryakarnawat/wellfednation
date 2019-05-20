package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserBean;
import dao.UserI;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean user = new UserBean();
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		long num =Long.parseLong(request.getParameter("mobile"));
		user.setMobile(num);
		user.setAddress(request.getParameter("address"));
		user.setPostal(Long.parseLong(request.getParameter("postal")));
		user.setCity(request.getParameter("city"));
		user.setPancard(request.getParameter("pan"));
		user.setUserType(request.getParameterValues("usertype"));
		
		System.out.println(user.getUserType());
		
		UserI insertUser = new UserI(user);

		RequestDispatcher rd = request.getRequestDispatcher("default.html");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
