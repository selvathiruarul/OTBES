function reasonforcancellation() {
	var reason1 = document.forms["f1"]["reason"].value;
	
	if (reason1 == null || reason1 == "") {
		document.getElementById("rerror").innerHTML = "Reason must be filled out ";
		return false;
	} else {
		document.getElementById("rerror").innerHTML = " ";
	}
	if (reason1.length < 10) {
		document.getElementById("rerror").innerHTML = "Reason must be greater than 15 characters";
		return false;
	} else {
		document.getElementById("rerror").innerHTML = " ";
	}
	return true;
}

function validate()
{

	var custid=document.forms["f1"]["custid"].value;

	if(custid==null || custid=="")
	{
		document.getElementById("error").innerHTML="Please enter the Customer ID";
		return false;
	}
	else
	{
		document.getElementById("error").innerHTML="";
	}
	
	if(isNaN(custid))
	{
		document.getElementById("error").innerHTML="non numeric character not allowed";
		return false;   
	}  
	else
	{
		document.getElementById("error").innerHTML="";
	}
	if(custid.length!=6)
	{
		document.getElementById("error").innerHTML="Customer ID should be 6 digits";
			return false;
	}
	else
	{
		document.getElementById("error").innerHTML="";
	}
 
	return true;
}
