function validate()
{
	var bill=document.forms["f1"]["Typeofbill"].value;
	
	if(bill!="eBill"  &&  bill!="paperBill")
	{
		
		document.getElementById("error").innerHTML="Invalid type of bill";
		return false;
	}
	else
	{
		document.getElementById("error").innerHTML="";
		

	}
	
	return true;

	
	
	
}