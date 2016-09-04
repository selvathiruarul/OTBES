function validateuserid(param) {
	if(param=='121121')
	{
		return true;
	}else{
		return false;
	}
	
}

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

function isAlphaNumeric(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode;
   if (charCode > 31 && (charCode < 48 || charCode > 57)&& (charCode < 65 || charCode > 90)&& (charCode < 97 || charCode > 122))
   {
  	 return false;
   }
   else
   {
  	 return true;
   }
}

function validateForm() {
	var newticketcustomer = document.forms["namenewticket"]["customerid"].value;
	if ((newticketcustomer == null || newticketcustomer == "")) {
		document.getElementById('ciderror').innerHTML = 'Customer ID must be filled out';
		return false;
	}
	else{
		document.getElementById('ciderror').innerHTML = '';
	}
	if (isNaN(newticketcustomer)) {
		document.getElementById('ciderror').innerHTML = 'Only Numeric Values are allowed(0-9)';
		return false;
	}
	else{
		document.getElementById('ciderror').innerHTML = '';
	}
	if (newticketcustomer.length <= 5) {
		document.getElementById('ciderror').innerHTML = 'Customer ID is 6 characters in Length';
		return false;
	}
	else{
		document.getElementById('ciderror').innerHTML = '';
	}
	if (!newticketcustomer.match(/[0-9]/)) {
		document.getElementById('ciderror').innerHTML = 'Only numeric values are allowed. avoid using (.)';
		return false;
	}
	else{
		document.getElementById('ciderror').innerHTML = '';
	}	
}
function validateraiseForm() {	
	var raisenewsissue = document.forms["raisenewticket"]["sissue"].value;
	var raisenewdissue = document.forms["raisenewticket"]["dissue"].value;
	if ((raisenewsissue == null || raisenewsissue == "") && (raisenewdissue == null || raisenewdissue == ""))
	{
		document.getElementById('sissueerror').innerHTML = 'Short Summary must be filled out';
		document.getElementById('dissueerror').innerHTML = 'Detailed Summary must be filled out';
		return false;
	}
	else{
		document.getElementById('sissueerror').innerHTML = '';
		document.getElementById('dissueerror').innerHTML = '';
	}
	if((raisenewsissue.length>150)||(raisenewsissue.length<10)){
		document.getElementById('sissueerror').innerHTML = 'not lessthan 10 characters or not morethan 150 characters';
		return false;
	}
	else{
		document.getElementById('sissueerror').innerHTML = '';
	}
	
	if ((raisenewsissue == null || raisenewsissue == "")) {
		document.getElementById('sissueerror').innerHTML = 'Short Summary must be filled out';
		return false;
	}
	else{
		document.getElementById('sissueerror').innerHTML = '';
	}
	var raisenewdissue = document.forms["raisenewticket"]["dissue"].value;
	if ((raisenewdissue == null || raisenewdissue == "")) {
		document.getElementById('dissueerror').innerHTML = 'Detailed Summary must be filled out';
		return false;
	}
	else{
		document.getElementById('dissueerror').innerHTML = '';
	}
	if((raisenewdissue.length>150)||(raisenewdissue.length<10)){
		document.getElementById('dissueerror').innerHTML = 'not lessthan 10 characters or not morethan 150 characters';
		return false;
	}
	else{
		document.getElementById('dissueerror').innerHTML = '';
	}
	var fileupload = document.forms["raisenewticket"]["path"].value;
	if((fileupload==null)||(fileupload=="")){
		return true;
	}else{
	var ext = fileupload.substring(fileupload.lastIndexOf('.') + 1);
	if(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "JPG" || ext == "png" || ext == "PNG")
	{
		return true;
	} 
	else
	{
		document.getElementById('udocerror').innerHTML = 'Upload Image Files only';
		return false;
	}
	}
}
function validateviewForm() {
	var viewticket = document.forms["nameviewticket"]["ticketid"].value;
	if ((viewticket == null || viewticket == "")) {
		document.getElementById('tiderror').innerHTML = 'Ticket ID must be filled out';
		return false;
	}
	else{
		document.getElementById('tiderror').innerHTML = '';
	}
	if (isNaN(viewticket)) {
		document.getElementById('tiderror').innerHTML = 'Only Numeric Values are allowed(0-9)';
		return false;
	}
	else{
		document.getElementById('tiderror').innerHTML = '';
	}
	if (viewticket.length <= 5) {
		document.getElementById('tiderror').innerHTML = 'Ticket ID is 6 characters in Length';
		return false;
	}
	else{
		document.getElementById('tiderror').innerHTML = '';
	}
}
function validatedeleteForm() {
	var deleteticket = document.forms["namedeleteticket"]["ticketid"].value;
	if ((deleteticket == null || deleteticket == "")) {
		document.getElementById('tiderror').innerHTML = 'Ticket ID must be filled out';
		return false;
	}
	else{
		document.getElementById('tiderror').innerHTML = '';
	}
	if (isNaN(deleteticket)) {
		document.getElementById('tiderror').innerHTML = 'Only Numeric Values are allowed(0-9)';
		return false;
	}
	else{
		document.getElementById('tiderror').innerHTML = '';
	}
	if (deleteticket.length <= 5) {
		document.getElementById('tiderror').innerHTML = 'Ticket ID is 6 characters in Length';
		return false;
	}
	else{
		document.getElementById('tiderror').innerHTML = '';
	}
}
function validateupdatedetailsForm() {
	
	var updatesissue = document.forms["nameupdateticketdetails"]["sissue"].value;
	var updatedissue = document.forms["nameupdateticketdetails"]["dissue"].value;
	var updatestatus = document.forms["nameupdateticketdetails"]["status"].value;
	var updatercomment = document.forms["nameupdateticketdetails"]["rcomment"].value;
	if ((updatesissue == null || updatesissue == "") && (updatedissue == null || updatedissue == ""))
	{
		document.getElementById('sissueerror').innerHTML = 'Short Summary must be filled out';
		document.getElementById('dissueerror').innerHTML = 'Detailed Summary must be filled out';
		return false;
	}
	else{
		document.getElementById('sissueerror').innerHTML = '';
		document.getElementById('dissueerror').innerHTML = '';
	}
	if ((updatesissue == null || updatesissue == "")) {
		document.getElementById('sissueerror').innerHTML = 'Short Summary must be filled out';
		return false;
	}
	else{
		document.getElementById('sissueerror').innerHTML = '';
	}
	if((updatesissue.length>150)||(updatesissue.length<10)){
		document.getElementById('sissueerror').innerHTML = 'not lessthan 10 characters or not morethan 150 characters';
		return false;
	}
	else{
		document.getElementById('sissueerror').innerHTML = '';
	}
	var updatedissue = document.forms["nameupdateticketdetails"]["dissue"].value;
	if ((updatedissue == null || updatedissue == "")) {
		document.getElementById('dissueerror').innerHTML = 'Detailed Summary must be filled out';
		return false;
	}
	else{
		document.getElementById('dissueerror').innerHTML = '';
	}
	if((updatedissue.length>150)||(updatedissue.length<10)){
		document.getElementById('dissueerror').innerHTML = 'not lessthan 10 characters or not morethan 150 characters';
		return false;
	}
	else{
		document.getElementById('dissueerror').innerHTML = '';
	}
	var fileupload = document.forms["nameupdateticketdetails"]["path"].value;
	if((fileupload==null)||(fileupload=="")){
		return true;
	}else{
	var ext = fileupload.substring(fileupload.lastIndexOf('.') + 1);
	if(ext == "gif" || ext == "GIF" || ext == "JPEG" || ext == "jpeg" || ext == "jpg" || ext == "JPG" || ext == "png" || ext == "PNG")
	{
		return true;
	} 
	else
	{
		document.getElementById('udocerror').innerHTML = 'Upload Image Files only';
		return false;
	}
	}	
	if((updatestatus=="closed" || updatestatus=="CLOSED" || updatestatus=="Closed") &&(updatercomment==null)){
		document.getElementById('rcerror').innerHTML = 'Resolution Comments must be filled out';
		return false;
	}
	else{
		document.getElementById('rcerror').innerHTML = '';
	}
	
}
function validateupdateForm() {	
	var updateticket = document.forms["nameupdateticket"]["ticketid"].value;
	if ((updateticket == null || updateticket == "")) {
		document.getElementById('tiderror').innerHTML = 'Ticket ID must be filled out';
		return false;
	}
	else{
		document.getElementById('tiderror').innerHTML = '';
	}
	if (isNaN(updateticket)) {
		document.getElementById('tiderror').innerHTML = 'Only Numeric Values are allowed(0-9)';
		return false;
	}
	else{
		document.getElementById('tiderror').innerHTML = '';
	}
	if (updateticket.length <= 5) {
		document.getElementById('tiderror').innerHTML = 'Ticket ID is 6 characters in Length';
		return false;
	}
	else{
		document.getElementById('tiderror').innerHTML = '';
	}
}


