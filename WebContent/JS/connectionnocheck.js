function validate()
{
	
	var connectionNo=document.forms["form1"]["connectionNo"].value;
	var numcheck = /^[0-9]+$/;
	if(connectionNo==null || connectionNo=="")
	{
		document.getElementById("error").innerHTML="Enter the connection number";
		return false;
	}
	else
	{
		document.getElementById("error").innerHTML="";
	}
	if(!numcheck.test(connectionNo))
	{
		document.getElementById("error").innerHTML="Enter numbers only";
		return false;
	}
	else
	{
		document.getElementById("error").innerHTML="";
	}
	
	
	if(connectionNo.length!=8)
	{
		document.getElementById("error").innerHTML="Connection Number should be 8 digits";
			return false;
	}
	return true;
}
function updateCallDetails()
{
	
	
	var duration=document.forms["form1"]["duration"].value;
	var intcheck = /^[0-9]+$/;


	
	if(duration==null || duration=="")
	{
		document.getElementById("duerror").innerHTML="please enter the duration of call";
		return false;
	}
	else
	{
		document.getElementById("duerror").innerHTML="";
	}
	
	if(!intcheck.test(duration))
	{
		document.getElementById("duerror").innerHTML="Invalid duration of call";
		return false;
	}
	else
	{
		document.getElementById("duerror").innerHTML="";
	}
			
	return true;
}






