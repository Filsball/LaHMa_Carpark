<!DOCTYPE html>
<html>
	<head>
		<title>Startseite</title>
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:300i,400" rel="stylesheet">
		<link href="/LaHMa_Servlet/CSS/fancyButton.css" rel="stylesheet" type="text/css">
		<script src="/LaHMa_Servlet/js/servletConnection.js" type="text/javascript"></script>
	</head>
	<body>
		<div class="header">
			<h1>LaHMa Park</h1>
			<div class="parent">
				<div class="container">
					<div class="neon">noch frei: </div>
					<div class="neon">27 </div>
				</div>
			</div>
			<div class="parent2">
				<div class="container">
					<div class="neon">open: </div>
					<div class="neon">24/7 </div>
				</div>
			</div>
		</div>
		<nav>
			<ul>
				<li onclick="if(setTicketID())aufruf('checkTicket')">Führe Ticket ein</li>
				<li onclick="if(setTicketID())aufruf('scanAbo')">Scanne Abo-Ticket</li>
				<li onclick="aufruf('back')">Verlassen</li>
			</ul>
		</nav>

		<form method="get" action="/LaHMa_Servlet/LaHMa_Controller" id="startFormular">
			<input id="method" name="method" type="hidden">
			<input id="ticketID" name="ticketID" type="hidden">
		</form>
	</body>
</html>

