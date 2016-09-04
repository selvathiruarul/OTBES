<%@ page errorPage="/JSP/Error.jsp"%>
<%@ page language="java"%>
<%@ page import="com.otbes.vo.BTHMTicketVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Update Registered Ticket Details - Bharat Tele Services</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/HelpdeskValidations.js"> </script>
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

<div id="tabs"><%@ include file="/JSP/menu.jsp"%></div>



<div id="menu"><%@ include file="/JSP/sidepane.jsp"%>
</div>
<div id='main'>
<form id="idupdateticketdetails" name="nameupdateticketdetails"
	enctype="multipart/form-data"
	onsubmit="return validateupdatedetailsForm()" action="BTHMServlet">
<%
	session.setAttribute("page", "updateTicketpage");
%> <%
 	BTHMTicketVO bthmTicketVo = (BTHMTicketVO) request
 			.getAttribute("BTHMTicketVO");
 %> <%
 	int customer = bthmTicketVo.getCustomerId();
 	int ticket = bthmTicketVo.getTicketId();
 	String customerid = "" + customer;
 	String ticketid = "" + ticket;
 	String ticketSummary = bthmTicketVo.getTicketSummary();
 	String ticketDescription = bthmTicketVo.getTicketDescription();
 	String dateRaised = bthmTicketVo.getDateRaised();
 	String ticketStatus = bthmTicketVo.getTicketStatus();
 	String ticketCategory = bthmTicketVo.getTicketCategory();
 	String ticketPriority = bthmTicketVo.getTicketPriority();
 	String uploadDoc = bthmTicketVo.getUploadDoc();
 	String ticketClosedDate = bthmTicketVo.getTicketClosedDate();
 	String resolutionComments = bthmTicketVo.getResolutionComments();
 	if (customerid == null) {
 		customerid = "";
 	}
 	if (ticketid == null) {
 		ticketid = "";
 	}
 	if (ticketSummary == null) {
 		ticketSummary = "";
 	}
 	if (ticketDescription == null) {
 		ticketDescription = "";
 	}
 	if (dateRaised == null) {
 		dateRaised = "";
 	}
 	if (ticketStatus == null) {
 		ticketStatus = "";
 	}
 	if (ticketCategory == null) {
 		ticketCategory = "";
 	}
 	if (uploadDoc == null) {
 		uploadDoc = "";
 	}
 	if (ticketClosedDate == null) {
 		ticketClosedDate = "";
 	}
 	if (resolutionComments == null) {
 		resolutionComments = "";
 	}
 	if (ticketPriority == null) {
 		ticketPriority = "";
 	}
 %>
<p id="mandatory">* Mandatory</p>
<p align="right"><a
	href="<%=request.getContextPath()%>/JSP/BTHMUpdateRegisteredTicket.jsp"><b>BACK</b></a></p>
