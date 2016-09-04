<%@ page errorPage="/JSP/Error.jsp"%>
<%@ page language="java"%>
<%@ page import="com.otbes.vo.BTHMTicketVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Delete Registered Ticket Details - Bharat Tele Services</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/HelpdeskValidations.js"> 
	
</script>
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
	enctype="multipart/form-data" action="BTHMServlet">
<%
	session.setAttribute("page", "deletepage");
%> 
<%
 	BTHMTicketVO bthmTicketVo = (BTHMTicketVO) request
 			.getAttribute("BTHMTicketVO");
 %>
 <% 
		int customer=bthmTicketVo.getCustomerId();
		int ticket=bthmTicketVo.getTicketId();
		String customerid= ""+customer;
		String ticketid= ""+ticket;
		String ticketSummary=bthmTicketVo.getTicketSummary();	
		String ticketDescription=bthmTicketVo.getTicketDescription();
		String dateRaised=bthmTicketVo.getDateRaised();		
		String ticketStatus=bthmTicketVo.getTicketStatus();	
		String ticketCategory=bthmTicketVo.getTicketCategory();	
		String ticketPriority=bthmTicketVo.getTicketPriority();	
		String uploadDoc=bthmTicketVo.getUploadDoc();		
		String ticketClosedDate=bthmTicketVo.getTicketClosedDate();	
		String resolutionComments=bthmTicketVo.getResolutionComments();
		if(customerid==null){customerid="";}
		if(ticketid==null){ticketid="";}
		if(ticketSummary==null){ticketSummary="";}
		if(ticketDescription==null){ticketDescription="";}
		if(dateRaised==null){dateRaised="";}
		if(ticketStatus==null){ticketStatus="";}
		if(ticketCategory==null){ticketCategory="";}
		if(uploadDoc==null){uploadDoc="";}
		if(ticketClosedDate==null){ticketClosedDate="";}
		if(resolutionComments==null){resolutionComments="";}
		if(ticketPriority==null){ticketPriority="";}		
	%>
<p align="right"><a href="<%=request.getContextPath()%>/JSP/BTHMDeleteRegisteredTicket.jsp"><b>BACK</b></a></p>
<fieldset><legend><%=resourceBundle.getString("deleteTicket") %></legend>
<table border="0" cellspacing="10" cellpadding="10">
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("customerId") %>:</label></td>
		<td ALIGN="left"><%out.print(customerid);%></td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("ticketId") %>:</label></td>
		<td ALIGN="left"><%out.print(ticketid);%><input type=hidden name="ticketid" value="<%out.print(ticketid);%>"></input></td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("summaryOfTheIssue") %>:</label></td>
		<td ALIGN="left"><%out.print(ticketSummary);%></td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("descriptionOfTheIssue") %>:</label></td>
		<td ALIGN="left"><%out.print(ticketDescription);%></td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("dateOfOpeningTheTicket") %>:</label></td>
		<td ALIGN="left"><%out.print(dateRaised);%></td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("statusOfTheTicket") %>:</label></td>
		<td ALIGN="left"><%out.print(ticketStatus);%></td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("issueCategory") %>:</label></td>
		<td ALIGN="left"><%out.print(ticketCategory);%></td>
	</tr>

	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("priority") %>:</label></td>
		<td ALIGN="left"><%out.print(ticketPriority);%></td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("uploadSupportingDocuments") %>:</label></td>
		<td ALIGN="left"><%out.print(uploadDoc);%></td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("dateOfClosingTheTicket") %>:</label></td>
		<td ALIGN="left"><%out.print(ticketClosedDate);%></td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("resolutionComments") %>:</label></td>
		<td ALIGN="left"><%out.print(resolutionComments);%></td>
	</tr>
</table>
<center><input type="submit" value="<%=resourceBundle.getString("deleteTicket") %>" class="button"></input></center>
</fieldset>
</form>
</div>
</div>
</div>
</body>
</html>