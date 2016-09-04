<%@ page errorPage="/JSP/Error.jsp"%>
<%@ page language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.otbes.vo.BTHMCustomerVO"%>
<%@ page import="java.text.DateFormat"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<html>
<head>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>New Ticket Registration For Customer - Bharat Tele Services</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/HelpdeskValidations.js"></script>
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
<div id="menu"><%@ include file="/JSP/sidepane.jsp"%></div>
<div id='main'>
<form id="idraisenewticket" name="raisenewticket" method="post"
	onsubmit="return validateraiseForm()" action="BTHMServlet">	

<p id="mandatory">* Mandatory</p>
<%
	session.setAttribute("page", "createpage");

%>
<p align="right"><a href="<%=request.getContextPath()%>/JSP/BTHMNewTicket.jsp"><b>BACK</b></a></p>
<fieldset><legend><%=resourceBundle.getString("raiseTicket") %></legend> <%
 	BTHMCustomerVO bthmCustomerVo = (BTHMCustomerVO) request
 			.getAttribute("BTHMCustomerVO");
 %>
<table border="0" cellspacing="10" cellpadding="10">
	<tr>
		<td ALIGN="left"><label class="label"><%=resourceBundle.getString("customerId")%>: * </label></td>
		<td ALIGN="left"><input type="text" name="customerid" size="40" 
			class="input" value="<%out.print(bthmCustomerVo.getCustomerId());%>" readonly="readonly"><span
			class="error" id="ciderror"></span>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("summaryOfTheIssue")%>: * </label></td>
		<td ALIGN="left"><textarea name="sissue" rows=3 cols=31	class="input"></textarea><span class="error" id="sissueerror"></span></td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("descriptionOfTheIssue")%>: * </label></td>
		<td ALIGN="left"><textarea name="dissue" rows=8 cols=31 class="input"></textarea><span class="error" id="dissueerror"></span></td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("dateOfOpeningTheTicket")%>:  </label></td>
		<td ALIGN="left"><input type="text" name="dot" size="40" 
		<%DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
			String formattedDate = df.format(new Date());%>
			value="<%out.print(formattedDate);%>" class="input"
			readonly="readonly"></input><span class="error" id="doterror"></span></td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("statusOfTheTicket")%>:  </label></td>
		<td ALIGN="left"><select name="status" class="input">
			<option value="OPEN">OPEN</option>			
		</select><span class="error" id="soterror"></span></td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("issueCategory")%>:  </label></td>
		<td ALIGN="left"><select name="category" class="input">
			<option value="BILL DISPUTE">BILL DISPUTE</option>
			<option value="PROFILE ISSUES">PROFILE ISSUES</option>
			<option value="PASSWORD ISSUES">PASSWORD ISSUES</option>
			<option value="USERID ISSUES">USERID ISSUES</option>
			<option value="OTHER ISSUES">OTHER ISSUES</option>
		</select><span class="error" id="iserror"></span></td>
	</tr>

	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("priority")%>:  </label></td>
		<td ALIGN="left"><select name="priority" class="input">
			<option value="HIGH">HIGH</option>
			<option value="MEDIUM">MEDIUM</option>
			<option value="LOW">LOW</option>
		</select><span class="error" id="prerror"></span></td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("uploadSupportingDocuments")%>:</label></td>
		<td ALIGN="left"><input type="file" name="path" size="40" accept='image/*'
			class="input"><span class="error" id="udocerror"></span></td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("resolutionComments")%>:</label></td>
		<td ALIGN="left"><textarea name="rcomment" rows=4 cols=31 class="input"></textarea><span class="error" id="rcerror"></span></td>
	</tr>
	<tr>
		<td ALIGN="center"><input type="submit" value="<%=resourceBundle.getString("registerTicket")%>"
			class="button" /></td>
		<td ALIGN="center"><input type="reset" value="<%=resourceBundle.getString("reset")%>"
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