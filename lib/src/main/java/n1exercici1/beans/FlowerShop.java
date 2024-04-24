package n1exercici1.beans;

import java.io.Serializable;

public class FlowerShop implements Serializable {

private static final long serialVersionUID = 1L;
	
	private String name;
	private double totalEarnings;
	private double totalStockValue;
	
	//important for json deserialization
	public FlowerShop() {
		super();
	}
	
	public FlowerShop(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTotalEarnings() {
		return totalEarnings;
	}

	public void setTotalEarnings(double totalEarnings) {
		this.totalEarnings = totalEarnings;
	}

	public double getTotalStockValue() {
		return totalStockValue;
	}

	public void setTotalStockValue(double totalStockValue) {
		this.totalStockValue = totalStockValue;
	}

	@Override
	public String toString() {
		return "FlowerShop [name=" + name 
								+ ", totalEarnings=" + totalEarnings 
								+ ", totalStockValue=" + totalStockValue + "]";
	}

}
