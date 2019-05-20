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
	logo-image: url("hunger.jpg");
	height: 60px;
	width: 92px; 
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
	<h1 style="color: #FFFFFF">Welcome to Delivery Channel...!</h1>

	<input class="button" type="button"
		onclick="location.href='HOME.html';" value="Order List" />
	<input class="button" type="button"
		onclick="location.href='OrderTrack.html';" value="Track Order" />
	<input class="button" type="button"
		onclick="location.href='Notification.html';" value="Notification" />
	<input class="button" type="button"
		onclick="location.href='#Review.html';" value="Review" />
	<br>
	<input class="button" type="button"
		onclick="location.href='#Provider.html';" value="Provider List" />
	<input class="button" type="button"
		onclick="location.href='#Reciever.html';" value="Reciever List" />
	<input class="button" type="button"
		onclick="location.href='#OrderHistory.html';" value="Order History" />

</body>
</html>