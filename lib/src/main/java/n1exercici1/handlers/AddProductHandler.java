package n1exercici1.handlers;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import n1exercici1.beans.Product;
import n1exercici1.utis.Constants;
import n1exercici1.utis.Utils;
import n1exercici1.utis.Validations;



public class AddProductHandler {

private static Logger logger = LoggerFactory.getLogger(AddProductHandler.class);
	
	public static void runAddProduct() {
		
		logger.info("AddProductHandler :: runAddProduct :: About to add a new product.");
		
		AppHandler.printText(Constants.Headings.ADD_PRODUCT);
		
		String productOption = "";

		do {
			
			AppHandler.printText(TextMenuHandler.getProductMenu());
			
			do {
				
				AppHandler.printText(TextMenuHandler.getEnterValidOption());
				productOption = AppHandler.readConsoleInput().trim();
				
			} while(!Validations.isValidProductOption(productOption));
			
			processAddProductOption(productOption);
			
		} while(!productOption.equalsIgnoreCase("0"));
		
	}
	
	private static void processAddProductOption(String productOption) {
		
		switch(productOption) {
			case "1":
				runCreateTree();
				break;
			case "2":
				runCreateFlower();
				break;
			case "3":
				runCreateDecoration();
				break;
			case "0":
				runExitProductOption();
				break;
			default:
				break;
		}
		
	}
	
	private static void runCreateTree() {
		
		//name
		String treeName = "";
		do {
			
			AppHandler.printText(TextMenuHandler.getEnterValidProductName());
			treeName = AppHandler.readConsoleInput().trim();
			
		} while(!Validations.isValidProductName(treeName));
		
		Product product = StockHandler.findProductByName(treeName);

		if(product == null) {
			
			//sell price
			String sellPrice = "";
			do {
				
				AppHandler.printText(TextMenuHandler.getEnterSellPrice());
				sellPrice = AppHandler.readConsoleInput().trim();
				
			} while(!Validations.isValidPrice(sellPrice));
			
			//cost price
			String costPrice = "";
			do {
				
				AppHandler.printText(TextMenuHandler.getEnterCostPrice());
				costPrice = AppHandler.readConsoleInput().trim();
				
			} while(!Validations.isValidPrice(costPrice));
			
			//stock
			String stock = "";
			do {
				
				AppHandler.printText(TextMenuHandler.getEnterValidStock());
				stock = AppHandler.readConsoleInput().trim();
				
			} while(!Validations.isNaturalNumber(stock));
			
			//height
			String height = "";
			do {
				
				AppHandler.printText(TextMenuHandler.getEnterValidHeight());
				height = AppHandler.readConsoleInput().trim();
				
			} while(!Validations.isNaturalNumber(height));
			
			//create product
			StockHandler.createTree(treeName, Double.parseDouble(sellPrice), Double.parseDouble(costPrice), Integer.parseInt(stock), height);
			
			AppHandler.printText(TextMenuHandler.getProductAddedMessage());
			
		} else {
			
			AppHandler.printText(TextMenuHandler.getProductAlreadyExists());
			
		}
		
	}
	
	private static void runCreateFlower() {
		
		//name
		String flowerName = "";
		do {
			
			AppHandler.printText(TextMenuHandler.getEnterValidProductName());
			flowerName = AppHandler.readConsoleInput().trim();
			
		} while(!Validations.isValidProductName(flowerName));
		
		Product product = StockHandler.findProductByName(flowerName);

		if(product == null) {
			
			//sell price
			String sellPrice = "";
			do {
				
				AppHandler.printText(TextMenuHandler.getEnterSellPrice());
				sellPrice = AppHandler.readConsoleInput().trim();
				
			} while(!Validations.isValidPrice(sellPrice));
			
			//cost price
			String costPrice = "";
			do {
				
				AppHandler.printText(TextMenuHandler.getEnterCostPrice());
				costPrice = AppHandler.readConsoleInput().trim();
				
			} while(!Validations.isValidPrice(costPrice));
			
			//stock
			String stock = "";
			do {
				
				AppHandler.printText(TextMenuHandler.getEnterValidStock());
				stock = AppHandler.readConsoleInput().trim();
				
			} while(!Validations.isNaturalNumber(stock));
			
			//colour
			String colour = "";
			do {
				
				AppHandler.printText(TextMenuHandler.getEnterValidColour());
				colour = AppHandler.readConsoleInput().trim();
				
			} while(!Validations.isValidColour(colour, AppHandler.getColours()));
			
			//create product
			StockHandler.createFlower(flowerName, Double.parseDouble(sellPrice), Double.parseDouble(costPrice), Integer.parseInt(stock), colour);
			
			AppHandler.printText(TextMenuHandler.getProductAddedMessage());
			
		} else {
			
			AppHandler.printText(TextMenuHandler.getProductAlreadyExists());
			
		}
		
	}
	
	private static void runCreateDecoration() {
		
		//name
		String decorationName = "";
		do {
			
			AppHandler.printText(TextMenuHandler.getEnterValidProductName());
			decorationName = AppHandler.readConsoleInput().trim();
			
		} while(!Validations.isValidProductName(decorationName));
		
		Product product = StockHandler.findProductByName(decorationName);

		if(product == null) {
			
			//sell price
			String sellPrice = "";
			do {
				
				AppHandler.printText(TextMenuHandler.getEnterSellPrice());
				sellPrice = AppHandler.readConsoleInput().trim();
				
			} while(!Validations.isValidPrice(sellPrice));
			
			//cost price
			String costPrice = "";
			do {
				
				AppHandler.printText(TextMenuHandler.getEnterCostPrice());
				costPrice = AppHandler.readConsoleInput().trim();
				
			} while(!Validations.isValidPrice(costPrice));
			
			//stock
			String stock = "";
			do {
				
				AppHandler.printText(TextMenuHandler.getEnterValidStock());
				stock = AppHandler.readConsoleInput().trim();
				
			} while(!Validations.isNaturalNumber(stock));
			
			//material
			String material = "";
			do {
				
				AppHandler.printText(TextMenuHandler.getEnterValidMaterial());
				material = AppHandler.readConsoleInput().trim();
				
			} while(!Validations.isValidMaterialOption(material));
			
			//create product
			StockHandler.createDecoration(decorationName, Double.parseDouble(sellPrice), Double.parseDouble(costPrice), Integer.parseInt(stock), Utils.getMaterial(material));
			
			AppHandler.printText(TextMenuHandler.getProductAddedMessage());
			
		} else {
			
			AppHandler.printText(TextMenuHandler.getProductAlreadyExists());
			
		}
		
	}
	
	private static void runExitProductOption() {
		
		logger.info("AddProductHandler :: runExitProductOption :: Exiting the add product menu.");
		AppHandler.printText(TextMenuHandler.getExitCurrentMenuMessage());
		
	}
		
}
