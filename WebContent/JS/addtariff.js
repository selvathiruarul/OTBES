function tariff()
{
	var tariffname = document.forms["form1"]["tariffName"].value;
	var lpr = document.forms["form1"]["localpulseRate"].value;
	var pattern=/^([PLAN])+([0-9]{3,4})$/;

	var ratecheck=/^([0-9]{0,2})+\.([0-9]{2})$/;
	var spr = document.forms["form1"]["stdpulseRate"].value;
	var ipr = document.forms["form1"]["isdpulseRate"].value;
	var mr=document.forms["form1"]["monthlyRental"].value;
	
	if (tariffname == null || tariffname == "") {
		document.getElementById("fnerror").innerHTML = "tariff Name must be filled out";
		return false;
	} else {
		document.getElementById("fnerror").innerHTML = "";

	}
	
	
	if(!pattern.test(tariffname))
	{
		document.getElementById("fnerror").innerHTML = "Invalid tariff name";
		return false;
	}
	else {
		document.getElementById("fnerror").innerHTML = "";

	}
	
	if (lpr == null || lpr == "") {
		document.getElementById("lnerror").innerHTML = "Local pulse rate must be filled out";
		return false;
	} else {
		document.getElementById("lnerror").innerHTML = "";

	}
	
	if(!ratecheck.test(lpr))
	{
		document.getElementById("lnerror").innerHTML = "Invalid Local pulse rate ";
		return false;
	}
	 else {
			document.getElementById("lnerror").innerHTML = "";

		}
	
	if (spr == null || spr == "") {
		document.getElementById("snerror").innerHTML = "Std pulse rate must be filled out";
		return false;
	} else {
		document.getElementById("snerror").innerHTML = "";

	}
	
	if(!ratecheck.test(spr))
	{
		document.getElementById("snerror").innerHTML = "Invalid Std pulse rate ";
		return false;
	}
	 else {
			document.getElementById("snerror").innerHTML = "";

		}
		
	
	if (ipr == null || ipr == "") {
		document.getElementById("inerror").innerHTML = "Isd pulse rate must be filled out";
		return false;
	} else {
		document.getElementById("inerror").innerHTML = "";

	}
	
	if(!ratecheck.test(ipr))
	{
		document.getElementById("inerror").innerHTML = "Invalid Isd pulse rate ";
		return false;
	}
	 else {
			document.getElementById("inerror").innerHTML = "";

		}
	
	if(mr==null ||mr =="")
	{
		document.getElementById("mnerror").innerHTML = "Monthly rent must be filled out";
		return false;
	}
	else
	{
		document.getElementById("mnerror").innerHTML = "";
	}
	
	
	return true;
}
function rentcheck()
{
	
	var tariffname = document.getElementById("tn").value;
	var rent=tariffname.substring(4,tariffname.length+1);
	document.forms["form1"]["monthlyRental"].value=rent;
}

function updatetariff()
{
	
	var lpr = document.forms["form1"]["localpulseRate"].value;
	var ratecheck=/^([0-9]{0,2})+\.([0-9]{2})$/;
	var spr = document.forms["form1"]["stdpulseRate"].value;
	var ipr = document.forms["form1"]["isdpulseRate"].value;
	
	if (lpr == null || lpr == "") {
		document.getElementById("lnerror").innerHTML = "Local pulse rate must be filled out";
		return false;
	} else {
		document.getElementById("lnerror").innerHTML = "";

	}
	
	if(!ratecheck.test(lpr))
	{
		document.getElementById("lnerror").innerHTML = "Invalid Local pulse rate ";
		return false;
	}
	 else {
			document.getElementById("lnerror").innerHTML = "";

		}
	
	if (spr == null || spr == "") {
		document.getElementById("snerror").innerHTML = "Std pulse rate must be filled out";
		return false;
	} else {
		document.getElementById("snerror").innerHTML = "";

	}
	
	if(!ratecheck.test(spr))
	{
		document.getElementById("snerror").innerHTML = "Invalid Std pulse rate ";
		return false;
	}
	 else {
			document.getElementById("snerror").innerHTML = "";

		}
		
	
	if (ipr == null || ipr == "") {
		document.getElementById("inerror").innerHTML = "Isd pulse rate must be filled out";
		return false;
	} else {
		document.getElementById("inerror").innerHTML = "";

	}
	
	if(!ratecheck.test(ipr))
	{
		document.getElementById("inerror").innerHTML = "Invalid Isd pulse rate ";
		return false;
	}
	 else {
			document.getElementById("inerror").innerHTML = "";

		}

}


