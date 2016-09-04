<%@ page errorPage="/JSP/Error1.jsp"%>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.otbes.vo.*"%>
<%@ page import="javax.servlet.http.HttpSession.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />

<title>OTBES</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/addcustomer.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/validate.js"> </script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_blue.css" id="blue" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_green.css" id="green" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_pink.css" id="pink" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_orange.css" id="orange" />
<meta name="keywords" content="" />
<meta name="description" content="" />

</head>
<body onKeyDown="return showKeyCode(event)" onLoad="disableBackButton();setTheme('<%=session.getAttribute("themeColor")%>')">
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
	CustomerVO cust = (CustomerVO) request.getAttribute("customer5");
%>


<div id='main'>

<fieldset><legend><%=resourceBundle.getString("updateCustomerDetailsByCustomer")%></legend>
<form name="reg" action="BTASServlet" method="post"
	onsubmit="return validate()">
<div id="mandatory"><%=resourceBundle.getString("allFieldsAreMandatory")%></div>
<input type="hidden" name="option" value="updationbycustomer"></input>


<table border=0 cellspacing=10 cellpadding=10 align="center">
	<tr>
		<td align="left"><label><%=resourceBundle.getString("customerId")%></label></td>
		<td align="left"><input type="text" name="cid" readonly="readonly"
			value=<%=session.getAttribute("userid")%>></td>
	</tr>

	<tr>
		<td align="left"><label><%=resourceBundle.getString("firstName")%></label></td>
		<td align="left"><input type="text" name="fn" value=<%=cust.getFirstName()%>></input><span
			id="fnerror"></span></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("middleName")%></label></td>
		<td align="left"><input type="text" name="mn" value=<%=cust.getMiddleName()%>></input><span
			id="mnerror"> </span></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("lastName")%></label></td>
		<td align="left"><input type="text" name="ln" value=<%=cust.getLastName()%>></input><span
			id="lnerror"> </span></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("address")%></label></td>
		<td align="left"><textarea rows=5 name="add" id="addid"><%=cust.getAddress()%></textarea><span
			id="adderror"> </span></td>
	</tr>

	<tr>
		<td align="left"><label><%=resourceBundle.getString("state")%></label></td>
		<td align="left"><select name="state">
			<option value="<%=cust.getState()%>"><%=cust.getState()%></option>
			<option value="Andaman and Nicobar Islands">Andaman and
			Nicobar Islands</option>
			<option value="Andhra Pradesh">Andhra Pradesh</option>
			<option value="Arunachal Pradesh">Arunachal Pradesh</option>
			<option value="Assam">Assam</option>
			<option value="Bihar">Bihar</option>
			<option value="Chandigarh">Chandigarh</option>
			<option value="Chhattisgarh">Chhattisgarh</option>
			<option value="Dadra and Nagar Haveli">Dadra and Nagar
			Haveli</option>
			<option value="Daman and Diu">Daman and Diu</option>
			<option value="Delhi">Delhi</option>
			<option value="Goa">Goa</option>
			<option value="Gujarat">Gujarat</option>
			<option value="Haryana">Haryana</option>
			<option value="Himachal Pradesh">Himachal Pradesh</option>
			<option value="Jammu and Kashmir">Jammu and Kashmir</option>
			<option value="Jharkhand">Jharkhand</option>
			<option value="Karnataka">Karnataka</option>
			<option value="Kerala">Kerala</option>
			<option value="Lakshadweep">Lakshadweep</option>
			<option value="Madhya Pradesh">Madhya Pradesh</option>
			<option value="Maharashtra">Maharashtra</option>
			<option value="Manipur">Manipur</option>
			<option value="Meghalaya">Meghalaya</option>
			<option value="Mizoram">Mizoram</option>
			<option value="Nagaland">Nagaland</option>
			<option value="Orissa">Orissa</option>
			<option value="Pondicherry">Pondicherry</option>
			<option value="Punjab">Punjab</option>
			<option value="Rajasthan">Rajasthan</option>
			<option value="Sikkim">Sikkim</option>
			<option value="Tamil Nadu">Tamil Nadu</option>
			<option value="Tripura">Tripura</option>
			<option value="Uttaranchal">Uttaranchal</option>
			<option value="Uttar Pradesh">Uttar Pradesh</option>
			<option value="West Bengal">West Bengal</option>
		</select></td>
	</tr>



	<tr>
		<td align="left"><label><%=resourceBundle.getString("country")%></label></td>
		<td align="left"><input type="text" name="country" readonly="readonly"
			value=<%=cust.getCountry()%>></input></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("pincode")%></label></td>
		<td align="left"><input type="text" name="pincode" value=<%=cust.getPinCode()%>></input><span
			id="pinerror"> </span><br></br>
		</td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("contact")%></label></td>
		<td align="left"><input type="text" name="contact" value=<%=cust.getPhoneNo()%>></input><span
			id="conerror"> </span></td>
	</tr>
	<tr>
		<td align="left"><label><%=resourceBundle.getString("email")%></label></td>
		<td align="left"><input type="text" name="email" value=<%=cust.getEmail()%>></input><span
			id="emailerror"> </span></td>
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