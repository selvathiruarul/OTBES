package com.otbes.dao;


import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import com.otbes.connection.DBConnection;
import com.otbes.constants.Queryconstant;

import com.otbes.vo.CustomerVO;
import com.otbes.vo.Customerreportvo;
import com.otbes.vo.HelpDeskReport;
import com.otbes.vo.TicketSummary;

import com.otbes.vo.LoginVO;

/**
 * The descriptive text that explaining the purpose and use of the class.
 * 
 * @author T.Gomathi Priya ,Rina
 * @version 1.0
 * @Class name Customerdao
 * @Creation Date 8/12/2012 @ History
 */

public class Customerdao {

	public CustomerVO insertCustomer(CustomerVO cust) throws SQLException,
			IOException {
		/**
		 *This function is used to add the customer details and return the
		 * customer id
		 * 
		 * @param CustomerVO
		 *            cust is a object of the class CustomerVO
		 * @return CustomerVO custdetails is object of the class CustomerVO
		 * @exception SQL
		 *                exception, IOException
		 * @since jdk 1.6.0_29
		 * @see none
		 */
		CustomerVO custdetails = new CustomerVO();
		
		Connection con = DBConnection.connectionDB();
		PreparedStatement st = con
				.prepareStatement(Queryconstant.INSERTCUSTOMERQUERY);
		st.setString(1, cust.getFirstName());
		st.setString(2, cust.getMiddleName());
		st.setString(3, cust.getLastName());
		st.setString(4, cust.getAddress());
		st.setString(5, cust.getState());
		st.setString(6, cust.getCountry());
		st.setInt(7, cust.getPinCode());
		st.setString(8, cust.getStatus());
		st.setString(9, cust.getEmail());
		st.setLong(10, cust.getPhoneNo());
		st.executeUpdate();
		PreparedStatement st1 = con
				.prepareStatement(Queryconstant.CUSTOMERIDQUERY);
		st1.setString(1, cust.getFirstName());
		st1.setString(2, cust.getMiddleName());
		st1.setString(3, cust.getLastName());
		st1.setString(4, cust.getAddress());
		st1.setString(5, cust.getState());
		st1.setString(6, cust.getCountry());
		st1.setInt(7, cust.getPinCode());
		st1.setString(8, cust.getStatus());
		st1.setString(9, cust.getEmail());
		st1.setLong(10, cust.getPhoneNo());

		ResultSet r = st1.executeQuery();

		while (r.next()) {

			custdetails.setCustomerID(r.getInt(1));

		}
		con.commit();
		return custdetails;

	}

	public CustomerVO viewCustomer(int id) throws SQLException, IOException {
		/**
		 * To get the customer details for the particular customer
		 * 
		 * @param int Customerid
		 * @return CustomerVO custdetails is object of the class CustomerVO
		 * @exception SQL
		 *                exception, IOException
		 * @since jdk 1.6.0_29
		 * 
		 */

		CustomerVO custdetails = new CustomerVO();
		
		Connection con = DBConnection.connectionDB();

		PreparedStatement st = con
				.prepareStatement(Queryconstant.VIEWCUSTOMERQUERY);

		st.setInt(1, id);
		ResultSet r = st.executeQuery();

		while (r.next()) {

			custdetails.setCustomerID(r.getInt(1));
			custdetails.setFirstName(r.getString(2));
			custdetails.setMiddleName(r.getString(3));
			custdetails.setLastName(r.getString(4));
			custdetails.setAddress(r.getString(5));
			custdetails.setState(r.getString(6));
			custdetails.setCountry(r.getString(7));
			custdetails.setPinCode(r.getInt(8));
			custdetails.setStatus(r.getString(9));
			custdetails.setEmail(r.getString(10));
			custdetails.setPhoneNo(r.getLong(11));
			custdetails.setIdProof(r.getString(12));
			custdetails.setAddressProof(r.getString(13));
			con.commit();

		}
		return custdetails;

	}

	public void updateCustomer(CustomerVO cust) throws SQLException,
			IOException {

		/**
		 * To update the customer details for the particular customer
		 * 
		 * @param CustomerVO
		 *            cust is a object of the class CustomerVO
		 * @return void
		 * @exception SQL
		 *                exception, IOException
		 * @since jdk 1.6.0_29
		 * @see none
		 */

		
		Connection con = DBConnection.connectionDB();
		PreparedStatement st = con
				.prepareStatement(Queryconstant.UPDATECUSTOMERQUERY);
		st.setString(1, cust.getFirstName());
		st.setString(2, cust.getMiddleName());
		st.setString(3, cust.getLastName());
		st.setString(4, cust.getAddress());
		st.setString(5, cust.getState());
		st.setString(6, cust.getCountry());
		st.setString(7, cust.getEmail());
		st.setInt(8, cust.getPinCode());

		st.setLong(9, cust.getPhoneNo());
		st.setInt(10, cust.getCustomerID());
		st.executeUpdate();
		con.commit();

	}

