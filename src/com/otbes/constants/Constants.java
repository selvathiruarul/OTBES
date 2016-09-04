package com.otbes.constants;

/**
 * @author 588438
 * @version 1.0
 * @Class BTHMServlet
 * @Creation 07-12-2012 @ History
 */
public class Constants {

	public static String SERVERNAME = "172.24.137.30"; // server name
	public static String SID = "1521"; // Server or System ID
	public static String URL = "jdbc:oracle:thin:@172.24.137.30:1521:ora10g"; // Connection
																				// URL
	public static String USERNAME = "e588438"; // Username for the connection -
												// oracle
	public static String PWD = "nEhuHqqoz"; // password for the connection -
											// oracle
	public static String RETRIEVE_ASSIGNED_TICKET = "select * from ticketassignments where employeeId="; // SQL
																											// retrieval
																											// query
																											// for
																											// viewing
																											// ticket
																											// assignments
																											// based
																											// on
																											// employee
																											// id
	public static String RETRIEVE_TICKET_TABLE = "select * from helpdeskticket where ticketid="; // SQL
																									// retrieval
																									// query
																									// for
																									// viewing
																									// ticket
																									// details
																									// based
																									// on
																									// ticket
																									// id
																									// id
	public static String RETRIEVE_EMPLOYEE_TICKET = "select * from helpdeskemployee where employeeId="; // SQL
																										// retrieval
																										// query
																										// for
																										// viewing
																										// employee
																										// details
																										// based
																										// on
																										// employee
																										// id
	public static String DELETE_EMPLOYEE_USER = "delete from users where userid=";// SQL
																					// Query
																					// to
																					// delete
																					// user
																					// from
																					// user
																					// table
	public static String ADDHELPDESKEMPLOYEESUCCESS = "/JSP/BTHMAdd.jsp"; // JSP
																			// page
	public static String ADDHELPDESKEMPLOYEE = "/JSP/BTHMAddHelpDeskEmployee.jsp";// JSP
																					// page
	public static String ASSIGNEMPLOYEE = "/JSP/BTHMAssignEmployeeResult.jsp";// JSP
																				// page
	public static String VIEWHELPDESKEMPLOYEE = "/JSP/BTHMView.jsp";// JSP page
	public static String VIEWHELPDESKEMPLOYEEDETAILS = "/JSP/BTHMViewDetails.jsp";// JSP
																					// page
	public static String UPDATEHELPDESKEMPLOYEE = "/JSP/BTHMUpdateEmployee.jsp";// JSP
																				// page
	public static String UPDATEHELPDESKEMPLOYEEDETAILS = "/JSP/BTHMUpdateDetails.jsp";// JSP
																						// page
	public static String UPDATEHELPDESKEMPLOYEEDETAILSSUCCESS = "/JSP/BTHMUpdateSuccess.jsp"; // JSP
																								// page
	public static String DELETEHELPDESKEMPLOYEE = "/JSP/BTHMDelete.jsp"; // JSP
																			// page
	public static String DELETEHELPDESKEMPLOYEEDETAILS = "/JSP/BTHMDeleteDetails.jsp";// JSP
																						// page
	public static String DELETEHELPDESKEMPLOYEEDETAILSSUCCESS = "/JSP/BTHMDeleteEmployeeSuccess.jsp";// JSP
																										// page
	public static String DELETEHELPDESKTICKET = "/JSP/BTHMDeleteRegisteredTicket.jsp";// JSP
																						// page
	public static String DELETEHELPDESKTICKETDETAILS = "/JSP/BTHMDeleteRegisteredTicketDetails.jsp";// JSP
																									// page
	public static String DELETEHELPDESKTICKETDETAILSSUCCESS = "/JSP/BTHMDeleteTicketSucess.jsp";// JSP
																								// page
	public static String RAISENEWTICKET = "/JSP/BTHMRaiseNewTicket.jsp";// JSP
																		// page
	public static String UPDATEREGISTEREDTICKET = "/JSP/BTHMUpdateRegisteredTicket.jsp";// JSP
																						// page
	public static String VIEWTICKETDETAILS = "/JSP/BTHMViewTicketDetails.jsp";// JSP
																				// page
	public static String DELETEASSIGNEDTICKETS = "/JSP/BTHMDeleteAssignedTicket.jsp";// JSP
																						// page
	public static String PROFILE = "/JSP/profile.jsp";// JSP page
	public static String INVALIDEMPLOYEEIDMSG = "Enter a valid EmployeeID!"; // Message
	public static String INVALIDTICKETIDMSG = "Please Enter a valid Ticket Id...";// Message
	public static String INVALIDTICKETMSG = "Invalid Ticket Id";// Message

