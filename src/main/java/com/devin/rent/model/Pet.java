package com.devin.rent.model;

import java.io.Serializable;

public class Pet implements Serializable{
	private static final long serialVersionUID = 8544474817045077079L;
	private String petName;
	private double petCost;
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public double getPetCost() {
		return petCost;
	}
	public void setPetCost(double petCost) {
		this.petCost = petCost;
	}
}
