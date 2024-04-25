package n1exercici1.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import n1exercici1.beans.Ticket;
import n1exercici1.singletons.FlowerShopSingleton;
import n1exercici1.singletons.SalesSingleton;
import n1exercici1.utis.Constants;
import n1exercici1.utis.Utils;
import n1exercici1.utis.Validations;


public class TicketHandler {

	
	private static Logger logger = LoggerFactory.getLogger(TicketHandler.class);

	
	public static void runViewSales() {
		
		logger.info("TicketHandler :: runViewSales :: About to display the tickets created since the given date.");
		
		String date = "";
		
		AppHandler.printText(TextMenuHandler.getDateMessage());
		
		do {
			
			AppHandler.printText(TextMenuHandler.getEnterValidDate());
			date = AppHandler.readConsoleInput().trim();
			
		} while(!Validations.isValidDate(Utils.appendTimeToDate(date)));
		
		AppHandler.printText(getSales(Utils.appendTimeToDate(date)));
		
	}
	
	private static String getSales(String sinceDate) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(Constants.Headings.SALES);
		
		for(Ticket ticket : SalesSingleton.getSalesSingleton().getSales()) {
			if(Utils.parseDateFromString(ticket.getCreationDateTime()).after(Utils.parseDateFromString(sinceDate))) {
				sb.append(ticket.toString());
			}
		}
		
		sb.append("\n");
		
		return sb.toString();
		
	}
	
	public static void runViewEarnings() {
		
		logger.info("ViewEarningsHandler :: runViewEarnings :: About to display the total earnings.");		
		AppHandler.printText(getEarnings());
		
	}
	
	private static String getEarnings() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(Constants.Headings.EARNINGS);
		
		for(Ticket ticket : SalesSingleton.getSalesSingleton().getSales()) {
			sb.append("Ticket Id: ").append(ticket.getTicketId()).append(", ").append(ticket.getTotalAmount()).append(" eur.\n");
		}
		
		sb.append("\nTotal: ").append(FlowerShopSingleton.getFlowerShopSingleton().getFlowerShop().getTotalEarnings()).append(" eur.\n");
		
		return sb.toString();
		
	}
	
	public static void recalculateTotalEarnings(double totalTicketAmount) {
		
		double newTotal = FlowerShopSingleton.getFlowerShopSingleton().getFlowerShop().getTotalEarnings() + totalTicketAmount;
		FlowerShopSingleton.getFlowerShopSingleton().getFlowerShop().setTotalEarnings(newTotal);
		
	}	
}
