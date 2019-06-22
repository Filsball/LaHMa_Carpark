function aufruf(input){
	document.getElementById('method').value=input; 
	document.getElementById('startFormular').submit();
}

function setTicketID(){
	var id = prompt("TicketID",0);
	if(id==null) return false;
	document.getElementById("ticketID").value=id;
	return true;
}
