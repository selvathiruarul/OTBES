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
<%
	ConnectionVO conn = (ConnectionVO) request
			.getAttribute("viewconnection1");
%>
<div id="wrapper">
<div id="wrapper_background">
<div id="header"></div>

<div id="tabs"><%@ include file="/JSP/menu.jsp"%></div>
<div id="menu"><%@ include file="/JSP/sidepane.jsp"%>

</div>
<div id="main">
<fieldset><legend><%=resourceBundle.getString("viewConnection")%></legend>
<form name="f1" action="BTASServlet" onsubmit="validate1()"
	method="post"><input type="hidden" name="option"
	value="viewconnection2" />
<table align="left" cellpadding="10" cellspacing="10">
	<tr>
		<td align="left"><label><%=resourceBundle.getString("customerId")%></label></td>
		<td align="left"><input type="text" name="id" value="<%=conn.getCustId()%>"
			readonly="readonly" /></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("connectionNumber")%></label></td>
		<td align="left"><input type="text" name="number"
			value="<%=conn.getConnectionNo()%>" readonly="readonly" /></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("typeOfBill")%></label></td>
		<td align="left"><input type="text" name="Typeofbill"
			value=<%=conn.getTypeOfBill()%> readonly="readonly" /></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("tariffType")%></label></td>
		<td align="left"><input type="text" name="tariff"
			value="<%=conn.getTariffType()%>" readonly="readonly" /></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("status")%></label></td>
		<td align="left"><input type="text" name="status" value="<%=conn.getStatus()%>"
			readonly="readonly" /></td>
	</tr>
	<%if(conn.getReason()!=null){%>
<tr>

<td align="left"><label><%=resourceBundle.getString("reasonForCancellation")%></label></td>
		<td align="left"><textarea name="reason" readonly="readonly" ><%=conn.getReason()%></textarea>
			  </td>
</tr>
<%} %>
</table>
</form>
</fieldset>
</div>
</div>
</div>
</body>
</html>