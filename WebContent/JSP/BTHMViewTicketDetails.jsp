<%@ page errorPage="/JSP/Error.jsp"%>
<%@ page language="java" %>
<%@ page import="com.otbes.vo.BTHMTicketVO"%>
<%@ page import="java.util.Date,java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/validate.js"> </script>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>View Ticket Details</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_blue.css" id="blue" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_green.css" id="green" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_pink.css" id="pink" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_orange.css" id="orange" />
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

<div id="tabs"></div>
<div id="tabs"><%@ include file="/JSP/menu.jsp"%></div>
<div id="menu"><%@ include file="/JSP/sidepane.jsp"%>
</div>
<div id="main">
<%
	session.setAttribute("page", "UpdateTicketDetails");
%> <%
 	BTHMTicketVO ticketId = (BTHMTicketVO) request
 			.getAttribute("ticketdetails");
 	if (ticketId.getTicketStatus().matches("Assigned")) {
 %>
<form name="view" method="post" action="BTHMServlet"
	onsubmit="return validateEmployeeUpdate()">
<fieldset><legend><%=resourceBundle.getString("viewTicketDetails")%></legend>
<p id="mandatory">* Mandatory</p>
<table border="0" cellspacing=10 cellpadding=10>
	<tr>
		<td><%=resourceBundle.getString("ticketId")%></td>
		<td ALIGN="left"><input type="text" name="ticketid"
			value="<%=ticketId.getTicketId()%>" readonly="readonly"></input></td>
	</tr>
	<tr>
		<td ><%=resourceBundle.getString("summaryOfTheIssue")%></td>
		<td ALIGN="left"><textarea name="shortSummary" readonly="readonly"><%=ticketId.getTicketSummary()%></textarea></td>
	</tr>
	<tr>
		<td><% %><%=resourceBundle.getString("descriptionOfTheIssue")%></td>
		<td ALIGN="left"><textarea name="description"><%=ticketId.getTicketDescription()%></textarea></td>
	</tr>
	<tr>
		<td><%=resourceBundle.getString("issueCategory")%>:</td>
		<td ALIGN="left"><input type="text" value="<%=ticketId.getTicketCategory()%>"
			name="ticketCategory" readonly="readonly"></input></td>
	</tr>
	<tr>
		<td><%=resourceBundle.getString("priority")%>:</td>
		<td ALIGN="left"><input type="text" name="ticketPriority"
			value="<%=ticketId.getTicketPriority()%>" readonly="readonly"></input></td>
	</tr>
	<tr>
		<td><%=resourceBundle.getString("statusOfTheTicket")%></td>
		<td ALIGN="left"><select name="status">
			<option value="<%=ticketId.getTicketStatus()%>"><%=ticketId.getTicketStatus()%></option>
			<option value="Closed">Closed</option>
		</select></td>
	</tr>
	<tr>
		<td><%=resourceBundle.getString("resolutionComments")%>:*</td>
		<td><textarea name="resolutionComments" id="resolutionComment"><%if(ticketId.getResolutionComments()!=null)out.print(ticketId.getResolutionComments()); %></textarea></td>
	</tr>
	<tr><td></td>
		<td align="center"><input type="submit" value="<%=resourceBundle.getString("update") %>"
			class="button" /></td>
	</tr>
</table>
<p>
<span id="error">
<%
	if (request.getAttribute("message") != null) {
%> <%=request.getAttribute("message")%>
<%
	}
%>
</span></p>
</fieldset>
</form>
<%
	} else {
%>
<p>Ticket Closed</p>
<%
	}
%>
</div>
</div>
</div>
</body>
</html>