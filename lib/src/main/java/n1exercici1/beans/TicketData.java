package n1exercici1.beans;

import java.io.Serializable;

public class TicketData implements Serializable{

private static final long serialVersionUID = 1L;
	
	private int quantity;
	private int productId;
	
	public TicketData() {
		super();
	}
	
	public TicketData(int quantity, int productId) {
		super();
		this.quantity = quantity;
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "TicketData [quantity=" + quantity 
							+ ", productId=" + productId + "]";
	}

}
