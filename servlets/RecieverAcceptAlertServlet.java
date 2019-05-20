package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.AcceptedOrdersBean;
import dao.AcceptedOrdersI;
import dao.AlertU;

/**
 * Servlet implementation class RecieverAcceptAlertServlet
 */
@WebServlet("/RecieverAcceptAlertServlet")
public class RecieverAcceptAlertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecieverAcceptAlertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderPlates = Integer.parseInt(request.getParameter("orderPlates"));
		String ordeId = request.getParameter("OrderId");
		int ordeIdi=Integer.parseInt(ordeId);
		int plates = Integer.parseInt(request.getParameter("Plates"));
		
		AlertU alertu = new AlertU(orderPlates, plates, ordeIdi);
		
		HttpSession session=request.getSession();
		String remail = (String)session.getAttribute("email");
		String pemail=request.getParameter("Email");
		
		AcceptedOrdersBean aobean = new AcceptedOrdersBean();
		aobean.setOrder_id(ordeIdi);
		//System.out.println(""+orderId);
		aobean.setAccepted_plates(orderPlates);
		//System.out.println(orderPlates);
		aobean.setProviderEmail(pemail);
		//System.out.println(pemail);
		//System.out.println(remail);
		aobean.setRecieverEmail(remail);
		
		AcceptedOrdersI aoi = new AcceptedOrdersI(aobean);
		int orderId = aoi.insert();
		session.setAttribute("acceptOrder", 1);		
		session.setAttribute("OrderId", orderId);	
		RequestDispatcher rd = request.getRequestDispatcher("RecieverHome.jsp");
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
