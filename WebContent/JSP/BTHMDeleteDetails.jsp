<%@ page errorPage="/JSP/Error.jsp"%>
<%@ page import="com.otbes.vo.BTHMEmployeeVO"%>
<%@ page language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>BharatTele Services</title>
<script type="text/javascript"
	
src="<%=request.getContextPath()%>/JS/HelpdeskValidations.js"> 

</script>
<script type="text/javascript" 
  src="<%=request.getContextPath()%>/JS/CALENDAR_JS/dateJS.js"> 
	
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

<div id="header"><%	session.setAttribute("page", "deletedetails");%></div>

<div id="tabs"><%@ include file="/JSP/menu.jsp"%></div>

<div id="menu"><%@ include file="/JSP/sidepane.jsp" %></div>

<div id='main'>
<%
	BTHMEmployeeVO evo = (BTHMEmployeeVO) request.getAttribute("employeeVO");
%>

<form name="deletedetailsEmployee" onSubmit="return deleteEmployeeValidate()"
	method="post" action="BTHMServlet">
	<p id="mandatory">* Mandatory</p>
	<p align="right"><a href="<%=request.getContextPath()%>/JSP/BTHMDelete.jsp"><b>BACK</b></a></p>
<fieldset><legend><%=resourceBundle.getString("deleteHelpDeskEmployeeDetails") %></legend>
<table border="0" cellspacing=10 cellpadding=10>

	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("employeeId") %></label></td>
		<td ALIGN="left"><input type="text" name="employeeId" readonly="readonly"
			value="<%=evo.getEmployeeId()%>" /><span class="error" id="emperror"></span>
		</td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("employeeStatus") %></label></td>
		<td ALIGN="left"><label>INACTIVE</label></td>
	</tr>
	<tr>
	<td  ALIGN="left"><label><%=resourceBundle.getString("dateOfSeparation") %></label></td>
	<td ALIGN="left"><input  type="text"  readonly="readonly" name="dateofseparation" id="dateinput"></input>
	<img src="<%=request.getContextPath()%>/IMAGES/CALENDAR_IMAGES/cal.gif" class="calendar" style="cursor: pointer;" onclick="javascript:NewCssCal ('dateinput','ddMMyyyy')" /> 
	<span class="error" id="doserror">*</span></td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("reasonForSeparation") %></label></td>
		<td ALIGN="left"><textarea name="reasonforseparartion" cols="25"
			rows="5"></textarea><span class="error" id="rserror">*</span></td>
	</tr>
	
	<tr>
		<td ALIGN="left"><input type="submit"  class="button" value="<%=resourceBundle.getString("delete") %>" /></td>
		<td ALIGN="left"><input type="reset" class="button" value="<%=resourceBundle.getString("reset") %>" /></td>
	</tr>
</table>
<input type="hidden" name="dateofjoining" value="<%=evo.getDateOfJoining()%>" ></input>
</fieldset>
</form>
</div>
</div>
</div>
</body>
</html>