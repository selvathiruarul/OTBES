package com.otbes.vo;

/**
 * The descriptive text that explaining the purpose and use of the class.
 * 
 * @author Vinod,Madhumathi,Kalaiarasan
 * @version 1.0
 * @Class name CallDetailVO
 * @Creation Date 8/12/2012 @ History
 */
public class CallDetailVO {

	public int getCallID() {
		return callID;
	}

	public void setCallID(int callID) {
		this.callID = callID;
	}

	public long getConnectionNo() {
		return connectionNo;
	}

	public void setConnectionNo(long connectionNo) {
		this.connectionNo = connectionNo;
	}

	public String getDateOfCall() {
		return dateOfCall;
	}

	public void setDateOfCall(String dateOfCall) {
		this.dateOfCall = dateOfCall;
	}

	public long getDialedNo() {
		return dialedNo;
	}

	public void setDialedNo(long dialedNo) {
		this.dialedNo = dialedNo;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getTypeOfCall() {
		return typeOfCall;
	}

	public void setTypeOfCall(String typeOfCall) {
		this.typeOfCall = typeOfCall;
	}

	private int callID;
	private long connectionNo;
	private String dateOfCall;
	private long dialedNo;
	private int duration;
	private String typeOfCall;
}
