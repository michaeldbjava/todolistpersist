package de.filehelper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 * @author michael
 * @version 0.1
 */
public class FileSaveLocalHelper {
	/**
	 * 
	 * @param filename
	 * @param pathDirectory
	 * @param data
	 * @return Status of save opereration
	 */
	public static boolean saveFileFromByteArray(String filename, String pathDirectory, byte[] data) {
		Path path = Paths.get(pathDirectory);
		if (Files.isDirectory(path)) {
			Path completePathToSaveFile = Paths.get(path.toString(), filename);
			if(!Files.exists(completePathToSaveFile)){
				try {
					Files.write(completePathToSaveFile, data);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return true;
			}
			else{
				return false;
			}
			
		}
		else{
			return false;
		}

		
	}
}
