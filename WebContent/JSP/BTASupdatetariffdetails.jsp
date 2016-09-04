<%@ page errorPage="/JSP/Error1.jsp"%>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.otbes.vo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OTBES</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/addtariff.js"></script>
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
<div id="main">
<fieldset><legend><%=resourceBundle.getString("updateTariff")%></legend>
<form name="form1" onsubmit="return updatetariff()" action="BTASServlet"
	method="post">
<div id="mandatory"><%=resourceBundle.getString("allFieldsAreMandatory")%></div>
<input type="hidden" name="option" value="updateview1"></input> <%
 	TariffVO tariff = (TariffVO) request.getAttribute("update");
 %>
<table align="left" cellpadding="10" cellspacing="10">
	<tr>
		<td align="left"><label><%=resourceBundle.getString("tariffType")%></label></td>
		<td align="left"><input type="text" name="tarifftype"
			value="<%=tariff.getTariffName()%>" readonly="readonly"></input></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("localPulseRate")%></label></td>
		<td align="left"><input type="text" name="localpulseRate"
			value="<%=tariff.getLocalPulseRate()%>"></input></td><td align="left"><label>(##.## or #.##)</label><span id="lnerror"></span></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("localUnit")%></label></td>




		<td align="left"><select name="localUnit">
			<option value="<%=tariff.getLocalUnit()%>"><%=tariff.getLocalUnit()%>
			</option>
			<option value="Sec">Sec</option>
			<option value="Min">Min</option>
		</select></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("stdPulseRate")%></label></td>
		<td align="left"><input type="text" name="stdpulseRate"
			value="<%=tariff.getStdPulseRate()%>"></input></td> <td align="left"><label>(##.## or #.##)</label><span id="snerror"></span></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("stdUnit")%></label></td>

		<td align="left"><select name="stdUnit">
			<option value="<%=tariff.getStdUnit()%>"><%=tariff.getStdUnit()%></option>
			<option value="Sec">Sec</option>
			<option value="Min">Min</option>
		</select></td>
		</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("isdPulseRate")%></label></td>

		<td align="left"><input type="text" name="isdpulseRate"
			value="<%=tariff.getIsdPulseRate()%>"></input></td> <td align="left"><label>(##.## or #.##)</label></td><td align="left"><span id="inerror"></span></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("isdUnit")%></label></td>
		<td align="left"><select name="isdUnit">
			<option value="<%=tariff.getIsdUnit()%>"><%=tariff.getIsdUnit()%></option>
			<option value="Sec">Sec</option>
			<option value="Min">Min</option>
		</select></td>
		</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("monthlyRental")%></label></td>
		<td align="left"><input type="text" name="monthlyRental"readonly="readonly"
			value="<%=tariff.getMonthlyRental()%>" ></input></td>
	</tr>
	<tr>
		<td align="left"><input class="button" type="submit" value="<%=resourceBundle.getString("update")%>"></td>
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