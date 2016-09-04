<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.Date,com.otbes.language.*,java.util.Locale,java.util.ResourceBundle,java.text.SimpleDateFormat"%>
<%@ page errorPage="/JSP/Error1.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>


<%@ page import="com.otbes.vo.*"%>
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
	src="<%=request.getContextPath()%>/JS/adminviewdispute.js"> </script>
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
<meta name="keywords" content="" />
<meta name="description" content="" />
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
<fieldset><legend><%=resourceBundle.getString("billDispute")%></legend>
<form action="BTBMServlet" method="post"><input type="hidden"
	name="option" value="adminView">
<center>
<h5><%=resourceBundle.getString("enterTheSearchCriteria")%></h5>
</center>
<center>
<table>
	<tr></tr>

	<tr>
		<td><%=resourceBundle.getString("dateOfDispute")%></td>
		<td><input type="text" id="Text2" readonly="readonly"
			name="doDisp"></input> <span id="daterror"> </span><img
			src="<%=request.getContextPath()%>/IMAGES/CALENDAR_IMAGES/cal.gif"
			style="cursor: pointer;"
			onclick="javascript:NewCssCal ('Text2','ddMMyyyy')" /></td>
		<td>Status:</td>
		<td><select name="status">
			<option value="OPEN"><%=resourceBundle.getString("open")%></option>
			<option value="CLOSED"><%=resourceBundle.getString("closed")%></option>
		</select></td>
	</tr>

	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr>
		<td></td>
		<td><input type="submit"
			value="<%=resourceBundle.getString("search")%>" class="button"></input></td>
	</tr>

</table>

</center>
</form>
<form action="BTBMServlet" method="post"><input type="hidden"
	name="option" value="highlight"></input>
<center>
<table>


	<tr>
		<td></td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td></td>
		<td></td>
	</tr>
	<tr>


		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		
		<td><input type="submit"
			value="<%=resourceBundle.getString("disputeOpen>7Days")%>"
			class="button"></input></td>
	</tr>
</table>
</center>
</form>

</fieldset>
</div>
</div>
</div>


</body>
</html>






