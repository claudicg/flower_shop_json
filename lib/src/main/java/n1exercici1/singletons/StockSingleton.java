package n1exercici1.singletons;

import java.util.ArrayList;
import java.util.List;

import n1exercici1.beans.Product;
import n1exercici1.io.FileManager;
import n1exercici1.io.FlowerShopFileReader;
import n1exercici1.io.FlowerShopFileWriter;
import n1exercici1.utis.Constants;

public class StockSingleton {

	private static StockSingleton stockSingleton;
	
	private int maxAssignedProductId;
	private List<Product> stock;
	
	private StockSingleton() {
		super();
		this.stock = new ArrayList<>();
	}
	
	public static StockSingleton getStockSingleton() {
		if(stockSingleton == null) {
			stockSingleton = new StockSingleton();
		}
		return stockSingleton;
	}
	
	public int getNextProductId() {
		this.maxAssignedProductId++;
		return maxAssignedProductId;
	}

	public int getMaxAssignedProductId() {
		return maxAssignedProductId;
	}

	public void setMaxAssignedProductId(int maxAssignedProductId) {
		this.maxAssignedProductId = maxAssignedProductId;
	}

	public List<Product> getStock() {
		return stock;
	}

	public void setStock(List<Product> stock) {
		this.stock = stock;
	}
	
	public void loadStock() {
		FlowerShopFileReader.readStockFile(Constants.Files.STOCK);		
	}
	
	public void handleMaxAssignedProducIdPersitence() {
		
		if(!FileManager.fileExists(Constants.Files.PATH_CONTROL, Constants.Files.IDS)) {
			FileManager.createFile(Constants.Files.PATH_CONTROL, Constants.Files.IDS);
		}
		
		FlowerShopFileWriter.writeIdToFile("product:" + maxAssignedProductId + "\n", Constants.Files.IDS);
		
	}
	
	public void handleStockPersistence() {
		
		FileManager.deleteFile(Constants.Files.PATH_PERSISTENCE, Constants.Files.STOCK, true);
		
		if(stock.isEmpty()) {
			FileManager.createFile(Constants.Files.PATH_PERSISTENCE, Constants.Files.STOCK);
		} else {
			for(int i = 0; i < stock.size(); i++) {
				if(stock.size() == 1) {
					FlowerShopFileWriter.writeToJsonFile(stock.get(i), Constants.Files.STOCK, true, true);
				} else if(i == 0 && stock.size() > 1) {
					FlowerShopFileWriter.writeToJsonFile(stock.get(i), Constants.Files.STOCK, true, false);
				} else if(i == stock.size() - 1 && stock.size() > 1) {
					FlowerShopFileWriter.writeToJsonFile(stock.get(i), Constants.Files.STOCK, false, true);
				} else {
					FlowerShopFileWriter.writeToJsonFile(stock.get(i), Constants.Files.STOCK, false, false);
				}
			}
		}
		
	}

}
