function validate()
{

	var filename=document.forms["form1"]["file"].value;
	var extension=filename.substr(filename.lastIndexOf('.')+1).toLowerCase();
    if (filename) {
        if (extension=='xml' || extension=='csv') {
        } else {
        	document.getElementById("error").innerHTML="File must be xml or csv";
            return false;
        }
    } else {
    	document.getElementById("error").innerHTML="Upload CSV";
        return false;
    }

}
	