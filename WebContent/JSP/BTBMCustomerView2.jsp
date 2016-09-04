<%@ page errorPage="/JSP/Error1.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="com.otbes.vo.*"%>
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

textarea {
	width: 140px;
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
<p align="right"><a
	href="<%=request.getContextPath()%>/JSP/BTBMView1disp.jsp"><b>Back</b></a></p>
<fieldset><legend><%=resourceBundle.getString("billDispute")%></legend>
<form>
<table>

	<tr></tr>
	<tr></tr>
	<%
		BTBMVo v2 = (BTBMVo) request.getAttribute("details");
	%>

	<tr>
		<td><label><%=resourceBundle.getString("disputeId")%> </label></td>
		<td><input type="text" value="<%=v2.getDisputeId()%>"
			readonly="readonly"></input></td>
	</tr>
	<tr>
		<td><label><%=resourceBundle.getString("billId")%> </label></td>
		<td><input type="text" value="<%=v2.getBillItemId()%>"
			readonly="readonly"></td>
	</tr>
	<tr>
		<td><label><%=resourceBundle.getString("reasonForDispute")%></label></td>
		<td><textarea name="r" readonly="readonly"><%=v2.getReason()%></textarea>
		</td>
	</tr>
	<tr>
		<td><label><%=resourceBundle.getString("dateOfRaise")%></label></td>
		<td><input type="text" value="<%=v2.getDate()%>"
			readonly="readonly"></td>
	</tr>
	<tr>
		<td><label><%=resourceBundle.getString("status")%></label></td>
		<td><input type="text" value="<%=v2.getStatus()%>"
			readonly="readonly"></td>
	</tr>
	<tr>
		<td><label><%=resourceBundle.getString("dateOfCancel")%></label></td>
		<td><input type="text" value="<%=v2.getDateOfCancel()%>"
			readonly="readonly"></td>
	</tr>
	<tr>
		<td><label><%=resourceBundle.getString("reasonForCancel")%>
		</label></td>
		<td><textarea name="r" readonly="readonly"><%=v2.getReasonForCancel()%></textarea>
		</td>
	</tr>
	<tr>
		<td><label><%=resourceBundle.getString("dateOfResolve")%></label></td>
		<td><input type="text" value="<%=v2.getDateOfResolving()%>"
			readonly="readonly"></td>
	</tr>
	<tr>
		<td><label><%=resourceBundle.getString("resolutionComments")%></label></td>
		<td><textarea name="r" readonly="readonly"><%=v2.getResolutionComments()%></textarea>
		</td>
	</tr>
	<tr>
		<td><label><%=resourceBundle.getString("adjustedCost")%>
		</label></td>
		<td><input type="text" value="<%=v2.getAdjustedCallCost()%>"
			readonly="readonly"></td>
	</tr>
</table>
</form>
</fieldset>
</div>
</div>
</div>
</body>
</html>





