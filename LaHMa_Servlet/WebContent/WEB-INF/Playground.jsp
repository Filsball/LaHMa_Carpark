<!DOCTYPE html>
<html>
	<head>
		<title>Aktuelle Tickets</title>
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:300i,400" rel="stylesheet">
		<link href="/LaHMa_Servlet/CSS/fancyButton.css" rel="stylesheet" type="text/css">
		<script src="/LaHMa_Servlet/js/servletConnection.js" type="text/javascript"></script>
		
		<style>
		
.container {
      position: absolute;
    height: 300px;
    width: 80vw;
    left: calc(50% - 40vw);
    display: flex;
    top: 300px;
}

.card {
  display: flex;
  height: 280px;
  width: 200px;
  background-color: #900c25;
  border-radius: 10px;
  box-shadow: -1rem 0 3rem #000;
/*   margin-left: -50px; */
  transition: 0.4s ease-out;
  position: relative;
  left: 0px;
}

.card:not(:first-child) {
    margin-left: -50px;
}

.card:hover {
  transform: translateY(-20px);
  transition: 0.4s ease-out;
}

.card:hover ~ .card {
  position: relative;
  left: 50px;
  transition: 0.4s ease-out;
}

.title {
  color: white;
  font-weight: 300;
  position: absolute;
  left: 20px;
  top: 15px;
}

.bar {
  position: absolute;
  top: 100px;
  left: 20px;
  height: 5px;
  width: calc(100% - 40px);
}

.emptybar {
  background-color: #2e3033;
  width: 100%;
  height: 100%;
}

.filledbar {
  position: absolute;
  top: 0px;
  z-index: 3;
  width: 0px;
  height: 100%;
  background: rgb(0,154,217);
  background: linear-gradient(90deg, rgba(0,154,217,1) 0%, rgb(147, 220, 255) 65%, rgb(255, 255, 255) 100%);
  transition: 0.6s ease-out;
}

.card:hover .filledbar {
  width: calc(100% - 20px);
  transition: 0.4s ease-out;
}

.circle {
  position: absolute;
  top: 150px;
  left: calc(50% - 60px);
}

.stroke {
  stroke: white;
  stroke-dasharray: 360;
  stroke-dashoffset: 360;
  transition: 0.6s ease-out;
}

svg {
  fill: #840b21;
  stroke-width: 2px;
}

.card:hover .stroke {
  stroke-dashoffset: 100;
  transition: 0.6s ease-out;
}
		</style>
		
		
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
		<div class="container">
			<%@ page import="java.util.List, model.*, java.util.Iterator" %>
			<%
				
				List<Ticket> list = TicketDBS.getAktList();
				Iterator<Ticket> iter = list.iterator();
				while(iter.hasNext()){
					Ticket ticket = iter.next();
			%>
				<div class="card">
				    <h3 class="title">Ticket <%=ticket.getId()%></h3>
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
		


		<form method="get" action="/LaHMa_Servlet/LaHMa_Controller" id="startFormular">
			<input id="method" name="method" type="hidden">
		</form>
	</body>
</html>