	public void addLogin(LoginVO login) throws SQLException, IOException {
		/**
		 * To add the username and password
		 * 
		 * @param LoginVO
		 *            login is an object of LoginVO
		 * @return void none
		 * @exception SQL
		 *                exception, IOException
		 * @since jdk 1.6.0_29
		 */

		
		Connection con = DBConnection.connectionDB();

		PreparedStatement st = con
				.prepareStatement(Queryconstant.ADDLOGINQUERY);
		st.setInt(1, login.getUserName());
		st.setString(2, login.getRole());
		st.setString(3, login.getPassword());
		st.executeUpdate();
		con.commit();

	}

	public int deleteCustomer(int id) throws SQLException, IOException {
		/**
		 * To check whether the customer is having any active connection
		 * 
		 * @param int Customer id
		 * @return int count-To check Active connection for a particular
		 *         customer
		 * @exception SQL
		 *                exception, IOException
		 * @since jdk 1.6.0_29
		 * @see none
		 */
		
		Connection con = DBConnection.connectionDB();
		PreparedStatement st = con.prepareStatement(Queryconstant.DELETECHECK);
		st.setInt(1, id);
		int count = 0;// To return no of connections for the particular customer
		ResultSet r = st.executeQuery();
		while (r.next()) {
			count = count + 1;

		}
		con.commit();
		return count;

	}

	public void deleteCustomerStatus(int id) throws SQLException, IOException {
		/**
		 * To change the status of the customer
		 * 
		 * @param int Customerid
		 * @return void none
		 * @exception SQL
		 *                exception, IOException
		 * @since jdk 1.6.0_29
		 * @see none
		 */

		
		Connection con = DBConnection.connectionDB();
		PreparedStatement st = con
				.prepareStatement(Queryconstant.DELETECUSTOMER);
		st.setInt(1, id);
		st.executeUpdate();
		con.commit();
	}

	public void deleteLogin(int id) throws SQLException, IOException {

		/**
		 * To delete the login for the customer
		 * 
		 * @param int Customer id
		 * @return void
		 * @exception SQL
		 *                exception, IOException
		 * @since jdk 1.6.0_29
		 * @see none
		 */

		
		Connection con = DBConnection.connectionDB();

		PreparedStatement st = con.prepareStatement(Queryconstant.DELETELOGIN);
		st.setInt(1, id);
		st.executeUpdate();
		con.commit();
	}

	public CustomerVO searchId(int id) throws SQLException, IOException {
		/**
		 * To check the customer id is present and the status
		 * 
		 * @param int Customer id
		 * @return CustomerVO
		 * @exception SQL
		 *                exception, IOException
		 * @since jdk 1.6.0_29
		 * @see none
		 */
		
		Connection con = DBConnection.connectionDB();
		CustomerVO custdetails = new CustomerVO();

		PreparedStatement st = con
				.prepareStatement(Queryconstant.SEARCHIDSTATUS);
		st.setInt(1, id);

		ResultSet r = st.executeQuery();
		while (r.next()) {

			custdetails.setCustomerID(r.getInt(1));
			custdetails.setStatus(r.getString("status"));
			custdetails.setFirstName(r.getString("firstname"));
		}
		return custdetails;
	}

	public boolean validateLogin(LoginVO login) throws SQLException,
			IOException {
		/**
		 * To validate the login for the customer
		 * 
		 * @param LoginVO
		 *            vo-the object of LoginVO
		 * @return boolean
		 * @exception SQL
		 *                exception, IOException
		 * @since jdk 1.6.0_29
		 * @see none
		 */
		
		Connection con = DBConnection.connectionDB();

		boolean check = false;

		PreparedStatement st = con
				.prepareStatement(Queryconstant.LOGINVALIDATE);
		st.setInt(1, login.getUserName());
		st.setString(2, login.getPassword());
		st.setString(3, login.getRole());
		ResultSet r = st.executeQuery();
		while (r.next()) {
			check = true;
		}

		return check;
	}

