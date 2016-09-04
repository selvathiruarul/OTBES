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
		
	var disputeId=document.forms["gen"]["disputeId"].value;
	if(disputeId=="" ||disputeId==null || isNaN(disputeId))
	{
		document.getElementById("iderror").innerHTML=" Enter a valid bill dispute Id";
		document.getElementById("iderror").style.color="red";
		return false;
	}
	else{
		document.getElementById('iderror').innerHTML = '';
	}
	return true;
}

function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode;
   if (charCode > 31 && (charCode < 48 || charCode > 57))
   {
  	 return false;
   }
   else
   {
  	 return true;
   }
}