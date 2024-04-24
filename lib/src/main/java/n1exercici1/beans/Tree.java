package n1exercici1.beans;


import n1exercici1.enums.ProductTypeEnum;
import n1exercici1.handlers.AppHandler;
import n1exercici1.interfaces.ISpecificProduct;

public class Tree extends Product implements ISpecificProduct{
	
	private static final long serialVersionUID = 1L;
	
	private int height;
	
	//important for json deserialization
	public Tree() {
		super();
	}
	
	public Tree(String name, double sellPrice, double costPrice, int stock, int height) {
		super(name, sellPrice, costPrice, stock);
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public void printProductType() {
		AppHandler.printText(ProductTypeEnum.TREE.getType());
	}

	@Override
	public String toString() {
		return super.toString() + "Tree [height=" + height + "]]";
	}

	@Override
	public String toCatalogue() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.getProductId()).append(" >>> ")
			.append(super.getName()).append(", ")
			.append(super.getSellPrice()).append(" eur./unit, ")
			.append(height).append("cm");
		
		return sb.toString();
		
	}

	@Override
	public String toStock() {

		StringBuilder sb = new StringBuilder();
		
		sb.append(super.getProductId()).append(" >>> ")
			.append(super.getStock()).append(" x ")
			.append(super.getName()).append(", ")
			.append(super.getCostPrice()).append(" eur./unit, ")
			.append(super.getCostPrice() * super.getStock()).append(" eur.");
		
		return sb.toString();
		
	}

}
