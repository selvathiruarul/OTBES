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
	var custid=document.forms["gen"]["custid"].value;	
	var id=document.forms["gen"]["id"].value;
	var r=document.forms["gen"]["r"].value;
	
	if(custid=="" ||custid==null || isNaN(custid) || custid.length<6 ||custid.length>6)
	{
		document.getElementById("custerror").innerHTML=" Enter a valid customer id";
		document.getElementById("custerror").style.color="red";
		return false;
	}
	else
	{
		document.getElementById("custerror").innerHTML=" ";
	}
	if(id=="" ||id==null || isNaN(id) || id.length>7 || id.length<7  )
	{
		document.getElementById("bilit1error").innerHTML=" Enter a valid Bill Item Id";
		document.getElementById("bilit1error").style.color="red";
		return false;
	}
	else
	{
		document.getElementById("bilit1error").innerHTML=" ";
	}
	if(r=="" ||r==null )
	{
		document.getElementById("reaserror").innerHTML=" Enter the reason";
		document.getElementById("reaserror").style.color="red";
		return false;
	}
	else
	{
		document.getElementById("reaserror").innerHTML=" ";
	}
	if (reWhiteSpace.test(r)) { 
		document.getElementById("reaserror").innerHTML=" Enter the valid reason";
		document.getElementById("reaserror").style.color="red";
        return false; 
}
	else
	{
		document.getElementById("reaserror").innerHTML=" ";
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