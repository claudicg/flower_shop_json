package n1exercici1.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import n1exercici1.utis.Constants;

public class FlowerShopFileWriter {

private static Logger logger = LoggerFactory.getLogger(FlowerShopFileWriter.class);
	
	public static void writeIdToFile(String str, String fileName) {
		
		logger.info("FlowerShopFileWriter :: writeIdToFile :: " + Constants.Messages.WRITING_TO + fileName);
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			
			fw = new FileWriter(Constants.Files.PATH_CONTROL + fileName, true);
			bw = new BufferedWriter(fw);
			
			StringBuffer sb = new StringBuffer();
			sb.append(str);
			bw.write(sb.toString());

		} catch (IOException e) {
			logger.error("FlowerShopFileWriter :: writeIdToFile :: " + Constants.Errors.IO_EXCEPTION, e);
		} finally {
			
			try {
				bw.close();
			} catch (IOException e) {
				logger.error("FlowerShopFileWriter :: writeIdToFile :: bw.close() :: " + Constants.Errors.IO_EXCEPTION, e);
			}
			
			try {
				fw.close();
			} catch (IOException e) {
				logger.error("FlowerShopFileWriter :: writeIdToFile :: fw.close() :: " + Constants.Errors.IO_EXCEPTION, e);
			}
			
		}
		
	}
	
	public static void writeToJsonFile(Object object, String fileName, boolean isFirstElement, boolean isLastElement) {
		
		logger.info("FlowerShopFileWriter :: writeToJsonFile :: " + Constants.Messages.WRITING_TO + fileName);
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			
			fw = new FileWriter(Constants.Files.PATH_PERSISTENCE + fileName, true);
			bw = new BufferedWriter(fw);
			
			StringBuffer sb = new StringBuffer();
			sb.append(Serialization.mapObjectToJson(object));
			
			if(isFirstElement && isLastElement) {	
				bw.write("[" + sb.toString() + "]\n");
			} else if(isFirstElement && !isLastElement) {
				bw.write("[" + sb.toString() + ",\n");
			} else if(!isFirstElement && isLastElement) {
				bw.write(sb.toString() + "]\n");
			} else if(!isFirstElement && !isLastElement) {
				bw.write(sb.toString() + ",\n");
			}

		} catch (IOException e) {
			logger.error("FlowerShopFileWriter :: writeToJsonFile :: " + Constants.Errors.IO_EXCEPTION, e);
		} finally {
			
			try {
				bw.close();
			} catch (IOException e) {
				logger.error("FlowerShopFileWriter :: writeToJsonFile :: bw.close() :: " + Constants.Errors.IO_EXCEPTION, e);
			}
			
			try {
				fw.close();
			} catch (IOException e) {
				logger.error("FlowerShopFileWriter :: writeToJsonFile :: fw.close() :: " + Constants.Errors.IO_EXCEPTION, e);
			}
			
		}

	}

}
