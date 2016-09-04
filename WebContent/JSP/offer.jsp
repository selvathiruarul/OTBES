<%@ page errorPage="/JSP/Error2.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Offers</title>
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
<img style="padding-top:10px;" height="120%" width="100%" src="<%=request.getContextPath() %>/IMAGES/IMAGES_HOME/newyearwish.jpg">
<%} else {%><%@ include file="/JSP/sidepane.jsp" %><%}%>
</div>

<div id="main">

<div id="content2">
	<h4> -- AMAZING OFFERS -- </h4>
			

<div id="contentHead"><h4><marquee> Enjoy the New Year Special Offers &nbsp &nbsp &nbsp***&nbsp &nbsp &nbspPay your Bill Online before Due date and enjoy 2% Discount in subsequent bills <span>*</span> &nbsp &nbsp &nbsp ***&nbsp &nbsp &nbsp Get Free Fastrack Watch for every New connection &nbsp &nbsp &nbsp *** &nbsp &nbsp &nbsp Get free talktime for every Recharge &nbsp &nbsp &nbsp ***&nbsp &nbsp &nbsp Get Unlimited talktime offers &nbsp &nbsp &nbsp </h4></marquee></div>
<div id="offer_subdiv">
<img height="90px" width="80px" src="<%=request.getContextPath() %>/IMAGES/IMAGES_HOME/newyear.jpg">

<br>
<br>
<br>
<br>
<br>
<img height="90px" width="80px" src="<%=request.getContextPath() %>/IMAGES/IMAGES_HOME/watch.jpg">
<br>
<br>


<img height="90px" width="80px" src="<%=request.getContextPath() %>/IMAGES/IMAGES_HOME/discount.jpg">
</div>

<div id="offer_maindiv">
As the festival season continues,  service provider Bharat Tele Services  (BTS) is ready to launch special New Year festival offers for customers across India.
The prepaid BTS customers can celebrate a little more as from 1st January,2013, BTS will introduce 2 new prepaid offers specially designed for customers where in it will give FREE 2G SIM Card along with its New Year Plan at discounted price and Data Voucher (starter kit) for free.
Under Voice Plan for Subscribers offer, BTS will provide free 2G SIM card and New Year Plan Voucher worth Rs.550 for Rs.500 with all freebies like free 100 Minutes for Voice calls, 200 Local and National SMS and 100 MB free data usage.
While with Data Plan for Subscribers offer,BTS will provide free 2G SIM card and Data Plan Starter Voucher worth Rs.200 for FREE.
<br>
<br>
As Bharat Tele Services(BTS) is serving its customers for many decades,it continues to provide special offers for its customers who is having three mobile/Landline connections.Bharat Tele Services(BTS) is offering a Brand New FastTrack Watch for subscribers having three mobile/Landline connections.
<br>
<br>
<br>
<br>

As Bharat Tele Services(BTS) is serving customers for many decades, it continues to provide great discount for its customers who is paying the bill on or before due date. Bharat Tele Services(BTS) provides 75% discount for customers paying by date. 
</div>
</div>
</div>
</div>
</div>
</body>
</html>