package devin.birtciel.rent.model;

import java.text.DecimalFormat;

public class Summary {
	private String name;
	private String bills;
	private double total;
	public Summary(String name, String bills, double total){
		this.name = name;
		this.bills = bills;
		this.total = total;
	}
	public String getName() {
		return name;
	}
	public String getBills() {
		return bills;
	}
	public double getTotal() {
		return total;
	}
	@Override
	public String toString(){
		DecimalFormat format = new DecimalFormat("$#,##0.00");
		return name + " owes " + format.format(total) + " for " + bills + ".";
	}
}
