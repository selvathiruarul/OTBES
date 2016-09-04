<%@ page errorPage="/JSP/Error1.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="com.otbes.vo.*"%>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>OTBES</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/highlight.js"> </script>
<meta name="keywords" content="" />
<meta name="keywords" content="" />
<meta name="description" content="" />
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



<div id='main'><br>
<p align="right"><a
	href="<%=request.getContextPath()%>/JSP/BTBMAdminView.jsp"><b>Back</b></a></p>
<h3><%=resourceBundle.getString("billDispute")%></h3>
<form action="BTBMServlet" method="post" onSubmit="return validate()">
<input type="hidden" name="option" value="highlight2"></input>
<table>
	<tr>
		<th class="th"><%=resourceBundle.getString("billId")%></th>
		<th class="th"><%=resourceBundle.getString("disputeId")%></th>
		<th class="th"><%=resourceBundle.getString("userId")%></th>
		<th class="th"><%=resourceBundle.getString("status")%></th>
		<th class="th"><%=resourceBundle.getString("raisedDate")%></th>
		<th class="th"><%=resourceBundle.getString("disputeReason")%></th>
		<th class="th"><%=resourceBundle.getString("dateOfCancel")%></th>
		<th class="th"><%=resourceBundle.getString("reasonForCancel")%></th>
	</tr>
	<%
		BTBMVo vo = (BTBMVo) request.getAttribute("result");
	%>
	<%
		int index = vo.getIndex();
		for (int i = 0; i < index; i++) {
			BTBMVo vo1 = vo.getListVO().get(i);
	%>



	<tr class="tr">
		<td class="td"><%=vo1.getBillItemId()%></td>
		<td class="td"><%=vo1.getDisputeId()%></td>
		<td class="td"><%=vo1.getUserId()%></td>
		<td class="td"><%=vo1.getStatus()%></td>
		<td class="td"><%=vo1.getDate()%></td>
		<td class="td"><%=vo1.getReason()%></td>
		<td class="td"><%=vo1.getDateOfCancel()%></td>
		<td class="td"><%=vo1.getReasonForCancel()%></td>
		<td class="td"><input type="radio" name="select"
			value="<%=vo1.getDisputeId()%>"></input></td>
	</tr>
	<%
		}
	%>

</table>
<table>
	<tr>

		<td><input type="submit" name="redirect"
			value="<%=resourceBundle.getString("resolve")%>" class="button"></input></td>
	</tr>

</table>
</form>




</div>
</div>
</div>
</body>
</html>



