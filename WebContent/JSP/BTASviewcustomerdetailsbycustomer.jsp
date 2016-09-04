<%@ page errorPage="/JSP/Error1.jsp"%>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.otbes.vo.*"%>
<%@ page import="javax.servlet.http.HttpSession.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>OTBES</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/validate.js"> </script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_blue.css" id="blue" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_green.css" id="green" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_pink.css" id="pink" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_orange.css" id="orange" />
<%
	CustomerVO cust = (CustomerVO) request.getAttribute("customer4");
%>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="layout.css" rel="stylesheet" type="text/css" />
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

<div id='main'>

<fieldset><legend><%=resourceBundle.getString("viewCustomerDetailsByCustomer")%></legend>
<form name="view" method="post" action="BTASServlet"><input
	type="hidden" name="option" value="viewbycustomer">
<table border=0 cellspacing=10 cellpadding=10 align="center">
	<tr>
		<td align="left"><label><%=resourceBundle.getString("customerId")%></label></td>
		<td align="left"><input type="text" name="id" readonly="readonly"
			value=<%=session.getAttribute("userid")%>></input></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("firstName")%></label></td>
		<td align="left"><input type="text" name="fn" readonly="readonly" value=<%=cust.getFirstName()%>></input></td>
	</tr>
	<tr>
		<td align="left"><label> <%=resourceBundle.getString("middleName")%></label></td>
		<td align="left"><input type="text" name="mn" readonly="readonly" value=<%=cust.getMiddleName()%>></input></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("lastName")%></label></td>
		<td align="left"><input type="text" name="ln" readonly="readonly" value=<%=cust.getLastName()%>></input></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("address")%></label></td>
		<td align="left"><textarea rows=5 name="add" readonly="readonly"><%=cust.getAddress()%></textarea></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("state")%></label></td>
		<td align="left"><input type="text" name="state" readonly="readonly" value=<%=cust.getState()%>></input></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("country")%></label></td>
		<td align="left"><input type="text" name="country" readonly="readonly" value=<%=cust.getCountry()%>></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("pincode")%></label></td>
		<td align="left"><input type="text" name="pincode" readonly="readonly" value=<%=cust.getPinCode()%>></input></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("contact")%></label></td>
		<td align="left"><input type="text" name="contact" readonly="readonly" value=<%=cust.getPhoneNo()%>></input></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("email")%></label></td>
		<td align="left"><input type="text" name="email" readonly="readonly" value=<%=cust.getEmail()%>></input></td>
	</tr>


</table>

</form>
</fieldset>
</div>
</div>
</div>
</body>
</htMl>