<fieldset><legend><%=resourceBundle.getString("updateTicketDetails") %></legend>
<table border="0" cellspacing="10" cellpadding="10">
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("customerId") %>:</label></td>
		<td ALIGN="left"><input type="text" class="input"
			name="customerid" size="40" readonly="readonly"
			value="<%out.print(customerid);%>">
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("ticketId") %>:</label></td>
		<td ALIGN="left"><input type="text" class="input" name="ticketid"
			size="40" readonly="readonly" value="<%out.print(ticketid);%>"><span
			class="error" id="tiderror"></span>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("summaryOfTheIssue") %>:</label></td>
		<td ALIGN="left"><textarea name="sissue" class="input" rows=3
			cols=31><%out.print(ticketSummary);%>
		</textarea><span class="error" id="sissueerror">*</span></td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("descriptionOfTheIssue") %>:</label></td>
		<td ALIGN="left"><textarea class="input" name="dissue" rows=8
			cols=31><%out.print(ticketDescription);%>
		</textarea><span class="error" id="dissueerror"></span></td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("dateOfOpeningTheTicket") %>:</label></td>
		<td ALIGN="left"><input class="input" type="text" name="dot"
			size="40" value="<%out.print(dateRaised);%>"></input><span
			class="error" id="doterror"></span></td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("statusOfTheTicket") %></label></td>
		<td ALIGN="left"><select name="status" class="input">
			<%
				if (ticketStatus.equalsIgnoreCase("open")) {
			%>
			<option selected="selected" value="OPEN">OPEN</option>
			<option value="CLOSED">CLOSED</option>
			<%
				} else {
			%>
			<option value="OPEN">OPEN</option>
			<option selected="selected" value="CLOSED">CLOSED</option>
			<%
				}
			%>
		</select><span class="error" id="lnerror"></span></td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("issueCategory") %>:</label></td>
		<td ALIGN="left"><select name="category" class="input">
			<%
				if (ticketCategory.equalsIgnoreCase("BILL DISPUTE")) {
			%>
			<option selected="selected" value="BILL DISPUTE">BILL
			DISPUTE</option>
			<option value="PROFILE ISSUES">PROFILE ISSUES</option>
			<option value="PASSWORD ISSUES">PASSWORD ISSUES</option>
			<option value="USERID ISSUES">USERID ISSUES</option>
			<option value="OTHER ISSUES">OTHER ISSUES</option>
			<%
				} else if (ticketCategory.equalsIgnoreCase("PROFILE ISSUES")) {
			%>
			<option value="BILL DISPUTE">BILL DISPUTE</option>
			<option selected="selected" value="PROFILE ISSUES">PROFILE
			ISSUES</option>
			<option value="PASSWORD ISSUES">PASSWORD ISSUES</option>
			<option value="USERID ISSUES">USERID ISSUES</option>
			<option value="OTHER ISSUES">OTHER ISSUES</option>
			<%
				} else if (ticketCategory.equalsIgnoreCase("PASSWORD ISSUES")) {
			%>
			<option value="BILL DISPUTE">BILL DISPUTE</option>
			<option value="PROFILE ISSUES">PROFILE ISSUES</option>
			<option selected="selected" value="PASSWORD ISSUES">PASSWORD
			ISSUES</option>
			<option value="USERID ISSUES">USERID ISSUES</option>
			<option value="OTHER ISSUES">OTHER ISSUES</option>
			<%
				} else if (ticketCategory.equalsIgnoreCase("USERID ISSUES")) {
			%>
			<option value="BILL DISPUTE">BILL DISPUTE</option>
			<option value="PROFILE ISSUES">PROFILE ISSUES</option>
			<option value="PASSWORD ISSUES">PASSWORD ISSUES</option>
			<option selected="selected" value="USERID ISSUES">USERID
			ISSUES</option>
			<option value="OTHER ISSUES">OTHER ISSUES</option>
			<%
				} else {
			%>
			<option value="BILL DISPUTE">BILL DISPUTE</option>
			<option value="PROFILE ISSUES">PROFILE ISSUES</option>
			<option value="PASSWORD ISSUES">PASSWORD ISSUES</option>
			<option value="USERID ISSUES">USERID ISSUES</option>
			<option selected="selected" value="OTHER ISSUES">OTHER
			ISSUES</option>
			<%
				}
			%>
		</select><span class="error" id="lnerror"></span></td>
	</tr>

	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("priority") %>:</label></td>
		<td ALIGN="left"><select class="input" name="priority">
			<%
				if (ticketPriority.equalsIgnoreCase("HIGH")) {
			%>
			<option selected="selected" value="HIGH">HIGH</option>
			<option value="MEDIUM">MEDIUM</option>
			<option value="LOW">LOW</option>
			<%
				} else if (ticketPriority.equalsIgnoreCase("MEDIUM")) {
			%>
			<option value="HIGH">HIGH</option>
			<option selected="selected" value="MEDIUM">MEDIUM</option>
			<option value="LOW">LOW</option>
			<%
				} else {
			%>
			<option value="HIGH">HIGH</option>
			<option value="MEDIUM">MEDIUM</option>
			<option selected="selected" value="LOW">LOW</option>
			<%
				}
			%>
		</select><span class="error" id="lnerror"></span></td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("uploadSupportingDocuments") %>:</label></td>
		<td ALIGN="left"><input class="input" type="text" name="docpath"
			size="40" value="<%out.print(uploadDoc);%>"><br>
		<input type="file" name="path" size="40"><span class="error"
			id="udocerror"></span></td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("dateOfClosingTheTicket") %>:</label></td>
		<td ALIGN="left"><input class="input" type="text" name="doc"
			size="40" readonly="readonly"
			value="<%out.print(ticketClosedDate);%>"></input><span class="error"
			id="doterror"></span></td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("resolutionComments") %>:</label></td>
		<td ALIGN="left"><textarea class="input" name="rcomment" rows=4
			cols=31>
		<%
			out.print(resolutionComments);
		%>
		</textarea><span class="error" id="rcerror"></span></td>
	</tr>
	<tr>
		<td ALIGN="center"><input type="submit" value="<%=resourceBundle.getString("updateTicket") %>"
			class="button"></input></td>
		<td ALIGN="center"><input type="reset" value="<%=resourceBundle.getString("reset") %>"
			class="button" /></td>

	</tr>

</table>
</fieldset>
</form>
</div>

</div>
</div>
</body>
</html>