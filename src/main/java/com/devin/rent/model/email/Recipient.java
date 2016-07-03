package com.devin.rent.model.email;

public class Recipient {

	private String name;
	private String addr;
	
	public Recipient(String name, String addr){
		this.name = name;
		this.addr = addr;
	}
	
	public String getName() {
		return name;
	}

	public String getAddr() {
		return addr;
	}
	
}
