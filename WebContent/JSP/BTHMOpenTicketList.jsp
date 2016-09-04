<%@ page errorPage="/JSP/Error.jsp"%>
<%@ page language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Open Tickets</title>
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
<div id="menu">
<%@ include file="/JSP/sidepane.jsp" %>
</div>
<div id="main">
<p align="right"><a href="<%=request.getContextPath()%>/JSP/profile.jsp"><b>BACK</b></a></p>

<form method="post" action="BTHMServlet" >
<fieldset>
<legend><%=resourceBundle.getString("assignTicketToEmployee")%></legend>
<%session.setAttribute("page","AssignTicketPage"); %>
<input type="submit" name="submit" value="<%=resourceBundle.getString("showOpenTicketList") %>" class="button"></input>
</fieldset>
</form>
<% 
if(request.getAttribute("message")!=null){%>
	<p><span id="error"><%=request.getAttribute("message")%></span></p>
	<%}%>
</div>
</div>
</div>
</body>
</html>