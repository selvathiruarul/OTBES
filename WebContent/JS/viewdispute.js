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
var x;
x=document.f1.custId.value;
if(isNaN(x)|| x.indexOf(" ")!=-1){
              alert("Enter numeric value");
              return false; 
             }
if(x == "" || x == null)
{
alert("CustomerId should not be empty...");
return false;
}
return true;
}

