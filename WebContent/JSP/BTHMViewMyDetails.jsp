<%@ page errorPage="/JSP/Error.jsp"%>
<%@ page language="java"%>
    <%@ page import="com.otbes.vo.BTHMEmployeeVO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link rel="stylesheet" type="text/css" href=groupf.css />
<title>BharatTele Services</title>
<script type="text/javascript" 
  src="<%=request.getContextPath()%>/JS/validate.js"> 

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

<div id="header">
</div>

<div id="tabs"><%@ include file="/JSP/menu.jsp"%></div>
<div id="menu"><%@ include file="/JSP/sidepane.jsp" %></div>

<div id='main'>

<form name="viewDetails" style="text-align: center">

<%BTHMEmployeeVO emp =(BTHMEmployeeVO) session.getAttribute("employeeDetails");%>
<center>
<fieldset>
<legend><%=resourceBundle.getString("viewHelpDeskEmployeeDetails")%></legend>
<table border="0" cellspacing=10 cellpadding=10>

<tr>
<td  ALIGN="left"><label><%=resourceBundle.getString("employeeId")%></label></td><td  ALIGN="left"><%=emp.getEmployeeId()%> 
</td>
</tr>

<tr>
<td  ALIGN="left"><label><%=resourceBundle.getString("firstName")%></label></td><td  ALIGN="left"><%=emp.getFirstName()%> </td>
</tr>
<%if(emp.getMiddleName()!=null){%>
<tr>
<td  ALIGN="left"><label><%=resourceBundle.getString("middleName")%></label></td><td  ALIGN="left"><%=emp.getMiddleName()%></td>
</tr>
<%} %>
<tr>
<td  ALIGN="left"><label><%=resourceBundle.getString("lastName")%></label></td><td  ALIGN="left"><%=emp.getLastName()%></td>
</tr>

<tr>
	<td  ALIGN="left"><label><%=resourceBundle.getString("designation")%></label></td>
	<td  ALIGN="left"><%=emp.getDesignation()%>
	</td>
</tr>

<tr>
<td  ALIGN="left"><label><%=resourceBundle.getString("dateOfJoining")%></label></td><td  ALIGN="left"><%=emp.getDateOfJoining()%></td>
</tr>

<tr>
<td  ALIGN="left"><label><%=resourceBundle.getString("panCardNumber")%></label></td><td  ALIGN="left"><%=emp.getPancard()%></td>
</tr>

<tr>
<td  ALIGN="left"><label><%=resourceBundle.getString("employeeStatus")%></label></td><td  ALIGN="left"><%=emp.getStatus()%></td>
</tr>
</table>
</fieldset>
</center>

</form>

</div>

</div>
</div>
</body>
</html>