/**
 * 
 */
package de.testdao.userentity;

import static org.junit.Assert.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Test;

import de.dao.UserDao;
import de.entity.todolist.DocumentTodolist;
import de.entity.todolist.Todolist;
import de.entity.user.User;

/**
 * @author michael
 * @version 0.1
 *
 */
public class TestExistingToDoListReadAndSaveDocWithFile {

	

	@Test
	public void test() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("todolistpersist");
		EntityManager em = emf.createEntityManager();
		UserDao userDao = new UserDao(em);
		User user = userDao.retrieveUser("heinz40");
		boolean statusWriteFile=false;
		List<Todolist> toDoList = user.getTodolists();
		int i = 0;
		for (Todolist list : toDoList) {

			List<DocumentTodolist> listDoc = list.getDocumentsTodolist();
			
			for(DocumentTodolist doc:listDoc){
				byte[] data = doc.getFiledata();
				try{
					if(data!=null){
					String pathValue = "c:\\tmp\\androidintro_v" + i +".pdf";
					Path newPathToFile = Paths.get(pathValue);
					
					Files.write(newPathToFile, data);
					System.out.println("Dokument zur Todoliste "  + list.getTodolist()+ " wurde unter dem Pfad " + pathValue);
					}
					else{
						System.out.println("ToDo Liste " + list.getTodolist() + " enthält keine Dateien");
					}
					
					i++;
					statusWriteFile=true;
				}
				catch(Exception e){
					e.printStackTrace();
					statusWriteFile=false;
				}
			}
			
		
		}
		em.close();
		assertTrue(statusWriteFile);
	}
	

}
