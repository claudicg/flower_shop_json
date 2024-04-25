package n1exercici1.handlers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import n1exercici1.beans.Decoration;
import n1exercici1.beans.Flower;
import n1exercici1.beans.Product;
import n1exercici1.beans.Tree;
import n1exercici1.factories.DecorationFactory;
import n1exercici1.factories.FlowerFactory;
import n1exercici1.factories.TreeFactory;
import n1exercici1.singletons.FlowerShopSingleton;
import n1exercici1.singletons.StockSingleton;
import n1exercici1.utis.Constants;
import n1exercici1.utis.Validations;


public class StockHandler {
	
	private static Logger logger = LoggerFactory.getLogger(StockHandler.class);
	
	public static void createTree(String name, double sellPrice, double costPrice, int stock, String height) {
		
		TreeFactory factory = new TreeFactory();
		Tree tree = (Tree) factory.createSpecificProduct(name, sellPrice, costPrice, stock, height);
		
		StockSingleton.getStockSingleton().getStock().add(tree);
		
		recalculateTotalStockValueOnAdd(tree.getStock(), tree.getCostPrice());
		
		logger.info("StockHandler :: createTree :: New tree created.");
		
	}
	
	public static void createFlower(String name, double sellPrice, double costPrice, int stock, String colour) {
		
		FlowerFactory factory = new FlowerFactory();
		Flower flower = (Flower) factory.createSpecificProduct(name, sellPrice, costPrice, stock, colour);
		
		StockSingleton.getStockSingleton().getStock().add(flower);
		
		recalculateTotalStockValueOnAdd(flower.getStock(), flower.getCostPrice());
		
		logger.info("StockHandler :: createFlower :: New flower created.");
		
	}
	
	public static void createDecoration(String name, double sellPrice, double costPrice, int stock, String material) {
		
		DecorationFactory factory = new DecorationFactory();
		Decoration decoration = (Decoration) factory.createSpecificProduct(name, sellPrice, costPrice, stock, material);
		
		StockSingleton.getStockSingleton().getStock().add(decoration);
		
		recalculateTotalStockValueOnAdd(decoration.getStock(), decoration.getCostPrice());
		
		logger.info("StockHandler :: createDecoration :: New decoration created.");
		
	}
	
	public static void showCatalogue() {
		
		List<Tree> trees = new ArrayList<>();
		List<Flower> flowers = new ArrayList<>();
		List<Decoration> decorations = new ArrayList<>();
		
		for(Product product : StockSingleton.getStockSingleton().getStock()) {
			if(product instanceof Tree) {
				trees.add((Tree) product);
			} else if(product instanceof Flower) {
				flowers.add((Flower) product);
			} else if(product instanceof Decoration) {
				decorations.add((Decoration) product);
			}
		}
		
		AppHandler.printText(Constants.Headings.TREES);
		trees.forEach((Tree tree) -> {AppHandler.printText(tree.toCatalogue());});
		
		AppHandler.printText(Constants.Headings.FLOWERS);
		flowers.forEach((Flower flower) -> {AppHandler.printText(flower.toCatalogue());});
		
		AppHandler.printText(Constants.Headings.DECORATIONS);
		decorations.forEach((Decoration decoration) -> {AppHandler.printText(decoration.toCatalogue());});
		
	}
	
	public static void showStock() {
		
		List<Tree> trees = new ArrayList<>();
		List<Flower> flowers = new ArrayList<>();
		List<Decoration> decorations = new ArrayList<>();
		
		for(Product product : StockSingleton.getStockSingleton().getStock()) {
			if(product instanceof Tree) {
				trees.add((Tree) product);
			} else if(product instanceof Flower) {
				flowers.add((Flower) product);
			} else if(product instanceof Decoration) {
				decorations.add((Decoration) product);
			}
		}
		
		AppHandler.printText(Constants.Headings.TREES);
		trees.forEach((Tree tree) -> {AppHandler.printText(tree.toStock());});
		
		AppHandler.printText(Constants.Headings.FLOWERS);
		flowers.forEach((Flower flower) -> {AppHandler.printText(flower.toStock());});
		
		AppHandler.printText(Constants.Headings.DECORATIONS);
		decorations.forEach((Decoration decoration) -> {AppHandler.printText(decoration.toStock());});
		
	}
	
