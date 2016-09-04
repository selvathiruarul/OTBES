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
<%@ page import="java.util.ArrayList"%>
</head>
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
	href="<%=request.getContextPath()%>/JSP/BTBMViewid1.jsp"><b>Go to View
Bill</b></a></p>
<h3><%=resourceBundle.getString("billPayment")%></h3>
<form><input type="hidden" name="option" value="view4"></input> <%!@SuppressWarnings("unchecked")%>

<%
	ArrayList<BillItemVO> billitems = new ArrayList<BillItemVO>();
	billitems = (ArrayList<BillItemVO>) request
			.getAttribute("BillItems");
%>
<h3>Bill Items</h3>
<table class="table">
	<tr>
		<th class="th"><%=resourceBundle.getString("billId")%></th>
		<th class="th"><%=resourceBundle.getString("connectionNumber")%></th>
		<th class="th"><%=resourceBundle.getString("billItemId")%></th>
		<th class="th"><%=resourceBundle.getString("callDuration")%></th>
		<th class="th"><%=resourceBundle.getString("dialledNumber")%></th>
		<th class="th"><%=resourceBundle.getString("typeOfCall")%></th>
		<th class="th"><%=resourceBundle.getString("dateOfCall")%></th>
		<th class="th"><%=resourceBundle.getString("callCost")%></th>
	</tr>
	<%
		for (int count = 0; count < billitems.size(); count++)

		{
	%>
	<tr class="tr">
		<td class="td"><%=billitems.get(count).getBillID()%></td>
		<td class="td"><%=billitems.get(count).getConnectionNo()%></td>
		<td class="td"><%=billitems.get(count).getBillItemId()%></td>
		<td class="td"><%=billitems.get(count).getCallDuration()%></td>
		<td class="td"><%=billitems.get(count).getDialledNo()%></td>
		<td class="td"><%=billitems.get(count).getTypeOfCall()%></td>
		<td class="td"><%=billitems.get(count).getDateOfCall()%></td>
		<td class="td"><%=billitems.get(count).getCallCost()%></td>
	</tr>

	<%
		}
	%>

</table>
</form>
</div>
</div>
</div>
</body>
</html>