<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">function aufruf(input){document.getElementById('method').value=input.value; document.getElementById('startFormular').submit();}</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ausfahrautomat</title>
</head>
<body>
<form method="get" action="/LaHMa_Servlet/LaHMa_Controller" id="startFormular">
<input type="hidden" value="" name="method" id="method">
<input type="button" value="Lese Ticket" onclick="aufruf(this);">
<input type="button" value="Scanne Abo" onclick="aufruf(this);">
</form>
</body>
</html>