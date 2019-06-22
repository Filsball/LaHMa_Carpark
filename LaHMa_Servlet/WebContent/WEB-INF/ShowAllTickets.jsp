<!DOCTYPE html>
<html>
	<head>
		<title>Aktuelle Tickets</title>
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:300i,400" rel="stylesheet">
		<link href="/LaHMa_Servlet/CSS/fancyButton.css" rel="stylesheet" type="text/css">
		<script src="/LaHMa_Servlet/js/servletConnection.js" type="text/javascript"></script>
		<style>.dummy-positioning {
  width: 100%;
  height: 100vh;
  align-items: center;
  justify-content: center;
}

.success-icon {
  display: inline-block;
  width: 8em;
  height: 8em;
  font-size: 20px;
  border-radius: 50%;
  border: 4px solid #96df8f;
  background-color: #fff;
  position: relative;
  overflow: hidden;
  -webkit-transform-origin: center;
          transform-origin: center;
  -webkit-animation: showSuccess 180ms ease-in-out;
          animation: showSuccess 180ms ease-in-out;
  -webkit-transform: scale(1);
          transform: scale(1);
}

.success-icon__tip, .success-icon__long {
  display: block;
  position: absolute;
  height: 4px;
  background-color: #96df8f;
  border-radius: 10px;
}
.success-icon__tip {
  width: 2.4em;
  top: 4.3em;
  left: 1.4em;
  -webkit-transform: rotate(45deg);
          transform: rotate(45deg);
  -webkit-animation: tipInPlace 300ms ease-in-out;
          animation: tipInPlace 300ms ease-in-out;
  -webkit-animation-fill-mode: forwards;
          animation-fill-mode: forwards;
  -webkit-animation-delay: 180ms;
          animation-delay: 180ms;
  visibility: hidden;
}
.success-icon__long {
  width: 4em;
  -webkit-transform: rotate(-45deg);
          transform: rotate(-45deg);
  top: 3.70em;
  left: 2.75em;
  -webkit-animation: longInPlace 140ms ease-in-out;
          animation: longInPlace 140ms ease-in-out;
  -webkit-animation-fill-mode: forwards;
          animation-fill-mode: forwards;
  visibility: hidden;
  -webkit-animation-delay: 440ms;
          animation-delay: 440ms;
}

@-webkit-keyframes showSuccess {
  from {
    -webkit-transform: scale(0);
            transform: scale(0);
  }
  to {
    -webkit-transform: scale(1);
            transform: scale(1);
  }
}

@keyframes showSuccess {
  from {
    -webkit-transform: scale(0);
            transform: scale(0);
  }
  to {
    -webkit-transform: scale(1);
            transform: scale(1);
  }
}
@-webkit-keyframes tipInPlace {
  from {
    width: 0em;
    top: 0em;
    left: -1.6em;
  }
  to {
    width: 2.4em;
    top: 4.3em;
    left: 1.4em;
    visibility: visible;
  }
}
@keyframes tipInPlace {
  from {
    width: 0em;
    top: 0em;
    left: -1.6em;
  }
  to {
    width: 2.4em;
    top: 4.3em;
    left: 1.4em;
    visibility: visible;
  }
}
@-webkit-keyframes longInPlace {
  from {
    width: 0em;
    top: 5.1em;
    left: 3.2em;
  }
  to {
    width: 4em;
    top: 3.70em;
    left: 2.75em;
    visibility: visible;
  }
}
@keyframes longInPlace {
  from {
    width: 0em;
    top: 5.1em;
    left: 3.2em;
  }
  to {
    width: 4em;
    top: 3.70em;
    left: 2.75em;
    visibility: visible;
  }
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
		<div class="container2">
			<%@ page import="java.util.List, model.*, java.util.Iterator" %>
			<%
				
				List<Ticket> list = TicketDBS.getAktList();
				Iterator<Ticket> iter = list.iterator();
				while(iter.hasNext()){
					Ticket ticket = iter.next();
			%>
				<div class="card" onclick="setTicketID(<%=ticket.getId()%>); aufruf(${answereMethod });">
				    <h3 class="title">Ticket <%=ticket.getId()%></h3>
				    <div class="bar">
				      <div class="emptybar"></div>
				      <div class="filledbar"></div>
				    </div>
				    <div class="circle">
				      <svg version="1.1" xmlns="http://www.w3.org/2000/svg">
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
				  
			<%
					
				}
			%>
		


		<form method="get" action="/LaHMa_Servlet/LaHMa_Controller" id="startFormular">
			<input id="method" name="method" type="hidden">
			<input id="ticketID" name="ticketID" type="hidden">
		</form>
	</body>
</html>

