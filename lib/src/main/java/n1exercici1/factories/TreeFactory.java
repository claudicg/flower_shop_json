package n1exercici1.factories;

import n1exercici1.beans.Tree;
import n1exercici1.interfaces.ISpecificProduct;

public class TreeFactory extends ProductAbstractFactory{

	@Override
	public ISpecificProduct createSpecificProduct(String name, double sellPrice, double costPrice, int stock, String other) {
		return new Tree(name, sellPrice, costPrice, stock, Integer.parseInt(other));
	}
}
