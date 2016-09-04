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
	var adjustamt=document.forms["gen"]["adjustamt"].value;	
	var callcost=document.forms["gen"]["callcost"].value;
	var adamt = parseInt(adjustamt);
	var cost = parseInt(callcost);
	if(adjustamt=="" ||adjustamt==null || adjustamt<=0 || isNaN(adjustamt) )
	{
		document.getElementById("ccerror").innerHTML=" Enter a valid amount";
		document.getElementById("ccerror").style.color="red";
		return false;
	}
	
	if(cost < adamt ){
		document.getElementById("ccerror").innerHTML=" Actual call cost amount is less " ;
		document.getElementById("ccerror").style.color="red";
		return false ;
		
	}
	else {
		document.getElementById("ccerror").innerHTML=" " ;
	}

	
	return true ;
}

function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode;
   if (charCode > 31 && (charCode < 46 || charCode > 57))
   {
  	 return false;
   }
   else
   {
  	 return true;
   }
}