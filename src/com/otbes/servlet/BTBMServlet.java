package com.otbes.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;



import com.otbes.dao.BTBMdao;
import com.otbes.service.BTBMService;
import com.otbes.vo.*;


/**
 * @author 		 587864
 * @version 	 1.0
 * @class 		 BTBMServlet
 * @date 		 27/11/12
 */
public class BTBMServlet extends HttpServlet {

	private static Logger log = Logger.getLogger("otbeslogger");
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BTBMServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String page=request.getParameter("option");
		HttpSession session = request.getSession();

		/**
		 * Bill Payment (view payment)
		 * This function is used to view the bill id of the payment made by the customer
		 */
		if(page.equalsIgnoreCase("viewcid")){
			int customerId=Integer.parseInt(request.getParameter("customerId"));
			PaymentVO1 details=new PaymentVO1();
			details.setCustomerId(customerId);
			ArrayList<PaymentVO1> connection=new ArrayList<PaymentVO1>();
			BTBMService bs=new BTBMService();
			connection=bs.viewCustomer(details);
			if(!connection.isEmpty()){
			request.setAttribute("Viewdetail",connection);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/BTBMpay.jsp");   
			dispatcher.forward(request, response);
			}else{
				request.setAttribute("error","invalidBillID");
				request.setAttribute("back","/JSP/BTBMViewcid.jsp");
				request.setAttribute("legend","billPayment");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/BTBMErrorMsg.jsp");   
				dispatcher.forward(request, response);
				
			}
		}
		
		
		/**
		 * Bill Payment (view payment)
		 * This function is used to view the payment made by the customer
		 */
		if(page.equalsIgnoreCase("payPage")) {
			int billId=Integer.parseInt(request.getParameter("billId"));	
			PaymentDetailsVO details=new PaymentDetailsVO();
			details.setBillId(billId);
			PaymentDetailsVO paymentdetails= new PaymentDetailsVO();
			BTBMService bs=new BTBMService();
			try {
				paymentdetails= bs.getBillDetails(details);
			} catch (Exception e) {
				log.error(e);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
				dispatcher.forward(request, response);

			}

			if(paymentdetails.getBillId()==details.getBillId()) {	
				request.setAttribute("result", paymentdetails);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/BTBMpaydetails.jsp");   
				dispatcher.forward(request, response);   
			}
			else{
				request.setAttribute("error","sorryThereIsNobillForThisConnectionNumber");
				request.setAttribute("back","/JSP/BTBMpay.jsp");
				request.setAttribute("legend","billPayment");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/BTBMErrorMsg.jsp");   
				dispatcher.forward(request, response);
			}
		}



		/**
		 * Bill Payment (view connection number to view Bill) 
		 * This function is used to retrieve the connection numbers for particular customer 
		 */
		
		if(page.equalsIgnoreCase("viewid")){
			int customerId=Integer.parseInt(request.getParameter("customerId"));
			PaymentVO1 details=new PaymentVO1();
			details.setCustomerId(customerId);
			ArrayList<PaymentVO1> connection=new ArrayList<PaymentVO1>();
			BTBMService bs=new BTBMService();
			connection=bs.viewId(details);
			request.setAttribute("Viewdetail",connection);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/BTBMView.jsp");   
			dispatcher.forward(request, response);   
			
		} 
		
		/**
		 * Bill Payment (view Bill by customer) 
		 * This function is used to retrieve the bill id for particular connection number 
		 */
		if(page.equalsIgnoreCase("viewpage")) {
			int connectionNo=Integer.parseInt(request.getParameter("connectionNo"));
			PaymentVO billdetails= new PaymentVO();
			billdetails.setConnectionNo(connectionNo);
			ArrayList<PaymentVO> arraylist=new ArrayList<PaymentVO>();
			BTBMService bs=new BTBMService();

			try {
				arraylist=bs.getBill(billdetails);
			} 
			catch (Exception e) {
				log.error(e);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
				dispatcher.forward(request, response);
			}

			if(arraylist.isEmpty()){
				request.setAttribute("error","sorryThereIsNobillForThisConnectionNumber");
				request.setAttribute("back","/JSP/BTBMView1.jsp");
				request.setAttribute("legend","billPayment");
				request.setAttribute("View", arraylist);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/BTBMErrorMsg.jsp");   
				dispatcher.forward(request, response);  
			}
			else {
				request.setAttribute("View", arraylist);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/BTBMView3.jsp");   
				dispatcher.forward(request, response);  
			}


		}


