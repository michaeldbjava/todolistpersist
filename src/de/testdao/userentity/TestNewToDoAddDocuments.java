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

import org.junit.Test;

import de.dao.UserDao;
import de.entity.todolist.DocumentTodo;
import de.entity.todolist.Todo;
import de.entity.todolist.Todolist;
import de.entity.user.User;

/**
 * @author michael
 * @version 0.1
 *
 */
public class TestNewToDoAddDocuments {

	

	@Test
	public void addOneDocumentToNewTodo() {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("todolistpersist");
		EntityManager em = emf.createEntityManager();
		UserDao userDao = new UserDao(em);
		// Test 1, nur einen neuen Nutzer hinzufügen
		User user = userDao.retrieveUser("heinz40");
		List<Todolist> todolists = user.getTodolists();
		for(Todolist list:todolists){
			Todo todoWithDocuments = new Todo();
			todoWithDocuments.setTodo("Ein ToDo mit einer Datei");
			try {
				Path pathToFile = Paths.get("c:\\tmp\\androidintro.pdf");
				byte[] data = Files.readAllBytes(pathToFile);
				DocumentTodo docTodo = new DocumentTodo();
				docTodo.setFiledata(data);
				docTodo.setTodo(todoWithDocuments);
				todoWithDocuments.getDocumenttodo().add(docTodo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			list.addTodo(todoWithDocuments);
		}
		
		boolean statusAddDocumentToTodo=userDao.updateUser(user);
		em.close();
		assertTrue(statusAddDocumentToTodo);
	}
	
	@Test
	public void addMoreDocumentsToOneTodo() {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("todolistpersist");
		EntityManager em = emf.createEntityManager();
		UserDao userDao = new UserDao(em);
		// Test 1, nur einen neuen Nutzer hinzufügen
		User user = userDao.retrieveUser("heinz40");
		List<Todolist> todolists = user.getTodolists();
		for(Todolist list:todolists){
			Todo todoWithDocuments = new Todo();
			todoWithDocuments.setTodo("Ein ToDo mit einer Datei");
			try {
				Path pathToFile = Paths.get("c:\\tmp\\androidintro.pdf");
				byte[] data = Files.readAllBytes(pathToFile);
				DocumentTodo docTodo = new DocumentTodo();
				docTodo.setFiledata(data);
				docTodo.setTodo(todoWithDocuments);
				
				DocumentTodo docTodo2 = new DocumentTodo();
				docTodo2.setFiledata(data);
				docTodo2.setTodo(todoWithDocuments);
				docTodo2.setTodo(todoWithDocuments);
				todoWithDocuments.getDocumenttodo().add(docTodo);
				todoWithDocuments.getDocumenttodo().add(docTodo2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			list.addTodo(todoWithDocuments);
		}
		
		boolean statusAddDocumentToTodo=userDao.updateUser(user);
		em.close();
		assertTrue(statusAddDocumentToTodo);
	}

}
