<%@ page
	import="java.util.Date,com.otbes.language.*,java.util.Locale,java.util.ResourceBundle,java.text.SimpleDateFormat"%>
<%@ page errorPage="/JSP/Error1.jsp"%>
<%@page import="com.otbes.vo.*"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<style>
label {
	display: inline-block;
	float: center;
	clear: left;
	width: 250px;
	text-align: left;
}

input {
	display: inline-block;
	float: center;
}

select {
	width: 150px;
}
</style>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
	Date date = new Date();
	date.setMonth(date.getMonth() - 1);
	String td = sdf.format(date);
	String dateParts[] = td.split("-");
	String month = dateParts[1];
%>
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
<p align="right"><a
	href="<%=request.getContextPath()%>/JSP/BTBMconnectionno.jsp"
	style="text-decoration: none"><b>BACK</b></a></p>
<fieldset><legend><%=resourceBundle.getString("billGeneration")%></legend>
<form action="BTBMServlet" method="post">
<%
	ConnectionVO connvo = (ConnectionVO) request
			.getAttribute("details");
%> <input
	type="hidden" name="option" value="billgeneration"></input> <label><%=resourceBundle.getString("connectionNumber")%></label><input
	type="text" name="connectionNo" value="<%=connvo.getConnectionNo()%>"
	readonly="readonly"></input><br>
<br>

<label><%=resourceBundle.getString("customerId")%></label><input
	type="text" name="customerId" value="<%=connvo.getCustId()%>"
	readonly="readonly"></input><br>
<br>
<label><%=resourceBundle.getString("typeOfBill")%></label><input
	type="text" name="typeOfBill" value="<%=connvo.getTypeOfBill()%>"
	readonly="readonly"></input><br>
<br>
<label><%=resourceBundle.getString("tariffPlan")%></label><input
	type="text" name="tariffType" value="<%=connvo.getTariffType()%>"
	readonly="readonly"></input><br>
<br>
<label><%=resourceBundle.getString("month")%></label><input type="text"
	name="month" value=<%out.println(month);%> readonly="readonly"></input><br>
<br>
<center><input type="submit"
	value=<%=resourceBundle.getString("generateBill")%> class="button"></input></center>
</form>
</fieldset>
</div>
</div>
</div>
</body>
</html>