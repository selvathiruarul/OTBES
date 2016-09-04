function validate()
{
	var lr=document.forms["f1"]["localpulseRate"].value;
	var local=document.forms["f1"]["localUnit"].value;
	var stdr=document.forms["f1"]["stdpulseRate"].value;
	var std=document.forms["f1"]["stdUnit"].value;
	var isdr=document.forms["f1"]["isdpulseRate"].value;
	var isd=document.forms["f1"]["isdUnit"].value;
	
	var rent=document.forms["f1"]["monthlyRental"].value;
	var ratecheck = /^[0-9]+\.[0-9]$/;
	var rentcheck=/^[0-9 ]$/;
	
	
	if (lr==null || lr=="")
	{
		document.getElementById("lnerror").innerHTML="provide valid local call rate";
	  return false;
	  }
	else
	{
		document.getElementById("lnerror").innerHTML="";

	}
	if(!ratecheck.test(lr))
	{
		document.getElementById("lnerror").innerHTML="invalid local pulse rate";
	  return false;
	  }
	else
	{
		document.getElementById("lnerror").innerHTML="";
	 
	}	


	if(local==""  &&  local==null)
	{
		
		document.getElementById("lerror").innerHTML="Invalid type ";
		return false;
	}
	else
	{
		document.getElementById("lerror").innerHTML="";
		
	
		
	}
	
	
	
	if(local!="Sec"  &&  local!="Min")
	{
		
		document.getElementById("lerror").innerHTML="Invalid type ";
		return false;
	}
	else
	{
		document.getElementById("lerror").innerHTML="";
		
	
		
	}
	
	
	if (stdr==null || stdr=="")
	{
		document.getElementById("snerror").innerHTML="provide valid std call rate";
	  return false;
	  }
	else
	{
		document.getElementById("snerror").innerHTML="";
	  
	}
	if(!ratecheck.test(stdr))
	{
		document.getElementById("snerror").innerHTML="invalid std pulse rate";
	  return false;
	  }
	else
	{
		document.getElementById("snerror").innerHTML="";
	 
	}	
	
	
	if(std==""  &&  std==null)
	{
		
		document.getElementById("serror").innerHTML="Invalid type ";
		return false;
	}
	else
	{
		document.getElementById("serror").innerHTML="";
		
	
		
	}
	if(std==""  &&  std=="Min")
	{
		
		document.getElementById("serror").innerHTML="Invalid type ";
		return false;
	}
	else
	{
		document.getElementById("serror").innerHTML="";
		
	
		
	}
	if(isd==""  &&  isd==null)
	{
		
		document.getElementById("ierror").innerHTML="Invalid type ";
		return false;
	}
	else
	{
		document.getElementById("ierror").innerHTML="";
		
	
		
	}
	
	
	if (isdr==null || isdr=="")
	{
		document.getElementById("inerror").innerHTML="provide valid isd call rate";
	  return false;
	  }
	else
	{
		document.getElementById("inerror").innerHTML="";
		
	}


	if(!ratecheck.test(isdr))
	{
		document.getElementById("lnerror").innerHTML="invalid local pulse rate";
	  return false;
	  }
	else
	{
		document.getElementById("lnerror").innerHTML="";
	 
	}	

	if(isd!="Sec"  &&  isd!="Min")
	{
		
		document.getElementById("ierror").innerHTML="Invalid type ";
		return false;
	}
	else
	{
		document.getElementById("ierror").innerHTML="";
		
	
		
	}
	var rent=document.forms["f1"]["monthlyRental"].value;
	if (rent==null || rent=="")
	  {
		document.getElementById("mnerror").innerHTML="provide valid monthly rent";
	  return false;
	  }
	else
	{
		document.getElementById("mnerror").innerHTML="";
		
	}
	if(!rentcheck.test(rent))
	{
		document.getElementById("lnerror").innerHTML="invalid rent";
	  return false;
	  }
	else
	{
		document.getElementById("lnerror").innerHTML="";
	 
	}	

	return true;

	
	
	
}