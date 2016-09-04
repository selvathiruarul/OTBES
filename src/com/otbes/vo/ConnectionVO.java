package com.otbes.vo;

/**
 * The descriptive text that explaining the purpose and use of the class.
 * 
 * @author Naveen kumar
 * @version 1.0
 * @Class name ConnectionVO
 * @Creation Date 8/12/2012 @ History
 */
public class ConnectionVO {

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	private int custId;
	private int connectionNo;
	private String status;
	private String tariffType;
	private String typeOfBill;
	private String reason;
	private int count;

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public int getConnectionNo() {
		return connectionNo;
	}

	public void setConnectionNo(int connectionNo) {
		this.connectionNo = connectionNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTariffType() {
		return tariffType;
	}

	public void setTariffType(String tariff) {
		this.tariffType = tariff;
	}

	public String getTypeOfBill() {
		return typeOfBill;
	}

	public void setTypeOfBill(String typeOfBill) {
		this.typeOfBill = typeOfBill;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}

}
