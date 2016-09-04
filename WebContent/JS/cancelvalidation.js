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
	var reasons=document.forms["gen"]["reasons"].value;
	if(reasons=="" ||reasons==null )
	{
		document.getElementById("canerror").innerHTML=" Enter the reason";
		document.getElementById("canerror").style.color="red";
		return false;
	}
	else
	{
		document.getElementById("canerror").innerHTML=" ";
	}
	if (reWhiteSpace.test(reasons)) { 
		document.getElementById("canerror").innerHTML=" Enter the proper reason";
		document.getElementById("canerror").style.color="red";
        return false; 
} 
	else
	{
		document.getElementById("canerror").innerHTML=" ";
	}

	return true;
	}