		/**
		 * Bill Payment (view Bill by customer) 
		 * This function is used to view the bills for particular connection number 
		 */
		if(page.equalsIgnoreCase("view2page")) {
			int billId=Integer.parseInt(request.getParameter("billId"));
			PaymentVO billdetails=new PaymentVO();
			billdetails.setBillId(billId);
			ArrayList<PaymentVO> arraylist=new ArrayList<PaymentVO>();
			BTBMService bs=new BTBMService();

			try {
				arraylist=bs.getPaymentDetails(billdetails);
			}
			catch (Exception e) {
				log.error(e);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
				dispatcher.forward(request, response);
			}

			request.setAttribute("Viewdetails", arraylist);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/BTBMViewdetails.jsp");   
			dispatcher.forward(request, response);  
		}

		/**
		 * Bill Payment (view Bill items by customer) 
		 * This function is used to view the bill items for particular bill id.
		 */
		if(page.equalsIgnoreCase("view4"))
		{
			int billId = Integer.parseInt(request.getParameter("billId"));
			BTBMdao dao = new BTBMdao();

			try {
				ArrayList<BillItemVO> billitems = dao.getBillItems(billId);
				request.setAttribute("BillItems",billitems);
				request.setAttribute("billID", billId);
				ServletContext context=getServletContext();
				RequestDispatcher reqDispatcher=context.getRequestDispatcher("/JSP/BTBMBillItemDetails.jsp");
				reqDispatcher.forward(request, response);
			} 
			catch (Exception e) {
				log.error(e);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
				dispatcher.forward(request, response);
			}
		}

		/**
		 * Bill Payment (view connection number to make payment) 
		 * This function is used to retrieve the connection numbers for particular customer 
		 */
		
		if(page.equalsIgnoreCase("make")){
			int customerId=Integer.parseInt(request.getParameter("customerId"));
			PaymentVO1 details=new PaymentVO1();
			details.setCustomerId(customerId);
			ArrayList<PaymentVO1> connection=new ArrayList<PaymentVO1>();
			BTBMService bs=new BTBMService();
			connection=bs.viewId(details);
			request.setAttribute("Viewdetail",connection);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/BTBMView1.jsp");   
			dispatcher.forward(request, response);   
			
		}
		
