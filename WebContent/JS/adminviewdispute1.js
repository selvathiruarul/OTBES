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
	
	var radios=document.getElementsByName("resolve");
	for(var i=0,length=radios.length; i<length; i++)
	{
		if(radios[i].checked == true)
		{
			 return true;
		
		}
		
		}
	
	document.getElementById('raderror').innerHTML= "Select any Bill dispute details to be resolved";
	return false;
	
}