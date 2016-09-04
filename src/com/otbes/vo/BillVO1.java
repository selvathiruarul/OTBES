package com.otbes.vo;

import java.sql.Date;
/**
 * @author 		 587864
 * @version 	 1.0
 * @class 		 BillVO1
 * @date 		 27/11/12
 */
public class BillVO1 {

	private int connectionNum;
	private int billId;
	private float arrears;
	private float excess;
	private float originalAmount;
	private float totalAmount;
	private String typeOfBill;
	private Date billDate;
	private String statusOfPay;
	
	
	

	
	/**
	 * @param connectionNum
	 * @param billId
	 * @param arrears
	 * @param excess
	 * @param originalAmount
	 * @param totalAmount
	 * @param typeOfBill
	 * @param billDate
	 * @param statusOfPay
	 * since jdk1.6.0_29
	 */
	public BillVO1(int connectionNum, int billId, float arrears, float excess,
			float originalAmount, float totalAmount, String typeOfBill,
			Date billDate , String statusOfPay) {
		super();
		this.connectionNum = connectionNum;
		this.billId = billId;
		this.arrears = arrears;
		this.excess = excess;
		this.originalAmount = originalAmount;
		this.totalAmount = totalAmount;
		this.typeOfBill = typeOfBill;
		this.billDate = billDate;
		this.statusOfPay = statusOfPay;
	}
	
	/**
	 * @return statusOfPay
	 * since jdk1.6.0_29
	 * 
	 */
	public String getStatusOfPay() {
		return statusOfPay;
	}

	/**
	 * @param statusOfPay
	 * since jdk1.6.0_29
	 */
	public void setStatusOfPay(String statusOfPay) {
		this.statusOfPay = statusOfPay;
	}

	public BillVO1() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return connectionNum
	 * since jdk1.6.0_29
	 */
	public int getConnectionNum() {
		return connectionNum;
	}

	/**
	 * @param connectionNum
	 * since jdk1.6.0_29
	 */
	public void setConnectionNum(int connectionNum) {
		this.connectionNum = connectionNum;
	}

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
	 * @return excess
	 * since jdk1.6.0_29
	 */
	public float getExcess() {
		return excess;
	}

	/**
	 * @param excess
	 * since jdk1.6.0_29
	 */
	public void setExcess(float excess) {
		this.excess = excess;
	}

	/**
	 * @return originalAmount
	 * since jdk1.6.0_29
	 */
	public float getOriginalAmount() {
		return originalAmount;
	}

	/**
	 * @param originalAmount
	 * since jdk1.6.0_29
	 */
	public void setOriginalAmount(float originalAmount) {
		this.originalAmount = originalAmount;
	}

	/**
	 * @return totalAmount
	 * since jdk1.6.0_29
	 */
	public float getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount
	 * since jdk1.6.0_29
	 */
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return typeOfBill
	 * since jdk1.6.0_29
	 */
	public String getTypeOfBill() {
		return typeOfBill;
	}

	/**
	 * @param typeOfBill
	 * since jdk1.6.0_29
	 */
	public void setTypeOfBill(String typeOfBill) {
		this.typeOfBill = typeOfBill;
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
	
	
	

	
	
}
