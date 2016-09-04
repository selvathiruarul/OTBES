function disableBackButton()
{
	window.history.forward();
}
setTimeout("disableBackButton()", 0);
function showKeyCode(e)
{
var keycode =(window.event) ? event.keyCode : e.keyCode;

if((keycode == 116))
{
event.keyCode = 0;
event.returnValue = false;
return false;
}
}
function validate()
{
	var id=document.forms["gen"]["dispId"].value;
	if(id==""){
		document.getElementById("iderror").innerHTML = "Select the BillId";
		return false;
	}
    else{
		document.getElementById("iderror").innerHTML = '';
	}
}