package n1exercici1.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import n1exercici1.beans.FlowerShop;
import n1exercici1.beans.Product;
import n1exercici1.beans.Ticket;
import n1exercici1.singletons.FlowerShopSingleton;
import n1exercici1.singletons.SalesSingleton;
import n1exercici1.singletons.StockSingleton;
import n1exercici1.utis.Constants;
import n1exercici1.utis.Utils;
import n1exercici1.utis.Validations;



public class FlowerShopFileReader {

	private static Logger logger = LoggerFactory.getLogger(FlowerShopFileReader.class);

	public static FlowerShop readFlowerShopFile(String fileName) {
		
		logger.info("FlowerShopFileReader :: readFlowerShopFile :: " + Constants.Messages.READING_FROM + fileName);
		
		FlowerShop flowerShop = null;
		
		if(FileManager.fileExists(Constants.Files.PATH_PERSISTENCE, Constants.Files.FLOWER_SHOP)) {
			
			BufferedReader br = null;	
			
			try {
				
				br = new BufferedReader(new FileReader(Constants.Files.PATH_PERSISTENCE + fileName));
				
				String line = br.readLine().trim();
				if(line != null) {
					flowerShop = Serialization.mapJsonToFlowerShop(Utils.replaceUnwantedJsonFileCharacters(line));
				}
				
				if(flowerShop != null) {
					FlowerShopSingleton.getFlowerShopSingleton().setFlowerShop(flowerShop);
				}
				
			} catch (FileNotFoundException e) {
				logger.error("FlowerShopFileReader :: readFlowerShopFile :: " + Constants.Errors.FNF_EXCEPTION, e);
			} catch (IOException e) {	
				logger.error("FlowerShopFileReader :: readFlowerShopFile :: " + Constants.Errors.IO_EXCEPTION, e);
			} finally {
				
				try {
					br.close();
				} catch (IOException e) {
					logger.error("FlowerShopFileReader :: readFlowerShopFile :: br.close() :: " + Constants.Errors.IO_EXCEPTION, e);
				}
				
			}
		}
		
		return flowerShop;

	}
	
	public static void readSalesFile(String fileName) {
		
		logger.info("FlowerShopFileReader :: readSalesFile :: " + Constants.Messages.READING_FROM + fileName);
		
		if(FileManager.fileExists(Constants.Files.PATH_PERSISTENCE, Constants.Files.SALES)) {
			
			BufferedReader br = null;	
			
			try {
				
				br = new BufferedReader(new FileReader(Constants.Files.PATH_PERSISTENCE + fileName));
				
				String line = br.readLine();
				while(line != null) {
					if(!line.trim().equals("")) {
						Ticket ticket = Serialization.mapJsonToTicket(Utils.replaceUnwantedJsonFileCharacters(line));
						if(ticket != null) {
							SalesSingleton.getSalesSingleton().getSales().add(ticket);
						}
					}
					line = br.readLine();
				}
				
			} catch (FileNotFoundException e) {
				logger.error("FlowerShopFileReader :: readSalesFile :: " + Constants.Errors.FNF_EXCEPTION, e);
			} catch (IOException e) {	
				logger.error("FlowerShopFileReader :: readSalesFile :: " + Constants.Errors.IO_EXCEPTION, e);
			} finally {
				
				try {
					br.close();
				} catch (IOException e) {
					logger.error("FlowerShopFileReader :: readSalesFile :: br.close() :: " + Constants.Errors.IO_EXCEPTION, e);
				}
				
			}
		}

	}
	
