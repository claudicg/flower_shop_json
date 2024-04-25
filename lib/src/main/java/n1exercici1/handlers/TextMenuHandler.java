package n1exercici1.handlers;

import java.util.Arrays;
import java.util.List;

import n1exercici1.enums.MaterialsEnum;
import n1exercici1.enums.ProductTypeEnum;
import n1exercici1.utis.Constants;


public class TextMenuHandler {

	public static String getCreateFlowerShopMenu() {
		return Constants.Menus.CREATE_FS_MENU;
	}
	
	public static String getEnterValidNameMessage() {
		return Constants.Menus.VALID_NAME;
	}
	
	public static String getMainMenu() {
		return Constants.Menus.MAIN_MENU;
	}
	
	public static String getFlowerShopCreatedMessage() {
		return Constants.Menus.CREATED_FS;
	}
	
	public static String getExitMessage() {
		return Constants.Menus.EXIT;
	}
	
	public static String getEnterValidOption() {
		return Constants.Menus.VALID_OPTION;
	}
	
	public static String getDateMessage() {
		return Constants.Menus.DATE_MENU;
	}
	
	public static String getEnterValidDate() {
		return Constants.Menus.VALID_DATE;
	}
	
	public static String getProductMenu() {
		
		StringBuilder sb = new StringBuilder();
		
		List<ProductTypeEnum> productTypeEnumValues = Arrays.asList(ProductTypeEnum.values());
		
		int count = 1;
		for(ProductTypeEnum enumValue : productTypeEnumValues) {
			sb.append(count).append(". ").append(enumValue.getType()).append("\n");
			count++;
		}
		
		sb.append("0. Exit\n");
		
		return sb.toString();
		
	}
	
	public static String getExitCurrentMenuMessage() {
		return Constants.Menus.EXIT_CURRENT;
	}
	
	public static String getEnterValidProductName() {
		return Constants.Menus.PRODUCT_NAME;
	}
	
	public static String getEnterSellPrice() {
		return Constants.Menus.SELL_PRICE;
	}
	
	public static String getEnterCostPrice() {
		return Constants.Menus.COST_PRICE;
	}
	
	public static String getEnterValidStock() {
		return Constants.Menus.STOCK;
	}
	
	public static String getEnterValidHeight() {
		return Constants.Menus.HEIGHT;
	}
	
	public static String getEnterValidColour() {
		return Constants.Menus.COLOUR;
	}
	
	public static String getEnterValidMaterial() {
		
		StringBuilder sb = new StringBuilder();
		
		List<MaterialsEnum> materialsEnumValues = Arrays.asList(MaterialsEnum.values());
		
		int count = 1;
		for(MaterialsEnum enumValue : materialsEnumValues) {
			sb.append(count).append(". ").append(enumValue.getName()).append("\n");
			count++;
		}
		
		return sb.toString();
		
	}
	
	public static String getProductAlreadyExists() {
		return Constants.Menus.PRODUCT_EXISTS;
	}
	
	public static String getProductAddedMessage() {
		return Constants.Menus.PRODUCT_ADDED;
	}
	
	public static String getEnterValidProductId() {
		return Constants.Menus.PRODUCT_ID;
	}
	
	public static String getDeletedMessage() {
		return Constants.Menus.DELETED;
	}
	
	public static String getNotDeletedMessage() {
		return Constants.Menus.NOT_DELETED;
	}
	
	public static String getTicketMenu() {
		return Constants.Menus.TICKET_MENU;
	}
	
	public static String getSuccessfulPurchaseMessage() {
		return Constants.Menus.SUCCESSFUL;
	}
	
	public static String getNotSuccessfulPurchaseMessage() {
		return Constants.Menus.NOT_SUCCESSFUL;
	}
	
	public static String getTicketHasNoProductsMessage() {
		return Constants.Menus.NO_PRODUCTS;
	}
	
	public static String getProductNotFoundMessage() {
		return Constants.Menus.PRODUCT_NOT_FOUND;
	}
	
	public static String getEnterValidQuantity() {
		return Constants.Menus.QUANTITY;
	}
	
	public static String getInsufficientStockMessage() {
		return Constants.Menus.INSUFFICIENT_STOCK;
	}
}
