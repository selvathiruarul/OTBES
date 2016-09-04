package com.otbes.dao;

import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;


import com.otbes.connection.DBConnection;
import com.otbes.constants.Queryconstant;

import com.otbes.vo.CallDetailVO;
import com.otbes.vo.ReportVo;

/**
 * The descriptive text that explaining the purpose and use of the class.
 * 
 * @author Vinod,Madhu mathi,Kalaiarasan
 * @version 1.0
 * @Class name CallDetaildao
 * @Creation Date 8/12/2012 @ History
 */

public class CallDetaildao {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	private static Logger log = Logger.getLogger("otbeslogger");

	public void insert(CallDetailVO cd) {
		/**
		 * This function is used to upload a call details file.
		 * 
		 * @param CallDetailFileVO
		 * @return void
		 * @exception SQLException
		 *                and Exception are thrown.
		 * @since jdk1.6.0_29
		 */

		try {
			con = DBConnection .connectionDB ();

			PreparedStatement ps = con
					.prepareStatement(Queryconstant.INSERTCALL);
			ps.setLong(1, cd.getConnectionNo());
			ps.setString(2, cd.getDateOfCall());
			ps.setLong(3, cd.getDialedNo());
			ps.setInt(4, cd.getDuration());
			ps.setString(5, cd.getTypeOfCall());
			ps.executeUpdate();

		} catch (SQLException e) {

			log.error(e);
		} catch (Exception e) {

			log.error(e);
		}
	}

	public ArrayList<CallDetailVO> viewCallDetails(CallDetailVO vo) {
		/**
		 * This function is used to view the call details of particular
		 * connection number.
		 * 
		 * @param CallDetailVO
		 * @return ArrayList<CallDetailVO> returns the call details of
		 *         particular connection number.
		 * @exception SQLException
		 *                and Exception are thrown.
		 * @since jdk1.6.0_29
		 */

		ArrayList<CallDetailVO> calldetailslist = new ArrayList<CallDetailVO>();
		CallDetailVO calldetail = null;
		try {
			con = DBConnection .connectionDB();
			ps = con.prepareStatement(Queryconstant.SELECTCALL);
			ps.setLong(1, vo.getConnectionNo());

			rs = ps.executeQuery();

			while (rs.next()) {
				calldetail = new CallDetailVO();
				calldetail.setCallID(rs.getInt("callid"));
				calldetail.setConnectionNo(rs.getLong("connectionNo"));
				calldetail.setDateOfCall(rs.getString("dateOfCall"));
				calldetail.setDialedNo(rs.getInt("dialedNo"));
				calldetail.setDuration(rs.getInt("callduration"));
				calldetail.setTypeOfCall(rs.getString("typeofcall"));
				calldetailslist.add(calldetail);
			}
			ps.close();
			con.close();

		} catch (SQLException e) {

			log.error(e);
		} catch (Exception e) {

			log.error(e);
		}
		return calldetailslist;
	}

	public ArrayList<CallDetailVO> viewCallDetailsById(CallDetailVO vo) {
		/**
		 * This function is used to view the particular call detail of specific
		 * connection number.
		 * 
		 * @param CallDetailVO
		 * @return ArrayList<CallDetailVO>
		 * @exception SQLException
		 *                and Exception are thrown.
		 * @since jdk1.6.0_29
		 */
		ArrayList<CallDetailVO> calldetailslist = new ArrayList<CallDetailVO>();
		CallDetailVO calldetail = null;
		try {
			con = DBConnection .connectionDB();
			ps = con.prepareStatement(Queryconstant.SELECTCALLBYID);
			ps.setInt(1, vo.getCallID());

			rs = ps.executeQuery();

			while (rs.next()) {
				calldetail = new CallDetailVO();
				calldetail.setCallID(rs.getInt("callid"));
				calldetail.setConnectionNo(rs.getLong("connectionNo"));
				calldetail.setDateOfCall(rs.getString("dateOfCall"));
				calldetail.setDialedNo(rs.getInt("dialedNo"));
				calldetail.setDuration(rs.getInt("callduration"));
				calldetail.setTypeOfCall(rs.getString("typeofcall"));
				calldetailslist.add(calldetail);
			}
			ps.close();
			con.close();

		} catch (SQLException e) {

			log.error(e);
		} catch (Exception e) {

			log.error(e);
		}
		return calldetailslist;
	}

