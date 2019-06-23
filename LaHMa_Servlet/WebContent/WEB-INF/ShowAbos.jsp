<!DOCTYPE html>
<html>
	<head>
		<title>Aktuelle Tickets</title>
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
		<div class="container2">
			<%@ page import="java.util.List, model.*, java.util.Iterator" %>
			<%
				
				List<Abo> list = AboDBS.getAktuelleAbos();
				Iterator<Abo> iter = list.iterator();
				while(iter.hasNext()){
					Abo abo = iter.next();
			%>
				<div class="card" onclick="setAboID(<%=abo.getId()%>); aufruf(${answereMethod });">
				    <h3 class="title">Abo <%=abo.getId()%></h3>
				    <div class="bar">
				      <div class="emptybar"></div>
				      <div class="filledbar"></div>
				    </div>
				    <div class="circle">
				      <svg version="1.1" xmlns="http://www.w3.org/2000/svg">
				      <circle class="stroke" cx="60" cy="60" r="50"/>
				    </svg>
				    </div>
				  </div>
				  
			<%
					
				}
			%>
		
		</div>


		<form method="get" action="/LaHMa_Servlet/LaHMa_Controller" id="startFormular">
			<input id="method" name="method" type="hidden">
			<input id="ticketID" name="ticketID" type="hidden">
		</form>
	</body>
</html>

