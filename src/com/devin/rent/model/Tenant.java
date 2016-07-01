package com.devin.rent.model;

import java.io.Serializable;
import java.util.List;

public class Tenant implements Serializable{
	private static final long serialVersionUID = -1589716727759028591L;
	private String name;
	private String number;
	private String email;
	private List<Pet> pets;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Pet> getPets() {
		return pets;
	}
	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
}
