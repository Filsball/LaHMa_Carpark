
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300i,400" rel="stylesheet">
<link href="/LaHMa_Servlet/CSS/fancyButton.css" rel="stylesheet" type="text/css">
<script type="text/javascript">function aufruf(input){document.getElementById('method').value=input; document.getElementById('startFormular').submit();}</script>
</head>
<body>
<div class="header">
  <h1 contenteditable spellcheck="false">LaHMa Park</h1>
  <div class="parent">
  <div class="container">
  <div class="neon">noch frei: </div>
  <div class="neon">27 </div>
  </div>
</div>
</div>
<nav>
  <ul>
    <li>löse Ticket</li>
    <li onclick="aufruf('Ticketautomat')">Ticketautomat</li>
    <li>fahre aus</li>
    <li>Manageroptionen</li>
  </ul>
</nav>

<form method="get" action="/LaHMa_Servlet/LaHMa_Controller">
<input type="hidden">
</form>
</body>
</html>

