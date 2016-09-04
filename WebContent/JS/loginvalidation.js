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
	
	var uName=document.forms["gen"]["uName"].value;	
	var pwd=document.forms["gen"]["pwd"].value;	
	if(uName==" " ||uName==null || isNaN(uName) || uName.length<1 )
	{
		document.getElementById("logerror").innerHTML=" Enter a user name";
		document.getElementById("logerror").style.color="red";
		return false;
	}
	
	if(uName.length<6 || uName.length>6 )
	{
		document.getElementById("logerror").innerHTML=" Enter a valid 6 digit user name";
		document.getElementById("logerror").style.color="red";
		return false;
	}
	else{
		document.getElementById('logerror').innerHTML = '';
	}
	if(pwd==" " ||pwd==null  || pwd.length<1)
	{
		document.getElementById("log1error").innerHTML=" Enter a password";
		document.getElementById("log1error").style.color="red";
		return false;
	}
	if(pwd.length<6 )
	{
		document.getElementById("log1error").innerHTML=" Password should be greater than 5 characters";
		document.getElementById("log1error").style.color="red";
		return false;
	}
	else{
		document.getElementById('log1error').innerHTML = '';
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
function isAlphanemeric(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode;
   if (charCode > 31 && (charCode < 48 || charCode > 57) && (charCode < 65 || charCode > 90)&& (charCode < 97 || charCode > 122))
   {
  	 return false;
   }
   else
   {
  	 return true;
   }
}