
<%@ page errorPage="/JSP/Error1.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>OTBES</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/validate.js"> </script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/layout_blue.css" id="blue" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/layout_green.css" id="green" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/layout_pink.css" id="pink" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/layout_orange.css" id="orange" />
<style>
label {
	display: inline-block;
	float: left;
	clear: left;
	width: 250px;
	text-align: left;
}

input {
	display: inline-block;
	float: center;
}
</style>
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
<div id="header"></div>

<div id="tabs"><%@ include file="/JSP/menu.jsp"%></div>
<div id="menu"><%@ include file="/JSP/sidepane.jsp"%>
</div>


<div id='main'>
<p align="right"><a
	href="<%=request.getContextPath()%>/JSP/BTBMViewConnection.jsp"><b>Go
To View Bill</b></a></p>
<fieldset><legend><%=resourceBundle.getString("billGeneration")%></legend>
<form action="BTBMServlet" method="post"><input type="hidden"
	name="option" value="view3"></input> <%! @SuppressWarnings("unchecked") %>
<%@ page import="com.otbes.vo.*"%> <%@ page
	import="java.util.ArrayList"%>

<h3><b><%=resourceBundle.getString("billDetails")%></b></h3>

<br>
<br>
<% ArrayList<BillVO1> recentBills = (ArrayList<BillVO1>) session.getAttribute("recentBills");
	//BillVO recentBills[] = (BillVO[]) session.getAttribute("recentBills");
   int selectedBillID = Integer.parseInt((String) request.getAttribute("selectedBillId") );

   BillVO1 selectedBill = null;
   if(recentBills!=null)
   {
		for(BillVO1 billVO:recentBills)
		{
			if( selectedBillID == billVO.getBillId())
			{
				selectedBill=billVO;
			}
		}
   }
   else
   {
	   System.err.println("No Bills found");
   }
		
%>


<table>
	<tr>
		<td><label><%=resourceBundle.getString("connectionNumber")%></label></td>
		<td><input type="text" name="connNo" readonly="readonly"
			value="<%=selectedBill.getConnectionNum() %>"></input></td>
	</tr>
	<tr>
		<td><label><%=resourceBundle.getString("billId")%></label></td>
		<td><input type="text" name="billId" readonly="readonly"
			value="<%=selectedBill.getBillId() %>"></input></td>
	</tr>
	<tr>
		<td><label><%=resourceBundle.getString("arrears")%></label></td>
		<td><input type="text" name="arrears" readonly="readonly"
			value="<%=selectedBill.getArrears() %>"></input></td>
	</tr>
	<tr>
		<td><label><%=resourceBundle.getString("excess")%></label></td>
		<td><input type="text" name="excess" readonly="readonly"
			value="<%=selectedBill.getExcess() %>"></input></td>
	</tr>
	<tr>
		<td><label><%=resourceBundle.getString("billAmount")%></label></td>
		<td><input type="text" name="bill_amt" readonly="readonly"
			value="<%=selectedBill.getOriginalAmount() %>"></input></td>
	</tr>
	<tr>
		<td><label><%=resourceBundle.getString("totalAmount")%></label></td>
		<td><input type="text" name="total_amt" readonly="readonly"
			value=" <%=selectedBill.getTotalAmount() %>"></input></td>
	</tr>
	<tr>
		<td><label><%=resourceBundle.getString("billDate")%></label></td>
		<td><input type="text" name="date" readonly="readonly"
			value="<%=selectedBill.getBillDate() %>"></input></td>
	</tr>
	<tr>
		<td><label><%=resourceBundle.getString("typeOfBill")%></label></td>
		<td><input type="text" name="billtype" readonly="readonly"
			value="<%=selectedBill.getTypeOfBill() %>"></input></td>
	</tr>
	<tr>
		<td><label><%=resourceBundle.getString("statusOfPay")%></label></td>
		<td><input type="text" name="status" readonly="readonly"
			value="<%=selectedBill.getStatusOfPay() %>"></input></td>
	</tr>
</table>
<center><input type="submit" name="submit"
	value=<%=resourceBundle.getString("viewBillItem")%> class="button"></input></center>
</form>
</fieldset>
</div>
</div>
</div>
</body>
</html>


