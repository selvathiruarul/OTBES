function disableBackButton()
{	
	window.history.forward();
}
setTimeout("disableBackButton()", -1);
function showKeyCode(e)
{
var keycode =(window.event) ? event.keyCode : e.keyCode;

if(keycode == 116)
{
event.keyCode = 0;
event.returnValue = false;
return false;
}
}

function validate() {	
	var fn = document.forms["reg"]["fn"].value;
	var mn = document.forms["reg"]["mn"].value;
	var ln = document.forms["reg"]["ln"].value;
	var add = document.forms["reg"]["add"].value;
	var pincode = document.forms["reg"]["pincode"].value;
	var contact = document.forms["reg"]["contact"].value;
	var x = document.forms["reg"]["email"].value;
	var pattern = /^([a-zA-Z])+([a-zA-Z0-9_.-])+([a-zA-Z0-9])+@([a-zA-Z0-9_.-])+\.([a-zA-Z]{2,4})$/;

	var check = /^[A-Za-z]+$/;
	var pincodecheck = /^[0-9]+$/;

	if (fn == "" || fn == null) {
		document.getElementById("fnerror").innerHTML = "First Name must be filled out";
		document.getElementById("fnerror").style.color = "red";
		return false;
	} else {

		document.getElementById("fnerror").innerHTML = "";
	}

	if (!check.test(fn)) {
		document.getElementById("fnerror").innerHTML = "Enter the valid First Name ";
		return false;
	}

	else {

		document.getElementById("fnerror").innerHTML = "";
	}
	if (mn == "" || mn == null) {
		document.getElementById("mnerror").innerHTML = "Middle Name must be filled out";
		document.getElementById("mnerror").style.color = "red";
		return false;
	} else {

		document.getElementById("mnerror").innerHTML = "";
	}

	if (!check.test(mn)) {
		document.getElementById("mnerror").innerHTML = "Enter the valid Middle Name ";
		return false;
	} else {

		document.getElementById("mnerror").innerHTML = "";
	}

	if (ln == "" || ln == null) {

		document.getElementById("lnerror").innerHTML = "Last Name must be filled out";
		document.getElementById("lnerror").style.color = "red";
		return false;
	} else {

		document.getElementById("lnerror").innerHTML = "";
	}

	if (!check.test(ln)) {
		document.getElementById("lnerror").innerHTML = "Enter the valid last Name ";
		return false;
	} else {

		document.getElementById("lnerror").innerHTML = "";
	}

	if (add == "" || add == null) {
		document.getElementById("adderror").innerHTML = "Address must be filled out";

		return false;

	}

	else {

		document.getElementById("adderror").innerHTML = "";
	}

	if (add.length < 20 || add.length > 60) {
		document.getElementById("adderror").innerHTML = "Address should be within  20 to 60 characters  ";
		return false;
	} else {
		document.getElementById("adderror").innerHTML = "";
	}

	if (pincode == "" || pincode == null) {
		document.getElementById("pinerror").innerHTML = "Pin code must be filled out";
		return false;
	} else {

		document.getElementById("pinerror").innerHTML = "";
	}
	if (pincode.length != 6) {
		document.getElementById("pinerror").innerHTML = "Pin code should be 6 digits";
		return false;

	} else {

		document.getElementById("pinerror").innerHTML = "";
	}
	if (!pincodecheck.test(pincode)) {
		document.getElementById("pinerror").innerHTML = "Invalid Pin code ";

		document.getElementById("pinerror").style.color = "red";

		return false;
	}

	else {

		document.getElementById("pinerror").innerHTML = "";
	}
	if (contact == "" || contact == null) {
		document.getElementById("conerror").innerHTML = "Contact No  must be filled out";
		return false;
	} else {

		document.getElementById("conerror").innerHTML = "";
	}
	if (!pincodecheck.test(contact)) {
		document.getElementById("conerror").innerHTML = "Invalid contact number ";

		document.getElementById("conerror").style.color = "red";
		return false;
	} else {

		document.getElementById("conerror").innerHTML = "";
	}

	if (contact.length < 8) {
		document.getElementById("conerror").innerHTML = "Contact number should be minimum of 8 digits ";
		return false;
	} else {
		document.getElementById("conerror").innerHTML = "";
	}
	if (x == null || x == "")

	{
		document.getElementById("emailerror").innerHTML = "Enter the email id";
		return false;
	}

	else {
		document.getElementById("emailerror").innerHTML = "";
	}

	if (!pattern.test(x)  ) {
		document.getElementById("emailerror").innerHTML = "Invalid Email id";
		return false;
	} else {
		document.getElementById("emailerror").innerHTML = "";
	}
	
	


	return true;
}
function emailcheck()
{
	
}


function customeridcheck() {
	var delcid = document.forms["f1"]["cid"].value;
	var check = /^[0-9]+$/;
	if (delcid == "" || delcid == null) {

		document.getElementById("iderror").innerHTML = "Customer Id must be filled ";
		return false;
	} else {
		document.getElementById("iderror").innerHTML = " ";
	}

	if (delcid.indexOf(' ') > -1) {
		document.getElementById("iderror").innerHTML = "Whitespace not allowed";

		return false;
	} else {
		document.getElementById("iderror").innerHTML = " ";
	}
	if (!check.test(delcid)) {
		document.getElementById("iderror").innerHTML = "Customer Id must contain only numbers";

		return false;
	} else {
		document.getElementById("iderror").innerHTML = " ";
	}
	if (delcid.length != 6) {
		document.getElementById("iderror").innerHTML = "Customer Id must be in 6 digits ";

		return false;
	} else {
		document.getElementById("iderror").innerHTML = " ";
	}

	return true;

}


