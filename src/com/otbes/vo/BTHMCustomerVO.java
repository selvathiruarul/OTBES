package com.otbes.vo;

/**
 * @author 588438
 * @version 1.0
 * @Class BTHMServlet
 * @Creation 07-12-2012 @ History
 */
public class BTHMCustomerVO {
	private int customerId;	//Id of the customer
	private int count;		// to count the number of occurrences

	/**
	 * @return count
	 * @since jdk1.6.0_29
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count
	 * @since jdk1.6.0_29
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return customer Id
	 * @since jdk1.6.0_29
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 * @since jdk1.6.0_29
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
}
