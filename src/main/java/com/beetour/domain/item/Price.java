package com.beetour.domain.item;

public class Price {
	private double baseTotalAmount;			//市场价
	private double basePreferentialPrice;	//优惠价
	private double perPrice;				//团购价

	public double getBaseTotalAmount() {
		return baseTotalAmount;
	}

	public void setBaseTotalAmount(double baseTotalAmount) {
		this.baseTotalAmount = baseTotalAmount;
	}

	public double getBasePreferentialPrice() {
		return basePreferentialPrice;
	}

	public void setBasePreferentialPrice(double basePreferentialPrice) {
		this.basePreferentialPrice = basePreferentialPrice;
	}

	public double getPerPrice() {
		return perPrice;
	}

	public void setPerPrice(double perPrice) {
		this.perPrice = perPrice;
	}

}