	@SuppressWarnings("null")
	public ArrayList<CallDetailVO> updateViewCallDetails(CallDetailVO vo) {
		/**
		 * This function is used to view the particular call detail of specific
		 * connection number.
		 * 
		 * @param CallDetailVO
		 * @return ArrayList<CallDetailVO>
		 * @exception SQLException
		 *                and Exception are thrown.
		 * @since jdk1.6.0_29
		 */

		ArrayList<CallDetailVO> calldetailslist = new ArrayList<CallDetailVO>();
		CallDetailVO calldetail = null;
		try {
			con = DBConnection .connectionDB();
			ps = con.prepareStatement(Queryconstant.SELECTCALL);
			ps.setInt(1, vo.getCallID());
			rs = ps.executeQuery();

			calldetail.setCallID(rs.getInt("callID"));
			calldetail.setConnectionNo(rs.getLong("connectionNo"));
			calldetail.setDateOfCall(rs.getString("dateOfCall"));
			calldetail.setDialedNo(rs.getInt("dialedNo"));
			calldetail.setDuration(rs.getInt("duration"));
			calldetail.setTypeOfCall(rs.getString("typeOfCall"));
			calldetailslist.add(calldetail);

			ps.close();
			con.close();

		} catch (SQLException e) {

			log.error(e);
		} catch (Exception e) {

			log.error(e);
		}
		return calldetailslist;
	}

	public void updateCallDetails(CallDetailVO vo) {
		/**
		 * This function is used to update the particular call detail of
		 * specific connection number.
		 * 
		 * @param CallDetailVO
		 * @return void
		 * @exception SQLException
		 *                and Exception are thrown.
		 * @since jdk1.6.0_29
		 */

		try {
			con = DBConnection .connectionDB();
			ps = con.prepareStatement(Queryconstant.UPDATECALL);
			ps.setInt(1, vo.getDuration());
			ps.setString(2, vo.getTypeOfCall());
			ps.setInt(3, vo.getCallID());
			rs = ps.executeQuery();
			ps.close();
			con.close();

		} catch (SQLException e) {

			log.error(e);
		} catch (Exception e) {

			log.error(e);
		}
	}

	public void deleteCallDetails(CallDetailVO vo) {
		/**
		 * This function is used to delete the particular call detail of
		 * specific connection number.
		 * 
		 * @param CallDetailVO
		 * @return void
		 * @exception SQLException
		 *                and Exception are thrown.
		 * @since jdk1.6.0_29
		 */

		try {
			con = DBConnection .connectionDB();
			ps = con.prepareStatement(Queryconstant.DELETECALL);
			ps.setInt(1, vo.getCallID());
			rs = ps.executeQuery();
			ps.close();
			con.close();

		} catch (SQLException e) {

			log.error(e);
		} catch (Exception e) {

			log.error(e);
		}
	}
	public ArrayList<CallDetailVO> generateReport(int conno) throws SQLException, IOException{
		ArrayList<CallDetailVO> dateList = new ArrayList<CallDetailVO>();
		 
		Connection con = DBConnection.connectionDB();
		String query=" SELECT * FROM calldetails WHERE connectionNo=?";
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1,conno);
		System.out.println();
		
		ResultSet rs=st.executeQuery();
		while(rs.next())
			
