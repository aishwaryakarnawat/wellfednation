package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.AlertBean;
import dao.AlertI;

/**
 * Servlet implementation class RaiseAlertServlet
 */
@WebServlet("/RaiseAlertServlet")
public class RaiseAlertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RaiseAlertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		AlertBean alert = new AlertBean();

		alert.setEmail(session.getAttribute("email").toString());
		alert.setFoodOption(request.getParameter("foodOption"));
		alert.setFoodType(request.getParameter("foodType"));
		int plates = Integer.parseInt(request.getParameter("plates"));
		alert.setPlates(plates);
		alert.setReqDate(Date.valueOf(request.getParameter("reqDate")));

		/*
		 * SimpleDateFormat t24 = new SimpleDateFormat("HH:mm"); SimpleDateFormat t12 =
		 * new SimpleDateFormat("hh:mm a"); java.util.Date date = null; try { date =
		 * t12.parse(request.getParameter("reqTime")); } catch (ParseException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 * System.out.println(t12.getTimeZone());
		 */
		/*
		 * SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
		 * SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
		 * java.util.Date date = null; try { System.out.println(); date =
		 * parseFormat.parse(request.getParameter("reqTime"));
		 * System.out.println("date "+date); } catch (ParseException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		String time = request.getParameter("reqTime");
		
		/*
		 * System.out.println(time); String s = time; SimpleDateFormat sdf = new
		 * SimpleDateFormat("hh:mm a"); long ms = 0; try { ms = sdf.parse(s).getTime();
		 * System.out.println(ms); } catch (ParseException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */
		DateFormat df = new SimpleDateFormat("HH:mm");
		int hours = 0;
		int min = 0;
		try {
			 hours = df.parse(time).getHours();
			 min = df.parse(time).getMinutes();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Time time2 = new Time(hours, min, 0);
		alert.setReqTime(time2);
		alert.setLeft_plates(plates);
		System.out.println(alert.getReqTime());
		  AlertI alerti = new AlertI(alert);
		  int alertRaised = alerti.insert();
		  int alertId = alerti.getAlertId();
		  session.setAttribute("alertId", alertId);
		  System.out.println("alertid : "+alertId);
		  session.setAttribute("insertAlert", alertRaised);
		//  PrintWriter pw = response.getWriter(); pw.println("Alert Raised");
		RequestDispatcher rd = request.getRequestDispatcher("ProviderHome.jsp");
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
