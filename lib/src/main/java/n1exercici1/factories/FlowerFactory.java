package n1exercici1.factories;

import n1exercici1.beans.Flower;
import n1exercici1.interfaces.ISpecificProduct;

public class FlowerFactory extends ProductAbstractFactory{

	@Override
	public ISpecificProduct createSpecificProduct(String name, double sellPrice, double costPrice, int stock, String other) {
		return new Flower(name, sellPrice, costPrice, stock, other);
	}
}