function addEmployeeValidate() {

	var x1 = document.forms["addHelpDeskEmployee"]["firstname"].value;
	var x2 = document.forms["addHelpDeskEmployee"]["lastname"].value;
	var x3 = document.forms["addHelpDeskEmployee"]["dateofjoining"].value;
	var x4 = document.forms["addHelpDeskEmployee"]["pancard"].value;
	var panPat = /^([a-zA-Z]{5})(\d{4})([a-zA-Z]{1})$/;
	if ((x1 == null || x1 == "" || x1.length <=2) ||(x2 == null || x2 == "")

		|| (x3 == null || x3 == "")
			|| (x4 == null || x4 == "" || x4.length != 10 || x4.search(panPat) == -1)) {
		if (x1 == null || x1 == "" || x1.length <=2){ 
			document.getElementById('fnerror').innerHTML = 'Enter the valid first name';
			
		}
		 else
			document.getElementById('fnerror').innerHTML = '';
			if (x2 == null || x2 == "" ){
			document.getElementById('lnerror').innerHTML = 'Enter valid the last name';
			
		}
		else
			document.getElementById('lnerror').innerHTML = '';
		if (x3 == null || x3 == ""){
			document.getElementById('dojerror').innerHTML = 'Enter the date ';
			
		}
		else
			document.getElementById('dojerror').innerHTML = '';

		if (x4 == null || x4 == "" ||x4.length != 10 ||  x4.search(panPat) == -1){
			document.getElementById('pnerror').innerHTML = 'Enter a valid number';
			
		}
		else
			document.getElementById('pnerror').innerHTML = '';
		
		return false;
	}
	else
	return true;
}
function employeeViewIdValidate()
{
var x1=document.forms["viewEmployee"]["employeeId"].value;
if ((x1==null || x1=="" || isNaN(x1)))
{
	document.getElementById('eperror').innerHTML = 'Enter the employee id';
	return false;
}
else {return true;}
}
function employeeUpdateIdValidate()
{
var x1=document.forms["updateEmployee"]["employeeId"].value;
if ((x1==null || x1=="" || isNaN(x1)))
{	
	document.getElementById('eperror').innerHTML = 'Enter the employee id';
	return false;
	
}
else {return true;}
}
function employeeDeleteIdValidate()
{
var x1=document.forms["deleteEmployee"]["employeeId"].value;
if ((x1==null || x1=="" || isNaN(x1)))
{	
	document.getElementById('eperror').innerHTML = 'Enter the employee id';
	return false;
}
else {return true;}
}
function deleteEmployeeValidate()
{
	var x1=document.forms["deletedetailsEmployee"]["dateofseparation"].value;
	var x2=document.forms["deletedetailsEmployee"]["reasonforseparartion"].value;
	var x3=document.forms["deletedetailsEmployee"]["dateofjoining"].value;
		
	
	if((x1==null)||(x1=="") || (x2==null||x2=="") || (x1 != null))
	{
	if((x1==null)||(x1=="")){
		document.getElementById("doserror").innerHTML='Enter the date';
		return false;
	}
	else
	{
		document.getElementById("doserror").innerHTML='';
	}
	if(x2==null||x2==""){
		document.getElementById("rserror").innerHTML='Enter the Reason';
		return false;
	}
	else
	{
		document.getElementById("rserror").innerHTML='';
	}
	
	
	dojD=x3.substring(8,10);
	dojM=x3.substring(5,7);
	dojY=x3.substring(0,4);

	dosD=x1.substring(0,2);
	dosM=x1.substring(3,5);
	dosY=x1.substring(6,10);
		
	if((dojD>dosD && dojM==dosM && dojY==dojY)||((dojM>dosM) && dojY==dosY) || (dojY>dosY))
	{
		document.getElementById("doserror").innerHTML='Date Of Joining and Separation mismatch! DOJ:'+dojD+'.'+dojM+'.'+dojY;
		document.getElementById("dateinput").value=" ";
		return false;
	}
	else{	
		return true;
		}
	
	}
	
}