	public static final String GETPAYMENT = "select * from paymentdetails where billid= ? ";
	public static final String GETBILL = "select billId from Bill where CONNECTIONNO= ? and rownum<5 order by BillDate desc";
	public static final String GETBILL1 = "select * from Bill where BILLID= ?";
	public static final String VIEWBILL = "select billID,connectionNO,originalAMount,excess,arrears,statusOFPAYMENT,totalAMount from (select billID,connectionNO,originalAMount,excess,arrears,statusOFPAYment,totalAMounT from bill order by billDATE desc) where connectionNO= ? and rownum<2 ";
	public static final String PAYMENTINSERT = "insert into paymentdetails values(?,?,?,?,'paid',?,?,?,?,?,?,SYSDATE,?)";
	public static final String PAYMENTUPDATE = "update bill set excess=?,statusOFPAYment='paid' where billID= ?";
	public static final String DISPUTEINSERT = "select billitemId,to_char(sysdate,'dd/mm/yyyy') from BillDispute where billitemId=? and customerid=?";
	public static final String DISPUTEINSERT1 = "insert into BillDispute (BillItemId , ReasonForRaising , DisputeId , DateOfRaise , CustomerId , statusOfDispute)values (?,?,?,sysdate,?,'OPEN')";
	public static final String DISPUTEINSERT2 = "select to_char(sysdate,'dd/mm/yyyy') from billdispute";
	public static final String DISPUTEUPDATE = "select disputeid,billitemid,to_char(dateofraise,'dd/mm/yyyy'),reasonforraising,to_char(sysdate,'dd/mm/yyyy') from BillDispute where disputeId=?";
	public static final String DISPUTEUPDATE1 = "Update BillDispute set dateOfRaise =sysdate , reasonForRaising = ? , statusofdispute='OPEN' where billItemId=?";
	public static final String CANCELDISPUTE = "select billitemid,disputeid, to_char(sysdate,'dd/mm/yyyy') from billdispute where disputeid=? and statusofdispute='OPEN'";
	public static final String CANCELDISPUTE1 = "update BillDispute set dateofcancel= sysdate,reasonForCancel=?,statusOfDispute='CLOSED' where disputeid=? and statusofdispute='OPEN'";
	public static final String RESOLVE = "select * from BillDispute where disputeId=?";
	public static final String RESOLVE1 = "update BillDispute set dateOfResolution=sysdate,discrepancy=?,resolutionComments=?,callCost=?,statusOfDispute='CLOSED' where disputeId=?";
	public static final String RESOLVE2 = "select round(excess) from bill where billid=(select billid from billitem where billitemid=(select billitemid from billdispute where disputeid=?))";
	public static final String RESOLVE3 = "update bill set excess=? where billid=(select billid from billitem where billitemid=(select billitemid from billdispute where disputeid=?))";
	public static final String VIEWDISPUTE = "select disputeid from BillDispute where customerID=?";
	public static final String VIEWDISPUTE1 = "select billitemid, reasonforraising,disputeid,to_char(dateofraise,'dd/mm/yyyy'),reasonforcancel,statusofdispute,callcost,to_char(dateofcancel,'dd/mm/yyyy'),resolutioncomments, to_char(dateofresolution,'dd/mm/yyyy') from BillDispute where disputeId=?";
	public static final String VIEWDISPUTE2 = "select billitemid, reasonforraising,disputeid,to_char(dateofraise,'dd/mm/yyyy'),statusofdispute,reasonforcancel,to_char(dateofcancel,'dd/mm/yyyy'),customerid from BillDispute where statusOfDispute=? AND dateOfRaise-(to_date(?,'dd-mm-yyyy'))<1  AND dateOfRaise-(to_date(?,'dd-mm-yyyy'))>0 order by statusOfDispute ";
	public static final String VIEWDISPUTE3 = "select billitemid, reasonforraising,disputeid,to_char(dateofraise,'dd/mm/yyyy'),statusofdispute,reasonforcancel,to_char(dateofcancel,'dd/mm/yyyy'),customerid from BillDispute where statusOfDispute=?  order by statusOfDispute ";
	public static final String VIEWDISPUTE4 = "select billitemid,disputeid,customerid,statusofdispute,reasonforraising,to_char(dateofraise,'dd/mm/yyyy'),to_char(dateofcancel,'dd/mm/yyyy'),reasonforcancel from billdispute where (sysdate-dateofraise)>7 and statusofdispute='OPEN' order by disputeid";
	public static final String GETCONNECTION = "select * from Connection where connectionNo=?";
	public static final String GETTARIFF = "select * from Tariff where tariffname=?";
	public static final String GETCALL = "select * from bill where ConnectionNo=? and ((sysdate+14)-billdate)<1 and ((sysdate+14)-billdate)>0";
	public static final String GETCALL1 = "select * from CallDetails where ConnectionNo=? and to_char(DateOfCall,'Mon')=?";
	public static final String GETCALL2 = "insert into billitem values(?,?,?,?,?,?,?,?,?)";
	public static final String GENERATEBILL = "select CallCost  from BillItem where connectionno = ? and to_char(DateOfCall,'Mon')=?";
	public static final String BILLARREAR = "select Arrears from Bill where ConnectionNo=? and StatusOfPayment='unpaid'";
	public static final String BILLARREAR1 = "select * from(select Excess from Bill where ConnectionNo=? order by BillDate desc)where rownum=1 ";
	public static final String BILLINSERT = "update Bill set StatusOfPayment='paid',Excess=?,Arrears=? where ConnectionNo=?";
	public static final String BILLINSERT1 = "insert into Bill values(?,?,?,?,?,SYSDATE+14,?,'unpaid',?)";
	public static final String GETBILLCONNECTION = "select * from Bill where ConnectionNo = ?  order by BillDate desc ";
	public static final String GETBILLITEM = "select * from BillItem where BillId =  ?";
	public static final String GETBILLITEM1 = "select * from BillItem where BillId = ? and ConnectionNo = ? and BillItemId = ? ";
	public static final String GETBILLITEM2 = "select * from BillItem where ConnectionNo = ? ";
	public static final String BILLUPDATE = "update billitem set callcost = ? where BillID = ? and ConnectionNo = ? and BillItemId= ? ";
	public static final String UPDATEEXCESS = "select excess from bill where BillID = ? ";
	public static final String BILLUPDATE1 = "update bill set Excess = ? where BillID = ? and ConnectionNo = ?  ";
	public static final String BILLDELETE = "delete from bill where billid= ?";
	public static final String BILLITEMDELETE = "delete from billitem where billid= ?";
	public static final String LOGINPAGE = "select * from login where UserName=? and role=?";
	public static final String GETCONNECTIONNO = "select connectionno from connection where customerid= ? ";
	public static final String GETBILLID = "select billid from paymentdetails where customerid= ? ";

}
