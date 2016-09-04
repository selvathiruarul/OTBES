package com.otbes.vo;

import java.sql.Date;
/**
 * @author 		 587864
 * @version 	 1.0
 * @class 		 BillItemVO
 * @date 		 27/11/12
 */
public class BillItemVO {

	private int billID ;			 			
	private int connectionNo;						
	private int billItemId	;						
	private float callDuration	;			
	private int dialledNo;					
	private String typeOfCall	;				
	private Date dateOfCall	;				
	private float callCost	;
	private float adjustAmt ;
	
	/**
	 * @return adjustAmt
	 * @since jdk1.6.0_29
	 */
	public float getAdjustAmt() {
		return adjustAmt;
	}
	/**
	 * @param adjustAmt
	 * @since jdk1.6.0_29
	 */
	public void setAdjustAmt(float adjustAmt) {
		this.adjustAmt = adjustAmt;
	}
	/**
	 * @return billID
	 * @since jdk1.6.0_29
	 */
	public int getBillID() {
		return billID;
	}
	/**
	 * @param billID
	 * @since jdk1.6.0_29
	 */
	public void setBillID(int billID) {
		this.billID = billID;
	}
	/**
	 * @return connectionNo
	 * @since jdk1.6.0_29
	 */
	public int getConnectionNo() {
		return connectionNo;
	}
	/**
	 * @param connectionNo
	 * @since jdk1.6.0_29
	 */
	public void setConnectionNo(int connectionNo) {
		this.connectionNo = connectionNo;
	}
	/**
	 * @return billItemId
	 * @since jdk1.6.0_29
	 */
	public int getBillItemId() {
		return billItemId;
	}
	/**
	 * @param billItemId
	 * @since jdk1.6.0_29
	 */
	
	public void setBillItemId(int billItemId) {
		this.billItemId = billItemId;
	}
	/**
	 * @return callDuration
	 * @since jdk1.6.0_29
	 */
	public float getCallDuration() {
		return callDuration;
	}
	/**
	 * @param callDuration
	 * @since jdk1.6.0_29
	 */
	public void setCallDuration(float callDuration) {
		this.callDuration = callDuration;
	}
	/**
	 * @return dialledNo
	 * @since jdk1.6.0_29
	 */
	public int getDialledNo() {
		return dialledNo;
	}
	/**
	 * @param dialledNo
	 * @since jdk1.6.0_29
	 */
	public void setDialledNo(int dialledNo) {
		this.dialledNo = dialledNo;
	}
	/**
	 * @return typeOfCall
	 * @since jdk1.6.0_29
	 */
	public String getTypeOfCall() {
		return typeOfCall;
	}
	/**
	 * @param typeOfCall
	 * @since jdk1.6.0_29
	 */
	public void setTypeOfCall(String typeOfCall) {
		this.typeOfCall = typeOfCall;
	}
	/**
	 * @return dateOfCall
	 * @since jdk1.6.0_29
	 */
	public Date getDateOfCall() {
		return dateOfCall;
	}
	/**
	 * @param dateOfCall
	 * @since jdk1.6.0_29
	 */
	public void setDateOfCall(Date dateOfCall) {
		this.dateOfCall = dateOfCall;
	}
	/**
	 * @return callCost
	 * @since jdk1.6.0_29
	 */
	public float getCallCost() {
		return callCost;
	}
	/**
	 * @param callCost
	 * @since jdk1.6.0_29
	 */
	public void setCallCost(float callCost) {
		this.callCost = callCost;
	}
	
	
	
	
					
}
