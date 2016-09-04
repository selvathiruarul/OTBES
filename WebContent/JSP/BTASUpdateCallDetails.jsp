<%@ page errorPage="/JSP/Error1.jsp"%>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.ArrayList,com.otbes.vo.CallDetailVO"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="com.otbes.language.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OTBES</title>


<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/connectionnocheck.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/validate.js"> </script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_blue.css" id="blue" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_green.css" id="green" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_pink.css" id="pink" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_orange.css" id="orange" />
</head>
<body onKeyDown="return showKeyCode(event)"  onLoad="disableBackButton();setTheme('<%=session.getAttribute("themeColor")%>')">
<%
response.setHeader("Pragma","no-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires",0);
String role=(String)session.getAttribute("User");

if(role==null)
	response.sendRedirect("index.jsp");
%>

<div id="wrapper">
<div id="wrapper_background">

<div id="header"></div>
<div id="tabs"><%@ include file="/JSP/menu.jsp"%></div>
<div id="menu"><%@ include file="/JSP/sidepane.jsp"%>

</div>
<%
	ArrayList<CallDetailVO> call = (ArrayList<CallDetailVO>) request
			.getAttribute("CallDetail");
	CallDetailVO callDetails = call.get(0);
%>
<div id="main">
<fieldset><legend><%=resourceBundle.getString("updateCallDetails")%></legend>
<form action="BTASServlet" method="post" name="form1"
	onsubmit="return updateCallDetails()">
<div id="mandatory"><%=resourceBundle.getString("allFieldsAreMandatory")%></div>
<input type="hidden" name="option" value="updatecalldetails" />

<table>

	<tr>
		<td align="left"><label><%=resourceBundle.getString("callId")%></label></td>

		<td align="left"><input type="text" id="callid" readonly="readonly"
			name="callid" value=<%=callDetails.getCallID()%> /></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("connectionNumber")%></label></td>

		<td align="left"><input type="text" id="connno" readonly="readonly"
			name="connno" value=<%=callDetails.getConnectionNo()%> /></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("dateOfCall")%></label></td>
		<td align="left"><input type="text" id="dateofcall" name="dateofcall" readonly="readonly"
			value=<%=callDetails.getDateOfCall()%> /><span id="derror"></span></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("calledNumber")%></label></td>
		<td align="left"><input type="text" id="calledno" name="calledno" readonly="readonly""
			value=<%=callDetails.getDialedNo()%> /><span id="cerror"></span></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("duration")%></label></td>
		<td align="left"><input type="text" id="duration" name="duration" maxlength="5"
			value=<%=callDetails.getDuration()%> /><span id="duerror"></span></td>
	</tr>
	
	
	<% if(callDetails.getTypeOfCall().equalsIgnoreCase("LOCAL")){%>
		<tr>
		<td align="left"><label><%=resourceBundle.getString("typeOfCall")%></label></td>
		<td align="left"><select name="type">
			<option value="<%=callDetails.getTypeOfCall()%>"><%=callDetails.getTypeOfCall()%>
			</option>
			<option value="STD">STD</option>
			<option value="ISD">ISD</option>
			
			
		</select></td></tr>
	
	<%} else if (callDetails.getTypeOfCall().equalsIgnoreCase("STD")){%>
	<tr>
	<td align="left"><label><%=resourceBundle.getString("typeOfCall")%></label></td>
		<td align="left"><select name="type">
		<option value="<%=callDetails.getTypeOfCall()%>"><%=callDetails.getTypeOfCall()%>
			</option>
		<option value="LOCAL">LOCAL</option>
			
			<option value="ISD">ISD</option>
			</select></td></tr>
	
	
		<%} else if  (callDetails.getTypeOfCall().equalsIgnoreCase("ISD")){%>
	<tr>
	<td align="left"><label><%=resourceBundle.getString("typeOfCall")%></label></td>
		<td align="left"><select name="type">
		<option value="<%=callDetails.getTypeOfCall()%>"><%=callDetails.getTypeOfCall()%>
			</option>
		<option value="LOCAL">LOCAL</option>
			
			<option value="STD">STD</option>
			
			</select></td></tr>
	
	<%}%>
		


	<tr>
		<td colspan="2" align="center"><input type="submit"
			class="button" value="<%=resourceBundle.getString("update")%>" /></td>
	</tr>
</table>
</form>
</fieldset>
</div>
</div>
</div>
</body>
</html>