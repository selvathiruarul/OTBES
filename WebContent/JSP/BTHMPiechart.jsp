<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.otbes.vo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/layout_blue.css" id="blue" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/layout_green.css" id="green" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/layout_pink.css" id="pink" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/layout_orange.css" id="orange" />
<script type="text/javascript" src="https://www.google.com/jsapi">
 </script>
<script type="text/javascript"> 
    <%!@SuppressWarnings("unchecked")%>
     google.load("visualization", "1", {packages:["corechart"]});    
     google.setOnLoadCallback(drawChart);
    
    <%ArrayList<BTHMTicketVO> al = new ArrayList<BTHMTicketVO>();
			al = (ArrayList<BTHMTicketVO>) request.getAttribute("report");
			BTHMTicketVO v = null;
			int count = 0;%>
 	
  	   
           function drawChart() 
           {   	 
                var data = google.visualization.arrayToDataTable([         
 ['Task', 'Hours per Day'], 
 <%for (count = 0; count < (al.size() - 1); count++) {
				v = (BTHMTicketVO) al.get(count);%>
['<%=v.getTicketCategory()%>',  <%=v.getTicketId()%>],
<%}
			v = (BTHMTicketVO) al.get(count);%>
['<%=v.getTicketCategory()%>',  <%=v.getTicketId()%>]
 ]);
                
          	   
var options = {title: 'Ticket Report - Current Month',is3D:true};    
var chart = new google.visualization.PieChart(document.getElementById('chart'));   

chart.draw(data, options);     

}
 </script>
</head>
<body onKeyDown="return showKeyCode(event)"
	onLoad="disableBackButton();setTheme('<%=session.getAttribute("themeColor")%>')">
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
<div id="main">
<fieldset><legend><%=resourceBundle.getString("ticketReport")%></legend>
<div id="chart"></div>
</fieldset>
</div>
</div>
</div>
</body>

</html>