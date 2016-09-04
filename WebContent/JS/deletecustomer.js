function validate()
{
	var delcid=document.forms["del"]["cid"].value;
	var check=/^[0-9]+$/;
	if(delcid=="" || delcid==null)
	{
		
		document.getElementById("iderror").innerHTML="Customer Id must be filled ";
		document.getElementById("iderror").style.color="red";
		return false;
		
	}
	else
	{
		document.getElementById("iderror").innerHTML="";
	}
	
	
	if (!check.test(delcid))
	{
		document.getElementById("iderror").innerHTML="Customer Id must contain only numbers";
		document.getElementById("iderror").style.color="red";
		return false;
	}
	else
	{
		document.getElementById("iderror").innerHTML="";
	}
	 if (delcid.length!=6)
	{
		document.getElementById("iderror").innerHTML="Customer Id must be in 6 digits ";
		document.getElementById("iderror").style.color="red";
		return false;
	}
	 else
	 {
		 document.getElementById("iderror").innerHTML="";
	 }
		
	return true;

}