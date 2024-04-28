package n1exercici1.utis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import n1exercici1.enums.DateFormatEnum;
import n1exercici1.enums.MaterialsEnum;



public class Utils {

	private static Logger logger = LoggerFactory.getLogger(Utils.class);
	
	public static String getCurrentDateTime() {
		return new SimpleDateFormat(DateFormatEnum.TIMESTAMP.getFormat()).format(new Date());
	}
	
	public static Date parseDateFromString(String strDate) {
		
		SimpleDateFormat sdf = new SimpleDateFormat(DateFormatEnum.TIMESTAMP.getFormat());
		
		Date date = null;
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			logger.error("Utils :: parseDateFromString :: " + Constants.Errors.PARSE_EXCEPTION, e);
		}
		
		return date;
		
	}
	
	public static String appendTimeToDate(String date) {
		return date + " 00:00:00";
	}
	
	public static String replaceUnwantedJsonFileCharacters(String str) {
		return str.replace("[", "").replace("]", "").replace(",]", "").trim();
	}
	
	public static String getMaterial(String material) {
		List<MaterialsEnum> materials = Arrays.asList(MaterialsEnum.values());
		return materials.get(Integer.parseInt(material) - 1).getName();
	}
	
}
