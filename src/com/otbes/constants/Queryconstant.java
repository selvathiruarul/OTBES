package com.otbes.constants;
/**
* The descriptive text that explaining the purpose and use of the class.
      * @author  GROUP D
      * @version      1.0
      * @Class name Queryconstant
      * @Creation Date 8/12/2012
     * @ History 
*/
public class Queryconstant {
	public static final String APPPATH="C:\\Documents and Settings\\588919\\workspace\\OTBES\\WebContent\\WEB-INF\\files\\";
	public static final String INSERTCALL="INSERT INTO calldetails(connectionNo,dateofcall,dialedNo,callduration,typeofcall) VALUES(?,TO_DATE(?,'DD/MM/YYYY'),?,?,?)";
	public static final String SELECTCALL = "SELECT * FROM calldetails WHERE connectionNo=?";
	public static final String SELECTCALLBYID = "SELECT * FROM calldetails WHERE callid=?";
	public static final String DELETECALL = "DELETE FROM calldetails WHERE callid=?";
	public static final String UPDATECALL = "UPDATE calldetails SET callduration=?,typeofcall=? WHERE callid=?";
	public static final String DELETECALLID = "DELETE FROM calldetails WHERE connectionNo=?";
	
	public static final String INSERTCUSTOMERQUERY="insert into Customer(FirstName,MiddleName,LastName,Address,State,Country,PINCode,Status,Email,PhoneNo) values(?,?,?,?,?,?,?,?,?,?)";
	public static final String CUSTOMERIDQUERY="select customerid from Customer where FirstName=? AND MiddleName=? AND LastName=? AND  Address=? AND State=? AND Country=? AND Pincode=? AND Status=? AND Email=? AND PhoneNo=?";
	public static final String VIEWCUSTOMERQUERY="select * from Customer where CustomerId=?";
	public static final String UPDATECUSTOMERQUERY="update Customer set FirstName=?,MiddleName=?,LastName=?,Address=?,State=?,Country=?,Email=?,Pincode=?,PhoneNo=? where CustomerId=?";
	public static final String ADDLOGINQUERY="insert into Users(userid,role,password, dateupdated, expiry, theme) values(?,?,?,SYSDATE, 30, 'orange')";
	public static final String DELETECHECK="select *from Connection where CustomerId=? AND Status='Active'";
	public static final String DELETECUSTOMER="update Customer set Status='Inactive' where Customerid=?";
	public static final String DELETELOGIN="delete from users where userid=?";
	public static final String SEARCHIDSTATUS="select customerid,status,firstname from Customer where Customerid=?";
	public static final String LOGINVALIDATE="select *from Users where userid=? AND password=? AND role=?";
	public static final String STATUSUPDATE="UPDATE customer SET status=? where Customerid=?";
	public static final String PROOFUPDATE="UPDATE customer SET idproof=?,addressproof=? where Customerid=?";



	public static final String SELECTCUSTOMERID="select customerid from customer where customerid=?";
	public static final String INSERTCONNECTIONDET="insert into connection(customerid,typeofbill,tariffname,status) values (?,?,?,?)";
	public static final String SELECTCONNNO = "select connectionno from connection where CUSTOMERID=? and status='Active'";

	public static final String SELECTCONNNO1 = "select connectionno from connection where CUSTOMERID=?";
	public static final String SELECTMAXCONN = "select MAX(Connectionno) from connection where customerid=?";
 	public static final String UPDATECONNECTION = "update connection set typeofbill=?,tariffname=?,status=? where customerid=?";
    public static final String VIEWCONNECTIONNO="select * from connection where connectionno=?";
    public static final String SELECTTARIFF="select tariffname from tariff";
    public static final String DELETETARIFF="delete from tariff where tariffname=?";
    public static final String CHECKTARIFFCONN="select TARIFFNAME from connection where tariffname=?";
    public static final String UPDATETARIFF="update tariff set localpulserate=?,localunit=?,stdpulserate=?,stdunit=?,isdpulserate=?,isdunit=?,monthlyrental=? where tariffname=?";
    public  static final String ADDTARIFF="insert into tariff(tariffname,MONTHLYRENTAL,localpulserate,localunit,stdpulserate,stdunit,isdpulserate,isdunit) values(?,?,?,?,?,?,?,?)";
    public  static final String VIEWTARIFF="select * from tariff where tariffname=?";
	public static final String GETSTATUS = "select status from customer where customerid=?";
	public static final String DELETECONNECTION="update connection set STATUS='Cancelled',CANCELLATIONREASON=?where connectionno=?";
	public static final String SELECTCUSTOMERIDSTATUS ="select customerid from customer where customerid=? and status='Active'"; 

	
}
