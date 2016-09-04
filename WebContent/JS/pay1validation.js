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
		
	var billId=document.forms["gen"]["billId"].value;	
	if(billId=="" ||billId==null || isNaN(billId) || billId.length<6 )
	{
		document.getElementById("payerror").innerHTML=" Enter a valid Bill id";
		document.getElementById("payerror").style.color="red";
		return false;
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