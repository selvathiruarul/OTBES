<%@ page errorPage="/JSP/Error.jsp"%>
<%@ page import="com.otbes.language.*,java.util.Locale,java.util.ResourceBundle"%>
    <%@ page import="com.otbes.vo.BTHMEmployeeVO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link rel="stylesheet" type="text/css" href=groupf.css />
<title>BharatTele Services</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/HelpdeskValidations.js"> 
	
</script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_blue.css" id="blue" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_green.css" id="green" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_pink.css" id="pink" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_orange.css" id="orange" />

</head>
<body onKeyDown="return showKeyCode(event)" onLoad="disableBackButton();setTheme('<%=session.getAttribute("themeColor")%>')" >
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
<div id="header">
</div>

<div id="tabs"><%@ include file="/JSP/menu.jsp"%></div>

<div id="menu">
<%@ include file="/JSP/sidepane.jsp" %></div>
<div id='main'>
<fieldset><legend><%=resourceBundle.getString("employeeDetails") %></legend> 
<%BTHMEmployeeVO employee =(BTHMEmployeeVO) request.getAttribute("employee");%>
<center><p><%=resourceBundle.getString("aNewEmployeeisAddedToTheHelpDeskTeam") %></p></center>
		<p><%=resourceBundle.getString("employeeDetails") %></p>
		<p><%=resourceBundle.getString("employeeId") %>: <%= employee.getEmployeeId() %></p>
		<p><%=resourceBundle.getString("lastName") %>:<%=employee.getFirstName()+" "+(employee.getLastName()) %></p><br>

<input type="button" class="button"  value="<%=resourceBundle.getString("addAnotherEmployee") %>" onClick="self.location='BTHMAddHelpDeskEmployee.jsp'" />

</fieldset>

</div>
</div>
</div>
</body>
</html>