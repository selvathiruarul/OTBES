<%@ page errorPage="/JSP/Error1.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>OTBES</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
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
<%@ page import="com.otbes.vo.*"%>



<%
	PaymentDetailsVO v = (PaymentDetailsVO) request
			.getAttribute("result");
%>

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
<div id="wrapper">
<div id="wrapper_background">
<div id="header"></div>

<div id="tabs"><%@ include file="/JSP/menu.jsp"%></div>
<div id="menu"><%@ include file="/JSP/sidepane.jsp"%>
</div>

<div id='main'>
<p align="right"><a href="<%=request.getContextPath()%>/JSP/BTBMViewcid.jsp"><b>BACK</b></a></p>
<fieldset><legend><%=resourceBundle.getString("billPayment")%></legend>
<form action="BTBMServlet"><%=resourceBundle.getString("payDetails")%>
<br>
<br>
<br>
<label><%=resourceBundle.getString("billId")%></label> <input type=text
	value=<%out.println(v.getBillId());%> readonly="readonly"></input><br>
<br>
<label><%=resourceBundle.getString("connectionNumber")%></label> <input
	type=text value=<%out.println(v.getConnectionNo());%>
	readonly="readonly"></input><br>
<br>
<label><%=resourceBundle.getString("totalAmount")%></label> <input
	type=text value=<%out.println(v.getTotalAmt());%> readonly="readonly"></input><br>
<br>
<label><%=resourceBundle.getString("amountPaid")%></label> <input
	type=text value=<%out.println(v.getAmountYoupay());%>
	readonly="readonly"></input><br>
<br>
<label><%=resourceBundle.getString("paymentDate")%> (YYYY-MM-DD)</label>
<input type=text value=<%out.println(v.getPaymentDate());%>
	readonly="readonly"></input> <br>
<br>
</form>
</fieldset>
</div>
</div>
</div>
</body>
</html>