	public static void readStockFile(String fileName) {
		
		logger.info("FlowerShopFileReader :: readStockFile :: " + Constants.Messages.READING_FROM + fileName);
		
		if(FileManager.fileExists(Constants.Files.PATH_PERSISTENCE, Constants.Files.STOCK)) {
			
			BufferedReader br = null;	
			
			try {
				
				br = new BufferedReader(new FileReader(Constants.Files.PATH_PERSISTENCE + fileName));
				
				String line = br.readLine();
				while(line != null) {
					if(!line.trim().equals("")) {
						Product product = Serialization.mapJsonToProduct(Utils.replaceUnwantedJsonFileCharacters(line));
						if(product != null) {
							StockSingleton.getStockSingleton().getStock().add(product);
						}
					}
					line = br.readLine();
				}
				
			} catch (FileNotFoundException e) {
				logger.error("FlowerShopFileReader :: readStockFile :: " + Constants.Errors.FNF_EXCEPTION, e);
			} catch (IOException e) {	
				logger.error("FlowerShopFileReader :: readStockFile :: " + Constants.Errors.IO_EXCEPTION, e);
			} finally {
				
				try {
					br.close();
				} catch (IOException e) {
					logger.error("FlowerShopFileReader :: readStockFile :: br.close() :: " + Constants.Errors.IO_EXCEPTION, e);
				}
				
			}
		}

	}
	
	public static void readIds(String fileName) {
		
		logger.info("FlowerShopFileReader :: readIds :: " + Constants.Messages.READING_FROM + fileName);
		
		if(FileManager.fileExists(Constants.Files.PATH_CONTROL, Constants.Files.IDS)) {
			
			BufferedReader br = null;
			
			try {
				
				br = new BufferedReader(new FileReader(Constants.Files.PATH_CONTROL + fileName));
				
				String line = br.readLine();
				while(line != null) {
					if(!line.trim().equals("")) {
						String idsArray[] = line.trim().split(":");
						if(Validations.isZeroOrAbove(idsArray[1])) {
							if(idsArray[0].equalsIgnoreCase("ticket")) {
								SalesSingleton.getSalesSingleton().setMaxAssignedTicketId(Integer.parseInt(idsArray[1]));
								
							} else if(idsArray[0].equalsIgnoreCase("product")) {
								StockSingleton.getStockSingleton().setMaxAssignedProductId(Integer.parseInt(idsArray[1]));
							}
						}
					}
					line = br.readLine();
				}
				
			} catch (FileNotFoundException e) {
				logger.error("FlowerShopFileReader :: readIds :: " + Constants.Errors.FNF_EXCEPTION, e);
			} catch (IOException e) {
				logger.error("FlowerShopFileReader :: readIds :: " + Constants.Errors.IO_EXCEPTION, e);
			} finally {
				
				try {
					br.close();
				} catch (IOException e) {
					logger.error("FlowerShopFileReader :: readIds :: br.close() :: " + Constants.Errors.IO_EXCEPTION, e);
				}
				
			}
			
		}
		
	}
	
	public static List<String> readColours(String fileName) {
		
		logger.info("FlowerShopFileReader :: readColours :: " + Constants.Messages.READING_FROM + fileName);
		
		List<String> colours = new ArrayList<>();
		
		if(FileManager.fileExists(Constants.Files.PATH_SIMPLE, Constants.Files.COLOURS)) {
			
			BufferedReader br = null;
			
			try {
				
				br = new BufferedReader(new FileReader(Constants.Files.PATH_SIMPLE + fileName));
				
				String line = br.readLine();
				while(line != null) {
					if(!line.trim().equals("")) {
						String colour = line.trim().toUpperCase();
						colours.add(colour);
					}
					line = br.readLine();
				}
				
			} catch (FileNotFoundException e) {
				logger.error("FlowerShopFileReader :: readColours :: " + Constants.Errors.FNF_EXCEPTION, e);
			} catch (IOException e) {
				logger.error("FlowerShopFileReader :: readColours :: " + Constants.Errors.IO_EXCEPTION, e);
			} finally {
				
				try {
					br.close();
				} catch (IOException e) {
					logger.error("FlowerShopFileReader :: readColours :: br.close() :: " + Constants.Errors.IO_EXCEPTION, e);
				}
				
			}
			
		}

		return colours;
		
	}

}
