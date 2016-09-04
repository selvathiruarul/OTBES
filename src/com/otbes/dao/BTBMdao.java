package com.otbes.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;


import com.otbes.connection.DBConnection;
import com.otbes.constants.Constants;
import com.otbes.service.BTBMService;
import com.otbes.vo.*;

/**
 * @author 		 587864
 * @version 	 1.0
 * @class 		 BTBMdao
 * @date         27/11/12
 */
public class BTBMdao {
	//Bill Payment - view payment
	/**
	 * @param customerId - Unique Id of the customer
	 * @return connection - Bill id of the bill paid
	 * @throws SQLException 
	 * @throws SQLException
	 * @since JDK 1.6.0_29 
	 * @see none
	 */
	private static Logger log = Logger.getLogger("otbeslogger");
	public ArrayList<PaymentVO1> viewCustomerid(int customerId) throws SQLException{
		ArrayList<PaymentVO1> connection=null;
		PaymentVO1 paymentvo1=null;
		Connection con = DBConnection.connectionDB();
		
		String sql = Constants.GETBILLID;
		PreparedStatement stmt;

		try {
							
			connection=new ArrayList<PaymentVO1>(); 
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, customerId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				paymentvo1=new PaymentVO1();
				System.out.println(rs.getInt(1));
				paymentvo1.setBillId(rs.getInt(1));
				connection.add(paymentvo1);
				} 	
		}
		catch (SQLException e) {
			log.error(e);
		}
		finally {
			con.commit();
			con.close();
		} 
		return connection;
	} 
	
	//Bill Payment - view payment
	/**
	 * @param billId - Unique Id of the Bill
	 * @return paymentdetails - Customer payment details
	 * @throws SQLException
	 * @since JDK 1.6.0_29 
	 * @see none
	 */
	public PaymentDetailsVO getPaymentDetails(int billId) throws SQLException  
	{
		PaymentDetailsVO paymentdetails=null;
		
		Connection con = DBConnection.connectionDB();
		
		ResultSet rs=null;
		PreparedStatement stmt=null;

		try{
			
			paymentdetails=new PaymentDetailsVO();

			try {
				
			}  
			catch (Exception e) {
				log.error(e);
			}
			String sql = Constants.GETPAYMENT;
			stmt = con.prepareStatement(sql);
			stmt.setInt(1,billId);
			rs = stmt.executeQuery();
			while(rs.next()){
				paymentdetails.setBillId(rs.getInt(1));
				paymentdetails.setConnectionNo(rs.getInt(2));
				paymentdetails.setTotalAmt(rs.getDouble(6));
				paymentdetails.setArrears(rs.getFloat(4));
				paymentdetails.setAmountYoupay(rs.getFloat(11));
				paymentdetails.setPaymentDate(rs.getDate(12));
			}
		}
		catch (SQLException e) {
			log.error(e);
		}
		finally {
			rs.close();
			stmt.close();
			con.commit();
			con.close();
		}
		return paymentdetails;
	}





	//Bill payment - view bill
	/**
	 * @param connectionNo - Contact number of the Customer
	 * @return bills - ArrayList object
	 * @throws SQLException
	 * @since JDK 1.6.0_29 
	 * @see none
	 */
	public ArrayList<PaymentVO> getBill(int connectionNo) throws SQLException 
	{
		ArrayList<PaymentVO> bills=null;
		
		Connection con = DBConnection.connectionDB();
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			
			try {
				
			} 
			catch (Exception e) {
				log.error(e);
			}
			bills=new ArrayList<PaymentVO>();
			String sql = Constants.GETBILL ;
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, connectionNo);
			rs = stmt.executeQuery();
			if(rs==null)
			{
				bills = null ;

			}

			else {
				while(rs.next()){
					PaymentVO v=new PaymentVO();
					v.setBillId(rs.getInt(1));
					bills.add(v);
				} 
			}
		}
		catch (SQLException e) {
			log.error(e);
		}
		finally{
			con.commit();
			stmt.close();
			con.close();
		}
		return bills;
	}



	//Bill payment - view bill
	/**
	 * @param billId -  Unique Id of the Bill
	 * @return billdetails - Arraylist object
	 * @throws SQLException
	 * @since JDK 1.6.0_29 
	 * @see none
	 */
	public ArrayList<PaymentVO> getBillDetails(int billId) throws SQLException
	{
		ArrayList<PaymentVO> billdetails=null;
		PaymentVO paymentvo=null;
		
		Connection con = DBConnection.connectionDB();
		
		String sql = Constants.GETBILL1;
		PreparedStatement stmt;

		try {
			paymentvo=new PaymentVO();
			
			try {
				
			} catch (Exception e) {

				log.error(e);
			}
			billdetails=new ArrayList<PaymentVO>(); 
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, billId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				paymentvo.setBillId(rs.getInt(1));
				paymentvo.setConnectionNo(rs.getInt(2));
				paymentvo.setOriginalAmt(rs.getFloat(3));
				paymentvo.setExcess(rs.getDouble(4));
				paymentvo.setArrears(rs.getFloat(5));
				paymentvo.setBillDate(rs.getDate(6));
				paymentvo.setTypeOfbill(rs.getString(7));
				paymentvo.setStatusOfpay(rs.getString(8));
				paymentvo.setTotalAmt(rs.getDouble(9));
				billdetails.add( paymentvo);
			} 
		}
		catch (SQLException e) {
			log.error(e);
		}
		finally {
			con.commit();
			con.close();
		} 
		return billdetails;
	}

     
	//Bill Payment - make payment
	/**
	 * @param customerId - Contact number of the Customer
	 * @return details - object of PaymentVO1
	 * @throws SQLException 
	 * @throws SQLException
	 * @since JDK 1.6.0_29 
	 * @see none
	 */
	
	public ArrayList<PaymentVO1> viewConnection(int customerId) throws SQLException{
		ArrayList<PaymentVO1> connection=null;
		PaymentVO1 paymentvo1=null;
		Connection con = DBConnection.connectionDB();

		String sql = Constants.GETCONNECTIONNO;
		PreparedStatement stmt;

		try {

			
			connection=new ArrayList<PaymentVO1>(); 
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, customerId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				paymentvo1=new PaymentVO1();
				paymentvo1.setConnectionNo(rs.getInt(1));
				connection.add(paymentvo1);
				} 	
		}
		catch (SQLException e) {
			log.error(e);
		}
		finally {
			con.commit();
			con.close();
		} 
		return connection;
	}
	

	//Bill Payment - make payment
	/**
	 * @param connectionNo - Contact number of the Customer
	 * @return details - object of PaymentVO1
	 * @throws SQLException
	 * @since JDK 1.6.0_29 
	 * @see none
	 */
	public PaymentVO1 viewBill(int connectionNo) throws SQLException
	{
		PaymentVO1 details=null;
		
		Connection con = DBConnection.connectionDB();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		

		try{
			details=new PaymentVO1();

			try {
				
			} 
			catch (Exception e) {
				log.error(e);
			}
			String sql = Constants.VIEWBILL;
			stmt = con.prepareStatement(sql);
			stmt.setInt(1,connectionNo);
			rs = stmt.executeQuery();
			while(rs.next()){
				details.setBillId(rs.getInt(1));
				details.setConnectionNo(rs.getInt(2));
				details.setOriginalAmt(rs.getFloat(3));
				details.setExcess(rs.getDouble(4));
				details.setArrears(rs.getFloat(5));
				details.setStatusOfpay(rs.getString(6));
				details.setTotalAmt(rs.getDouble(7));
			}
		}
		catch (SQLException e) {
			log.error(e);
		}
		finally {
			rs.close();
			stmt.close();
			con.commit();
			con.close();
		}
		return details;
	}




	//Bill Payment - make payment
	/**
	 * @param details - object of PaymentVO1
	 * @return count - Number of rows affected
	 * @throws SQLException
	 * @since JDK 1.6.0_29
	 * @see none
	 */
	public int insertDetails(PaymentVO1 details) throws SQLException{
		
		Connection con = DBConnection.connectionDB();
		
		PreparedStatement ps=null;
		int count=0;

		try{

			
			ps=con.prepareStatement(Constants.PAYMENTINSERT);
			ps.setInt(1,details.getBillId());
			ps.setInt(2,details.getConnectionNo());
			ps.setFloat(3,details.getOriginalAmt());
			ps.setFloat(4,details.getArrears());
			ps.setDouble(5,details.getTotalAmt());
			ps.setString(6,details.getBankName());
			ps.setString(7,details.getCardType());
			ps.setString(8,details.getCardNo());
			ps.setInt(9,details.getCvvNo());
			ps.setFloat(10,details.getAmountYoupay());
			ps.setInt(11,details.getCustomerId());
			count=ps.executeUpdate();
		}
		catch (SQLException e) {
			log.error(e);
		}
		finally {
			con.commit();
			con.close();
			ps.close();
		}
		return count;
	}




	//Bill Payment - make payment
	/**
	 * @param details - object of PaymentVO1
	 * @param excess - Difference of Amountyoupay and total amount
	 * @throws SQLException
	 * @since JDK 1.6.0_29
	 * @see none
	 */
	public void updateDetails(PaymentVO1 details,double excess) throws SQLException{
		
		Connection con = DBConnection.connectionDB();
		
		PreparedStatement ps=null;

		try {

			try {
				
			}
			catch (Exception e) {
				log.error(e);
			}
			int billId = details.getBillId();
			ps=con.prepareStatement(Constants.PAYMENTUPDATE);
			ps.setDouble(1,excess);
			ps.setInt(2,billId);
			ps.executeQuery();
		}
		catch (SQLException e) {
			log.error(e);
		}
		finally {
			ps.close();
			con.commit();
			con.close();
		}
	}





	// Bill Dispute (create)
	/**
	 * @param con - object of connection 
	 * @param raisevo1 - object of BTBMVo 
	 * @return raisevo - object of BTBMVo 
	 * @throws SQLException
	 * @since JDK 1.6.0_29
	 * @see none
	 */
	public BTBMVo addDispute(BTBMVo raisevo1)throws SQLException
	{
		int count=0;
		
		Connection con = DBConnection.connectionDB();
		PreparedStatement preparestatement;
		PreparedStatement  preparestatement1=null;
		PreparedStatement preparestatement2;
		ResultSet result=null;
		int disputeId = (int)Math.floor(Math.random()*50000);
		BTBMVo raisevo=null;

		try{
			raisevo=new BTBMVo();
			preparestatement1 = con.prepareStatement(Constants.DISPUTEINSERT);
			preparestatement1.setInt(1, raisevo1.getBillItemId());
			preparestatement1.setInt(2, raisevo1.getCustId());
			result = preparestatement1.executeQuery();

			if( result.next()==false)
			{
				preparestatement2 = con.prepareStatement(Constants.DISPUTEINSERT2);
				result = preparestatement2.executeQuery();
				if(result.next() == true)
				{
					raisevo.setDate(result.getString(1));
				}
				preparestatement = con.prepareStatement(Constants.DISPUTEINSERT1);
				preparestatement.setInt(1,raisevo1.getBillItemId());
				preparestatement.setString(2,raisevo1.getReason());
				preparestatement.setInt(3, disputeId);
				preparestatement.setInt(4, raisevo1.getCustId());
				count= preparestatement.executeUpdate();
				count++;
				raisevo.setDisputeId(disputeId);
				raisevo.setCount(count);
			}
		}
		catch (SQLException e) {
			log.error(e);
		}
		finally {
			con.commit();
			con.close();
		}
		return raisevo; 
	}




	// Bill Dispute ( customer update - Retrieving)
	/**
	 * @param disputeid - Unique id generated for Bill Dispute
	 * @return raisevo - object of BTBMVo
	 * @throws SQLException
	 * @since JDK 1.6.0_29
	 * @see none
	 */
	public BTBMVo getValues(int disputeid) throws SQLException
	{
		BTBMVo raisevo =null;
		
		Connection con = DBConnection.connectionDB();
		PreparedStatement preparestatement=null;
		ResultSet result=null;

		try{
			raisevo = new BTBMVo();

			String sql = Constants.DISPUTEUPDATE;
			preparestatement = con.prepareStatement(sql);
			preparestatement.setInt(1, disputeid);
			result= preparestatement.executeQuery();
			while(result.next())
			{
				if(disputeid == result.getInt(1))
					raisevo.setDisputeId(result.getInt(1));
				raisevo.setBillItemId(result.getInt(2));
				raisevo.setDate(result.getString(3));
				raisevo.setReason(result.getString(4));
				raisevo.setSysDate(result.getString(5));
			}
		}
		catch (SQLException e) {
			log.error(e);
		}
		finally{
			result.close();
			preparestatement.close();
			con.commit();
			con.close();
		}
		return raisevo;
	}




	// Bill Dispute ( customer update - Retrieving)
	/**
	 * @param raisevo - object of BTBMVo
	 * @return count - Number of rows affected
	 * @throws SQLException
	 * @since JDK 1.6.0_29
	 * @see none
	 */
	public int updateValues(BTBMVo raisevo) throws SQLException
	{
		int count=0;
		
		Connection con = DBConnection.connectionDB();
		
		PreparedStatement preparestatement=null;

		try{

			String sql = Constants.DISPUTEUPDATE1;
			preparestatement = con.prepareStatement(sql);
			preparestatement.setString(1,raisevo.getReason());
			preparestatement.setInt(2,raisevo.getBillItemId());
			count=preparestatement.executeUpdate();	
		}
		catch (SQLException e) {
			log.error(e);
		}
		finally {
			preparestatement.close();
			con.commit();
			con.close();
		}
		return count;
	}



	// Bill Dispute ( cancel) 
	/**
	 * @param conn - object of Connection
	 * @param raisevo1 - object of BTBMVo
	 * @return raisevo - object of BTBMVo
	 * @throws SQLException
	 * @since JDK 1.6.0_29
	 * @see none
	 */
	public BTBMVo cancel(BTBMVo raisevo1) throws SQLException
	{
		int count=0;
		PreparedStatement preparestatement=null;
		ResultSet result = null;
		BTBMVo raisevo =null;
		
		Connection con = DBConnection.connectionDB();

		try{
			raisevo = new BTBMVo();
			preparestatement=con.prepareStatement(Constants.CANCELDISPUTE);
			preparestatement.setInt(1,raisevo1.getDisputeId());
			result=preparestatement.executeQuery();
			con.commit();
			if(result.next()== true)
			{
				raisevo.setBillItemId(result.getInt(1));
				raisevo.setDisputeId(result.getInt(2));
				raisevo.setDateOfCancel(result.getString(3));
				count=1;
			}
			raisevo.setCount(count);
		}
		catch (SQLException e) {
			log.error(e);
		}
		finally {
			preparestatement.close();
			con.close();
		}
		return raisevo;
	}



	// Bill Dispute ( cancel)
	/**
	 * @param conn - object of Connection
	 * @param cancelvo - object of BTBMVo
	 * @return count - Number of rows affected
	 * @throws SQLException
	 * @since JDK 1.6.0_29
	 * @see none
	 */
	public int cancel2 (BTBMVo cancelvo) throws SQLException
	{
		PreparedStatement preparestatement=null;
		
		Connection con = DBConnection.connectionDB();
		int count=0;

		try{
			preparestatement=con.prepareStatement(Constants.CANCELDISPUTE1);

			preparestatement.setString(1,cancelvo.getReasonForCancel());	
			preparestatement.setInt(2, cancelvo.getDisputeId());
			count=preparestatement.executeUpdate();
		}
		catch (SQLException e) {
			log.error(e);
		}
		finally {
			con.commit();
			preparestatement.close();
			con.close();
		}

		cancelvo.setCount(count);
		return count;
	}




	// Bill Dispute(Admin Update)
	/**
	 * @param con - object of Connection
	 * @param updatevo - object of BTBMVo
	 * @return updatevo - object of BTBMVo
	 * @throws SQLException
	 * @since JDK 1.6.0_29
	 * @see none
	 */
	public BTBMVo search(BTBMVo updatevo) throws SQLException
	{
		
		Connection con = DBConnection.connectionDB();
		PreparedStatement preparestatement=con.prepareStatement(Constants.RESOLVE);
		preparestatement.setInt(1,updatevo.getDisputeId());
		ResultSet rs=preparestatement.executeQuery();
		con.commit();
		if(rs!=null)
		{
			while(rs.next())
			{
				updatevo.setDisputeId(rs.getInt("disputeId"));
				updatevo.setDate(rs.getString("dateOfResolution"));
				updatevo.setDiscrepancyFound(rs.getString("discrepancy"));
				updatevo.setResolutionComments(rs.getString("resolutionComments"));
				updatevo.setAdjustedCallCost(rs.getInt("callCost"));
				updatevo.setStatus(rs.getString("statusOfDispute"));
			}
			return updatevo;
		}
		else
		{
			return null;
		}	
	}



	// Bill Dispute(Admin Update)
	/**
	 * @param con - object of Connection
	 * @param updatevo - object of BTBMVo
	 * @return count - Number of rows affected
	 * @throws SQLException
	 * @since JDK 1.6.0_29
	 * @see none
	 */
	public int update(BTBMVo updatevo) throws SQLException
	{		
		int count=0;
		PreparedStatement ps=null;
		
		Connection con = DBConnection.connectionDB();

		try{
			ps=con.prepareStatement(Constants.RESOLVE1);
			ps.setString(1,updatevo.getDiscrepancyFound());
			ps.setString(2,updatevo.getResolutionComments());
			ps.setInt(3,updatevo.getAdjustedCallCost());
			ps.setInt(4,updatevo.getDisputeId());
			count = ps.executeUpdate();	
			con.commit();
			ps=con.prepareStatement(Constants.RESOLVE2);
			int disputeId = updatevo.getDisputeId();
			ps.setInt(1,disputeId);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				int excess=rs.getInt(1);
				int callCost=0;
				int temp=excess+callCost;
				ps=con.prepareStatement(Constants.RESOLVE3);
				ps.setInt(1, temp);
				ps.setInt(2,disputeId);
				int idx = 0;
				idx=ps.executeUpdate();
			}
		}
		catch (SQLException e) {
			log.error(e);
		}
		finally {
			con.commit();
			ps.close();
			con.close();
		}
		return count;
	}




	// Bill Dispute (view)
	/**
	 * @param userId - Id of the Customer
	 * @return viewvo - object of BTBMVo
	 * @throws SQLException
	 * @since JDK 1.6.0_29
	 * @see none
	 */
	public BTBMVo getDispute (int userId) throws SQLException
	{
		
		Connection con = DBConnection.connectionDB();
		
		PreparedStatement preparestatement=null;
		ResultSet result=null;
		BTBMVo viewvo=null;

		try{
			viewvo= new BTBMVo();

			preparestatement= con.prepareStatement(Constants.VIEWDISPUTE);
			preparestatement.setInt(1,userId);
			result =preparestatement.executeQuery();

			ArrayList<Integer> list =viewvo.getList();
			int index=0;
			while (result.next())
			{
				list.add(result.getInt(1));
				index++;
			}
			viewvo.setIndex(index);
		}
		catch (SQLException e) {
			log.error(e);
		}
		finally {
			preparestatement.close();
			con.close();
		}
		return viewvo;
	}



	// Bill Dispute (view)
	/**
	 * @param disputeId - Unique id generated for Bill Dispute
	 * @return viewvo - object of BTBMVo
	 * @throws SQLException
	 * @since JDK 1.6.0_29
	 * @see none
	 */
	public BTBMVo viewDispute (int disputeId) throws SQLException
	{
		
		Connection con = DBConnection.connectionDB();
		
		PreparedStatement preparestatement=null;
		ResultSet result=null;
		BTBMVo viewvo=null;

		try{
			viewvo= new BTBMVo();
			preparestatement = con.prepareStatement(Constants.VIEWDISPUTE1);
			preparestatement.setInt(1,disputeId);
			result =preparestatement.executeQuery();
			while (result.next())
			{
				viewvo.setBillItemId(result.getInt(1));
				viewvo.setReason(result.getString(2));
				viewvo.setDisputeId(result.getInt(3));
				viewvo.setDate(result.getString(4));
				viewvo.setReasonForCancel(result.getString(5));
				viewvo.setStatus(result.getString(6));
				viewvo.setAdjustedCallCost(result.getInt(7));
				viewvo.setDateOfCancel(result.getString(8));
				viewvo.setResolutionComments(result.getString(9));
				viewvo.setDateOfResolving(result.getString(10));
			}
		}
		catch (SQLException e) {
			log.error(e);
		}
		finally {
			preparestatement.close();
			con.close();
		}
		return viewvo;
	}



	// Bill Dispute (view)
	/**
	 * @param doDisp - date of Dispute raised
	 * @param status - status of the dispute
	 * @return viewvo - object of BTBMVo
	 * @throws SQLException
	 * @since JDK 1.6.0_29
	 * @see none
	 */
	public BTBMVo getSearch (String raiseDispute , String status) throws SQLException
	{
		
		Connection con = DBConnection.connectionDB();
		
		PreparedStatement  preparestatement=null;
		ResultSet result=null;
		BTBMVo viewvo=null;

		try{
			viewvo= new BTBMVo();

			preparestatement = con.prepareStatement(Constants.VIEWDISPUTE2);
			preparestatement.setString(1, status);
			preparestatement.setString(2, raiseDispute);
			preparestatement.setString(3, raiseDispute);
			result = preparestatement.executeQuery();
			ArrayList<BTBMVo> listVO =viewvo.getListVO();
			int index=0;
			while (result.next())
			{
				System.out.println("entered");
				BTBMVo viewvo1= new BTBMVo();
				viewvo1.setBillItemId(result.getInt(1));
				viewvo1.setReason(result.getString(2));
				viewvo1.setDisputeId(result.getInt(3));
				viewvo1.setDate(result.getString(4));
				viewvo1.setStatus(result.getString(5));
				viewvo1.setReasonForCancel(result.getString(6));
				viewvo1.setDateOfCancel(result.getString(7));
				viewvo1.setUserId(result.getInt(8));
				index++;
				listVO.add(viewvo1);
			}
			System.out.println(index);
			viewvo.setIndex(index);
		}
		catch (SQLException e) {
			log.error(e);
		}
		finally {
			preparestatement.close();
			con.close();
		}
		return  viewvo;
	}



	// Bill Dispute (view)
	/**
	 * @param status - status of the dispute
	 * @return viewvo - object of BTBMVo
	 * @throws SQLException
	 * @since JDK 1.6.0_29
	 * @see none
	 */
	public BTBMVo getSearch1 (String status) throws SQLException
	{
		
		Connection con = DBConnection.connectionDB();
		PreparedStatement preparestatement=null;
		ResultSet result=null;
		BTBMVo viewvo=null;

		try{
			viewvo= new BTBMVo();
			preparestatement = con.prepareStatement(Constants.VIEWDISPUTE3);
			preparestatement.setString(1, status);
			result = preparestatement.executeQuery();
			ArrayList<BTBMVo> listVO =viewvo.getListVO();
			int index=0;
			while (result.next())
			{
				BTBMVo viewvo1= new BTBMVo();
				viewvo1.setBillItemId(result.getInt(1));
				viewvo1.setReason(result.getString(2));
				viewvo1.setDisputeId(result.getInt(3));
				viewvo1.setDate(result.getString(4));
				viewvo1.setStatus(result.getString(5));
				viewvo1.setReasonForCancel(result.getString(6));
				viewvo1.setDateOfCancel(result.getString(7));
				viewvo1.setUserId(result.getInt(8));
				index++;
				listVO.add(viewvo1);
			}
			viewvo.setIndex(index);
		}
		catch (SQLException e) {
			log.error(e);
		}
		finally {
			preparestatement.close();
			con.close();
		}
		return  viewvo;
	}



	//Highlight the disputes
	/**
	 * @return viewvo - object of BTBMVo
	 * @throws SQLException
	 * @since JDK 1.6.0_29
	 * @see none
	 */
	public BTBMVo highlight () throws SQLException
	{
		
		Connection con = DBConnection.connectionDB();
		
		PreparedStatement preparestatement=null;
		ResultSet result=null;
		BTBMVo viewvo=null;

		try{
			viewvo= new BTBMVo();
			preparestatement= con.prepareStatement(Constants.VIEWDISPUTE4);
			result = preparestatement.executeQuery();
			ArrayList<BTBMVo> listVO = viewvo.getListVO();
			int index=0;
			while (result.next())
			{
				BTBMVo viewvo1= new BTBMVo();
				viewvo1.setBillItemId(result.getInt(1));
				viewvo1.setDisputeId(result.getInt(2));
				viewvo1.setUserId(result.getInt(3));
				viewvo1.setStatus(result.getString(4));
				viewvo1.setReason(result.getString(5));
				viewvo1.setDate(result.getString(6));
				viewvo1.setDateOfCancel(result.getString(7));
				viewvo1.setReasonForCancel(result.getString(8));
				index++;
				listVO.add(viewvo1);
			}
			viewvo.setIndex(index);
		}
		catch (SQLException e) {
			log.error(e);
		}
		finally {
			preparestatement.close();
			con.close();
		}
		return viewvo;
	}

	//BillGeneration - Get Connection Details
	/**
	 * @param connvo - connection details
	 * @return connvo - connection details associated with connection number
	 * @throws SQLException
	 * @since JDK 1.6.0_29
	 * @see none
	 */
	public ConnectionVO getConnectionDetailsFromDb(ConnectionVO connvo) throws SQLException {
		int connectionNo=connvo.getConnectionNo();
		
		Connection con = DBConnection.connectionDB();
		
		PreparedStatement ps=null;
		ResultSet rs=null;

		try{

			try {
				
			} catch (Exception e) {
				log.error(e);
			}
			ps=con.prepareStatement(Constants.GETCONNECTION);
			ps.setInt(1, connectionNo);
			rs=ps.executeQuery();
			int count=0;
			if(rs==null)
			{
				connvo.setCount(count);
				return connvo;
			}
			while(rs.next())
			{
				count++;
				connvo.setCount(count);
				connvo.setCustId(rs.getInt("customerid"));
				
				connvo.setConnectionNo(rs.getInt("connectionno"));
				connvo.setTypeOfBill(rs.getString("typeofbill"));
				connvo.setTariffType(rs.getString("tariffname"));
			}
		}
		catch (SQLException e) {
			log.error(e);
		}
		finally {
			rs.close();
			ps.close();
			con.close();
		}
		return connvo;
	}

	//BillGeneration - Get Tariff Details
	/**
	 * @param connvo - connection details
	 * @return BTBMTariffVO tariffvo - tariff details of particular connection number
	 * @throws SQLException
	 * @since JDK 1.6.0_29
	 * @see none
	 */
	public BTBMTariffVO getTariffdetails(ConnectionVO connvo) throws SQLException 
	{
		
		Connection con = DBConnection.connectionDB();
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		BTBMTariffVO tariffvo=null;

		try{
			tariffvo=new BTBMTariffVO();

			try {
				
			} 
			catch (Exception e) {
				log.error(e);
			}
			String tariffType=connvo.getTariffType();
			ps=con.prepareStatement(Constants.GETTARIFF);
			ps.setString(1, tariffType);
			rs=ps.executeQuery();
			while(rs.next())
			{
				tariffvo.setTariffType(rs.getString("tariffname"));
				tariffvo.setMonthlyRent(rs.getInt("monthlyrental"));
				tariffvo.setLocal(rs.getDouble("localpulserate"));
				tariffvo.setLocalUnit(rs.getString("localunit"));
				tariffvo.setStd(rs.getDouble("stdpulserate"));
				tariffvo.setStdUnit(rs.getString("stdunit"));
				tariffvo.setIsd(rs.getDouble("isdpulserate"));
				tariffvo.setIsdUnit(rs.getString("isdunit"));
			}
		}
		catch (SQLException e) {
			log.error(e);
		}
		finally {
			rs.close();
			ps.close();
			con.close();
		}
		return tariffvo;
	}

	//BillGeneration - Get Call Details
	/**
	 * @param callvo - call details
	 * @param tariffvo - tariff details
	 * @return BTBMCallDetailsVO callvo - call details inserted into bill items
	 * @throws SQLException
	 * @since JDK 1.6.0_29
	 * @see none
	 */
	public BTBMCallDetailsVO getCalldetails(BTBMCallDetailsVO callvo, BTBMTariffVO tariffvo) throws SQLException {
		
		Connection con = DBConnection.connectionDB();
		PreparedStatement psCheck=null;
		PreparedStatement ps=null;
		
		ResultSet rsc=null;
		int count=0;
		ResultSet rs=null;

		try{

		
			int connectionNo=callvo.getConnectionNo();
			String month=callvo.getMonth();
			psCheck=con.prepareStatement(Constants.GETCALL);
			psCheck.setInt(1, connectionNo);
			rsc = psCheck.executeQuery();
			if (rsc.next()==false)
			{
				ps=con.prepareStatement(Constants.GETCALL1);
				ps.setInt(1, connectionNo);
				ps.setString(2, month);
				rs=ps.executeQuery();
				int aNumber = (int) (Math.random() * 1000000);
				callvo.setBillId(aNumber);
				callvo.setBillItemId(callvo.getBillId());
				int bItem=(callvo.getBillItemId()*10);
				
				while(rs.next())
				{
					callvo.setCallId(rs.getInt("callid"));
					System.out.println(callvo.getCallId());
					callvo.setConnectionNo(rs.getInt("connectionno"));
					callvo.setCallDuration(rs.getInt("callduration"));
					
					callvo.setDialedNo(rs.getInt("dialedno"));
					callvo.setTypeOfCall(rs.getString("typeofcall"));
					count++;
					callvo.setDateOfCall(rs.getDate("dateofcall"));
					BTBMService bs=new BTBMService();
					callvo=bs.billCalculation(callvo,tariffvo);
					System.out.println(callvo.getCallId());
					bItem=bItem+1;
					callvo.setBillItemId(bItem);
					System.out.println(callvo.getBillId());
					System.out.println(callvo.getTypeOfCall());
					PreparedStatement ps1=con.prepareStatement(Constants.GETCALL2);
					ps1.setInt(1,callvo.getBillId());
					ps1.setInt(2, callvo.getConnectionNo());
					ps1.setInt(3,callvo.getBillItemId());
					ps1.setInt(4, callvo.getCallId());
					ps1.setDouble(5, callvo.getCallDuration());
					ps1.setInt(6, callvo.getDialedNo());
					ps1.setString(7, callvo.getTypeOfCall());
					ps1.setDate(8, callvo.getDateOfCall());
					ps1.setDouble(9, callvo.getCallCost());
					ps1.executeUpdate();
					ps1.close();
					
				}
			}
		}
		catch (SQLException e) {
			log.error(e);
		}
		finally {
		
			
			callvo.setCount(count);
			con.commit();
			con.close();
		}
		return callvo;
	}

	//BillGeneration - Generate Bill
	/**
	 * @param callvo - call details
	 * @param tariffvo - tariff details
	 * @return BillVO bill - bill details generated for particular connection number
	 * @throws SQLException
	 * @since JDK 1.6.0_29
	 * @see none
	 */
	public BillVO billGeneration(BTBMCallDetailsVO callvo, BTBMTariffVO tariffvo) throws SQLException {
		
		Connection con = DBConnection.connectionDB();
		PreparedStatement ps=null;
		ResultSet rs=null;
		BillVO bill=null;

		try{
			bill=new BillVO();

			try {
				
			}
			catch (Exception e) {
				log.error(e);
			}
			String month=callvo.getMonth();
			//ps=con.prepareStatement("select CallCost  from BillItem where connectionno = ? and to_char(DateOfCall,'Mon')=?");
			ps=con.prepareStatement(Constants.GENERATEBILL);
			ps.setInt(1, callvo.getConnectionNo());
			ps.setString(2, month);
			rs=ps.executeQuery();
			Double originalAmount=0.0;
			while(rs.next())
			{
			
			 Double cost = rs.getDouble(1);
			originalAmount=originalAmount+cost;	
			}
			
			bill.setOriginalAmount(originalAmount);
			System.out.println("mr"+tariffvo.getMonthlyRent());
			double oa=bill.getOriginalAmount()+tariffvo.getMonthlyRent();
			bill.setOriginalAmount(oa);
			System.out.println("oa"+bill.getOriginalAmount());
		}
		catch (SQLException e) {
			log.error(e);
		}
		finally {
			rs.close();
			ps.close();
			con.close();
		}
		return bill;
	}
	//BillGeneration - Get Arrears and Excess
	/**
	 * @param billvo - bill details
	 * @param callvo - call details
	 * @return BillVO bill - arrears and excess of particular bill
	 * @throws SQLException
	 * @since JDK 1.6.0_29
	 * @see none
	 */
	public BillVO billArrearsExcess(BillVO billvo,BTBMCallDetailsVO callvo) throws SQLException {
		
		Connection con = DBConnection.connectionDB();
		
		PreparedStatement ps=null;
		ResultSet rs=null;

		try{

			
			int connectionNo=callvo.getConnectionNo();
			ps=con.prepareStatement(Constants.BILLARREAR);
			ps.setInt(1,connectionNo );
			rs=ps.executeQuery();
			while(rs.next())
			{
				billvo.setArrears(rs.getDouble("Arrears"));
			}
			PreparedStatement pse=con.prepareStatement(Constants.BILLARREAR1);
			pse.setInt(1,connectionNo );
			ResultSet rse=pse.executeQuery();
			while(rse.next())
			{
				billvo.setExcess(rse.getDouble(1));
			}
		}
		catch (SQLException e) {
			log.error(e);
		}
		finally {
			con.close();
		}
		return billvo;
	}

	//BillGeneration - insert into bill
	/**
	 * @param billvo - bill details
	 * @param callvo - call details
	 * @param connvo - connection details
	 * @throws SQLException
	 * @since JDK 1.6.0_29
	 * @see none
	 */
	public void insertBill(BillVO billvo, BTBMCallDetailsVO callvo,ConnectionVO connvo) throws SQLException {
		
		Connection con = DBConnection.connectionDB();
		
		PreparedStatement ps=null;
		PreparedStatement psi=null;

		try{

			int billId=callvo.getBillId();
			int connectionNo=callvo.getConnectionNo();
			double originalAmount=billvo.getOriginalAmount();
			double ex=0,ar=0;
			double Excess=billvo.getExcess();
			double Arrears=billvo.getArrears();
			String typeOfBill=connvo.getTypeOfBill();
			double totalAmount=billvo.getTotalAmount();
			System.out.println(totalAmount);
			ps=con.prepareStatement(Constants.BILLINSERT);
			ps.setDouble(1, ex);
			ps.setDouble(2, ar);
			ps.setInt(3, connectionNo);
			ps.executeUpdate();
			ps.close();
			psi=con.prepareStatement(Constants.BILLINSERT1);
			psi.setInt(1, billId);
			psi.setInt(2, connectionNo);
			psi.setDouble(3, originalAmount);
			psi.setDouble(4, Excess);
			psi.setDouble(5, Arrears);
			psi.setString(6, typeOfBill);
			psi.setDouble(7, totalAmount);
			psi.executeUpdate();
		}
		catch (SQLException e) {
			log.error(e);
		}
		finally {
			psi.close();
			con.commit();
			con.close();
		}
	}

	//BillGeneration - view bills 
	/**
	 * @param connectionNum - connection number
	 * @return ArrayList<BillVO1> recentBillls - list of bills for particular connection number
	 * @throws SQLException
	 * @since JDK 1.6.0_29
	 * @see none
	 */
	public ArrayList<BillVO1> getBillsforConnection(int connectionNum) throws SQLException {
		
		Connection con = DBConnection.connectionDB();
		ArrayList<BillVO1> recentBills =null;
		ResultSet rs = null;

		try {
			recentBills = new ArrayList<BillVO1>();
			String vsql = Constants.GETBILLCONNECTION ; 
			PreparedStatement pstmt = con.prepareStatement(vsql);
			pstmt.setInt(1, connectionNum);
			rs = pstmt.executeQuery();
			if(rs==null)
			{
				recentBills = null;
			}
			else {
				while(rs.next())
				{
					BillVO1 Bills = new BillVO1();
					Bills.setConnectionNum(rs.getInt("ConnectionNo"));
					Bills.setBillId(rs.getInt("BillID"));
					Bills.setArrears(rs.getFloat("Arrears"));
					Bills.setExcess(rs.getFloat("excess"));
					Bills.setOriginalAmount(rs.getFloat("originalamount"));
					Bills.setTotalAmount(rs.getFloat("Totalamount"));
					Bills.setBillDate(rs.getDate("BillDate"));
					Bills.setTypeOfBill(rs.getString("TypeOfBill"));
					Bills.setStatusOfPay(rs.getString(8));
					Bills.setBillDate(rs.getDate(6));
					recentBills.add(Bills);
				}
			}

		}
		catch (Exception e) {
			log.error(e);
		}
		finally {
			con.commit();
			rs.close();
		}
		return recentBills;
	}
	//BillGeneration - view Bill items
	/**
	 * @param billId - bill id of particular bill
	 * @return ArrayList<BillItemVO> list - list of bill items
	 * @throws SQLException
	 * @since JDK 1.6.0_29
	 * @see none
	 */
	public ArrayList<BillItemVO> getBillItems(int billId) throws SQLException {
		
		Connection con = DBConnection.connectionDB();
		ResultSet rs = null ;
		ArrayList<BillItemVO> list =null;

		try {
			list = new ArrayList<BillItemVO>();
			String bsql = Constants.GETBILLITEM ;
			PreparedStatement ps = con.prepareStatement(bsql);
			ps.setInt(1, billId);
			rs = ps.executeQuery();
			if(rs==null)
			{
				list = null ;
			}
			else 
			{
				while(rs.next())
				{
					BillItemVO item = new BillItemVO();
					item.setBillID(rs.getInt("BillID"));
					item.setConnectionNo(rs.getInt("ConnectionNo"));
					item.setBillItemId(rs.getInt("BillItemId"));
					item.setCallDuration(rs.getFloat("CallDuration"));			
					item.setDialledNo(rs.getInt("DialedNo"));					
					item.setTypeOfCall(rs.getString("TypeOfCall"));	
					item.setDateOfCall(rs.getDate("DateOfCall"));				
					item.setCallCost(rs.getFloat("callcost"));
					list.add(item);
				}
			}
		}
		catch (Exception e) {
			log.error(e);
		}
		finally {
			con.commit();
			rs.close();
		}
		return list;
	}
	
	public ArrayList<BillItemVO> viewBillItems(BillItemVO itemvo) throws SQLException{
		
		Connection con = DBConnection.connectionDB();
	ArrayList<BillItemVO> billitems =null;
	ResultSet rs = null;
	
	try {
		billitems = new ArrayList<BillItemVO>();
		String vsql = Constants.GETBILLITEM2 ; 
		PreparedStatement pstmt = con.prepareStatement(vsql);
		pstmt.setInt(1, itemvo.getConnectionNo());
		rs = pstmt.executeQuery();
		if(rs==null)
		{
			 billitems = null;
		}
		else {
			while(rs.next())
			{
				BillItemVO item = new BillItemVO();
				item.setBillID(rs.getInt("BillID"));
				item.setConnectionNo(rs.getInt("ConnectionNo"));
				item.setBillItemId(rs.getInt("BillItemId"));
				item.setCallDuration(rs.getFloat("CallDuration"));			
				item.setDialledNo(rs.getInt("DialedNo"));					
				item.setTypeOfCall(rs.getString("TypeOfCall"));	
				item.setDateOfCall(rs.getDate("DateOfCall"));				
				item.setCallCost(rs.getFloat("callcost"));
				billitems.add(item);
			}
		}
		
	}
	catch (Exception e) {
		log.error(e);
	}
	finally {
		con.commit();
		rs.close();
	}
	return billitems;
}
		

	//BillGeneration - Get Bill item for update
	/**
	 * @param billVO - bill details
	 * @param vo - bill item details
	 * @return BillItemVO billitem - bill item details corresponding to bill item id
	 * @throws SQLException
	 * @since JDK 1.6.0_29
	 * @see none
	 */
	public BillItemVO getBillItems(BillVO1 billVO , BillItemVO itemvo) throws SQLException {
		
		Connection con = DBConnection.connectionDB();
		BillItemVO billitem =null;
		ResultSet rs = null;

		try {
			billitem = new BillItemVO();
			String bsql = Constants.GETBILLITEM1;
			PreparedStatement ps = con.prepareStatement(bsql);
			ps.setInt(1,billVO.getBillId());
			ps.setInt(2,billVO.getConnectionNum());
			ps.setInt(3, itemvo.getBillItemId());
			rs = ps.executeQuery();
			if(rs==null)
			{
				billitem = null ;
			}
			else 
			{
				while(rs.next())
				{
					billitem.setBillID(rs.getInt("BillID"));
					billitem.setConnectionNo(rs.getInt("ConnectionNo"));
					billitem.setBillItemId(rs.getInt("BillItemId"));
					billitem.setCallDuration(rs.getFloat("CallDuration"));			
					billitem.setDialledNo(rs.getInt("DialedNo"));					
					billitem.setTypeOfCall(rs.getString("TypeOfCall"));	
					billitem.setDateOfCall(rs.getDate("DateOfCall"));				
					billitem.setCallCost(rs.getFloat("callcost"));
				}
			}
		} 
		catch (Exception e) {
			log.error(e);
		}
		finally {
			con.commit();
			rs.close();
		}
		return billitem;
	}

	//BillGeneration - update bill item
	/**
	 * @param billVO - bill details
	 * @param vo - bill item details
	 * @param difference - difference between original call cost and updated call cost
	 * @return count - number of rows affected
	 * @throws SQLException
	 * @since JDK 1.6.0_29
	 * @see none
	 */
	public int updateBill(BillVO1 billVO , BillItemVO itemvo , float difference) throws SQLException {
		int count=0;
		
		Connection con = DBConnection.connectionDB();
		ResultSet rs = null ;
		BillVO1 billvo = new BillVO1();

		try {
			String vsql = Constants.BILLUPDATE;
			PreparedStatement pstmt = con.prepareStatement(vsql);
			pstmt.setFloat(1,itemvo.getAdjustAmt());
			pstmt.setInt(2, billVO.getBillId());
			pstmt.setInt(3,billVO.getConnectionNum());
			pstmt.setInt(4,itemvo.getBillItemId());
			count = pstmt.executeUpdate();
			String usql = Constants.UPDATEEXCESS;
			PreparedStatement upstmt = con.prepareStatement(usql);
			upstmt.setInt(1, billVO.getBillId());
			rs=upstmt.executeQuery();
			if(rs==null){
				//System.out.println("resultset is null");
			}
			else{
				while(rs.next()){
					billvo.setExcess(rs.getFloat(1));
				}
			}
			String sql = Constants.BILLUPDATE1;
			PreparedStatement ps = con.prepareStatement(sql);
			float excess = billvo.getExcess() + difference;
			System.out.println();
			ps.setFloat(1, excess);
			ps.setInt(2, billVO.getBillId());
			ps.setInt(3,billVO.getConnectionNum());
			ps.executeUpdate();
		} 
		catch (Exception e) {
			log.error(e);
		}
		finally {
			con.commit() ;
		}
		return count ;
	}
	//BillGeneration - delete bill
	/**
	 * @param billId - bill id
	 * @return int count - number of rows affected
	 * @throws SQLException
	 * @since JDK 1.6.0_29
	 * @see none
	 */
	public int deleteBill(int billId) throws SQLException {
		
		Connection con = DBConnection.connectionDB();
		int count = 0;

		try 
		{
			String bsql=Constants.BILLDELETE;
			PreparedStatement bps=con.prepareStatement(bsql);
			bps.setInt(1,billId);
			count = bps.executeUpdate();
			String sql=Constants.BILLITEMDELETE;
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,billId);
			ps.executeUpdate();
		} 
		catch (Exception e){
			log.error(e);
		}
		finally {
			con.close();
		}
		return count ;
	}


	
}





