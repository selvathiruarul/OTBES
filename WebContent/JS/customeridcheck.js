function validate()
{
	var delcid=document.forms["f1"]["custid"].value;
	var check=/^[0-9]+$/;
	if(delcid=="" || delcid==null)
	{
		
		document.getElementById("error").innerHTML="Customer Id must be filled ";
		document.getElementById("error").style.color="red";
		return false;
		
	}
	
	
	else if (!check.test(delcid))
	{
		document.getElementById("error").innerHTML="Customer Id must contain only numbers";
		document.getElementById("error").style.color="red";
		return false;
	}
	else if (delcid.length!=6)
	{
		document.getElementById("error").innerHTML="Customer Id must be in 6 digits ";
		document.getElementById("error").style.color="red";
		return false;
	}
		
	return true;

}