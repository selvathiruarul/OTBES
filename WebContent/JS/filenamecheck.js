function validate() {

	var filename = document.forms["view"]["idp"].value;
	var extension = filename.substr(filename.lastIndexOf('.') + 1)
			.toLowerCase();
	var filenamead = document.forms["view"]["addp"].value;

	var extensionad = filenamead.substr(filenamead.lastIndexOf('.') + 1)
			.toLowerCase();
	if (filename) {
		if (extension == 'jpg' || extension == 'png' || extension == 'bmp') {
		} else {
			document.getElementById("idperror").innerHTML = "File must be jpg or bmp or png";
			return false;
		}
	} else {
		document.getElementById("idperror").innerHTML = "Upload ID Proof";
		return false;
	}

	if (filenamead) {
		if (extensionad == 'jpg' || extensionad == 'png'
				|| extensionad == 'bmp') {
		} else {
			document.getElementById("addperror").innerHTML = "File must be jpg or bmp";
			return false;
		}
	} else {
		document.getElementById("addperror").innerHTML = "";
		return false;
	}

}
