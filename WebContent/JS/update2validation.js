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
	reWhiteSpace = new RegExp(/^\s+$/);
	var resolution=document.forms["gen"]["resolution"].value;
	var cost=document.forms["gen"]["cost"].value;
	if(resolution=="" ||resolution==null)
	{
		document.getElementById("reserror").innerHTML=" Enter a valid reason";
		document.getElementById("reserror").style.color="red";
		return false;
	}
	else{
		document.getElementById('reserror').innerHTML = '';
	}
	if (reWhiteSpace.test(resolution)) { 
		document.getElementById("reserror").innerHTML=" Enter the reason";
		document.getElementById("reserror").style.color="red";
        return false; 
} 
	else{
		document.getElementById('reserror').innerHTML = '';
	}
	if(cost=="" ||cost==null)
	{
		document.getElementById("costerror").innerHTML=" Enter a valid amount";
		document.getElementById("costerror").style.color="red";
		return false;
	}
	else{
		document.getElementById('costerror').innerHTML = '';
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

