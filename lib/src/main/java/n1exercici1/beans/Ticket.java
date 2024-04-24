package n1exercici1.beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import n1exercici1.utis.Utils;

public class Ticket implements Serializable{

private static final long serialVersionUID = 1L;
	
	private int ticketId;
	private Map<String, TicketData> products;
	private double totalAmount;
	private String creationDateTime;

	public Ticket() {
		super();
		this.products = new HashMap<>();
		this.creationDateTime = Utils.getCurrentDateTime();
	}

	public Map<String, TicketData> getProducts() {
		return products;
	}

	public void setProducts(Map<String, TicketData> products) {
		this.products = products;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(String creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n\n_____ Ticket Id: ").append(ticketId).append(" _____\n");
		sb.append("Date/Time: ").append(creationDateTime).append("\n");
		products.forEach((key, value) -> sb.append(value.getQuantity()).append(" x ").append(key).append(" (id:").append(value.getProductId()).append(")\n"));
		sb.append(totalAmount).append(" eur.\n");
		
		return sb.toString();
		
	}

}
