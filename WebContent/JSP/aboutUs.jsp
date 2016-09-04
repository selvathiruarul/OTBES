<%@ page errorPage="/JSP/Error1.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>About Us</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/HelpdeskValidations.js"> 

</script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_blue.css" id="blue" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_green.css" id="green" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_pink.css" id="pink" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_orange.css" id="orange" />
</head>
<body onKeyDown="return showKeyCode(event)" onLoad="disableBackButton();setTheme('<%=session.getAttribute("themeColor")%>')">
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
<img style="padding-top:10px;" height="120%" width="100%" src="<%=request.getContextPath() %>/IMAGES/IMAGES_HOME/building.jpg">

<%} else {%><%@ include file="/JSP/sidepane.jsp" %><%}%>
</div>

<div id="main">
					
<div id="content">Bharat Tele Services Ltd. was incorporated on 1st July 2005 . 

It took over the business of providing of telecom services and 

network management from the erstwhile Central Government 

Departments of Telecom Services (DTS) and Telecom Operations 

(DTO), with effect from 1st August 2005 on going concern 

basis.It is one of the largest and leading public sector units 

providing comprehensive range of telecom services in India.

BTS has installed Quality Telecom Network in the country and now 

focusing on improving it, expanding the network, introducing 

new telecom services online.The company has vast experience in 

planning, installation, network integration and maintenance of 

switching and transmission networks and also has a world class ISO 

9000 certified Telecom Training Institute.<br>

<div id="contentHead"><center>VISSION:</center></div>
Be the leading telecom service provider in India with global 

presence. Create a customer focused organization with excellence in 

customer care, sales and marketing. Leverage technology to provide affordable and innovative 

telecom. Services/products across customer segments. <br>

<div id="contentHead"><center>MISSION:</center></div>

Establishing efficient business processes enabled by IT. 
Providing a conducive work environment with strong focus on performance. <br>

<div id="contentHead"><center>OBJECTIVES:</center></div>

To be the Leading Telecom Services provider by achieving 

higher rate of growth so as to become a profitable enterprise. 
To provide quality and reliable fixed telecom service to our 

customer and thereby increase customers confidence. 
To provide customer friendly mobile telephone service of high 

quality and play a leading role as GSM operator in its area of 
operation. 


</div>


</div>
</div>
</div>	
</body>
</html>