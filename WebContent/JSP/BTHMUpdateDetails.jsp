<%@ page errorPage="/JSP/Error.jsp"%>
<%@ page import="com.otbes.vo.BTHMEmployeeVO"  %>
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

<div id="header">
<%session.setAttribute("page", "updateEmployeeDetails");%>
</div>
<div id="tabs"><%@ include file="/JSP/menu.jsp"%></div>

<div id="menu">
<%@ include file="/JSP/sidepane.jsp" %>
</div>
<div id='main'>

<form name="updateDetails" onsubmit="return updateEmployeeValidate()" method="post" action="BTHMServlet"  style="text-align: center">

<%BTHMEmployeeVO emp =(BTHMEmployeeVO) request.getAttribute("employeeVO");
String middlename=emp.getMiddleName();
if(middlename==null){middlename="";}%>

<p id="mandatory">* Mandatory</p>
<p align="right"><a href="<%=request.getContextPath()%>/JSP/BTHMUpdateEmployee.jsp"><b>BACK</b></a></p>
<fieldset>
<legend><%=resourceBundle.getString("updateHelpDeskEmployeeDetails")%></legend>
<table border="0" cellspacing=10 cellpadding=10>
<tr>
<td  ALIGN="left"><label><%=resourceBundle.getString("employeeId")%></label></td><td  ALIGN="left"><input type="text" name="empid" readonly="readonly" value="<%=emp.getEmployeeId()%>"/>
</td>
</tr>

<tr>
<td  ALIGN="left"><label><%=resourceBundle.getString("firstName")%></label></td><td  ALIGN="left"><input type="text" name="firstname"  maxlength="20" onKeyPress="return isCharacter(event)" value="<%=emp.getFirstName()%>" /><span class="error" id="fnerror">*</span></td>
</tr>

<tr>
<td  ALIGN="left"><label><%=resourceBundle.getString("middleName")%></label></td><td  ALIGN="left"><input type="text" name="middlename"  maxlength="20" onKeyPress="return isCharacter(event)" value="<%=middlename%>"/><span class="error" id="mnerror"></span></td>
</tr>

<tr>
<td  ALIGN="left"><label><%=resourceBundle.getString("lastName")%></label></td><td  ALIGN="left"><input type="text" name="lastname"  maxlength="20" onKeyPress="return isCharacter(event)" value="<%=emp.getLastName()%>"/><span class="error" id="lnerror">*</span></td>
</tr>

<tr>
	<td  ALIGN="left"><label><%=resourceBundle.getString("designation")%></label></td>
	<td  ALIGN="left">
		<select name="designation">
		<option selected="selected" value="<%=emp.getDesignation()%>"><%=emp.getDesignation()%></option>
		<%if(!emp.getDesignation().equalsIgnoreCase("TEAM MEMBER")) {%><option  value="TEAM MEMBER">TEAM MEMBER</option><%} %>
		<%if(!emp.getDesignation().equalsIgnoreCase("TEAM LEADERr")) {%><option value="TEAM LEADER">TEAM LEADER</option><%} %>
		<%if(!emp.getDesignation().equalsIgnoreCase("PROJECT MANAGER")) {%><option value="PROJECT MANAGER">PROJECT MANAGER</option><%} %>
		</select>
	</td>
</tr>

<tr>
<td  ALIGN="left"><label><%=resourceBundle.getString("dateOfJoining")%></label></td>
<td ALIGN="left"><input  type="text"  readonly="readonly" name="dateofjoining" value="<%=emp.getDateOfJoining()%>" id="dateinput"></input>
<img src="<%=request.getContextPath()%>/IMAGES/CALENDAR_IMAGES/cal.gif" class="calendar" style="cursor: pointer;" onclick="javascript:NewCssCal ('dateinput','ddMMyyyy')" /> 
<span class="error" id="dojerror">*</span></td>
</tr>

<tr>
<td  ALIGN="left"><label><%=resourceBundle.getString("panCardNumber")%></label></td><td  ALIGN="left"><input type="text" name="pancard" maxlength="10" value="<%=emp.getPancard()%>"  onKeyPress="return isAlphaNumeric(event)"/><span class="error" id="pnerror">*</span></td>
</tr>

<tr>
<td  ALIGN="left"><label><%=resourceBundle.getString("employeeStatus")%></label></td><td  ALIGN="left"><input type="text" name="status" readonly="readonly" value="<%=emp.getStatus()%>" /></td>
</tr>



</table>
<input type="submit"  class="button" value="<%=resourceBundle.getString("submit")%>" />
</fieldset>



</form>

</div>

</div>
</div>

</body>
</html>