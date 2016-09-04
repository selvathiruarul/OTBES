package com.otbes.service;


import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.otbes.dao.BTBMdao;
import com.otbes.vo.*;
/**
 * @author 		 587864
 * @version 	 1.0
 * @class 		 BTBMService
 * @date 		 27/11/12
 */
public class BTBMService {
	//Bill Payment( View Payment)
	/**
	 * @param  		PaymentDetailsVO1 details - customerId
	 * @return 		ArrayList<PaymentVO1> connection - bill id of the particular customer
	 * @exception 	SQLException
	 * @since	    JDK 1.6.0_29 
	 * @see         viewCustomerid(customerId)
	 */
	
	public ArrayList<PaymentVO1> viewCustomer(PaymentVO1 details){
		int customerId=details.getCustomerId();
		ArrayList<PaymentVO1> connection=new ArrayList<PaymentVO1>();
		BTBMdao dao=new BTBMdao();
		try {
			connection=dao.viewCustomerid(customerId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	//Bill Payment( View Payment)
	/**
	 * @param  		PaymentDetailsVO details - details of particular bill
	 * @return 		PaymentDetailsVO paymentdetails - payment details of bill
	 * @exception 	SQLException
	 * @since	    JDK 1.6.0_29 
	 * @see         getPaymentDetails(billId)
	 */
	public PaymentDetailsVO getBillDetails(PaymentDetailsVO details) throws Exception{
		int billId=details.getBillId();
		BTBMdao dao=new BTBMdao();
		PaymentDetailsVO paymentdetails=new PaymentDetailsVO();
		
		
			paymentdetails=dao.getPaymentDetails(billId);
		
		
		return paymentdetails;
	}



	//Bill Payment - View Bill
	/**
	 * @param 		PaymentVO details - details of particular bill
	 * @return 		ArrayList<PaymentVO> billdetails - list of bills associated with connection number
	 * @throws 		Exception 
	 * @since	    JDK 1.6.0_29 
	 * @see			getBill(connectionNo)
	 */
	public ArrayList<PaymentVO> getBill(PaymentVO details) throws Exception {
		int connectionNo=details.getConnectionNo();
		BTBMdao dao=new BTBMdao();
		ArrayList<PaymentVO> billdetails=new ArrayList<PaymentVO>();
		billdetails=dao.getBill(connectionNo);
		return billdetails;
	}



	//Bill Payment - View Bill
	/**
	 * @param 		PaymentVO details - details of particular bill
	 * @return		ArrayList<PaymentVO> billdetails - payment details of particular bill
	 * @throws      Exception 
	 * @since	    JDK 1.6.0_29
	 * @see			getBillDetails(billId)
	 */
	public ArrayList<PaymentVO> getPaymentDetails(PaymentVO details) throws Exception {
		int billId=details.getBillId();
		BTBMdao dao=new BTBMdao();
		ArrayList<PaymentVO> billdetails=new ArrayList<PaymentVO>();
		billdetails=dao.getBillDetails(billId);
		return billdetails;
	}


	//Bill Payment - View Bill

	/**
	 * @param 		PaymentVO1 details - details of particular bill
	 * @return 		PaymentVO1 billdetails - details of bill
	 * @throws Exception
	 * @since JDK 1.6.0_29
	 * @see viewBill(connectionNo),billCalculation(billdetails)
	 */
	public PaymentVO1 view(PaymentVO1 details){
		int connectionNo=details.getConnectionNo();
		BTBMdao dao=new BTBMdao();
		PaymentVO1 billdetails=new PaymentVO1();
		PaymentVO1 result=new PaymentVO1();
		
		try{
			billdetails=dao.viewBill(connectionNo);
			result=billCalculation(billdetails);
			billdetails.setTotalAmt(result.getTotalAmt());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return billdetails;
	}



	//Bill Payment - View connection number

	/**
	 * @param 		PaymentVO1 details - unique customer id
	 * @return 		PaymentVO1 connection - connection number
	 * @throws Exception
	 * @since JDK 1.6.0_29
	 * @see viewConnection(customerId)
	 * 
	 */
	public ArrayList<PaymentVO1> viewId(PaymentVO1 details){
		int customerId=details.getCustomerId();
		ArrayList<PaymentVO1> connection=new ArrayList<PaymentVO1>();
		BTBMdao dao=new BTBMdao();
		try {
			connection=dao.viewConnection(customerId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	//Bill Payment - Make Payment

	/**
	 * @param PaymentVO1 details - Payment details
	 * @return void
	 * @throws Exception
	 * @since JDK 1.6.0_29
	 * @see updateDetails(details,excessAmount),insertDetails(details)
	 */
	public void  make(PaymentVO1 details) throws Exception {
		BTBMdao dao=new BTBMdao();
		double excess=0;
		excess=(details.getAmountYoupay()-details.getTotalAmt()); 
		double excessAmount=details.getExcess()+excess;
		details.setExcess(excessAmount);
		if(excess==0 || excess>0 ){
			dao.updateDetails(details,excessAmount);
			dao.insertDetails(details);
		}
	}



	//Bill Payment - Make Payment
	/**
	 * @param amount - Billamount
	 * @return amount - Total Billamount
	 * @since JDK 1.6.0_29
	 * @see none
	 */
	public PaymentVO1 billCalculation(PaymentVO1 amount) {
		SimpleDateFormat d=new SimpleDateFormat("dd/MM/yyyy");
		Date date=new Date();
		String td=d.format(date);
		String dateParts[] = td.split("/");
		String day  = dateParts[0];
		String month  = dateParts[1];
		String year = dateParts[2];
		int dd=Integer.parseInt(day);
		double totalAmt = 0;
		if(dd > 15 && dd<27){
			totalAmt=(amount.getTotalAmt()+(amount.getTotalAmt()*.05));
		}
		else if(dd > 27 && dd <= 31 ){
			totalAmt=(amount.getTotalAmt()+(amount.getTotalAmt()*.1));
		}
		if(totalAmt!=0.0)
			amount.setTotalAmt(totalAmt);
		return amount ;
	}





	//Bill Payment - Make Payment
	/**
	 * @param paymentvo1 - Excess Billamount 
	 * @return excess - excess amount
	 * @since JDK 1.6.0_29
	 * @see none
	 */
	public double excessCalculation(PaymentVO1 paymentvo1){
		double excess=0;
		excess=(paymentvo1.getAmountYoupay()-paymentvo1.getTotalAmt());
		return excess;
	}
	

	// Bill Dispute (create)
	/**
	 * @param raisevo1 - object reference for BTBMVo 
	 * @return raisevo - object reference for BTBMVo
	 * @throws SQLException
	 * @since JDK 1.6.0_29
	 * @see addDispute(con, raisevo1)
	 */
	public BTBMVo insert(BTBMVo raisevo1)throws SQLException {
		BTBMdao raisedao = new BTBMdao();
		BTBMVo raisevo = null;
		{
			try {
				
				raisevo = raisedao.addDispute(raisevo1);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return raisevo;
	}


	//Bill Dispute ( Customer Update - Retrieving )
	/**
	 * @param raisevo - object reference for BTBMVo
	 * @return raisevo1 - object reference for BTBMVo
	 * @throws Exception
	 * @since JDK 1.6.0_29
	 * @see getValues(disputeid)
	 */
	public BTBMVo getDetails(BTBMVo raisevo )throws Exception {
    	int disputeid =raisevo.getDisputeId();
		BTBMdao raisedao = new BTBMdao();
		BTBMVo raisevo1 = new BTBMVo();
		
		try {
			raisevo1= raisedao.getValues(disputeid);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return raisevo1;
	}


	//Bill Dispute ( Customer Update )	
	/**
	 * @param raisevo - object reference for BTBMVo
	 * @return count - Number of rows affected
	 * @throws Exception
	 * @since JDK 1.6.0_29
	 * @see updateValues(raisevo)
	 */
	public int updateDetails(BTBMVo raisevo)throws Exception {
		int count=0;
		BTBMdao raisedao = new BTBMdao();
		
		try {
			count= raisedao.updateValues(raisevo);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}


	// Bill Dispute ( cancel) 

	/**
	 * @param raisevo - object reference for BTBMVo
	 * @return raisevo1 - object reference for BTBMVo
	 * @throws SQLException
	 * @since JDK 1.6.0_29
	 * @see cancel(con,raisevo)
	 */
	public BTBMVo cancellation(BTBMVo raisevo) throws SQLException {
		BTBMdao canceldao=new BTBMdao();
		BTBMVo raisevo1 = new BTBMVo();
		
		try {

			raisevo1=canceldao.cancel(raisevo);
		}		
		catch(Exception e) {
			e.printStackTrace();
		}
		return raisevo1; 		
	}


	// Bill Dispute ( cancel) 	
	/**
	 * @param cancelvo - object reference for BTBMVo
	 * @return count1 - Number of rows affected
	 * @throws SQLException
	 * @since JDK 1.6.0_29
	 * @see cancel2(con,cancelvo)
	 */
	public int cancellation2(BTBMVo cancelvo) throws SQLException {
		int count1=0;	
		BTBMdao daoboject=new BTBMdao();
		
		try {
			
			count1=daoboject.cancel2(cancelvo);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return count1; 		
	}


	// Admin Update

	/**
	 * @param updatevo - object reference for BTBMVo 
	 * @return updatevo1 - object reference for BTBMVo 
	 * @throws SQLException
	 * @since JDK 1.6.0_29
	 * @see search(con,updatevo)
	 */
	public BTBMVo searching(BTBMVo updatevo) throws SQLException {
		BTBMdao updatedao=new BTBMdao();		
		BTBMVo updatevo1=null;
		
		try {
			
			updatevo1 = updatedao.search(updatevo);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return updatevo1; 		
	}


	// Admin Update	
	/**
	 * @param updatevo - object reference for BTBMVo
	 * @return count1 - Number of rows affected
	 * @throws SQLException
	 * @since JDK 1.6.0_29
	 * @see update(con,updatevo)
	 */
	public int updation(BTBMVo updatevo) throws SQLException {
		int count1=0;	
		BTBMdao daoobject=new BTBMdao();
		
		try {
			
			count1 = daoobject.update(updatevo);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return count1; 
	}


	


	//BillGeneration - Retrieving Connection details 
	/**
	 * @param connvo - object of ConnectionVO
	 * @return connvo - object of ConnectionVO
	 * @throws Exception
	 * @since JDK 1.6.0_29
	 * @see getConnectionDetailsFromDb(connvo)
	 */
	public ConnectionVO getConnectionDetails(ConnectionVO connvo) throws Exception {
		connvo.getConnectionNo();
		BTBMdao dao=new BTBMdao();
		connvo=(ConnectionVO) dao.getConnectionDetailsFromDb(connvo);
		return connvo;
	}


	//Bill Generation -Retrieving Call and tariff details
	/**
	 * @param callvo - object of BTBMCallDetailsVO
	 * @param tariffvo - object of BTBMTariffVO
	 * @return callvo - object of CallVO
	 * @since JDK 1.6.0_29
	 * @see none
	 */
	public BTBMCallDetailsVO billCalculation(BTBMCallDetailsVO callvo, BTBMTariffVO tariffvo) {
		callvo.getCustomerId();
		callvo.getConnectionNo();
		callvo.getCallDuration();
		callvo.getDialedNo();
		callvo.getTypeOfCall();
		callvo.getLocalUnit();
		callvo.getDateOfCall();
		callvo.getBillId();
		tariffvo.getTariffType();
		tariffvo.getMonthlyRent();
		tariffvo.getLocal();
		tariffvo.getStd();
		tariffvo.getIsd();
		double callCost;
		
			if(tariffvo.getTariffType().equalsIgnoreCase("plan150"))
			{
				if(callvo.getTypeOfCall().equalsIgnoreCase("local"))
				{
					callCost=callvo.getCallDuration()*tariffvo.getLocal();
					callvo.setCallCost(callCost);
				}
				else if(callvo.getTypeOfCall().equalsIgnoreCase("std"))
				{
					callCost=callvo.getCallDuration()*tariffvo.getStd();
					callvo.setCallCost(callCost);
				}
				else if(callvo.getTypeOfCall().equalsIgnoreCase("isd"))
				{
					callCost=(callvo.getCallDuration()/60)*tariffvo.getIsd();
					callvo.setCallCost(callCost);
				}
			}
			else if(tariffvo.getTariffType().equalsIgnoreCase("plan250"))
			{
				if(callvo.getTypeOfCall().equalsIgnoreCase("local"))
				{
					callCost=callvo.getCallDuration()*tariffvo.getLocal();
					callvo.setCallCost(callCost);
				}
				else if(callvo.getTypeOfCall().equalsIgnoreCase("std"))
				{
					callCost=callvo.getCallDuration()*tariffvo.getStd();
					callvo.setCallCost(callCost);
				}
				else if(callvo.getTypeOfCall().equalsIgnoreCase("isd"))
				{
					callCost=(callvo.getCallDuration()/60)*tariffvo.getIsd();
					callvo.setCallCost(callCost);
				}
			}
			else if(tariffvo.getTariffType().equalsIgnoreCase("plan500"))
			{
				if(callvo.getTypeOfCall().equalsIgnoreCase("local"))
				{
					callCost=(callvo.getCallDuration()/60)*tariffvo.getLocal();
					callvo.setCallCost(callCost);
				}
				else if(callvo.getTypeOfCall().equalsIgnoreCase("std"))
				{
					callCost=(callvo.getCallDuration()/60)*tariffvo.getStd();
					callvo.setCallCost(callCost);
				}
				else if(callvo.getTypeOfCall().equalsIgnoreCase("isd"))
				{
					callCost=(callvo.getCallDuration()/60)*tariffvo.getIsd();
					callvo.setCallCost(callCost);
				}
			}
		
			else 
			{
				if(callvo.getTypeOfCall().equalsIgnoreCase("local"))
				{
					callCost=(callvo.getCallDuration())*tariffvo.getLocal();
					callvo.setCallCost(callCost);
				}
				else if(callvo.getTypeOfCall().equalsIgnoreCase("std"))
				{
					callCost=(callvo.getCallDuration())*tariffvo.getStd();
					callvo.setCallCost(callCost);
				}
				else if(callvo.getTypeOfCall().equalsIgnoreCase("isd"))
				{
					System.out.println(callvo.getCallDuration()+" "+callvo.getTypeOfCall());
					callCost=(callvo.getCallDuration())*tariffvo.getIsd();
					callvo.setCallCost(callCost);
				}
			}
			
			
		return callvo;
	}


	//Bill Generation - Calculation 
	/**
	 * @param billvo - object of BillVO
	 * @param callvo - object of BTBMCallDetailsVO
	 * @param connvo - object of ConnectionVO
	 * @throws Exception
	 * @since JDK 1.6.0_29
	 * @see insertBill(billvo,callvo,connvo)
	 */
	public void totalBillAmount(BillVO billvo, BTBMCallDetailsVO callvo, ConnectionVO connvo) throws Exception {
		double deduction,tamount;
		String tob=connvo.getTypeOfBill();
		if(connvo.getTypeOfBill().equalsIgnoreCase("ebill"))
		{
			deduction=billvo.getOriginalAmount()*0.02;
			tamount=billvo.getOriginalAmount()-deduction-billvo.getExcess()+billvo.getArrears();
			billvo.setTotalAmount(tamount);
		}
		else if(connvo.getTypeOfBill().equalsIgnoreCase("paperbill"))	
		{
			tamount=billvo.getOriginalAmount()-billvo.getExcess()+billvo.getArrears();
			billvo.setTotalAmount(tamount);
		}
		System.out.println(billvo.getTotalAmount());
		BTBMdao totaldao=new BTBMdao();
		totaldao.insertBill(billvo,callvo,connvo);
	}



	//Bill Generation - Delete Bill
	/**
	 * @param vo - object of BillVO1
	 * @return count - Number of rows affected
	 * @throws Exception
	 * @since JDK 1.6.0_29
	 * @see deleteBill(vo.getBillId())
	 */
	public int delete(BillVO1 vo) throws Exception 
	{
		BTBMdao bdao=new BTBMdao();
		int count = bdao.deleteBill(vo.getBillId());
		return count ;
	}


	//Bill Generation - Update Bill
	/**
	 * @param vo -  object of BillItemVO
	 * @return diff - Difference between Call cost and Adjustedamount
	 * @since JDK 1.6.0_29
	 * @see none
	 */
	public float getDifference(BillItemVO vo)
	{
		float diff = vo.getCallCost()-vo.getAdjustAmt();
		return diff ;
	}

}
