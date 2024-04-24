package n1exercici1.factories;

import n1exercici1.beans.Decoration;
import n1exercici1.interfaces.ISpecificProduct;

public class DecorationFactory extends ProductAbstractFactory{

	@Override
	public ISpecificProduct createSpecificProduct(String name, double sellPrice, double costPrice, int stock, String other) {
		return new Decoration(name, sellPrice, costPrice, stock, other);
	}
}
