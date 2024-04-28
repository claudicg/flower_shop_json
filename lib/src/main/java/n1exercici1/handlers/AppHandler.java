package n1exercici1.handlers;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import n1exercici1.beans.FlowerShop;
import n1exercici1.io.FileManager;
import n1exercici1.io.FlowerShopFileReader;
import n1exercici1.singletons.FlowerShopSingleton;
import n1exercici1.singletons.SalesSingleton;
import n1exercici1.singletons.StockSingleton;
import n1exercici1.utis.Constants;
import n1exercici1.utis.Validations;


public class AppHandler {
	
	private static Logger logger = LoggerFactory.getLogger(AppHandler.class);
	
	private static Scanner scanner;
	private static List<String> colours;
	
	
	@SuppressWarnings("static-access")
	public AppHandler() {
		super();
		scanner = new Scanner(System.in);
		this.colours = FlowerShopFileReader.readColours(Constants.Files.COLOURS);
	}
	
	public static String readConsoleInput() {
		return scanner.nextLine();
	}
	
	public static void closeConsoleInput() {
		scanner.close();
	}
	
	public static List<String> getColours() {
		return colours;
	}
	
	public static void printText(String text) {
		System.out.println(text);
	}
	
	public void runFlowerShop() {
		
		logger.info("AppHandler :: runFlowerShop :: __________ Flower Shop App running...");
		
		//checks if there is a flower shop already saved
		//if false -> first time using the app, must create a new flower shop
		if(!loadFlowerShopSaves()) {
			createFlowerShop();
		}

		runMainMenu();
		
	}
	
	private boolean loadFlowerShopSaves() {
		
		logger.info("AppHandler :: loadFlowerShopSaves :: Loading saves...");
		
		boolean flowerShopLoaded = false;
		
		FlowerShopSingleton.getFlowerShopSingleton().loadFlowerShop();
		
		if(FlowerShopSingleton.getFlowerShopSingleton().getFlowerShop() != null) {
			
			flowerShopLoaded = true;
			
			FlowerShopFileReader.readIds(Constants.Files.IDS);
			SalesSingleton.getSalesSingleton().loadSales();
			StockSingleton.getStockSingleton().loadStock();
			
		} else {
			
			//if we reach this point, it means it is the first time using the app or there is a problem with the consistency of the files
			//we delete all files to start over from scratch
			clearAllFiles();
			
		}
		
		return flowerShopLoaded;
		
	}
	
	private void clearAllFiles() {
		//File reset.
		FileManager.deleteFile(Constants.Files.PATH_CONTROL, Constants.Files.IDS, true);
		FileManager.deleteFile(Constants.Files.PATH_PERSISTENCE, Constants.Files.FLOWER_SHOP, true);
		FileManager.deleteFile(Constants.Files.PATH_PERSISTENCE, Constants.Files.SALES, true);
		FileManager.deleteFile(Constants.Files.PATH_PERSISTENCE, Constants.Files.STOCK, true);
		
	}
	
	private void createFlowerShop() {
		
		logger.info("AppHandler :: createFlowerShop :: Creating a new flower shop...");

		String name = "";
		
		printText(TextMenuHandler.getCreateFlowerShopMenu());
		
		do {
			
			printText(TextMenuHandler.getEnterValidNameMessage());
			name = readConsoleInput().trim();
			
		} while(!Validations.isValidName(name));
		
		FlowerShop flowerShop = new FlowerShop(name);
		FlowerShopSingleton.getFlowerShopSingleton().setFlowerShop(flowerShop);
		
		printText(TextMenuHandler.getFlowerShopCreatedMessage());	
		
	}


	public static void runMainMenu() {
		
		String menuOption = "";
		
		do {
			
			printText(TextMenuHandler.getMainMenu());
			
			do {
				
				printText(TextMenuHandler.getEnterValidOption());
				menuOption = readConsoleInput().trim();
				
			} while(!Validations.isValidOption(menuOption));
			
			processMainMenuOption(menuOption);
			
		} while(!menuOption.equalsIgnoreCase("0"));

		closeConsoleInput();
		
	}
	
	private static void processMainMenuOption(String menuOption) {
		
		switch(menuOption) {
			case "1":
				AddProductHandler.runAddProduct();
				break;
			case "2":
				DeleteProductHandler.runDeleteProduct();
				break;
			case "3":
				StockHandler.runViewCatalogue();
				break;
			case "4":
				StockHandler.runAddProductsToStock();
				break;
			case "5":
				StockHandler.runViewStock();
				break;
			case "6":
				StockHandler.runViewStockValue();
				break;
			case "7":
				CreateTicketHandler.runCreateNewTicket();
				break;
			case "8":
				TicketHandler.runViewSales();
				break;
			case "9":
				TicketHandler.runViewEarnings();
				break;
			case "0":
				runExitFlowerShop();
				break;
			default:
				break;
		}
		
	}
	
	private static void runExitFlowerShop() {
		
		logger.info("AppHandler :: runExitFlowerShop :: Flower Shop App shutting down...");

		FlowerShopSingleton.getFlowerShopSingleton().handleFlowerShopPersistance();
		
		SalesSingleton.getSalesSingleton().handleMaxAssignedTicketIdPersitence();
		SalesSingleton.getSalesSingleton().handleSalesPersistence();
		
		StockSingleton.getStockSingleton().handleMaxAssignedProducIdPersitence();
		StockSingleton.getStockSingleton().handleStockPersistence();
		
		AppHandler.printText(TextMenuHandler.getExitMessage());
		
	}
}
