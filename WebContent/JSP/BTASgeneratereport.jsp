<%@ page errorPage="/JSP/Error1.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/CALENDAR_JS/dateJS.js"> 
	</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OTBES</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/validate.js"> </script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_blue.css" id="blue" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_green.css" id="green" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_pink.css" id="pink" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_orange.css" id="orange" />
</head>
<body>
<form action="GenerateServlet" method="post">
<input type="hidden" name="option" value="generate"></input>"
<table>
<tr>
		<td ALIGN="left"><label>From:</label></td>
		<td ALIGN="left"><input type="text" 
			name="from" id="datefrom"></input> <img
			src="<%=request.getContextPath()%>/IMAGES/CALENDAR_IMAGES/cal.gif"
			class="calendar" style="cursor: pointer;"
			onclick="javascript:NewCssCal ('datefrom','ddMMyyyy')" /> <span
			class="error" id="dojerror">*</span></td>
	</tr>
<tr>
		<td ALIGN="left"><label>TO:</label></td>
		<td ALIGN="left"><input type="text" 
			name="to" id="dateto"></input> <img
			src="<%=request.getContextPath()%>/IMAGES/CALENDAR_IMAGES/cal.gif"
			class="calendar" style="cursor: pointer;"
			onclick="javascript:NewCssCal ('dateto','ddMMyyyy')" /> <span
			class="error" id="dojerror">*</span></td>
	</tr>
	<tr> <td><input type="submit" value="Generate"></input></td></tr>
</table>
</form>
</body>
</html>