		{
		CallDetailVO calldetail=new CallDetailVO();
		calldetail.setCallID(rs.getInt("callid"));
		calldetail.setConnectionNo(rs.getLong("connectionNo"));
		calldetail.setDateOfCall(rs.getString("dateOfCall"));
		calldetail.setDialedNo(rs.getInt("dialedNo"));
		calldetail.setDuration(rs.getInt("callduration"));
		calldetail.setTypeOfCall(rs.getString("typeofcall"));
		dateList.add(calldetail);
		}
		return dateList;
	}
	public int deleteCallsBycon(CallDetailVO vo) {
		/**
		 * This function is used to delete the call details of specific
		 * connection number.
		 * 
		 * @param CallDetailVO
		 * @return int count
		 * @exception SQLException
		 *                and Exception are thrown.
		 * @since jdk1.6.0_29
		 */

		int count = 0;// return the no of rows
		try {
			con = DBConnection .connectionDB();
			ps = con.prepareStatement(Queryconstant.DELETECALLID);
			ps.setLong(1, vo.getConnectionNo());

			count = ps.executeUpdate();

			ps.close();
			con.close();

		} catch (SQLException e) {

			log.error(e);
		} catch (Exception e) {

			log.error(e);
		}
		return count;
	}
	
	
	public ReportVo getConnectionNo (int custId) throws Exception
	{
		
		System.out.println("entered dao");
		
		int check=0;
		int count=0;
		con = DBConnection .connectionDB();
		
		ReportVo reportParent = new ReportVo();
		reportParent.setCustomerId(custId);
		ArrayList<ReportVo> conNoList = reportParent.getConNoList();
		try {
			System.out.println("entered dao");
			PreparedStatement ps = con.prepareStatement("select connectionno from connection where customerid=? group by connectionno");
			ps.setInt(1,custId);
			ResultSet result = ps.executeQuery();
			System.out.println(count);
			while (result.next())
			{
				
				ReportVo reportChild = new ReportVo();
				reportChild.setConnectionNo(result.getInt(1));
				conNoList.add(reportChild);
				count++;
												
			}
			
			System.out.println(count);
			for(int i=0 ; i<count ; i++)
			{
				int connectionno= reportParent.getConNoList().get(i).getConnectionNo();
				ArrayList<Integer> temp = reportParent.getPercentList();
				
				try {ps=con.prepareStatement("select connectionno from calldetails where connectionno=?");
				    ps.setInt(1,connectionno);
				    result=ps.executeQuery();
				    if (result.next()== true)
				    {
				    check++;	
					ps = con.prepareStatement("select count(typeofcall) from calldetails where connectionno=?");
					ps.setInt(1,connectionno);
					result = ps.executeQuery();
					while(result.next())
					{
						int tempTC =result.getInt(1);
						int add = reportParent.getTotalCalls();
						reportParent.setTotalCalls(add+tempTC);
						temp.add(result.getInt(1));
						System.out.println("Wntered while loop"+result.getInt(1));
						
					}
					ps = con.prepareStatement("select count(typeofcall) from calldetails where connectionno=? and typeofcall='STD'") ;
					ps.setInt(1,connectionno);
				    result = ps.executeQuery();
					while (result.next())
					{
						int tempSTD =result.getInt(1);
						int add = reportParent.getStdCalls();
						reportParent.setStdCalls(add+tempSTD);
						temp.add(result.getInt(1));
						System.out.println("got STD"+result.getInt(1));
					}
					ps = con.prepareStatement("select count(typeofcall) from calldetails where connectionno=? and typeofcall='ISD'") ;
					ps.setInt(1,connectionno);
				    result = ps.executeQuery();
					while (result.next())
					{
						int tempISD =result.getInt(1);
						int add = reportParent.getIsdCalls();
						reportParent.setIsdCalls(add+tempISD);
						temp.add(result.getInt(1));
						System.out.println("got ISD"+result.getInt(1));
					}
					ps = con.prepareStatement("select count(typeofcall) from calldetails where connectionno=? and typeofcall='LOCAL'") ;
					ps.setInt(1,connectionno);
				    result = ps.executeQuery();
					while (result.next())
					{
						int tempLOC =result.getInt(1);
						int add = reportParent.getLocalCalls();
						reportParent.setLocalCalls(add+tempLOC);
						temp.add(result.getInt(1));
						System.out.println("got LOCAL"+result.getInt(1));
					}
				    }
				    
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					log.error(e);
				}
				
						
			}
			
			System.out.println(count);
			reportParent.setCheck(check);
			reportParent.setCount(count);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e);
		}		
		//con.commit();
		//con.close();
		return reportParent;
		}
	
}
