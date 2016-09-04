package com.otbes.vo;

import java.sql.Date;
/**
 * @author 		 587864
 * @version 	 1.0
 * @class 		 BTBMCallDetailsVO
 * @date 		 27/11/12
 */
public class BTBMCallDetailsVO {
private String typeOfCall,localUnit,month;
private int connectionNo,dialedNo,customerId,CallId;
private double callCost;
private int callDuration;
int billId,billItemId;
private Date dateOfCall;
private int count;

/**
 * @return count
 * since jdk1.6.0_29
 */
public int getCount() {
	return count;
}
/**
 * @param count
 * since jdk1.6.0_29
 */
public void setCount(int count) {
	this.count = count;
}
/**
 * @return typeOfCall
 * since jdk1.6.0_29
 */
public String getTypeOfCall() {
	return typeOfCall;
}
/**
 * @param typeOfCall
 * since jdk1.6.0_29
 */
public void setTypeOfCall(String typeOfCall) {
	this.typeOfCall = typeOfCall;
}
/**
 * @return localUnit
 * since jdk1.6.0_29
 */
public String getLocalUnit() {
	return localUnit;
}
/**
 * @param localUnit
 * since jdk1.6.0_29
 */
public void setLocalUnit(String localUnit) {
	this.localUnit = localUnit;
}
/**
 * @return billItemId
 * since jdk1.6.0_29
 */
public int getBillItemId() {
	return billItemId;
}
/**
 * @param billItemId
 * since jdk1.6.0_29
 */
public void setBillItemId(int billItemId) {
	this.billItemId =  billItemId;
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
 * @return dialedNo
 * since jdk1.6.0_29
 */
public int getDialedNo() {
	return dialedNo;
}
/**
 * @param dialedNo
 * since jdk1.6.0_29
 */
public void setDialedNo(int dialedNo) {
	this.dialedNo = dialedNo;
}


/**
 * @return dateOfCall
 * since jdk1.6.0_29
 */
public Date getDateOfCall() {
	return dateOfCall;
}
/**
 * @param dateOfCall
 * since jdk1.6.0_29
 */
public void setDateOfCall(Date dateOfCall) {
	this.dateOfCall = dateOfCall;
}
/**
 * @param month
 * since jdk1.6.0_29
 */
public void setMonth(String month) {
	this.month = month;
}
/**
 * @return month
 * since jdk1.6.0_29
 */
public String getMonth() {
	return month;
}
/**
 * @param customerId
 * since jdk1.6.0_29
 */
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
/**
 * @return customerId
 * since jdk1.6.0_29
 */
public int getCustomerId() {
	return customerId;
}
/**
 * @param callCost
 * since jdk1.6.0_29
 */
public void setCallCost(double callCost) {
	this.callCost = callCost;
}
/**
 * @return callCost
 * since jdk1.6.0_29
 */
public double getCallCost() {
	return callCost;
}
/**
 * @param billId
 * since jdk1.6.0_29
 */
public void setBillId(int billId) {
	this.billId =  billId;
}
/**
 * @return billId
 * since jdk1.6.0_29
 */
public int getBillId() {
	return billId;
}
/**
 * @param callId
 * since jdk1.6.0_29
 */
public void setCallId(int callId) {
	CallId = callId;
}
/**
 * @return CallId
 * since jdk1.6.0_29
 */
public int getCallId() {
	return CallId;
}
public void setCallDuration(int callDuration) {
	this.callDuration = callDuration;
}
public int getCallDuration() {
	return callDuration;
}
}
