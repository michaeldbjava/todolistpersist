package de.filehelper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import de.entity.todolist.DocumentTodo;
/**
 * 
 * @author michael
 * @version
 */
public class PathToByteArray {
/**
 * Adds a file to document
 * @param path Path of file to add to document
 * @param documentToDo Represents an object of type DocumentTodo
 */
	public static byte[] getByteArrayOfFile(String path){
		try {
			Path pathToFile = Paths.get(path);
			byte[] data = Files.readAllBytes(pathToFile);
			return data;
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}

}
