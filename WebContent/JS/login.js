function validate()
{
	var un=document.forms["login"]["uName"].value;
	var pwd1=document.forms["login"]["pwd"].value;
	var check = /^[0-9]+$/;
	
	
	if(un==null || un=="")
	{
		document.getElementById("unerror").innerHTML="Enter the user name";
		return false;
	}
	else
	{
		document.getElementById("unerror").innerHTML="";
		
	}
	if (!check.test(un)) 
	{
		document.getElementById("unerror").innerHTML = "Invalid username ";
		return false;
	} else 
	{

		document.getElementById("unnerror").innerHTML = "";
	}

	
	if(pwd1==null || pwd1=="")
	{
		document.getElementById("pwderror").innerHTML="Enter the password";
		return false;
	}
	else
	{
		document.getElementById("pwderror").innerHTML="";
		
	}
	return true;
}
