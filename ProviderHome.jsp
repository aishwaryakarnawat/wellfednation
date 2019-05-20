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
.alert {
  padding: 20px;
  background-color: #f44336;
  color: white;
}

.closebtn {
  margin-left: 15px;
  color: white;
  font-weight: bold;
  float: right;
  font-size: 22px;
  line-height: 20px;
  cursor: pointer;
  transition: 0.3s;
}

.closebtn:hover {
  color: black;
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
	logo-image: url("hunger.jpg");
	height: 41px;
	width: 72px;
	color: #FFFFFF;
	font-family: "Open Sans";
	font-size: 30px;
	font-weight: bold;
	line-height: 41px;
}

.button {
	height: 106px;
	width: 106px;
	border-radius: 10px;
	background-color: #CDB556;
	box-shadow: 4px 4px 4px 0 rgba(0, 0, 0, 0.5);
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
		<img src="hunger.jpg" class="logoimg">
	</div>
	<%if(session.getAttribute("insertAlert").equals(1)){ %>
		<div class="alert">
	  		<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
					 Your Order has been placed!!! <strong> Order Id : <%out.print(session.getAttribute("alertId")); %></strong>
	</div>
	<%}session.setAttribute("insertAlert", 0); %>
	<h1 style="color: #FFFFFF">Welcome <%=session.getAttribute("email") %>...!</h1>

	<input class="button" type="button"
		onclick="location.href='RaiseAlert.html';" value="Raise Order" />
	<input class="button" type="button"
		onclick="location.href='OrderTrack.html';" value="Track Order" />
	<input class="button" type="button"
		onclick="location.href='Notification.html';" value="Notification" />
	<input class="button" type="button"
		onclick="location.href='#Review.html';" value="Review" />
	<br>
	<input class="button" type="button"
		onclick="location.href='#DeliveryList.html';" value="Delivery List" />
	<input class="button" type="button"
		onclick="location.href='#RecieverList.html';" value="Reciever List" />
	<input class="button" type="button"
		onclick="location.href='#OrderHistory.html';" value="Order History" />

</body>
</html>