package com.otbes.vo;
/**
 * @author 		 587864
 * @version 	 1.0
 * @class 		 BillVO
 * @date 		 27/11/12
 */
public class BillVO {
private double originalAmount;
private double Arrears; 
private double Excess;
private double totalAmount;

/**
 * @param originalAmount
 * since jdk1.6.0_29
 */
public void setOriginalAmount(double originalAmount) {
	this.originalAmount = originalAmount;
}

/**
 * @return originalAmount
 * since jdk1.6.0_29
 */
public double getOriginalAmount() {
	return originalAmount;
}

/**
 * @param arrears
 * since jdk1.6.0_29
 */
public void setArrears(double arrears) {
	Arrears = arrears;
}

/**
 * @return Arrears
 * since jdk1.6.0_29
 */
public double getArrears() {
	return Arrears;
}

/**
 * @param excess
 * since jdk1.6.0_29
 */
public void setExcess(double excess) {
	Excess = excess;
}

/**
 * @return Excess
 * since jdk1.6.0_29
 */
public double getExcess() {
	return Excess;
}

/**
 * @param totalAmount
 * since jdk1.6.0_29
 */
public void setTotalAmount(double totalAmount) {
	this.totalAmount = totalAmount;
}

/**
 * @return totalAmount
 * since jdk1.6.0_29
 */
public double getTotalAmount() {
	return totalAmount;
}
}
