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
function validate()
{
	
	var cno=document.forms["gen"]["cno"].value;	
	if(cno==" " ||cno==null || isNaN(cno) || cno.length<8 || cno.length>8)
	{
		document.getElementById("conerror").innerHTML=" Enter a valid connection number";
		document.getElementById("conerror").style.color="red";
		return false;
	}
	else{
		document.getElementById('conerror').innerHTML = '';
	}
		 
}

