/**
 * 
 */
package de.testdao.userentity;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

/**
 * @author michael
 *
 */
public class TestExistingToDoListAddDocumentWithFile {

	
	@Test
	public void test() {
		/* Try Simple file to byte array*/
		try{
		Path path = Paths.get("C:/temp/test.txt");
	      byte[] data = Files.readAllBytes(path);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
