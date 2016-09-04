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
function isCharacter(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode;
   if (charCode > 31 && (charCode < 65 || charCode > 90)&& (charCode < 97 || charCode > 122))
   {
  	 return false;
   }
   else
   {
  	 return true;
   }
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
function loginValidate() {
	var username = document.forms["login"]["uName"].value;
	var pwd = document.forms["login"]["pwd"].value;
	if ((username == "" || username == null) ||(pwd == "" || pwd == null)) {
		document.getElementById('inputerror').innerHTML = 'Enter username / password';
		return false;
	}		
		if (username.length <= 5) {
			document.getElementById('inputerror').innerHTML = 'Please enter a valid username';
			return false;
		}
		else{
			document.getElementById('inputerror').innerHTML = '';
		}	
		if (pwd.length <= 8) {
			document.getElementById('inputerror').innerHTML = 'Please enter the correct password';
			return false;
		}
		else{
			document.getElementById('inputerror').innerHTML = '';
		}
}
function ticketIdValidate() {
	var ticketid = document.forms["DeleteTicket"]["ticketid"].value;
	if (ticketid == "" || ticketid == null || isNaN(ticketid)) {
		document.getElementById('inputerror').innerHTML = 'Enter valid TicketId';
		return false;
	}
	if (ticketid.length <= 5) {
		document.getElementById('inputerror').innerHTML = 'Ticket ID is 6 characters in Length';
		return false;
	}
	else{
		document.getElementById('inputerror').innerHTML = '';
}
}
function ticketIdValidateView() {
	var ticketid = document.forms["viewTicket"]["ticketid"].value;
	if (ticketid == "" || ticketid == null || isNaN(ticketid)) {
		document.getElementById('inputerror').innerHTML = 'Enter Valid TicketId';
		return false;
	}
		if (ticketid.length <= 5) {
			document.getElementById('inputerror').innerHTML = 'Ticket ID is 6 characters in Length';
			return false;
		}
		else{
			document.getElementById('inputerror').innerHTML = '';
	}
}
function updateTicketValidate() {
	var ticketidvalue = document.forms["updateTicket"]["ticketid"].value;
	if (ticketidvalue == "" || ticketidvalue == null || isNaN(ticketidvalue)) {
		document.getElementById('inputerror').innerHTML = 'Enter Valid TicketID';
		return false;
	}
	if (ticketidvalue.length <= 5) {
		document.getElementById('inputerror').innerHTML = 'Ticket ID is 6 characters in Length';
		return false;
	}
	else{
		document.getElementById('inputerror').innerHTML = '';
}
}
function updateValidate(){
	var description=document.forms["update"]["description"].value;
	if (description == "" || description == null || description == "null" ) {
		document.getElementById('inputerror').innerHTML = 'Enter Description';
		return false;
		}
	else{
		document.getElementById('inputerror').innerHTML = '';
	}
 
	
	
		}

function validateEmployeeUpdate(){
	var resolutionComment=document.forms["view"]["resolutionComments"].value;
	if(resolutionComment == "" || resolutionComment == null){
		document.getElementById('error').innerHTML = 'Enter Valid Comment';
		return false;
	}
	document.getElementById('error').innerHTML = '';
	return true;
}
function validateDropDown(){
	var optionSelected=document.forms["ticketList"]["ticketId"].value;
	
	if(optionSelected=="0"){
		document.getElementById('error').innerHTML = 'Select a ticket to Assign';
		return false;
	}
	
}
function validateEmployeeDropDown(){
	var employeeOptionSelected=document.forms["employeeList"]["employeeId"].value;
	if(employeeOptionSelected=="0"){
		document.getElementById('error').innerHTML = 'Select a Employee to Assign';
		return false;
	}
}

function setTheme(theme) {
	
	var themes = [ "blue", "green","pink", "orange" ];
	for ( var i = 0; i < themes.length; i++) {
		var styleSheet = document.getElementById(themes[i]);
		if (themes[i] == theme) {
			styleSheet.removeAttribute("disabled");
		} else {
			styleSheet.setAttribute("disabled", "disabled");
		}
	}
}
function validateDate(){
	var x3=document.forms["myform"]["fromdate"].value;
	var x1=document.forms["myform"]["todate"].value;
	dojD=x3.substring(0,2);
	dojM=x3.substring(3,5);
	dojY=x3.substring(6,10);

	dosD=x1.substring(0,2);
	dosM=x1.substring(3,5);
	dosY=x1.substring(6,10);
		
	if((dojD>dosD && dojM==dosM && dojY==dojY)||((dojM>dosM) && dojY==dosY) || (dojY>dosY))
	{
		document.getElementById("dojerror").innerHTML='From date and To date mismatch! From Date:'+dojD+'.'+dojM+'.'+dojY;
		document.getElementById("dateto").value=" ";
		return false;
	}
	else{	
		return true;
		}
}

