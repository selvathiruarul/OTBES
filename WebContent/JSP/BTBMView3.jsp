<%@ page errorPage="/JSP/Error1.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.otbes.vo.*"%>
<%@ page import="java.util.ArrayList"%>
<%! @SuppressWarnings("unchecked") %>
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
	href="<%=request.getContextPath()%>/JSP/BTBMViewid1.jsp"><b>Back</b></a></p>
<fieldset><legend><%=resourceBundle.getString("billPayment")%></legend>
<form action="BTBMServlet" name="gen" method="post">
<% ArrayList<PaymentVO> v= (ArrayList<PaymentVO>)request.getAttribute("View"); %>



<input type="hidden" name="option" value="view2page"></input>
<table>
	<tr>
		<td><label><%=resourceBundle.getString("billId")%></label></td>
		<td></td>
		<td></td>
		<td></td>
		<td><select name="billId">
			<% for(PaymentVO v1:v)
{%>

			<option value="<%=v1.getBillId() %>"><%=v1.getBillId()%></option>
			<%} %>
		</select></td>
	</tr>
	<tr></tr>
	<tr></tr>
	<tr>
		<td></td>
		<td>
		<center><input type="submit"
			value="<%=resourceBundle.getString("submit")%>"
			onclick="return validate()" class="button"></input></center>
		</td>
	</tr>
</table>


</form>
</fieldset>
</div>
</div>
</div>
</body>
</html>


