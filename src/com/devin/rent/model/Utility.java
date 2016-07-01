package com.devin.rent.model;

import java.io.Serializable;
import java.util.List;

public class Utility implements Serializable{
	private static final long serialVersionUID = 1302113817245220872L;
	private String name;
	private double cost;
	private List<String> splitBill;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public List<String> getSplitBill() {
		return splitBill;
	}
	public void setSplitBill(List<String> splitBill) {
		this.splitBill = splitBill;
	}
}