	public static String getTotalStockValue() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(Constants.Menus.STOCK_VALUE);
		sb.append(FlowerShopSingleton.getFlowerShopSingleton().getFlowerShop().getTotalStockValue());
		sb.append(" eur.\n");
		
		return sb.toString();
		
	}
	
	public static void runAddProductsToStock() {
		
		String productName = "";
		do {
			
			AppHandler.printText(TextMenuHandler.getEnterValidProductName());
			productName = AppHandler.readConsoleInput().trim();
			
		} while(!Validations.isValidProductName(productName));
		
		Product product = findProductByName(productName);
		if(product != null) {
			
			String stockToBeAdded = "";
			do {
				
				AppHandler.printText(TextMenuHandler.getEnterValidStock());
				stockToBeAdded = AppHandler.readConsoleInput().trim();
				
				product.setStock(Integer.parseInt(stockToBeAdded) + product.getStock());
				recalculateTotalStockValueOnAdd(Integer.parseInt(stockToBeAdded), product.getCostPrice());
				AppHandler.printText(Constants.Menus.STOCK_UPDATE);
				
			} while(!Validations.isNaturalNumber(stockToBeAdded));
			
		}else {
			AppHandler.printText(Constants.Menus.PRODUCT_NOT_FOUND);
		}	
	}
	
	public static Product findProductByName(String name) {
		
		Product product = null;
		
		for(Product prod : StockSingleton.getStockSingleton().getStock()) {
			if(prod.getName().equalsIgnoreCase(name)) {
				product = prod;
				break;
			}
		}

		return product;
		
	}
	
	public static Product findProductByProductId(int productId) {
		
		Product product = null;
		
		for(Product prod : StockSingleton.getStockSingleton().getStock()) {
			if(prod.getProductId() == productId) {
				product = prod;
				break;
			}
		}
		
		return product;
		
	}
	
	public static boolean removeProductByProductId(int productId) {
		
		boolean deleted = false;
		
		for(Product prod : StockSingleton.getStockSingleton().getStock()) {
			if(prod.getProductId() == productId) {
				recalculateTotalStockValueOnDelete(prod.getStock(), prod.getCostPrice());
				StockSingleton.getStockSingleton().getStock().remove(prod);
				deleted = true;
				break;
			}
		}
		
		return deleted;
		
	}
	
	public static boolean thereIsEnoughStock(Product product, int quantity) {
		return (product.getStock() - quantity) >= 0;
	}
	
	public static void deductStock(Product product, int quantity) {
		
		product.setStock(product.getStock() - quantity);
		recalculateTotalStockValueOnDelete(quantity, product.getCostPrice());

	}
	
	public static void putBackInStock(Product product, int quantity) {
		
		product.setStock(product.getStock() + quantity);
		recalculateTotalStockValueOnAdd(quantity, product.getCostPrice());

	}
	
	private static void recalculateTotalStockValueOnAdd(int quantity, double unitPrice) {
		
		double newTotal = FlowerShopSingleton.getFlowerShopSingleton().getFlowerShop().getTotalStockValue() + (quantity * unitPrice);
		FlowerShopSingleton.getFlowerShopSingleton().getFlowerShop().setTotalStockValue(newTotal);
		
	}
	
	private static void recalculateTotalStockValueOnDelete(int quantity, double unitPrice) {
		
		double newTotal = FlowerShopSingleton.getFlowerShopSingleton().getFlowerShop().getTotalStockValue() - (quantity * unitPrice);
		FlowerShopSingleton.getFlowerShopSingleton().getFlowerShop().setTotalStockValue(newTotal);
		
	}
	
	public static void runViewCatalogue() {
		
		logger.info("StockHandler :: runViewCatalogue :: About to display all the products.");	
		StockHandler.showCatalogue();
		
	}
	
	public static void runViewStockValue() {
		
		logger.info("StockHandler :: runViewStockValue :: About to display the total stock value.");
		AppHandler.printText(StockHandler.getTotalStockValue());
		
	}
	

	public static void runViewStock() {
		
		logger.info("StockHandler :: runViewStock :: About to display the total stock of the shop.");	
		StockHandler.showStock();
		
	}


}
