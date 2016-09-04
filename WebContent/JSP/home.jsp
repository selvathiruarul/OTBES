<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page errorPage="/JSP/Error2.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/HelpdeskValidations.js"> 

</script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_blue.css" id="blue" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_green.css" id="green" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_pink.css" id="pink" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_orange.css" id="orange" />
<script type='text/javascript'>
var imageID=0;
function changeimage(every_seconds){
    //change the image
    if(!imageID){
        document.getElementById("myimage").src="../IMAGES/IMAGES_HOME/kerala.jpg";
        imageID++;
    }
    else{if(imageID==1){
        document.getElementById("myimage").src="../IMAGES/IMAGES_HOME/oldlady.jpg";
        imageID++;
    }
    else{if(imageID==2){
        document.getElementById("myimage").src="../IMAGES/IMAGES_HOME/farmer.jpg";
        imageID++;
    }
    else{if(imageID==3){
        document.getElementById("myimage").src="../IMAGES/IMAGES_HOME/fisher.jpg";
        imageID++;
    }
    else{if(imageID==4){
        document.getElementById("myimage").src="../IMAGES/IMAGES_HOME/hands.jpg";
        imageID++;
    }
    else{if(imageID==5){
        document.getElementById("myimage").src="../IMAGES/IMAGES_HOME/rajasthani.jpg";
        imageID++;
    }else{if(imageID==6){
        document.getElementById("myimage").src="../IMAGES/IMAGES_HOME/BTS.jpg";
        imageID=0;
    }
    }}}}}}
    //call same function again for x of seconds
    setTimeout("changeimage("+every_seconds+")",((every_seconds)*1000));
}
</script>
<%
	response.setHeader("Pragma", "no-control");
	response.setDateHeader("Cache-Control", 0);
	response.setDateHeader("Expires", 0);
	String user = (String) session.getAttribute("User");
	if(session.getAttribute("themeColor")==null){session.setAttribute("themeColor","orange");}
%>	

</head>
<body onKeyDown="return showKeyCode(event)" onLoad="changeimage(2);setTheme('<%=session.getAttribute("themeColor")%>')">

<div id="wrapper">
		<div id="wrapper_background">
<div id="header"></div>
<div id="tabs"><%@ include file="/JSP/menu.jsp"%></div>
<div id="menu">
<%
	if (session.getAttribute("User") == null) {
%> 
<img style="padding-top:20px;" height="120%" width="100%" src="<%=request.getContextPath() %>/IMAGES/IMAGES_HOME/butter.jpg">
<%} else {%><%@ include file="/JSP/sidepane.jsp" %><%}%>
</div>

<div id="main">

<div style='position:absolute;margin-left:-23%;width:0%;height:0%;' ><img width='600px' height='350px' id='myimage' src='http://www.photos.a-vsp.com/fotodb/14_green_cones.jpg'/></div>


</div>
</div>
</div>

</body>
</html>