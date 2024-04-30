package n1exercici1.utis;

public class Constants {

	public class Files {
		public static final String PATH_PERSISTENCE = "src/main/resources/persistence/";
		public static final String PATH_CONTROL = "src/main/resources/control/";
		public static final String PATH_SIMPLE = "src/main/resources/";
		public static final String IDS = "ids.txt";
		public static final String COLOURS = "colours.txt";
		public static final String FLOWER_SHOP = "flower-shop.json";
		public static final String SALES = "sales.json";
		public static final String STOCK = "stock.json";
	}
	
	public class Messages {
		public static final String WRITING_TO = "Writing to file ";
		public static final String READING_FROM = "Reading from file ";
		public static final String DELETING = "Deleting file ";
		public static final String CREATING = "Creating file ";
	}
	
	public class Errors {
		public static final String JSON_SERIALIZATION = "Object to JSON failed, ";
		public static final String IO_EXCEPTION = "I/O Exeception thrown, ";
		public static final String FNF_EXCEPTION = "File Not Found Exeception thrown, ";
		public static final String JSON_DESERIALIZATION = "JSON to object failed, ";
		public static final String PARSE_EXCEPTION = "Parsing failed, ";
	}
	
	public class Menus {
		public static final String CREATE_FS_MENU = "\n\nFirst time using the app?\nLet's create a new flower shop.)";
		public static final String VALID_NAME = "\nPlease, enter a valid name:\n";
		public static final String CREATED_FS = "\n>>> Good job! The shop is now up and running.\n\n";
		public static final String MAIN_MENU = "==== Flower Shop Menu ===="
												+ "\n\n1. Add Product."
												+ "\n2. Delete Product."
												+ "\n3. View Catalogue."
												+ "\n4. Add Products to Stock."
												+ "\n5. View Stock."
												+ "\n6. View Stock Value."
												+ "\n7. Create New Ticket."
												+ "\n8. View Sales."
												+ "\n9. View Earnings."
												+ "\n0. Exit.\n\n";
		public static final String VALID_OPTION = "\nPlease, enter a valid option:\n";
		public static final String DATE_MENU = "\n\nThe date to display sales since is required.\nThe date must be valid and have format yyyy-MM-dd.\n";
		public static final String VALID_DATE = "\nPlease, enter a valid date (yyyy-MM-dd):\n";
		public static final String EXIT_CURRENT = "\n>>> Exiting the current menu.\n\n";
		public static final String EXIT = "\n>>> Heading for the exit.\n\n";
		public static final String PRODUCT_NAME = "\nEnter a valid product name:\n";
		public static final String SELL_PRICE = "\nEnter the unit sell price:\n";
		public static final String COST_PRICE = "\nEnter the unit cost price:\n";
		public static final String STOCK = "\nEnter a valid stock:\n";
		public static final String HEIGHT = "\nEnter a valid height (in centimetres):\n";
		public static final String COLOUR = "\nEnter a valid colour:\n";
		public static final String PRODUCT_EXISTS = "\n>>> The product already exists.\n";
		public static final String STOCK_UPDATE = "\n>>> The stock has been updated.\n";
		public static final String PRODUCT_ADDED = "\n>>> The new product was added.\n\n";
		public static final String STOCK_VALUE = "\n>>> The total stock value of the shop is ";
		public static final String PRODUCT_ID = "\nEnter the product id of the product to be deleted:\n";
		public static final String DELETED = "\n>>> The product was deleted.\n";
		public static final String NOT_DELETED = "\n>>> The product could not be found or deleted.\n";
		public static final String TICKET_MENU = "\n\n1. Add Product."
												+ "\n2. Delete Product."
												+ "\n0. Exit.\n\n";
		public static final String SUCCESSFUL = "\n>>> The purchase was successful. Ticket was saved.\n";
		public static final String NOT_SUCCESSFUL = "\n>>> Ticket with not products. The purchase was not successful. Ticket was saved null.\n";
		public static final String NO_PRODUCTS = "\n>>> The ticket has no products.\n";
		public static final String PRODUCT_NOT_FOUND = "\n>>> Could not find the product.";
		public static final String QUANTITY = "\nEnter a valid quantity:\n";
		public static final String INSUFFICIENT_STOCK = "\n>>> Insufficient stock of this product.\n";
	}
	
	public class Headings {
		public static final String ADD_PRODUCT = "\n===== new product =====\n";
		public static final String DELETE_PRODUCT = "\n===== delete product =====\n";
		public static final String CATALOGUE = "\n===== catalogue =====\n";
		public static final String STOCK = "\n===== stock =====\n";
		public static final String STOCK_VALUE = "\n===== stock value =====\n";
		public static final String TICKET = "\n===== new ticket =====\n";
		public static final String SALES = "\n===== sales =====\n";
		public static final String EARNINGS = "\n===== earnings =====\n";
		public static final String TREES = "\n_____ trees _____\n";
		public static final String FLOWERS = "\n_____ flowers _____\n";
		public static final String DECORATIONS = "\n_____ decorations _____\n";
	}

}
