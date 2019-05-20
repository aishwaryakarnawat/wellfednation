<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Well Fed Nation</title>
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
.alert {
  padding: 20px;
  background-color: #f44336;
  color: white;
}
.button {
	height: 106px;
	width: 106px;
	border-radius: 10px;
	background-color: #C38E3F;
	box-shadow: 4px 4px 4px 0 rgba(0, 0, 0, 0.5);
	opacity: 100%;
}

.button-txt {
	padding: 16px;
	height: 48px;
	width: 72px;
	color: #333333;
	font-family: "Open Sans";
	font-size: 18px;
	font-weight: 600;
	line-height: 24px;
	text-align: center;
}
</style>

</head>
<body class="bg-img">

	<div class="logoposition">
		<img src="hunger.png" class="logoimg">
	</div>
	<%if(session.getAttribute("acceptOrder").equals(1)){ %>
		<div class="alert">
	  		<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
					 Your Order has been placed!!! <strong> Order Id : <%out.print(session.getAttribute("OrderId")); %>
					 </strong>
	</div>
	<%}session.setAttribute("acceptOrder", 0); %>
	<h1 style="color: #FFFFFF">Welcome..<%=(String)session.getAttribute("email") %>!</h1>
<table>
<tr>
<td>
	<form action="ShowAlertServlet">
		<% 
		String email = (String)session.getAttribute("email"); %>
		<input type="hidden" name="remail" value="<%=email%>"> 
		<input class="button" type="submit" value="Order List">
	</form></td>

	<td><input class="button" type="submit"
		onclick="location.href='OrderTrack.html';" value="Track Order" /></td>
	
	<td><form action="ShowAlertServlet">
		<% email = request.getParameter("email"); %>
		<input type="hidden" name="email" value="<%=email%>"> 
		<input class="button" type="submit" name="notifications"
			value="Notifications">
	</form></td>
	<td><input class="button" type="button"
		onclick="location.href='#Review.html';" value="Review" /></td></tr>
		<tr><td>
	<input class="button" type="button"
		onclick="location.href='#Provider.html';" value="Provider List" /></td>
	<td><input class="button" type="button"
		onclick="location.href='#Delivery.html';" value="Delivery List" /></td>
	<td><input class="button" type="button"
		onclick="location.href='#OrderHistory.html';" value="Order History" /></td></tr></table>
</body>
</html>