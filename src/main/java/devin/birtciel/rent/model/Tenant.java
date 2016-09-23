package devin.birtciel.rent.model;

import java.io.Serializable;
import java.util.List;

public class Tenant implements Serializable{
	private static final long serialVersionUID = -1589716727759028591L;
	private String name;
	private List<Pet> pets;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Pet> getPets() {
		return pets;
	}
	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
}
