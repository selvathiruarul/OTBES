<%@ page errorPage="/JSP/Error1.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="com.otbes.language.*"%>
	<%@ page import = "com.otbes.vo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OTBES</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/addcustomer.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/JS/validate.js"> </script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_blue.css" id="blue" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_green.css" id="green" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_pink.css" id="pink" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/layout_orange.css" id="orange" />
<%@ page import ="com.otbes.vo.*" %>
<%@ page import = "java.util.ArrayList" %> 
 <script type="text/javascript" src="https://www.google.com/jsapi">
 </script>
    <script type="text/javascript">     
    <%System.out.println("2"); %>
     google.load("visualization", "1", {packages:["corechart"]});    
     google.setOnLoadCallback(drawChart);
     <%ReportVo repVo = (ReportVo) request.getAttribute("result"); %>
 	
  	   
           function drawChart() 
           {     
        	   <%System.out.println("4"); %>  
                var data = google.visualization.arrayToDataTable([         
 ['Task', 'Hours per Day'], 
 

		

['<%="Local"%>',  <%=repVo.getLocalCalls() %>],
<%System.out.println(repVo.getLocalCalls());%>

['<%="STD"%>',  <%=repVo.getStdCalls() %>],
<%System.out.println(repVo.getStdCalls());%>
['<%="ISD"%>',  <%=repVo.getIsdCalls() %>]
<%System.out.println(repVo.getIsdCalls());%>

 ]);
                
          	   
var options = {title: 'Customer Call Report',is3D:true};    
var chart = new google.visualization.PieChart(document.getElementById('chart'));   

chart.draw(data, options);     

}
 </script> 
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
<div id="chart"></div> 


</div>
</div>
</div>
</body>
</html>