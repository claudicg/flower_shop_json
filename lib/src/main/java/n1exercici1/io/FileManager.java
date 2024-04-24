package n1exercici1.io;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import n1exercici1.utis.Constants;

public class FileManager {

private static Logger logger = LoggerFactory.getLogger(FileManager.class);
	
	public static void deleteFile(String path, String fileName, boolean delete) {
		
		logger.info("FileManager :: deleteFile :: " + Constants.Messages.DELETING + fileName);
		
		File file = new File(path + fileName);
		
		if(file.exists()) {		
			if(delete) {
				file.delete();
			}		
		}
		
	}
	
	public static void createFile(String path, String fileName) {
		
		logger.info("FileManager :: createFile :: " + Constants.Messages.CREATING + fileName);
		
		File file = new File(path + fileName);
		
		if(!file.exists()) {		
			try {
				file.createNewFile();
			} catch (IOException e) {
				logger.error("FileManager :: createFile :: " + Constants.Errors.IO_EXCEPTION, e);
			}
		}
		
	}
	
	public static boolean fileExists(String filePath, String fileName) {
		return (new File(filePath + fileName).exists());
	}

}
