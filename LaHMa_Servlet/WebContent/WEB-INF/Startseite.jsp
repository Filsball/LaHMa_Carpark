<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/LaHMa_Servlet/CSS/fancyButton.css" rel="stylesheet" type="text/css">
<script type="text/javascript">function aufruf(input){document.getElementById('method').value=input.value; document.getElementById('startFormular').submit();}</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LaHMa Park</title>
<style>
body 	{height: 100vh;
		background-image: linear-gradient(to bottom, hsl(0, 100%, 30%), hsla(0, 100%, 90%, 0.3));}
.button1 {border-radius: 25px;
		  background: #73AD21;
		  padding: 20px; 
		  width: 200px;
		  height: 150px; 
		  }
</style>
</head>
<body>
<form method="get" action="/LaHMa_Servlet/LaHMa_Controller" id="startFormular">
<h1 contenteditable spellcheck="false">LaHMa Park</h1>
<input type="hidden" value="" name="method" id="method">
<button class="button" value="Einfahren" onclick="aufruf(this);">
<span class="button__inner">Einfahren</span>
</button>
<button class="button" value="Ausfahren" onclick="aufruf(this);">
<span class="button__inner">Ausfahren</span>
</button>
<button class="button" value="Ticket entwerten" onclick="aufruf(this);">
<span class="button__inner">Ticket entwerten</span>
</button>
</form>
</body>
</html>