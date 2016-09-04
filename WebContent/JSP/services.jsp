<%@ page errorPage="/JSP/Error2.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>service</title>
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
<img style="padding-top:10px;" height="120%" width="100%" src="<%=request.getContextPath() %>/IMAGES/IMAGES_HOME/service.jpg">

<%} else {%><%@ include file="/JSP/sidepane.jsp" %><%}%>
</div>

<div id="main">

<div id="content2">
	<h4> -- AMAZING BTS SERVICES -- </h4>
			

<div id="contentHead"></div>
<div id="offer_subdiv">
<img height="90px" width="80px" src="<%=request.getContextPath() %>/IMAGES/IMAGES_HOME/credit.jpg">
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<img height="90px" width="80px" src="<%=request.getContextPath() %>/IMAGES/IMAGES_HOME/video_calling.jpg">
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<img height="90px" width="80px" src="<%=request.getContextPath() %>/IMAGES/IMAGES_HOME/fast_internet.bmp">
</div>

<div id="offer_maindiv">
<div id="contentHead">Payment of BTS Bills</div>
* Customer can pay BTS Mobile/Landline bills in any of the branches  across Globe.<br></br> 
* He/She can pay the bill through Cash, Cheque, DD or Credit Card. <br></br>
* Customer can pay multiple bill payments with single pay mode i.e. Cheque or DD.<br></br> 
* DD or Cheque should be in favour of "Bharat Tele Services, India"   and it must be from any of the RBI (Reserve Bank of India) recognized banks.<br></br> 
* No partial payment is allowed. <br></br>
* Customer can pay bill amount in excess and same will be deducted in next month bill.<br></br>
<br>
<br>
<div id="contentHead">Video Calling</div>
* You have got a call? Why not make it a video call? Now see all your friends as you chat with them on your mobile phone with BTS service<br></br>
* Just dial the number and enjoy. <br></br>
&nbsp&nbsp&nbsp --Charges--<br></br>
&nbsp&nbsp&nbsp * Home Outgoing: Rs 3/min<br></br>
&nbsp&nbsp&nbsp * Roam Incoming: Rs 3/min<br></br>
&nbsp&nbsp&nbsp * Roam Outgoing: Rs 4/min<br></br>
 

<br>
<br>
<br>

<div id="contentHead">Faster Downloads & High Speed Internet</div>
* Download large email attachments at lightning fast speeds right from your BTS mobile phone.<br></br>
* BTS 3G transfers voice data (calls) and non-voice data (emails, instant messaging) simultaneously to let you enjoy 3 times faster speed than 2G.<br></br>
* How fast is your phone? Get on the fast lane with BTS Mobile Internet Service.<br></br>
* Upload pictures and videos, share files and do much more with high speed internet right on your mobile phone.<br></br>

</div></div>
</div>
</div>
</div>

</body>
</html>