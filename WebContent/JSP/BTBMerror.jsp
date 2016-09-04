<%@ page errorPage="/JSP/Error1.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>OTBES</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/validate.js"> </script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/layout_blue.css" id="blue" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/layout_green.css" id="green" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/layout_pink.css" id="pink" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/layout_orange.css" id="orange" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/viewconnvalidation.js">
</script>
<meta name="keywords" content="" />
<meta name="description" content="" />
<style>
label {
	display: inline-block;
	float: left;
	clear: left;
	width: 250px;
	text-align: left;
}

input {
	display: inline-block;
	float: center;
}
</style>

</head>
<body onKeyDown="return showKeyCode(event)" onLoad="disableBackButton();setTheme('<%=session.getAttribute("themeColor")%>')">
<%
	response.setHeader("Pragma", "no-control");
	response.setDateHeader("Cache-Control", 0);
	response.setDateHeader("Expires", 0);
	String user = (String) session.getAttribute("User");
	if (user == null) {
		response.sendRedirect("redirect.jsp");
	}
%>
<%@ include file="/JSP/lingual.jsp"%>
<div id="wrapper">
<div id="wrapper_background">
<div id="header"></div>
<div id="tabs">
<ul>
	<li><a href="<%=request.getContextPath()%>/JSP/BTBMAdm.jsp"
		title="Home"><span>HOME</span></a></li>
	<li><a href="#" title="Services"><span>SERVICES</span></a></li>
	<li><a href="#" title="About Us"><span>ABOUT US</span></a></li>
	<li><a href="#" title="Offers"><span>OFFERS</span></a></li>
	<li><a href="#" title="Contact Us"><span>CONTACT US</span></a></li>
</ul>
</div>



<div id='menu'></div>



<div id='main'>
<p align="right"><a
	href="<%=request.getContextPath()%>/JSP/Login.jsp"
	style="text-decoration: none"><b>Back</b></a></p>
<fieldset><legend><%=resourceBundle.getString("login")%></legend><%=resourceBundle.getString("invalidUsernameAndPassword")%></fieldset>
</div>
</div>
</div>
</body>
</html>