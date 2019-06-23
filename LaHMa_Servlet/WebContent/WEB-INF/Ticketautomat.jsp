<!DOCTYPE html>
<html>
	<head>
		<title>Ticketautomat</title>
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
					<div class="neon">${freeSpots } </div>
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
				<li onclick="aufruf('selectTicket')">Entwerte Ticket</li>
				<li onclick="if(setTicketID())aufruf('scanAbo')">Scanne Abo-Ticket</li>
				<li onclick="aufruf('abo')">Abo Optionen</li>
				<li onclick="aufruf('back')">Zurück</li>
			</ul>
		</nav>
		<%@ page import="model.Ticket" %>
		<% 
			Ticket ticket = (Ticket) request.getAttribute("ticket");
			if(ticket != null){
		%>	
		<div class="container2">
			<div class="card" onclick="setTicketID(<%=ticket.getId()%>); aufruf('${answereMethod }');">
			    <h3 class="title">Ticket <%=ticket.getId()%></h3>
			    <div class="bar">
			      <div class="emptybar"></div>
			      <div class="filledbar"></div>
			    </div>
			    <div class="circle  <%if(ticket.getEnt()!= null){%> successCircle <%}%>">
			    <%if(ticket.getEnt()== null){%>
			      <svg version="1.1" xmlns="http://www.w3.org/2000/svg">
			    <%} %>
			      <circle class="stroke" cx="60" cy="60" r="50"/>
			    </svg>
			    <%if(ticket.getEnt()!= null){%>
			    	<div class="dummy-positioning d-flex">  
					  <div class="success-icon">
					    <div class="success-icon__tip"></div>
					    <div class="success-icon__long"></div>
					  </div>						  
					</div>
			    <%} %>
			    
			    </div>
			  </div>
		
		</div>	
				
		<%		
			}
		
		%>
		
		<form method="get" action="/LaHMa_Servlet/LaHMa_Controller" id="startFormular">
			<input id="method" name="method" type="hidden">
			<input id="ticketID" name="ticketID" type="hidden">
		</form>
	</body>
</html>

