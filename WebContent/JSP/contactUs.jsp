<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Us</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/HelpdeskValidations.js"> 

</script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_blue.css" id="blue" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_green.css" id="green" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_pink.css" id="pink" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_orange.css" id="orange" />
</head>
<body onKeyDown="return showKeyCode(event)" onLoad="setTheme('<%=session.getAttribute("themeColor")%>')">
<%
	response.setHeader("Pragma", "no-control");
	response.setDateHeader("Cache-Control", 0);
	response.setDateHeader("Expires", 0);
	String user = (String) session.getAttribute("User");
	
	
%>	
<div id="wrapper">
		<div id="wrapper_background">
<div id="header"></div>
<div id="tabs"><%@ include file="/JSP/menu.jsp"%></div>
<div id="menu">
<%
	if (session.getAttribute("User") == null) {
%> 
<img style="padding-top:10px;" height="70%" width="100%" src="<%=request.getContextPath() %>/IMAGES/IMAGES_HOME/contactus.bmp">
<%} else {%><%@ include file="/JSP/sidepane.jsp" %><%}%>
</div>

<div id="main">

<div id="content2">
			<h4> -- CONTACT US -- </h4>
			
<div id="contentHead">BTS CHENNAI</div>
47600001<br>
ADDRESS:<br>
N0:321,5TH AVENUE,ASHOK NAGAR<br>
CHENNAI-600043<br><br>


<div id="contentHead">BTS MUMBAI</div>
47600002<br>
ADDRESS:<br>
N0:23,ANDHERI-EAST<br>
MUMBAI-400059<br><br>



<div id="contentHead">BTS BENGALURU</div>
47600003<br>
ADDRESS:<br>
N0:345,JAY NAGAR<br>
BENGALURU-560001<br>

</div>
</div>
</div>
</div>
</body>
</html>