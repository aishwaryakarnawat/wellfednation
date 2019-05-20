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

table, th, td {
	
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
	height: 41px;
	width: 72px;
	color: #FFFFFF;
	font-family: "Open Sans";
	font-size: 30px;
	font-weight: bold;
	line-height: 41px;
}

/* Set a style for all buttons*/
button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

button:hover {
	opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
	width: 100%;
	padding: 10px 18px;
	background-color: #f44336;
	height : 45px;
}

/* Center the image and position the close button */
.closecontainer {
	text-align: center;
	margin: 24px 0 12px 0;
	position: relative;
}

.radiobutton {
	height: 21px;
	width: 21px;
}

.container {
	padding: 16px;
}

.containerend {
	padding: 16px;
	top: 658px;
	left: 361px;
	right: 838px;
	bottom: 86px;
	float: right;
}

.inputforradiobutton {
	left: 258px;
	right: 967px;
	height: 27px;
	width: 55px;
}

span.psw {
	float: right;
	padding-top: 16px;
}

/* Modal Content/Box */
.modal-content {
	float: left;
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	height: 615px;
	width: 497px;
	border-radius: 2px;
	background-color: #4A4A4A;
}

/* The Close Button (x) */
.close {
	position: absolute;
	right: 25px;
	top: 0;
	color: #000;
	font-size: 35px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: red;
	cursor: pointer;
}

/* Add Zoom Animation */
.animate {
	-webkit-animation: animatezoom 0.6s;
	animation: animatezoom 0.6s
}

@
-webkit-keyframes animatezoom {
	from {-webkit-transform: scale(0)
}

to {
	-webkit-transform: scale(1)
}

}
@
keyframes animatezoom {
	from {transform: scale(0)
}

to {
	transform: scale(1)
}

}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</style>
</head>
<body class="bg-img">
	<div class="logoposition">
		<img src="hunger.png" class="logoimg">
	</div>
	<div id="myDiv">
		<form class="modal-content animate" action="RecieverAcceptAlertServlet" method="post">
			<div class="container" style="color: #FFFFFF">
				<table style="width: 100%">
					<tr>
						<td>Option :</td>
						<td><% out.print(request.getParameter("FoodOption"));%></td>
					</tr>
					<tr>
						<td>Type :</td>
						<td><%=request.getParameter("FoodType")%></td>
					</tr>
					<tr>
						<td>Plates Available :</td>
						<td><%=request.getParameter("Plates")%></td>
					</tr>
					<tr>
						<td>Date :</td>
						<td><%=request.getParameter("ReqDate")%></td>
					</tr>
					<tr>
						<td>Time :</td>
						<td><%=request.getParameter("ReqTime")%></td>
					</tr>
					<tr>
						<td>Provider :</td>
						<td><%=request.getParameter("Email")%></td>
					</tr>
					<tr>
						<td>I need </td>
						<td><input type="number" name="orderPlates"></td>
						<td>number of plates</td>
					</tr>
					<input type="hidden" name="remail" value="<%=(String)session.getAttribute("email")%>">
					<input type="hidden" name="Email" value="<%=request.getParameter("Email")%>">
					<input type="hidden" name="FoodOption" value="<%=request.getParameter("FoodOption")%>">
					<input type="hidden" name="FoodType" value="<%=request.getParameter("FoodType")%>">
					<input type="hidden" name="Plates" value="<%=request.getParameter("Plates")%>">
					<input type="hidden" name="ReqDate" value="<%=request.getParameter("ReqDate")%>">
					<input type="hidden" name="ReqTime" value="<%=request.getParameter("ReqTime")%>">
					<input type="hidden" name="OrderId" value="<%=request.getParameter("OrderId")%>">
					</table>
			</div>

				<button type="submit" class="w3-button w3-green">Confirm</button>
				<button type="reset" class="cancelbtn">Cancel</button>
		</form>
	</div>
</body>
</html>