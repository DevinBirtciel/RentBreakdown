package devin.birtciel.rent.model;

import java.io.Serializable;
import java.util.List;

public class Utility implements Serializable{
	private static final long serialVersionUID = 1302113817245220872L;
	private String utilityName;
	private double utilityCost;
	private List<String> splitBill;
	public String getUtilityName() {
		return utilityName;
	}
	public void setUtilityName(String name) {
		this.utilityName = name;
	}
	public double getUtilityCost() {
		return utilityCost;
	}
	public void setUtilityCost(double cost) {
		this.utilityCost = cost;
	}
	public List<String> getSplitBill() {
		return splitBill;
	}
	public void setSplitBill(List<String> splitBill) {
		this.splitBill = splitBill;
	}
}
