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
	var connectionNo=document.forms["gen"]["connectionNo"].value;	
	if(connectionNo=="" ||connectionNo==null || isNaN(connectionNo) || connectionNo.length<8 ||connectionNo.length>8)
	{
		document.getElementById("connnerror").innerHTML=" Enter a valid connection number";
		document.getElementById("connnerror").style.color="red";
		return false;
	}
	else{
		document.getElementById('connnerror').innerHTML = '';
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