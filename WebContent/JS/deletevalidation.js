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
	var billid=document.forms["gen"]["billid"].value;	
	if(billid=="" ||billid==null || isNaN(billid) || billid.length>6  )
	{
		document.getElementById("bilerror").innerHTML=" Enter a valid Bill Id";
		document.getElementById("bilerror").style.color="red";
		return false;
	}
	 
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