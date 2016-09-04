package com.otbes.vo;

import java.sql.Date;
/**
 * @author 		 587864
 * @version 	 1.0
 * @class 		 PaymentDetailsVO
 * @date 		 27/11/12
 */
public class PaymentDetailsVO {
	private int billId;
	private int connectionNo;
	private double totalAmt;
	private float arrears;
	private float amountYoupay; 
	private Date paymentDate;
	
	/**
	 * @return billId
	 * since jdk1.6.0_29
	 */
	public int getBillId() {
		return billId;
	}
	/**
	 * @param billId
	 * since jdk1.6.0_29
	 */
	public void setBillId(int billId) {
		this.billId = billId;
	}
	/**
	 * @return connectionNo
	 * since jdk1.6.0_29
	 */
	public int getConnectionNo() {
		return connectionNo;
	}
	/**
	 * @param connectionNo
	 * since jdk1.6.0_29
	 */
	public void setConnectionNo(int connectionNo) {
		this.connectionNo = connectionNo;
	}
	/**
	 * @return totalAmt
	 * since jdk1.6.0_29
	 */
	public double getTotalAmt() {
		return totalAmt;
	}
	/**
	 * @param totalAmt
	 * since jdk1.6.0_29
	 */
	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}
	/**
	 * @return arrears
	 * since jdk1.6.0_29
	 */
	public float getArrears() {
		return arrears;
	}
	/**
	 * @param arrears
	 * since jdk1.6.0_29
	 */
	public void setArrears(float arrears) {
		this.arrears = arrears;
	}
	/**
	 * @return amountYoupay
	 * since jdk1.6.0_29
	 */
	public float getAmountYoupay() {
		return amountYoupay;
	}
	/**
	 * @param amountYoupay
	 * since jdk1.6.0_29
	 */
	public void setAmountYoupay(float amountYoupay) {
		this.amountYoupay = amountYoupay;
	}
	/**
	 * @return paymentDate
	 * since jdk1.6.0_29
	 */
	public Date getPaymentDate() {
		return paymentDate;
	}
	/**
	 * @param paymentDate
	 * since jdk1.6.0_29
	 */
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	

	
}