	public boolean updateStatus(int id, String status) throws SQLException,
			IOException {
		/**
		 * To update the status of the customer
		 * 
		 * @param int,String customer id, status of customer
		 * @return boolean returns true if status is successfully updated
		 * @exception SQL
		 *                exception, IOException
		 * @since jdk 1.6.0_29
		 * @see none
		 */

		
		Connection con = DBConnection.connectionDB();

		PreparedStatement st = con.prepareStatement(Queryconstant.STATUSUPDATE);
		st.setString(1, status);
		st.setInt(2, id);

		st.executeUpdate();
		con.commit();
		return true;
	}

	public void uploadProof(String idproof, String addproof, int id)
			throws SQLException, IOException {
		/**
		 * To upload the proof of the customer
		 * 
		 * @param int,String,String customer id,URL for id proof, URL for
		 *        address proof
		 * @return void none
		 * @exception SQL
		 *                exception, IOException
		 * @since jdk 1.6.0_29
		 * @see none
		 */

		
		Connection con = DBConnection.connectionDB();

		PreparedStatement st = con.prepareStatement(Queryconstant.PROOFUPDATE);
		st.setString(1, idproof);
		st.setString(2, addproof);
		st.setInt(3, id);

		st.executeUpdate();
		con.commit();

	}

	public String getStatus(int id) throws SQLException, IOException{
		Connection con = DBConnection.connectionDB();
		String status=null;
		PreparedStatement st = con.prepareStatement(Queryconstant.GETSTATUS);
		st.setInt(1,id);
		ResultSet rs=st.executeQuery();
		while(rs.next())
		{
			status=rs.getString("status");
		}
		con.commit();
		return status;
	}
	

	public ArrayList<Customerreportvo> getReportDetails(Customerreportvo vo) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.connectionDB();
		
		
		ArrayList<Customerreportvo> list=new ArrayList<Customerreportvo>();
		float total=0;
		PreparedStatement ps=con.prepareStatement("select state,count(state) as total from customer group by state");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Customerreportvo vo1=new Customerreportvo();
			vo1.setState(rs.getString(1));
			vo1.setCount(rs.getFloat(2));
			total=total+vo1.getCount();
			vo1.setTotal(total);
			list.add(vo1);
			System.out.println(total);
		}
		System.out.println(total);
		
		return list;
	}
	
	

	public ArrayList<HelpDeskReport> generateReport(String fromdate, String todate) throws SQLException, IOException{
		ArrayList<HelpDeskReport> dateList = new ArrayList<HelpDeskReport>();
		Connection con = DBConnection.connectionDB();
		String query=" select dateraised,count(dateraised) from helpdeskticket where dateraised between ? AND ? group by dateraised";
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1,fromdate);
		System.out.println();
		st.setString(2,todate);
		ResultSet rs=st.executeQuery();
		while(rs.next())
			
		{
		HelpDeskReport hd=new HelpDeskReport();
		hd.setDate(rs.getString(1));
		hd.setCount(rs.getInt(2));
		dateList.add(hd);
		}
		return dateList;
	}


	
	public ArrayList<TicketSummary> generateReporttable(String fromdate, String todate)throws SQLException, IOException {
		// TODO Auto-generated method stub
		
		 
		Connection con = DBConnection.connectionDB();
		
		String query=" select * from helpdeskticket where to_date(dateraised) between to_date(?, 'dd/mm/yyyy') AND to_date(?, 'dd/mm/yyyy') order by dateraised";
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1,fromdate);
		
		st.setString(2,todate);
		ResultSet rs=st.executeQuery();
		
		ArrayList<TicketSummary> tsl=new ArrayList<TicketSummary>();
		while(rs.next())
			
		{
			TicketSummary ts = new TicketSummary();
			ts.setTicketId(rs.getInt("ticketid"));
			ts.setTicketDescription(rs.getString("TICKETDESCRIPTION"));
			ts.setTicketSummary(rs.getString("TICKETSUMMARY"));
			ts.setDateRaised(rs.getString("DATERAISED"));
			ts.setCustomerId(rs.getInt("customerId"));
			ts.setTicketStatus(rs.getString("TICKETSTATUS"));
			ts.setTicketClosedDate(rs.getString("ticketClosedDate"));
			ts.setResolutionComments(rs.getString("RESOLUTIONCOMMENTS"));
			ts.setTicketPriority(rs.getString("ticketPriority"));
			ts.setTicketCategory(rs.getString("ticketCategory"));
			ts.setUploadDoc(rs.getString("UPLOADDOC"));
			tsl.add(ts);
		}
		return tsl;
	}
	
		
	}

