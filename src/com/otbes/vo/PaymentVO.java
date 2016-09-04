package com.otbes.vo;

import java.sql.Date;
/**
 * @author 		 587864
 * @version 	 1.0
 * @class 		 PaymentVO
 * @date 		 27/11/12
 */
public class PaymentVO {
	private int billId;
	private int connectionNo;
	private float originalAmt;
	private double excess;
	private float arrears;
	private Date billDate;
	private String typeOfbill;
	private String statusOfpay;
	private double totalAmt;
	
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
	 * @return originalAmt
	 * since jdk1.6.0_29
	 */
	public float getOriginalAmt() {
		return originalAmt;
	}
	/**
	 * @param originalAmt
	 * since jdk1.6.0_29
	 */
	public void setOriginalAmt(float originalAmt) {
		this.originalAmt = originalAmt;
	}
	/**
	 * @return excess
	 * since jdk1.6.0_29
	 */
	public double getExcess() {
		return excess;
	}
	/**
	 * @param excess
	 * since jdk1.6.0_29
	 */
	public void setExcess(double excess) {
		this.excess = excess;
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
	 * @return billDate
	 * since jdk1.6.0_29
	 */
	public Date getBillDate() {
		return billDate;
	}
	/**
	 * @param billDate
	 * since jdk1.6.0_29
	 */
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	/**
	 * @return typeOfbill
	 * since jdk1.6.0_29
	 */
	public String getTypeOfbill() {
		return typeOfbill;
	}
	/**
	 * @param typeOfbill
	 * since jdk1.6.0_29
	 */
	public void setTypeOfbill(String typeOfbill) {
		this.typeOfbill = typeOfbill;
	}
	/**
	 * @return statusOfpay
	 * since jdk1.6.0_29
	 */
	public String getStatusOfpay() {
		return statusOfpay;
	}
	/**
	 * @param statusOfpay
	 * since jdk1.6.0_29
	 */
	public void setStatusOfpay(String statusOfpay) {
		this.statusOfpay = statusOfpay;
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
	
}