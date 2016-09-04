package com.otbes.vo;

/**
 * The descriptive text that explaining the purpose and use of the class.
 * 
 * @author Rahini
 * @version 1.0
 * @Class name TariffVO
 * @Creation Date 8/12/2012 @ History
 */
public class TariffVO {

	public String getTariffName() {
		return tariffName;
	}

	public void setTariffName(String tariffName) {
		this.tariffName = tariffName;
	}

	public float getLocalPulseRate() {
		return localPulseRate;
	}

	public void setLocalPulseRate(float localPulseRate) {
		this.localPulseRate = localPulseRate;
	}

	public String getLocalUnit() {
		return localUnit;
	}

	public void setLocalUnit(String localUnit) {
		this.localUnit = localUnit;
	}

	public float getStdPulseRate() {
		return stdPulseRate;
	}

	public void setStdPulseRate(float stdPulseRate) {
		this.stdPulseRate = stdPulseRate;
	}

	public String getStdUnit() {
		return stdUnit;
	}

	public void setStdUnit(String stdUnit) {
		this.stdUnit = stdUnit;
	}

	public float getIsdPulseRate() {
		return isdPulseRate;
	}

	public void setIsdPulseRate(float isdPulseRate) {
		this.isdPulseRate = isdPulseRate;
	}

	public String getIsdUnit() {
		return isdUnit;
	}

	public void setIsdUnit(String isdUnit) {
		this.isdUnit = isdUnit;
	}

	public int getMonthlyRental() {
		return monthlyRental;
	}

	public void setMonthlyRental(int monthlyRental) {
		this.monthlyRental = monthlyRental;
	}

	private String tariffName;
	private float localPulseRate;
	private String localUnit;
	private float stdPulseRate;
	private String stdUnit;
	private float isdPulseRate;
	private String isdUnit;
	private int monthlyRental;

}
