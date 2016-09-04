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
	var r=document.forms["gen"]["r"].value;	
	if(r=="" ||r==null)
	{
		document.getElementById("reserror").innerHTML=" Enter a valid reason";
		document.getElementById("reserror").style.color="red";
		return false;
	}
	else{
		document.getElementById('reserror').innerHTML = '';
	}
	if (reWhiteSpace.test(r)) { 
		document.getElementById("reserror").innerHTML=" Enter the reason";
		document.getElementById("reserror").style.color="red";
        return false; 
} 
	else{
		document.getElementById('reserror').innerHTML = '';
	}
	return true; 
}