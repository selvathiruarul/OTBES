<%@ page errorPage="/JSP/Error.jsp"%>
<%@ page language="java"%>
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
<%session.setAttribute("page", "view");%>
</div>

<div id="tabs"><%@ include file="/JSP/menu.jsp"%></div>
<div id="menu">
<%@ include file="/JSP/sidepane.jsp" %></div>
<div id='main'>

<form name="viewEmployee"  action="BTHMServlet" onsubmit="return employeeViewIdValidate()" method="post">

<p id="mandatory">* Mandatory</p><fieldset>
<p align="right"><a href="<%=request.getContextPath()%>/JSP/profile.jsp"><b>BACK</b></a></p>
<legend><%=resourceBundle.getString("viewHelpDeskEmployeeDetails") %></legend>
<center>
<table border="0">
<tr></tr>
<tr>
<td  ALIGN="center"><label><%=resourceBundle.getString("enterEmployeeId") %></label></td><td  ALIGN="center"><input type="text" name="employeeId" maxlength="6" onKeyPress="return isNumberKey(event)"/>
</tr>
<tr>
<td  ALIGN="center"><input type="submit"  value="<%=resourceBundle.getString("view")%>" class="button"/></td><td  ALIGN="center"><input type="reset" value=<%=resourceBundle.getString("reset")%> class="button" /></td>
</tr>
 
</table></center>
</fieldset>

</form>
<%  if(request.getAttribute("message")!=null) { %>
<span id="eperror">
<%=request.getAttribute("message") %> 
</span>
<%
			}
			else{%>
			<br><span class="error" id="eperror"></span><%
			}
		%>
</div>
</div>
</div>

</body>
</html>