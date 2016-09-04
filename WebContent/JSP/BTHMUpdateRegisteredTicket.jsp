<%@ page errorPage="/JSP/Error.jsp"%>
<%@ page language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Update Registered Ticket - Bharat Tele Services</title>
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
<form name="nameupdateticket" onsubmit="return validateupdateForm()" action="BTHMServlet">
		<%session.setAttribute("page", "viewupdatepage");%>
	<p id="mandatory">* Mandatory</p>
<p align="right"><a href="<%=request.getContextPath()%>/JSP/profile.jsp"><b>BACK</b></a></p>
<fieldset><legend><%=resourceBundle.getString("updateTicket") %></legend>
<table border="0" cellpadding="10" cellspacing="10">

	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("ticketId")%>: * </label></td>
		<td ALIGN="left"><input type="text" class="input" name="ticketid" size="40" maxlength="6" onkeypress="return isNumberKey(event)" AUTOCOMPLETE="OFF">
			
	</tr>
	<tr>
		<td ALIGN="center"><input type="submit" value="<%=resourceBundle.getString("viewTicket") %>" class="button"></input></td>
		<td ALIGN="center"><input type="reset" value="<%=resourceBundle.getString("reset") %>" class="button"/></td>

	</tr>

</table>
</fieldset>
		<%
			if (request.getAttribute("error") != null) {
		%> <br><span id="error"><%=request.getAttribute("error")%></span>
	
		<%
			}
			else{%>
			<br><span class="error" id="tiderror"></span><%
			}
		%>
</form>
</div>

</div>
</div>

</body>
</html>