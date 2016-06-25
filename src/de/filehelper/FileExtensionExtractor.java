package de.filehelper;
/**
 * 
 * @author michael
 * @version 0.1
 */
public class FileExtensionExtractor {

	public static String getFileExtension(String path){
		String fileExtension = path.substring(path.lastIndexOf(".") + 1);
		return fileExtension;
	}

}
