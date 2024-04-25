package n1exercici1.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import n1exercici1.beans.Product;
import n1exercici1.beans.Ticket;
import n1exercici1.beans.TicketData;
import n1exercici1.singletons.SalesSingleton;
import n1exercici1.utis.Validations;


public class CreateTicketHandler {

	private static Logger logger = LoggerFactory.getLogger(CreateTicketHandler.class);
	
	public static void runCreateNewTicket() {
		
		logger.info("CreateNewTicketMenuHandler :: runCreateNewTicket :: About to create a new ticket.");
		
		Ticket newTicket = new Ticket();
		newTicket.setTicketId(SalesSingleton.getSalesSingleton().getNextTicketId());
		AppHandler.printText(newTicket.toString());
		
		String ticketMenuOption = "";
		do {
			
			AppHandler.printText(TextMenuHandler.getTicketMenu());
			
			do {
				
				AppHandler.printText(TextMenuHandler.getEnterValidOption());
				ticketMenuOption = AppHandler.readConsoleInput().trim();
				
			} while(!Validations.isValidTicketOption(ticketMenuOption));
			
			processTicketMenuOption(ticketMenuOption, newTicket);
			
			if(ticketMenuOption.equalsIgnoreCase("0")) {
				
				SalesSingleton.getSalesSingleton().getSales().add(newTicket);
				TicketHandler.recalculateTotalEarnings(newTicket.getTotalAmount());
				
			}
			
		} while(!ticketMenuOption.equalsIgnoreCase("0"));

	}
	
	private static boolean processTicketMenuOption(String ticketMenuOption, Ticket newTicket) {
		
		boolean ticketOk = false;
		
		switch(ticketMenuOption) {
			case "1":
				runAddProductToMenuOption(newTicket);
				break;
			case "2":
				runDeleteProductFromMenuOption(newTicket);
				break;
			case "0":
				runExitTicketOption(newTicket);
				break;
			default:
				break;
		}
		
		return ticketOk;
		
	}
	
	private static void runAddProductToMenuOption(Ticket newTicket) {
		
		//product name
		String productName = "";
		do {
			
			AppHandler.printText(TextMenuHandler.getEnterValidProductName());
			productName = AppHandler.readConsoleInput().trim();
			
		} while(!Validations.isValidProductName(productName));
		
		//checks if product exists in catalogue
		Product product = StockHandler.findProductByName(productName);
		
		//product exists in catalogue
		if(product != null) {
			
			//quantity
			String quantity = "";
			do {
				
				AppHandler.printText(TextMenuHandler.getEnterValidQuantity());
				quantity = AppHandler.readConsoleInput().trim();
				
			} while(!Validations.isNaturalNumber(quantity));
			
			//checks if there is sufficient stock
			boolean sufficientStock = StockHandler.thereIsEnoughStock(product, Integer.parseInt(quantity));
			
			if(sufficientStock) {
				
				//handle stock + sales
				StockHandler.deductStock(product, Integer.parseInt(quantity));
				recalculateTicketTotalAmountOnProductAdd(newTicket, Integer.parseInt(quantity), product.getSellPrice());
				addProductToTicket(newTicket, product.getName(), Integer.parseInt(quantity), product.getProductId());
				
				AppHandler.printText(TextMenuHandler.getProductAddedMessage());
				
				AppHandler.printText(newTicket.toString());
				
			} else {
				
				AppHandler.printText(TextMenuHandler.getInsufficientStockMessage());
				
			}

		} else {
			
			AppHandler.printText(TextMenuHandler.getProductNotFoundMessage() + ", name: " + productName + "\n");
			
		}
		
	}
	
	private static void runDeleteProductFromMenuOption(Ticket newTicket) {
		
		boolean hasProducts = checkTicketHasProducts(newTicket);
		
		if(hasProducts) {
		
			//product id
			String productId = "";
			do {
				
				AppHandler.printText(TextMenuHandler.getEnterValidProductId());
				productId = AppHandler.readConsoleInput().trim();
				
			} while(!Validations.isNaturalNumber(productId));
			
			//checks if product exists in catalogue
			Product product = StockHandler.findProductByProductId(Integer.parseInt(productId));
			
			//product exists in catalogue
			if(product != null) {
				
				int quantity = findProductQuantityInTicket(newTicket, product.getName());
				
				//handle stock + sales
				StockHandler.putBackInStock(product, quantity);
				recalculateTicketTotalAmountOnProductDelete(newTicket, quantity, product.getSellPrice());
				removeProductFromTicket(newTicket, product.getName());
				
				AppHandler.printText(TextMenuHandler.getDeletedMessage());
				
				AppHandler.printText(newTicket.toString());
				
			} else {
				
				AppHandler.printText(TextMenuHandler.getProductNotFoundMessage() + ", id: " + productId + "\n");
				
			}
			
		} else {

			AppHandler.printText(TextMenuHandler.getTicketHasNoProductsMessage());
			
		}
	
	}
	
	public static boolean checkTicketHasProducts(Ticket newTicket) {		
		return !newTicket.getProducts().isEmpty();		
	}
	
	public static int findProductQuantityInTicket(Ticket ticket, String productName) {
		TicketData data = ticket.getProducts().get(productName);
		if(data != null) {
			return data.getQuantity();
		} else {
			return 0;
		}
	}

	public static void addProductToTicket(Ticket ticket, String productName, int quantity, int productId) {
	TicketData data = new TicketData(quantity, productId);
	ticket.getProducts().put(productName, data);
	}

	public static void removeProductFromTicket(Ticket ticket, String productName) {
	ticket.getProducts().remove(productName);
	}

	public static void recalculateTicketTotalAmountOnProductAdd(Ticket ticket, int quantity, double sellPrice) {
	double productTotal = quantity * sellPrice;
	ticket.setTotalAmount(ticket.getTotalAmount() + productTotal);
	}

	public static void recalculateTicketTotalAmountOnProductDelete(Ticket ticket, int quantity, double sellPrice) {
	double productTotal = quantity * sellPrice;
	ticket.setTotalAmount(ticket.getTotalAmount() - productTotal);
	}
	
	private static void runExitTicketOption(Ticket newTicket) {
		
		boolean hasProducts = checkTicketHasProducts(newTicket);
		
		if(hasProducts) {
			
			AppHandler.printText(newTicket.toString());
			AppHandler.printText(TextMenuHandler.getSuccessfulPurchaseMessage());
			
		} else {
			
			newTicket = null;
			AppHandler.printText(TextMenuHandler.getNotSuccessfulPurchaseMessage());	
		}	
	}
}
