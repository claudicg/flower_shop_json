package n1exercici1.singletons;

import n1exercici1.beans.FlowerShop;
import n1exercici1.io.FileManager;
import n1exercici1.io.FlowerShopFileReader;
import n1exercici1.io.FlowerShopFileWriter;
import n1exercici1.utis.Constants;

public class FlowerShopSingleton {

private static FlowerShopSingleton flowerShopSingleton;
	
	private FlowerShop flowerShop;
	
	private FlowerShopSingleton() {
		super();
	}
	
	public static FlowerShopSingleton getFlowerShopSingleton() {
		if(flowerShopSingleton == null) {
			flowerShopSingleton = new FlowerShopSingleton();
		}
		return flowerShopSingleton;
	}

	public FlowerShop getFlowerShop() {
		return flowerShop;
	}

	public void setFlowerShop(FlowerShop flowerShop) {
		this.flowerShop = flowerShop;
	}
	
	public void loadFlowerShop() {
		FlowerShopFileReader.readFlowerShopFile(Constants.Files.FLOWER_SHOP);		
	}
	
	public void handleFlowerShopPersistance() {
		FileManager.deleteFile(Constants.Files.PATH_PERSISTENCE, Constants.Files.FLOWER_SHOP, true);
		FlowerShopFileWriter.writeToJsonFile(flowerShop, Constants.Files.FLOWER_SHOP, true, true);
	}

}
