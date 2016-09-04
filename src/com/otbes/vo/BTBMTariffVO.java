package com.otbes.vo;
/**
 * @author 		 587864
 * @version 	 1.0
 * @class 		 BTBMTariffVO
 * @date 		 27/11/12
 */
public class BTBMTariffVO {
private String tariffType,localUnit,stdUnit,isdUnit;

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
 * @return stdUnit
 * since jdk1.6.0_29
 */
public String getStdUnit() {
	return stdUnit;
}
/**
 * @param stdUnit
 * since jdk1.6.0_29
 */
public void setStdUnit(String stdUnit) {
	this.stdUnit = stdUnit;
}
/**
 * @return isdUnit
 * since jdk1.6.0_29
 */
public String getIsdUnit() {
	return isdUnit;
}
/**
 * @param isdUnit
 * since jdk1.6.0_29
 */
public void setIsdUnit(String isdUnit) {
	this.isdUnit = isdUnit;
}
private int monthlyRent;
private double local,std,isd;
/**
 * @return tariffType
 * since jdk1.6.0_29
 */
public String getTariffType() {
	return tariffType;
}
/**
 * @param tariffType
 * since jdk1.6.0_29
 */
public void setTariffType(String tariffType) {
	this.tariffType = tariffType;
}
/**
 * @return monthlyRent
 * since jdk1.6.0_29
 */
public int getMonthlyRent() {
	return monthlyRent;
}
/**
 * @param monthlyRent
 * since jdk1.6.0_29
 */
public void setMonthlyRent(int monthlyRent) {
	this.monthlyRent = monthlyRent;
}
/**
 * @return local
 * since jdk1.6.0_29
 */
public double getLocal() {
	return local;
}
/**
 * @param local
 * since jdk1.6.0_29
 */
public void setLocal(double local) {
	this.local = local;
}
/**
 * @return std
 * since jdk1.6.0_29
 */
public double getStd() {
	return std;
}
/**
 * @param std
 * since jdk1.6.0_29
 */
public void setStd(double std) {
	this.std = std;
}
/**
 * @return isd
 * since jdk1.6.0_29
 */
public double getIsd() {
	return isd;
}
/**
 * @param isd
 * since jdk1.6.0_29s
 */
public void setIsd(double isd) {
	this.isd = isd;
}
}
