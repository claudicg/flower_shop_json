package n1exercici1.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import n1exercici1.utis.Constants;
import n1exercici1.utis.Validations;



public class ProductHandler {

private static Logger logger = LoggerFactory.getLogger(ProductHandler.class);
	
	public static void runAddProduct() {
		
		logger.info("ProductHandler :: runAddProduct :: About to add a new product.");
		
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
				//runCreateTree();
				break;
			case "2":
				//runCreateFlower();
				break;
			case "3":
				//runCreateDecoration();
				break;
			case "0":
				//runExitProductOption();
				break;
			default:
				break;
		}
		
	}
		
}
