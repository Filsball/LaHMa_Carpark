<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300i,400" rel="stylesheet">
<link href="/LaHMa_Servlet/CSS/fancyButton.css" rel="stylesheet" type="text/css">
<script type="text/javascript">function aufruf(input){document.getElementById('method').value=input.value; document.getElementById('startFormular').submit();}</script>
</head>
<body>
<div class="header">
  <h1 contenteditable spellcheck="false">LaHMa Park</h1>
</div>
<nav>
  <ul>
    <li value="einfahren" onclick="aufruf(this);">Einfahren</li>
    <li value="bezahlen" onclick="aufruf(this);">bezahle Ticket</li>
    <li value="ausfahren" onclick="aufruf(this);">fahre aus</li>
    <li value="bilanz" onclick="aufruf(this);">Bilanzen einsehen</li>
    <li value="abo" onclick="aufruf(this);">Abonnentenoptionen</li>
  </ul>
</nav>


<input type="hidden" id="method">
</body>
</html>
