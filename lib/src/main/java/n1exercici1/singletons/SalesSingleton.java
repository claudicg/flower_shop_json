package n1exercici1.singletons;

import java.util.ArrayList;
import java.util.List;

import n1exercici1.beans.Ticket;
import n1exercici1.io.FileManager;
import n1exercici1.io.FlowerShopFileReader;
import n1exercici1.io.FlowerShopFileWriter;
import n1exercici1.utis.Constants;



public class SalesSingleton {

	private static SalesSingleton salesSingleton;
	
	private int maxAssignedTicketId;
	private List<Ticket> sales;
	
	private SalesSingleton() {
		super();
		this.sales = new ArrayList<>();
	}
	
	public static SalesSingleton getSalesSingleton() {
		if(salesSingleton == null) {
			salesSingleton = new SalesSingleton();
		}
		return salesSingleton;
	}
	
	public int getNextTicketId() {	
		this.maxAssignedTicketId++;
		return maxAssignedTicketId;
	}

	public int getMaxAssignedTicketId() {
		return maxAssignedTicketId;
	}

	public void setMaxAssignedTicketId(int maxAssignedTicketId) {
		this.maxAssignedTicketId = maxAssignedTicketId;
	}

	public List<Ticket> getSales() {
		return sales;
	}

	public void setSales(List<Ticket> sales) {
		this.sales = sales;
	}
	
	public void loadSales() {
		FlowerShopFileReader.readSalesFile(Constants.Files.SALES);		
	}
	
	public void handleMaxAssignedTicketIdPersitence() {
		
		FileManager.deleteFile(Constants.Files.PATH_CONTROL, Constants.Files.IDS, true);
		
		if(!FileManager.fileExists(Constants.Files.PATH_CONTROL, Constants.Files.IDS)) {
			FileManager.createFile(Constants.Files.PATH_CONTROL, Constants.Files.IDS);
		}
		
		FlowerShopFileWriter.writeIdToFile("ticket:" + maxAssignedTicketId + "\n", Constants.Files.IDS);
		
	}
	
	public void handleSalesPersistence() {
		
		FileManager.deleteFile(Constants.Files.PATH_PERSISTENCE, Constants.Files.SALES, true);
		
		if(sales.isEmpty()) {
			FileManager.createFile(Constants.Files.PATH_PERSISTENCE, Constants.Files.SALES);
		} else {
			for(int i = 0; i < sales.size(); i++) {
				if(sales.size() == 1) {
					FlowerShopFileWriter.writeToJsonFile(sales.get(i), Constants.Files.SALES, true, true);
				} else if(i == 0 && sales.size() > 1) {
					FlowerShopFileWriter.writeToJsonFile(sales.get(i), Constants.Files.SALES, true, false);
				} else if(i == sales.size() - 1 && sales.size() > 1) {
					FlowerShopFileWriter.writeToJsonFile(sales.get(i), Constants.Files.SALES, false, true);
				} else {
					FlowerShopFileWriter.writeToJsonFile(sales.get(i), Constants.Files.SALES, false, false);
				}
			}
		}

	}

}
