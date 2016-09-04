<%@ page errorPage="/JSP/Error.jsp"%>

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
<%session.setAttribute("page", "insert");%>
</div>

<div id="tabs"><%@ include file="/JSP/menu.jsp"%></div>

<div id="menu"><%@ include file="/JSP/sidepane.jsp"%>
</div>

<div id='main'>
<%  if(request.getAttribute("message")!=null) { %> <span id="error">
<%=request.getAttribute("message") %> </span> <%}%>

<form name="addHelpDeskEmployee" action="BTHMServlet"
	onSubmit="return addEmployeeValidate()" method="post">


<fieldset>
<p id="mandatory">* Mandatory</p>
<p align="right"><a href="<%=request.getContextPath()%>/JSP/profile.jsp"><b>BACK</b></a></p>
<legend><%=resourceBundle.getString("newHelpDeskEmployee") %></legend>
<table border="0" cellspacing=10 cellpadding=10>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("firstName") %></label></td>
		<td ALIGN="left"><input type="text" name="firstname" maxlength="20"
			onKeyPress="return isCharacter(event)" /><span class="error"
			id="fnerror">*</span>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("middleName") %></label></td>
		<td ALIGN="left"><input type="text" name="middlename" maxlength="20"
			onKeyPress="return isCharacter(event)" /><span class="error"
			id="mnerror"></span></td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("lastName") %></label></td>
		<td ALIGN="left"><input type="text" name="lastname" maxlength="20"
			onKeyPress="return isCharacter(event)" /><span class="error"
			id="lnerror">*</span></td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("designation") %></label></td>
		<td ALIGN="left"><select name="designation">
			<option selected="selected">TEAM MEMBER</option>
			<option>TEAM LEADER</option>
			<option>PROJECT MANAGER</option>
		</select></td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("dateOfJoining") %></label></td>
		<td ALIGN="left"><input type="text" readonly="readonly"
			name="dateofjoining" id="dateinput"></input> <img
			src="<%=request.getContextPath()%>/IMAGES/CALENDAR_IMAGES/cal.gif"
			class="calendar" style="cursor: pointer;"
			onclick="javascript:NewCssCal ('dateinput','ddMMyyyy')" /> <span
			class="error" id="dojerror">*</span></td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("panCardNumber") %></label></td>
		<td ALIGN="left"><input type="text" maxlength="10" name="pancard" onKeyPress="return isAlphaNumeric(event)" /><span
			class="error" id="pnerror">*</span></td>
	</tr>
	<tr>
		<td ALIGN="left"><label><%=resourceBundle.getString("employeeStatus") %></label></td>
		<td ALIGN="left"><label>ACTIVE</label></td>
	</tr>
	<tr>
		<td ALIGN="left"><input type="submit" class="button" value="<%=resourceBundle.getString("add") %>" /></td>
		<td ALIGN="left"><input type="reset" class="button" value="<%=resourceBundle.getString("reset") %>" /></td>
	</tr>

</table>
</fieldset>

</form>
</div>
</div>
</div>

</body>
</html>
