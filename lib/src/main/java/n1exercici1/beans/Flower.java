package n1exercici1.beans;

import n1exercici1.enums.ProductTypeEnum;
import n1exercici1.handlers.AppHandler;
import n1exercici1.interfaces.ISpecificProduct;

public class Flower extends Product implements ISpecificProduct {

private static final long serialVersionUID = 1L;
	
	private String colour;
	
	//important for json deserialization
	public Flower() {
		super();
	}
	
	public Flower(String name, double sellPrice, double costPrice, int stock, String colour) {
		super(name, sellPrice, costPrice, stock);
		this.colour = colour;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public void printProductType() {
		AppHandler.printText(ProductTypeEnum.FLOWER.getType());
	}

	@Override
	public String toString() {
		return super.toString() + "Flower [colour=" + colour + "]]";
	}

	@Override
	public String toCatalogue() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.getProductId()).append(" >>> ").append(super.getName()).append(", ").append(super.getSellPrice()).append(" eur., ").append(colour);
		
		return sb.toString();
		
	}

}
