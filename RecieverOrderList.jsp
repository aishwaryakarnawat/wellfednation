<%@page import="java.io.Writer"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.AlertBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body, html {
	height: 100%;
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box;
}

.bg-img {
	/* The image used */
	background-image: url("BG_Image.png");
	/* min-height: 840px;*/
	height: 100%;
	/* Center and scale the image nicely */
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	position: relative;
	background-attachment: fixed;
	padding: 14px 16px;
	opacity: 0.8;
}

.logoposition {
	top: 30px;
	left: 30px;
	right: 1178px;
	bottom: 697;
}

.logoimg {
	logo-image: url("hunger.png");
	height: 60px;
	width: 92px; 
	color: #FFFFFF;
	font-family: "Open Sans";
	font-size: 30px;
	font-weight: bold;
	line-height: 41px;
}

.notification {
	float: center;
	color: #FFFFFF;
	height: 200px;
	width: 497px;
	border: 50px solid #9B9B9B;
	opacity: 0.6;
	border-radius: 4px;
	background-color: #333333;
	margin-bottom: 5%;
}

.td {
	width: 497px;
	float: center;
}

.tr {
	margin-bottom: 50%;
}

.notificationtext {
	height: 24px;
	width: 234px;
	color: #FFFFFF;
	font-family: "Open Sans";
	font-size: 18px;
	font-weight: 600;
	line-height: 24px;
	text-align: center;
}

/* Modal Content/Box */
.modal-content {
	float: center;
	border: 1px solid #888;
	height: auto;
	width: 497px;
	border-radius: 2px;
	background-color: #4A4A4A;
}
</style>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="bg-img">
	<div class="logoposition">
		<img src="hunger.png" class="logoimg">
	</div>
	<h1 style="color: #FFFFFF">Available Orders</h1>
	<div class="modal-content">
		<form action="RecieverConfirmOrder.jsp">
			<table>
				<%
		List<AlertBean> alerts = new ArrayList<>();
		alerts=(List<AlertBean>)session.getAttribute("alerts");
		String remail = (String)session.getAttribute("email");
		Iterator<AlertBean> iterator = alerts.iterator();
		while(iterator.hasNext()){
			AlertBean alert = new AlertBean();
			alert = iterator.next();
	%>
				<tr class="notification">
					<td class="td">
						Option : <%out.write(alert.getFoodOption());%><br> 
						Type : <%out.write(alert.getFoodType()); %><br>
						Plates : <%out.print(alert.getPlates()); %><br> 
						Date : <%out.write(alert.getReqDate().toString()); %><br>
						Time : <%out.write(alert.getReqTime().toString()); %><br>
						Provider : <%out.write(alert.getEmail()); %><br>
						<%int id = alert.getId(); %>
						<input type="hidden" name="OrderId" value="<%=id%>">
						<% System.out.println("oid : "+alert.getId()); %>
						
						<%String email=alert.getEmail(); %>
						<input type="hidden" name="Email" value="<%=alert.getFoodType()%>">
						
						<%String FoodOption=alert.getFoodOption(); %>
						<input type="hidden" name="FoodOption" value="<%=FoodOption%>"> 
						
						<%String FoodType=alert.getFoodType(); %>
						<input type="hidden" name="FoodType" value="<%=FoodType%>"> 
						
						<%int Plates=alert.getPlates(); %>
						<input type="hidden" name="Plates" value="<%=Plates%>">
						
						<%String ReqDate=alert.getReqDate().toString(); %>
						<input type="hidden" name="ReqDate" value="<%=ReqDate%>"> 
						
						<%String ReqTime=alert.getReqTime().toString(); %>
						<input type="hidden" name="ReqTime" value="<%=ReqTime%>">
						<input type="submit" value="Accept" class="w3-button w3-green">
						
						
						</td>
				</tr>
				<%} %>
			</table>
		</form>
	</div>
</body>
</html>