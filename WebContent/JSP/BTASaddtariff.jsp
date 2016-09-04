<%@ page errorPage="/JSP/Error1.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ page import="com.otbes.language.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>OTBES</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/validate.js"> </script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_blue.css" id="blue" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_green.css" id="green" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_pink.css" id="pink" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_orange.css" id="orange" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/addtariff.js"></script>
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
<div id="main">
<fieldset><legend><%=resourceBundle.getString("addNewTariffPlan")%></legend>
<div id="mandatory"><%=resourceBundle.getString("allFieldsAreMandatory")%></div>
<form name="form1" action="BTASServlet" method="post"
	onsubmit="return tariff()"><input type="hidden" name="option"
	value="add" />
<table align="left" cellpadding="10" cellspacing="10">

	<tr>
		<td align="left"><label><%=resourceBundle.getString("tariffType")%></label></td>
		<td align="left"><input type="text" name="tariffName" value="PLAN" id="tn" onBlur="rentcheck()"
			 /><span id="fnerror"></span></td>
	</tr>
	<tr>
		<td align="left"><label> <%=resourceBundle.getString("localPulseRate")%></label></td>
		<td align="left"><input type="text" name="localpulseRate" maxlength="5"></input> <label>(##.## or #.##)</label></td><td align="left"><span id="lnerror"></span></td>
	</tr>
	<tr>
		<td align="left"><%=resourceBundle.getString("localUnit")%></td>
		<td align="left"><select name="localUnit">
			<option>Sec</option>
			<option>Min</option>
		</select></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("stdPulseRate")%></label></td>
		<td align="left"><input type="text" name="stdpulseRate" maxlength="5"/></input><label>(##.## or #.##)</label></td><td align="left"><span id="snerror"></span></td>
	</tr>
	<tr>
		<td align="left"><%=resourceBundle.getString("stdUnit")%></td>
		<td align="left"><select name="stdUnit">
			<option>Sec</option>
			<option>Min</option>
		</select></td>
	</tr>

	<tr>

		<td align="left"><label><%=resourceBundle.getString("isdPulseRate")%></label></td>
		<td align="left"><input type="text" name="isdpulseRate" maxlength="5"/></input><label>(##.## or #.##)</label></td><td align="left"><span id="inerror"></span></td>
	</tr>
	<tr>
		<td align="left"><%=resourceBundle.getString("isdUnit")%></td>
		<td align="left"><select name="isdUnit">
			<option>Sec</option>
			<option>Min</option>
		</select></td>
	</tr>
	<tr>

		<td align="left"><label><%=resourceBundle.getString("monthlyRental")%></label></td>
		<td align="left"><input type="text" name="monthlyRental" id="rent" /><span id="mnerror"></span></td>
	</tr>
	<tr>
		<td align="left"><input class="button" type="submit" value="<%=resourceBundle.getString("submit")%>"></td>
		<td align="left"><input class="button" type="reset" value="<%=resourceBundle.getString("reset")%>"></td>
	</tr>
</table>
</form>
</fieldset>
</div>
</div>
</div>
</body>
</html>