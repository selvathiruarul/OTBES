<%@ page errorPage="/JSP/Error.jsp"%>
<%@ page language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>View Ticket Details</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/validate.js"> </script>
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
<div id="menu">
<%@ include file="/JSP/sidepane.jsp" %>
</div>
<div id="main">
<form name="viewTicket" method="post" action="BTHMServlet" onSubmit="return ticketIdValidateView()">

<%session.setAttribute("page","viewpage"); %>
<p id="mandatory">* Mandatory</p>
<p align="right"><a href="<%=request.getContextPath()%>/JSP/profile.jsp"><b>BACK</b></a></p>
<fieldset>
<legend><%=resourceBundle.getString("viewTicketDetails") %></legend>

<table border="0">
<tr>
<td  ALIGN="left"><label><%=resourceBundle.getString("enterTicketId") %>*</label></td>
<td><input type="text" name="ticket" id="ticketid" maxlength="6" onKeyPress="return isNumberKey(event)"></input>
</td>
</tr>
</table>
<input type="submit" name="Submit" value="<%=resourceBundle.getString("viewDetails")%>" class="button"></input>
<p><span id="inputerror">
<%
if(request.getAttribute("message")!=null){%>
	<%=request.getAttribute("message")%>
	<%}%>
	</span></p>
	</fieldset>
</form>
</div>

</div>
</div>
</body>
</html>