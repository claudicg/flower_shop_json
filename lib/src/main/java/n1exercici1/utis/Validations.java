package n1exercici1.utis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import n1exercici1.enums.DateFormatEnum;
import n1exercici1.enums.MaterialsEnum;
import n1exercici1.enums.ProductTypeEnum;



public class Validations {

private static Logger logger = LoggerFactory.getLogger(Validations.class);
	
	//valid shop name: alphanumeric + some special characters + white spaces
	public static boolean isValidName(String name) {
		return name.matches("^[a-zA-Z0-9áéíóúüïñç\\s]+$");
	}
	
	//valid product name: alpha + some special characters + white spaces
	public static boolean isValidProductName(String productName) {
		return productName.matches("^[a-zA-Záéíóúüïñç\\s]+$");
	}
	
	//main menu options: 0 to 9
	public static boolean isValidOption(String option) {
		return option.matches("^[0-9]{1}$");
	}
	
	//number: 0 + all natural numbers
	public static boolean isZeroOrAbove(String option) {
		return option.matches("^[0-9]+$");
	}
	
	//valid price: 0 + all natural numbers . 0 + all natural numbers
	public static boolean isValidPrice(String price) {
		return price.matches("^([0-9]+|[0-9]+.{1}[0-9]+)$");
	}
	
	//valid product option: 0 to product type enum size
	public static boolean isValidProductOption(String option) {
		
		boolean validOption = false;
		
		if(isZeroOrAbove(option)) {
			
			int opt = Integer.parseInt(option);
			int size = Arrays.asList(ProductTypeEnum.values()).size();
			
			if(opt >= 0 && opt <= size) {
				validOption = true;
			}
		}

		return validOption;
		
	}
	
	//natural numbers
	public static boolean isNaturalNumber(String number) {
		return number.matches("^[1-9]{1}[0-9]*$");
	}
	
	//date format: yyyy-MM-dd HH:mm:ss
	public static boolean isValidDate(String strDate) {
		
		SimpleDateFormat sdf = new SimpleDateFormat(DateFormatEnum.TIMESTAMP.getFormat());
		sdf.setLenient(false);
		
		try {
			
			//step 1: valid date
			sdf.parse(strDate);
			
			//step 2: date not after current date time
			if(Utils.parseDateFromString(strDate).after(Utils.parseDateFromString(Utils.getCurrentDateTime()))) {
				return false;
			}
			
		} catch (ParseException e) {
			logger.error("Validations :: isValidDate :: " + Constants.Errors.PARSE_EXCEPTION, e);
			return false;
		}
		
		return true;
		
	}
	
	//valid colour: a colour contained in the colours file (add more if required)
	public static boolean isValidColour(String colour, List<String> colours) {
		return colours.contains(colour.trim().toUpperCase());
	}
	
	public static boolean isValidMaterialOption(String materialOption) {
		
		boolean validOption = false;
		
		if(isNaturalNumber(materialOption)) {
			
			int option = Integer.parseInt(materialOption);
			int size = Arrays.asList(MaterialsEnum.values()).size();
			
			if(option <= size) {
				validOption = true;
			}
		}

		return validOption;
		
	}
	
	//ticket menu options: 0 to 2
	public static boolean isValidTicketOption(String ticketMenuOption) {
		return ticketMenuOption.matches("^[0-2]{1}$");
	}
	
}