		/**
		 * Bill Payment (view bill to make payment) 
		 * This function is used to retrieve the bill id for particular connection number 
		 */
		if(page.equalsIgnoreCase("viewpage1")) {
			int connectionNo=Integer.parseInt(request.getParameter("connectionNo"));	
			PaymentVO1 details=new PaymentVO1();
			details.setConnectionNo(connectionNo);
			PaymentVO1 billdetails= new PaymentVO1();
			BTBMService bs=new BTBMService();
			billdetails=bs.view(details);

			if(billdetails.getConnectionNo()==details.getConnectionNo()){
				if(billdetails.getStatusOfpay().equals("unpaid")) {
					request.setAttribute("Viewdetail", billdetails);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/BTBMViewdetails1.jsp");   
					dispatcher.forward(request, response);   
				}
				else if(billdetails.getStatusOfpay().equals("paid")) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/BTBMpaid.jsp");   
					dispatcher.forward(request, response);   
				}
			}
			else {
				request.setAttribute("error","sorryThereIsNobillForThisConnectionNumber");
				request.setAttribute("back","/JSP/BTBMView1.jsp");
				request.setAttribute("legend","billPayment");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/BTBMErrorMsg.jsp");   
				dispatcher.forward(request, response);
			}
		}




		//Bill Payment (Make Payment) 
		/**
		 * Bill Payment (make payment by customer) 
		 * This function is used to make payment for particular connection number 
		 */
		if(page.equalsIgnoreCase("viewdetails")){
			int customerId=Integer.parseInt(request.getParameter("customerId"));
			int billId=Integer.parseInt(request.getParameter("billId"));
			int connectionNo=Integer.parseInt(request.getParameter("connectionNo"));
			float originalAmt=Float.parseFloat(request.getParameter("originalAmt"));
			float arrears=Float.parseFloat(request.getParameter("arrears"));
			float amountYoupay=Float.parseFloat(request.getParameter("amountYoupay"));
			String bankName=request.getParameter("bankName");
			String cardType=request.getParameter("cardType");
			String cardNo=request.getParameter("cardNo");
			int cvvNo=Integer.parseInt(request.getParameter("cvvNo"));
			double totalAmt=Double.parseDouble(request.getParameter("totalAmt"));
			PaymentVO1 paymentdetails=new PaymentVO1();
			paymentdetails.setBillId(billId);
			paymentdetails.setConnectionNo(connectionNo);
			paymentdetails.setOriginalAmt(originalAmt);
			paymentdetails.setArrears(arrears);
			paymentdetails.setAmountYoupay(amountYoupay);
			paymentdetails.setTotalAmt(totalAmt);
			paymentdetails.setBankName(bankName);
			paymentdetails.setCardType(cardType);
			paymentdetails.setCardNo(cardNo);
			paymentdetails.setCvvNo(cvvNo);
			paymentdetails.setCustomerId(customerId);
			System.out.println();
			BTBMService ls=new BTBMService();
			try {
				ls.make(paymentdetails);
			} catch (Exception e) {
				log.error(e);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
				dispatcher.forward(request, response);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/BTBMsucess.jsp");
			dispatcher.forward(request, response);
		}




		/**
		 * Bill Dispute (create) 
		 * This function is used to raise a dispute for particular bill item id 
		 */
		if(page.equalsIgnoreCase("Raise"))
		{
			BTBMVo raisevo = new BTBMVo();
			Integer itemId = Integer.parseInt(request.getParameter("id"));
			String raiseDate = request.getParameter("d");
			String raiseReason = request.getParameter("r");
			Integer userId = Integer.parseInt(request.getParameter("custid"));
			BTBMVo raisevo1 = new BTBMVo();
			raisevo1.setBillItemId(itemId);
			raisevo1.setDate(raiseDate);
			raisevo1.setReason(raiseReason);
			raisevo1.setCustId(userId);
			BTBMService serviceobject=new BTBMService();

			try {
				raisevo=serviceobject.insert(raisevo1);
			} 
			catch (SQLException e1) {
				log.error(e1);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
				dispatcher.forward(request, response);
			}

			request.setAttribute("DisputeId",raisevo);
			RequestDispatcher rd =getServletContext().getRequestDispatcher("/JSP/BTBMDisputeRaised.jsp");
			rd.forward(request,response);				
		}


		/**
		 * Bill Dispute (Customer update - Retrieving) 
		 * This function is used to retrieve the dispute details for particular dispute id 
		 */
		if(page.equalsIgnoreCase("EnterId")) {	
			int disputeId = Integer.parseInt(request.getParameter("disputeId"));
			BTBMVo raisevo = new BTBMVo();
			raisevo.setDisputeId(disputeId);
			BTBMService serviceobject = new BTBMService();
			BTBMVo raisevo1 = new BTBMVo();


			try {
				raisevo1= serviceobject.getDetails(raisevo );
				request.setAttribute("result",  raisevo1);
			} 
			catch (Exception e) {
				log.error(e);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
				dispatcher.forward(request, response);
			}

			int temp= raisevo1.getDisputeId();
			if(  temp == 0)
			{
				request.setAttribute("error","dearCustomer,PleaseCheckYourDisputeId");
				request.setAttribute("back","/JSP/BTBMupdatec.jsp");
				request.setAttribute("legend","billDispute");
				RequestDispatcher rd = request.getRequestDispatcher("/JSP/BTBMErrorMsg.jsp");
				rd.forward(request,response);
			}
			else
			{
				
				RequestDispatcher rd = request.getRequestDispatcher("/JSP/BTBMupdatec1.jsp");
				rd.forward(request,response);
			}
		}


		/**
		 * Bill Dispute (Customer Update)
		 * This function is used to update the dispute details for particular dispute id 
		 */
		if(page.equalsIgnoreCase("UpdateDispute"))
		{
			int itemId = Integer.parseInt(request.getParameter("bid"));
			String raiseDate= (request.getParameter("d"));
			String raiseReason = request.getParameter("r");
			BTBMVo raisevo = new BTBMVo();
			raisevo.setBillItemId(itemId);
			raisevo.setDate(raiseDate);
			raisevo.setReason(raiseReason);
			int count =0;
			BTBMService serviceobject = new BTBMService();

			try {
				count= serviceobject.updateDetails( raisevo );
			}
			catch(Exception e){
				log.error(e);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
				dispatcher.forward(request, response);
			}

			if(count!= 0)
			{
				RequestDispatcher rd = request.getRequestDispatcher("/JSP/BTBMupdatec3.jsp");
				rd.forward(request,response);
			}	
		}



		/**
		 * Bill Dispute (Cancel Dispute)
		 * This function is used to retrieve the dispute details to cancel by giving dispute id 
		 */
		if(page.equalsIgnoreCase("cancel"))

		{
			int itemid = Integer.parseInt(request.getParameter("disputeId"));
			BTBMVo cancelvo=new BTBMVo();		
			cancelvo.setDisputeId(itemid);
			BTBMService serviceobject=new BTBMService();
			BTBMVo cancelvo1= new BTBMVo();
			int count2=0;

			try {
				cancelvo1= serviceobject.cancellation(cancelvo);
				count2=cancelvo1.getCount();

				if(count2==1){
					request.setAttribute("result", cancelvo1);
					request.getRequestDispatcher("/JSP/BTBMcancel.jsp").forward(request, response);	
				}
				else
				{
					request.setAttribute("result", cancelvo1);
					request.setAttribute("error","errorDearCustomer,InvalidDisputeIdentificationNumberOrDisputeAlreadyCancelled");
					request.setAttribute("back","/JSP/BTBMcancel0.jsp");
					request.setAttribute("legend","billDispute");
					request.getRequestDispatcher("/JSP/BTBMErrorMsg.jsp").forward(request, response);
				}
			} 
			catch (SQLException e) {
				log.error(e);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
				dispatcher.forward(request, response);
			}
		}
		/**
		 * Bill Dispute (Cancel Dispute)
		 * This function is used to cancel the dispute raised by mistake by the customer 
		 */

		if(page.equalsIgnoreCase("cancelfirst"))
		{
			String reason=request.getParameter("reasons");
			int disputeId = Integer.parseInt(request.getParameter("disputeid"));
			BTBMVo cancelvo=new BTBMVo();
			cancelvo.setDisputeId(disputeId);
			cancelvo.setReasonForCancel(reason);
			BTBMService serviceobject = new BTBMService();

			try {
				int count= serviceobject.cancellation2(cancelvo);
				if (count == 1)
				{
					request.getRequestDispatcher("/JSP/BTBMcancel1.jsp").forward(request, response);	
				}
				else
				{
					request.setAttribute("error" , "errorDearCustomer,InvalidDisputeIdentificationNumberOrDisputeAlreadyCancelled");
					request.setAttribute("back","/JSP/BTBMcancel0.jsp");
					request.setAttribute("legend","billDispute");
					request.getRequestDispatcher("/JSP/BTBMErroMsg.jsp").forward(request, response);	
				}
			}
			catch (SQLException e) {
				log.error(e);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
				dispatcher.forward(request, response);
			}
		}



		/**
		 * Bill Dispute (Admin Update)
		 * This function is used to update the dispute raised by the customer 
		 */

		if(page.equalsIgnoreCase("update"))
		{
			int disputeId=(Integer.parseInt(request.getParameter("disputeid")));
			String raiseDate=request.getParameter("dat");
			String discrepancy=request.getParameter("disc");
			String resolve=request.getParameter("resolution");
			Integer callCost=Integer.parseInt(request.getParameter("cost"));
			String status=request.getParameter("state");
			BTBMVo updatevo=new BTBMVo();
			updatevo.setDisputeId(disputeId);
			updatevo.setDate(raiseDate);
			updatevo.setDiscrepancyFound(discrepancy);
			updatevo.setResolutionComments(resolve);
			updatevo.setAdjustedCallCost(callCost);
			updatevo.setStatus(status);
			BTBMService serviceobject=new BTBMService();
			int count2=0;

			try {
				count2=0;
				count2 = serviceobject.updation(updatevo);
			} 
			catch (SQLException e1) {
				log.error(e1);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
				dispatcher.forward(request, response);
			}

			if(count2>0)
			{
				request.setAttribute("result2", count2);
				request.getRequestDispatcher("/JSP/BTBMupdate3.jsp").forward(request, response);
			}				
		}



		/**
		 * Bill Dispute(View by customer and administrator)
		 * This function is used to view the dispute raised by the customer 
		 */


		if (page.equalsIgnoreCase("viewLink"))
		{
			int userId = Integer.parseInt(request.getParameter("custId"));
			BTBMdao daoobject =new BTBMdao();

			try {
				BTBMVo viewvo= daoobject.getDispute(userId);
				if( viewvo.getIndex()>0)
				{
					request.setAttribute("result",viewvo);
					RequestDispatcher rd1 = request.getRequestDispatcher("/JSP/BTBMCustomerView.jsp");
					rd1.forward(request, response);
				}
				else
				{
					request.setAttribute("error","dearCustomer,PleaseCheckYourDisputeId");
					request.setAttribute("back","/JSP/BTBMupdatec.jsp");
					request.setAttribute("legend","billDispute");
					RequestDispatcher rd1 = request.getRequestDispatcher("/JSP/BTBMErrorMsg.jsp");
					rd1.forward(request, response);
				}
			}
			catch (SQLException e) {
				log.error(e);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
				dispatcher.forward(request, response);
			}
			catch (Exception e) {
				log.error(e);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
				dispatcher.forward(request, response);
			}
		}

		/**
		 * Bill Dispute(View by customer)
		 * This function is used to view the dispute raised by the customer 
		 */
		if(page.equalsIgnoreCase("selectId"))
		{
			int disputeId = Integer.parseInt(request.getParameter("dispId"));
			BTBMdao daoobject =new BTBMdao();
			BTBMVo viewvo= new BTBMVo();

			try {
				viewvo =  daoobject.viewDispute(disputeId);
			} 
			catch (Exception e) {
				log.error(e);
			}

			request.setAttribute("details",viewvo);
			RequestDispatcher rd1 = request.getRequestDispatcher("/JSP/BTBMCustomerView2.jsp");
			rd1.forward(request, response);
		}
		/**
		 * Bill Dispute(View by administrator)
		 * This function is used to view the dispute raised by the customer 
		 */
		if(page.equalsIgnoreCase("adminView"))  
		{
			String raiseDate=null;
			raiseDate=request.getParameter("doDisp");
			String status=request.getParameter("status");
			BTBMVo viewvo = new BTBMVo();
			BTBMdao daoobject = new BTBMdao();
			System.out.println("123");
			System.out.println(status);


			/**
			 * Bill Dispute(View by administrator)
			 * This function is used to view the dispute raised by the customer through search criteria
			 */
			if(raiseDate.equalsIgnoreCase("")== false )
			{
				System.out.println("124");

				try {
					viewvo=daoobject.getSearch(raiseDate,status);
					if(viewvo.getIndex()>0)
					{
						System.out.println("125");
						request.setAttribute("result", viewvo);
						RequestDispatcher rd2 = request.getRequestDispatcher("/JSP/BTBMAdminView2.jsp");
						rd2.forward(request, response);
					}
					else
					{
						request.setAttribute("error","sorry,NoDisputeIsFoundMatchingTheSearchCriteria");
						request.setAttribute("back","/JSP/BTBMAdminView.jsp");
						request.setAttribute("legend","billDispute");
						RequestDispatcher rd2 = request.getRequestDispatcher("/JSP/BTBMErrorMsg.jsp");
						rd2.forward(request, response);
					}
				} 
				catch (SQLException e) {
					log.error(e);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
					dispatcher.forward(request, response);
				} 
				catch (Exception e) {
					log.error(e);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
					dispatcher.forward(request, response);
				}

			}
			/**
			 * Bill Dispute(View by administrator)
			 * This function is used to view the dispute raised by the customer through search criteria
			 */
			else if(raiseDate.equalsIgnoreCase("")==true )
			{
				System.out.println("126");
				try {
					viewvo=daoobject.getSearch1(status);
					if(viewvo.getIndex()>0)
					{
						System.out.println("128");
						request.setAttribute("result", viewvo);
						RequestDispatcher rd3 = request.getRequestDispatcher("/JSP/BTBMAdminView2.jsp");
						rd3.forward(request, response);
					}
					else
					{
						request.setAttribute("error","sorry,NoDisputeIsFoundMatchingTheSearchCriteria");
						request.setAttribute("back","/JSP/BTBMAdminView.jsp");
						request.setAttribute("legend","billDispute");
						RequestDispatcher rd = request.getRequestDispatcher("/JSP/BTBMErrorMsg.jsp");
						rd.forward(request, response);
			
					}
				} 
				catch (SQLException e) {
					log.error(e);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
					dispatcher.forward(request, response);
				} 
				catch (Exception e) {
					log.error(e);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
					dispatcher.forward(request, response);
				}

			}
		}

		/**
		 * Bill Dispute(View by administrator)
		 * This function is used to view the  search results
		 */
		if(page.equalsIgnoreCase("adminView2"))

		{
			System.out.println("223");
			BTBMVo viewvo = new BTBMVo();
			int disputeId = Integer.parseInt(request.getParameter("resolve"));
			viewvo.setDisputeId(disputeId );
			String redirect= request.getParameter("redirect");
			if(redirect.equalsIgnoreCase("Back")){
				
				RequestDispatcher rd2 = request.getRequestDispatcher("/JSP/BTBMAdminView.jsp");
				rd2.forward(request, response);
			}
			if(redirect.equalsIgnoreCase("resolve")){
				System.out.println("13");
				request.setAttribute("result", viewvo);
				RequestDispatcher rd2 = request.getRequestDispatcher("/JSP/BTBMupdate2.jsp");
				rd2.forward(request, response);
			}
		}


		/**
		 * Bill Dispute(View by administrator)
		 * This function is used to view the dispute that are not resolved within seven days
		 */

		if(page.equalsIgnoreCase("highlight"))
		{
			BTBMVo viewvo = new BTBMVo();
			BTBMdao daoobject = new BTBMdao();
			try {
				viewvo = daoobject.highlight();
				if(viewvo.getIndex()>0)
				{
					
					request.setAttribute("result", viewvo);
					RequestDispatcher rd2 = request.getRequestDispatcher("/JSP/BTBMHighlightDisp.jsp");
					rd2.forward(request, response);
				}
				else{
					request.setAttribute("error","sorry,NoDisputeIsFoundMatchingTheSearchCriteria");
					request.setAttribute("back","/JSP/BTBMAdminView.jsp");
					request.setAttribute("legend","billDispute");
					request.setAttribute("result",viewvo);
					RequestDispatcher rd2 = request.getRequestDispatcher("/JSP/BTBMErrorMsg.jsp");
					rd2.forward(request, response);
				}
			}
			catch (Exception e) {
				log.error(e);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
				dispatcher.forward(request, response);
			}
		}
		/**
		 * Bill Dispute(View by administrator)
		 * This function is used to view the dispute that are not resolved within seven days
		 */

		if(page.equalsIgnoreCase("highlight2"))
		{
			BTBMVo viewvo = new BTBMVo();
			int disputeId = Integer.parseInt(request.getParameter("select"));
			viewvo.setDisputeId(disputeId);
			String redirect= request.getParameter("redirect");
			if(redirect.equalsIgnoreCase("Back")){
				RequestDispatcher rd2 = request.getRequestDispatcher("/JSP/BTBMAdminView.jsp");
				rd2.forward(request, response);
			}
			if(redirect.equalsIgnoreCase("Resolve")){
				request.setAttribute("result", viewvo);
				RequestDispatcher rd2 = request.getRequestDispatcher("/JSP/BTBMupdate2.jsp");
				rd2.forward(request, response);
			}
		}



		/**
		 * BillGenerate view connection details
		 * This function is used to retrieve the connection details
		 */

		if(page.equalsIgnoreCase("connectionno"))
		{
			int connectionNo=Integer.parseInt(request.getParameter("cno"));
			ConnectionVO connvo=new ConnectionVO();
			connvo.setConnectionNo(connectionNo);
			BTBMService btbmservice=new BTBMService();
			try {
				connvo=btbmservice.getConnectionDetails(connvo);
				int count=connvo.getCount();
				if(count>0)
				{
					request.setAttribute("details", connvo);
					RequestDispatcher rd=request.getRequestDispatcher("BTBMbillgenerationdetails.jsp");
					rd.forward(request,response);
				}
				else
				{
					request.setAttribute("error","sorryThereIsNoSuchConnectionNumber");
					request.setAttribute("back","/JSP/BTBMconnectionno.jsp");
					request.setAttribute("legend","billGeneration");
					RequestDispatcher rd=request.getRequestDispatcher("/JSP/BTBMErrorMsg.jsp");
					rd.forward(request,response);
				}
			} 
			catch (SQLException e) {
				log.error(e);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
				dispatcher.forward(request, response);
			} 
			catch (Exception e) {
				log.error(e);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
				dispatcher.forward(request, response);
			}
		}


		/**
		 * Bill Generate Generate bill
		 * This function is used to generate bill for retrieved connection details
		 */

		if(page.equalsIgnoreCase("billgeneration"))
		{
			String tariffType=request.getParameter("tariffType");
			String typeOfBill=request.getParameter("typeOfBill");
			ConnectionVO connvo=new ConnectionVO();
			BTBMTariffVO tariffvo=new BTBMTariffVO();
			connvo.setTariffType(tariffType);
			connvo.setTypeOfBill(typeOfBill);
			BTBMdao conndao=new BTBMdao();
			try {
				tariffvo=conndao.getTariffdetails(connvo);
			}
			 
			catch (Exception e) {
				log.error(e);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
				dispatcher.forward(request, response);
			}
			int connectionNo=Integer.parseInt(request.getParameter("connectionNo"));
			String month=request.getParameter("month");
			BTBMCallDetailsVO callvo=new BTBMCallDetailsVO();
			callvo.setMonth(month);
			callvo.setConnectionNo(connectionNo);
			BTBMdao calldao=new BTBMdao();

			
				try {
					callvo=calldao.getCalldetails(callvo,tariffvo);
				} catch (SQLException e1) {
					log.error(e1);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
					dispatcher.forward(request, response);
				}
			 
			
			if (callvo.getCount()==0)
			{
				request.setAttribute("error","sorry,TheBillForThisMonthIsAlreadyGenerated");
				request.setAttribute("back","/JSP/BTBMconnectionno.jsp");
				request.setAttribute("legend","billGeneration");
				RequestDispatcher dispatch=request.getRequestDispatcher("BTBMErrorMsg.jsp");
				dispatch.forward(request,response);
			}
			else if(callvo.getCount()>0)
			{
				BillVO billvo=new BillVO();
				BTBMdao billdao=new BTBMdao();
				try {
					billvo=billdao.billGeneration(callvo,tariffvo);
				} 
				
				catch (Exception e) {
					log.error(e);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
					dispatcher.forward(request, response);
				}
				BTBMdao billarrearsdao=new BTBMdao();
				try {
					billarrearsdao.billArrearsExcess(billvo, callvo);
				}
				catch (SQLException e) {
					log.error(e);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
					dispatcher.forward(request, response);
				} 
				catch (Exception e) {
					log.error(e);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
					dispatcher.forward(request, response);
				}

				BTBMService totalbillservice=new BTBMService();
				try {
					System.out.println(billvo.getOriginalAmount());
					totalbillservice.totalBillAmount(billvo,callvo,connvo);
					System.out.println(billvo.getTotalAmount());
				} 
				catch (SQLException e) {
					log.error(e);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
					dispatcher.forward(request, response);
				} 
				catch (Exception e) {
					log.error(e);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
					dispatcher.forward(request, response);
				}
				RequestDispatcher dispatch=request.getRequestDispatcher("BTBMbillgenerationacknowledgement.jsp");
				dispatch.forward(request,response);
			
			}
		}

		// Bill Generation view bill
		/**
		 * Bill Generate view bill by administrator
		 * This function is used to retrieve the bill id for particular connection number 
		 */

		if(page.equalsIgnoreCase("view1"))
		{
			String connnum = request.getParameter("connection").trim();
			int connNum = Integer.parseInt(connnum);
			BTBMdao viewdao = new BTBMdao();

			try {
				ArrayList<BillVO1> recentBills = viewdao.getBillsforConnection(connNum);

				if(recentBills.isEmpty()) {
					request.setAttribute("error","sorryThereIsNobillForThisConnectionNumber");
					request.setAttribute("back","/JSP/BTBMViewConnection.jsp");
					request.setAttribute("legend","billGeneration");
					ServletContext context=getServletContext();
					RequestDispatcher reqDispatcher=context.getRequestDispatcher("/JSP/BTBMErrorMsg.jsp");
					reqDispatcher.forward(request, response);

				}

				else {

					session = request.getSession(true);
					session.setAttribute("recentBills",recentBills);
					session.setAttribute("connNum", connNum);
					ServletContext context=getServletContext();
					RequestDispatcher reqDispatcher=context.getRequestDispatcher("/JSP/BTBMBillList.jsp");
					reqDispatcher.forward(request, response);
				}
			}
			catch (Exception e) {
				log.error(e);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
				dispatcher.forward(request, response);
			}
		}


		/**
		 * Bill Generation (view Bill by administrator) 
		 * This function is used to view the bill details for particular bill id
		 */

		if(page.equalsIgnoreCase("view2")){
			String selectedBillId = request.getParameter("BillId");
			request.setAttribute("selectedBillId", selectedBillId);
			ServletContext context=getServletContext();
			RequestDispatcher reqDispatcher=context.getRequestDispatcher("/JSP/BTBMDisplayBill.jsp");
			reqDispatcher.forward(request, response);
		}



		/**
		 * Bill Generation (view Bill items by administrator) 
		 * This function is used to view the bill items for particular bill id 
		 */
		if(page.equalsIgnoreCase("view3"))
		{
			int billId = Integer.parseInt(request.getParameter("billId"));
			BTBMdao dao = new BTBMdao();

			try {
				ArrayList<BillItemVO> billitems = dao.getBillItems(billId);
				request.setAttribute("BillItems",billitems);
				request.setAttribute("billID", billId);
				ServletContext context=getServletContext();
				RequestDispatcher reqDispatcher=context.getRequestDispatcher("/JSP/BTBMBillItem.jsp");
				reqDispatcher.forward(request, response);
			} 
			catch (Exception e) {
				log.error(e);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
				dispatcher.forward(request, response);
			}
		}



		/**
		 * Bill Generation (update Bill items by administrator) 
		 * This function is used to retrieve  the bill items details for particular bill id 
		 */

		if(page.equalsIgnoreCase("update1"))
		{
			int conNo = Integer.parseInt(request.getParameter("conNo")) ;
			BillItemVO itemvo = new BillItemVO();
			itemvo.setConnectionNo(conNo);
			ArrayList<BillItemVO> billitem = null ;
			BTBMdao itemdao = new BTBMdao();
			
			try {
				billitem = new ArrayList<BillItemVO>();
				billitem = itemdao.viewBillItems(itemvo);
				
				if(billitem.isEmpty()){
					request.setAttribute("error","sorryThereIsNobBillItemForThisConnectionNumber");
					request.setAttribute("back","/JSP/BTBMupdate.jsp");
					request.setAttribute("legend","billGeneration");
					ServletContext context = getServletContext();
					RequestDispatcher dispatcher = context.getRequestDispatcher("/JSP/BTBMErrorMsg.jsp");
					dispatcher.forward(request,response);
				}
				else {
					session = request.getSession(true);
					session.setAttribute("billitems", billitem);
					session.setAttribute("conNo", conNo);
					ServletContext context = getServletContext();
					RequestDispatcher dispatcher = context.getRequestDispatcher("/JSP/BTBMupdateitem.jsp");
					dispatcher.forward(request,response);
				}
				
			} 
			catch (Exception e) {
				log.error(e);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
				dispatcher.forward(request, response);
			}
		}

		if(page.equalsIgnoreCase("updateview"))
		{
			String billItemid= request.getParameter("BillitemId");
			request.setAttribute("billItemid", billItemid);
			ServletContext context=getServletContext();
			RequestDispatcher reqDispatcher=context.getRequestDispatcher("/JSP/BTBMupdatebill.jsp");
			reqDispatcher.forward(request, response);
		}


		/**
		 * Bill Generation (update Bill items by administrator) 
		 * This function is used to update the retrieved  the bill items  
		 */

		if(page.equalsIgnoreCase("update2"))
		{
			int ConnectionNo = Integer.parseInt(request.getParameter("connNo"));
			int billid = Integer.parseInt(request.getParameter("billId"));
			int billitemid = Integer.parseInt(request.getParameter("billitemid"));
			float callCost = Float.parseFloat(request.getParameter("callcost"));
			float adjustAmt = Float.parseFloat(request.getParameter("adjustamt"));
			BTBMService service = new BTBMService();
			BillItemVO updatevo = new BillItemVO();
			updatevo.setCallCost(callCost);
			updatevo.setAdjustAmt(adjustAmt);
			float difference = service.getDifference(updatevo);
			BillVO1 billVO = new BillVO1();
			billVO.setConnectionNum(ConnectionNo);
			billVO.setBillId(billid);
			updatevo.setBillItemId(billitemid);
			BTBMdao dao = new BTBMdao();

			try 
			{
				int count=0;
				count = dao.updateBill(billVO , updatevo , difference);
				BillItemVO itemvo = new BillItemVO();
				itemvo.setBillID(billid);
				itemvo.setBillItemId(billitemid);
				request.setAttribute("billitems", itemvo);
				ServletContext context = getServletContext();
				RequestDispatcher dispatcher = context.getRequestDispatcher("/JSP/BTBMupdateAck.jsp");
				dispatcher.forward(request, response);
			} 
			catch (Exception e) {
				log.error(e);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
				dispatcher.forward(request, response);
			}
		}




		/**
		 * Bill Generation (delete bill ) 
		 * This function is used to delete particular bill id 
		 */
		if(page.equalsIgnoreCase("delete"))
		{
			int billId = Integer.parseInt(request.getParameter("billid"));
			int count=0;
			BillVO1 billvo = new BillVO1();
			billvo.setBillId(billId);
			BTBMService billservice = new BTBMService();

			try {
				count = billservice.delete(billvo);
			}
			catch (Exception e) {
				log.error(e);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JSP/Error1.jsp");
				dispatcher.forward(request, response);
			}

			if(count!=0) {
				ServletContext context = getServletContext();
				RequestDispatcher dispatcher = context.getRequestDispatcher("/JSP/BTBMDeleteAck.jsp");
				dispatcher.forward(request, response);
			}
			else {
				request.setAttribute("error","noSuchBillsFound");
				request.setAttribute("back","/JSP/BTBMdelete.jsp");
				request.setAttribute("legend","billGeneration");
				ServletContext context = getServletContext();
				RequestDispatcher dispatcher = context.getRequestDispatcher("/JSP/BTBMErrorMsg.jsp");
				dispatcher.forward(request, response);	
			}
		}



	}
}
