package n1exercici1.factories;

import n1exercici1.interfaces.ISpecificProduct;

public abstract class ProductAbstractFactory {

	public abstract ISpecificProduct createSpecificProduct(String name, double sellPrice, double costPrice, int stock, String other);
}
