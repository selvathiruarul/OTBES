<%@ page errorPage="/JSP/Error1.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.otbes.vo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OTBES</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/validate.js"> </script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_blue.css" id="blue" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_green.css" id="green" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_pink.css" id="pink" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_orange.css" id="orange" />
</head>
<body onKeyDown="return showKeyCode(event)"  onLoad="disableBackButton();setTheme('<%=session.getAttribute("themeColor")%>')">
<%
response.setHeader("Pragma","no-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires",0);
String role=(String)session.getAttribute("User");

if(role==null)
	response.sendRedirect("index.jsp");
%>
<div id="wrapper">
<div id="wrapper_background">
<div id="header"></div>


<div id="tabs"><%@ include file="/JSP/menu.jsp"%></div>
<div id="menu"><%@ include file="/JSP/sidepane.jsp"%>

</div>
<div id="main">
<fieldset><legend>VIEWING TARIFF DETAILS</legend>


<form action="BTASServlet" method="post">
<%
	TariffVO tariff = (TariffVO) request.getAttribute("tariff");
%>

<table align="left" cellpadding="10" cellspacing="10">

	<tr>
		<td align="left"><label><%=resourceBundle.getString("tariffType")%></label></td>
		<td align="left"><input type="text" value="<%=tariff.getTariffName()%>"
			readonly="readonly"></input></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("localPulseRate")%></label></td>
		<td align="left"><input type="text" value="<%=tariff.getLocalPulseRate()%>"
			readonly="readonly"></input></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("localUnit")%></label></td>
		<td align="left"><input type="text" value="<%=tariff.getLocalUnit()%>"
			readonly="readonly"></input></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("stdPulseRate")%></label></td>
		<td align="left"><input type="text" value="<%=tariff.getStdPulseRate()%>"
			readonly="readonly"></input></td>
	</tr>
	<tr>
		<td align="left"><label> <%=resourceBundle.getString("stdUnit")%></label></td>
		<td align="left"><input type="text" value="<%=tariff.getStdUnit()%>"
			readonly="readonly"></input></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("isdPulseRate")%></label></td>
		<td align="left"><input type="text" value="<%=tariff.getIsdPulseRate()%>"
			readonly="readonly"></input></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("isdUnit")%></label></td>
		<td align="left"><input type="text" value="<%=tariff.getIsdUnit()%>"
			readonly="readonly"></input></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("monthlyRental")%></label></td>
		<td align="left"><input type="text" value="<%=tariff.getMonthlyRental()%>"
			readonly="readonly"></input></td>
	</tr>
</table>
</form>
</fieldset>
</div>
</div>
</div>
</body>
</html>