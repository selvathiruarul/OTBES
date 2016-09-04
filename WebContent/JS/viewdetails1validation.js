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
	var cardNo=document.forms["gen"]["cardNo"].value;	
	var cvvNo=document.forms["gen"]["cvvNo"].value;
	var amountYoupay=document.forms["gen"]["amountYoupay"].value;	
    var totalAmt=document.forms["gen"]["totalAmt"].value;
    var t = parseInt(totalAmt);
    var a = parseInt(amountYoupay);
    var bank=document.forms["gen"]["bankName"].value;
    var card=document.forms["gen"]["cardType"].value;
    if(bank==""){
		document.getElementById("bankerror").innerHTML = "Select the Bank";
		return false;
	}
    else{
		document.getElementById("bankerror").innerHTML = '';
	}
    if(card==""){
		document.getElementById("typeerror").innerHTML = "Select the card type";
		return false;
	}
    else{
		document.getElementById("typeerror").innerHTML = '';
	}
    if(cardNo=="" ||cardNo==null || isNaN(cardNo) || cardNo.length>16 || cardNo.length<16)

	{
		document.getElementById("card1error").innerHTML=" Enter a valid 16 digit card number";
		document.getElementById("card1error").style.color="red";
		return false;
	}
	else{
		document.getElementById('card1error').innerHTML = '';
	}
	if(cvvNo=="" ||cvvNo==null || isNaN(cvvNo) || cvvNo.length>3  )
	{
		document.getElementById("cvv1error").innerHTML=" Enter a valid 3 digit cvv number";
		document.getElementById("cvv1error").style.color="red";
		return false;
	}
	else{
		document.getElementById('cvv1error').innerHTML = '';
	}
	if(amountYoupay=="" ||amountYoupay==null || isNaN(amountYoupay  ))
	{
		document.getElementById("amt1error").innerHTML=" Please enter the amount";
		document.getElementById("amt1error").style.color="red";
		return false;
	}
	else
	{
		document.getElementById("amt1error").innerHTML=" ";
	}

	if(t > a )
		{
        
        document.getElementById("amt1error").innerHTML=" Amount should not be less than total amount";
        document.getElementById("amt1error").style.color="red";
		return false;
	}

	else
	{
		document.getElementById("amt1error").innerHTML=" ";
	}
	 return true;
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


function isNumberKey1(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode;
   if (charCode > 31 && (charCode < 46 || charCode > 57))
   {
  	 return false;
   }
   else
   {
  	 return true;
   }
}





