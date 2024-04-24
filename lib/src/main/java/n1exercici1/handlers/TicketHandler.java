package n1exercici1.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import n1exercici1.beans.Ticket;
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
	
}
