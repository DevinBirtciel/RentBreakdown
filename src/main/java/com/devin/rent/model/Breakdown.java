package com.devin.rent.model;

import java.io.Serializable;
import java.util.List;

public class Breakdown implements Serializable{
	private static final long serialVersionUID = 3426747238275069452L;
	private double baseRent;
	private double taxRate;
	private List<Utility> utilities;
	private List<Tenant> tenants;
	public double getBaseRent() {
		return baseRent;
	}
	public void setBaseRent(double baseRent) {
		this.baseRent = baseRent;
	}
	public double getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}
	public List<Utility> getUtilities() {
		return utilities;
	}
	public void setUtilities(List<Utility> utilities) {
		this.utilities = utilities;
	}
	public List<Tenant> getTenants() {
		return tenants;
	}
	public void setTenants(List<Tenant> tenants) {
		this.tenants = tenants;
	}
}
