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
		
	var custId=document.forms["gen"]["custId"].value;	
	if(custId=="" ||custId==null || isNaN(custId) || custId.length<6 ||custId.length>6)
	{
		document.getElementById("cust1error").innerHTML=" Enter a valid customer id";
		document.getElementById("cust1error").style.color="red";
		return false;
	}
	else{
		document.getElementById('cust1error').innerHTML = '';
	}
	return true;
	}