function updateEmployeeValidate() {

	var x1 = document.forms["updateDetails"]["firstname"].value;
	var x2 = document.forms["updateDetails"]["lastname"].value;
	var x3 = document.forms["updateDetails"]["dateofjoining"].value;
	var x4 = document.forms["updateDetails"]["pancard"].value;
	var panPat = /^([a-zA-Z]{5})(\d{4})([a-zA-Z]{1})$/;
	if ((x1 == null || x1 == "" || x1.length <=2) ||(x2 == null || x2 == "")

		|| (x3 == null || x3 == "")
			|| (x4 == null || x4 == "" || x4.length != 10 || x4.search(panPat) == -1)) {
		if (x1 == null || x1 == "" || x1.length <=2){ 
			document.getElementById('fnerror').innerHTML = 'Enter the valid first name';
			return false;
		}
		 else
			document.getElementById('fnerror').innerHTML = '';
			if (x2 == null || x2 == "" ){
			document.getElementById('lnerror').innerHTML = 'Enter valid the last name';
			return false;
		}
		else
			document.getElementById('lnerror').innerHTML = '';
		if (x3 == null || x3 == ""){
			document.getElementById('dojerror').innerHTML = 'Enter the date ';
			return false;
		}
		else
			document.getElementById('dojerror').innerHTML = '';

		if (x4 == null || x4 == "" ||x4.length != 10 ||  x4.search(panPat) == -1){
			document.getElementById('pnerror').innerHTML = 'Enter a valid number';
			return false;
		}
		else
			document.getElementById('pnerror').innerHTML = '';
	}
	else
	return true;
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

function changePasswordValidate() {
	

	var x1 = document.forms["changepwd"]["newpass"].value;
	var x2 = document.forms["changepwd"]["repass"].value;
	
	if ((x1 == null || x1 == "" || x1.length <9)) {
		
		 document.getElementById('nperror').innerHTML = 'Enter the valid password';
			return false;
		}
		else
			document.getElementById('nperror').innerHTML = '';
			
	if (x1!=x2){
			document.getElementById('rperror').innerHTML = 'Retype valid the password';
			return false;
		}
		else
			document.getElementById('rperror').innerHTML = '';
		
	
	
	return true;
}
