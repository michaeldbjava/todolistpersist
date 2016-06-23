package de.testdao.userentity;

import static org.junit.Assert.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import de.dao.TodolistEMFactory;
import de.dao.UserDao;
import de.entity.todolist.DocumentTodo;
import de.entity.todolist.Todo;
import de.entity.todolist.Todolist;
import de.entity.user.User;
import de.entity.user.UserGroup;
/**
 * 
 * @author michael
 * @version 0.1
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test4DocumentCRUD {
	String username = "mondschein";
	String groupname = "gruppeSachbearbeiter";
	/**
	 * Test method to initialize test envirement.
	 */
	@Test
	public void aInitalizeTestCollection() {
		this.initializeTestCaseCollection();
	}
	
	@Test
	public void bAddDocuments() {
		EntityManager em = TodolistEMFactory.createEM("todolistpersist");
		UserDao userDao = new UserDao(em);
		User user = userDao.retrieveUser(username);

		List<Todolist> lists = user.getTodolists();
		Todolist list = lists.get(0);
		
		
		Todo t1 = new Todo("todo 1", "offen", "hoch", "irgendein content", null, null, null, null, null, false, null,
				new ArrayList<DocumentTodo>());
		/**
		 * Creates a new DocumentTodo object.
		 * @param documentname The document name
		 * @param comment A optional comment
		 * @param filedata The filedata
		 * @param fileextension The extension of file
		 * @param sizeoffile Size of file which is stored
		 * @param uploaddate Date of upload
		 * @param todo Todo object which contains this DocumentTodo object
		 */
		DocumentTodo doc1 = new DocumentTodo("Hallo.doc","Ein Kommentar",null,"doc",0, new java.util.Date(),t1);
		
		DocumentTodo doc2 = new DocumentTodo("Hallo2.doc","Ein Kommentar",null,"doc",0, new java.util.Date(),t1);
		DocumentTodo doc3 = new DocumentTodo("Hallo3.doc","Ein Kommentar",null,"doc",0, new java.util.Date(),t1);
		try {
			Path pathToFile = Paths.get("c:\\tmp\\androidintro.pdf");
			byte[] data = Files.readAllBytes(pathToFile);
			doc1.setFiledata(data);
			doc2.setFiledata(data);
			doc3.setFiledata(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		t1.setTodolist(list);
		t1.getDocumenttodo().add(doc1);
		t1.getDocumenttodo().add(doc2);
		t1.getDocumenttodo().add(doc3);
		Todo t2 = new Todo("todo 2", "offen", "hoch", "irgendein content", null, null, null, null, null, false, null,
				new ArrayList<DocumentTodo>());
		DocumentTodo doc4 = new DocumentTodo("Hallo.doc","Ein Kommentar",null,"doc",0, new java.util.Date(),t2);
		DocumentTodo doc5 = new DocumentTodo("Hallo.doc","Ein Kommentar",null,"doc",0, new java.util.Date(),t2);
		DocumentTodo doc6 = new DocumentTodo("Hallo.doc","Ein Kommentar",null,"doc",0, new java.util.Date(),t2);
		t2.setTodolist(list);
		t2.getDocumenttodo().add(doc4);
		t2.getDocumenttodo().add(doc5);
		t2.getDocumenttodo().add(doc6);
		
		list.getTodos().add(t1);
		list.getTodos().add(t2);

		boolean statusAddTodos = userDao.updateUser(user);
		em.close();
		assertEquals(true, statusAddTodos);
	}

	
	@Test
	public void zCleanTestCollection() {
		this.cleanTestCaseCollection();
	}


	public boolean initializeTestCaseCollection() {
		EntityManager em = TodolistEMFactory.createEM("todolistpersist");
		UserDao userDao = new UserDao(em);
		userDao.addUser(username, "Mondschein", "Frank", "Herr", "frank@testtest.de", "0221/6789898", "0178/8989889",
				"geheim", "Lieblingstier?", "Pferd");
		User user = userDao.retrieveUser(username);
		UserGroup userGroup = new UserGroup(groupname, user);

		user.getUserGroups().add(userGroup);

		Todolist list1 = new Todolist();
		list1.setTodolist("Liste 1");
		list1.setVisible(true);
		list1.setUser(user);
		user.getTodolists().add(list1);

		boolean statusInsert = userDao.updateUser(user);
		em.close();
		return statusInsert;
	}

	public boolean cleanTestCaseCollection() {
		/*EntityManager em = TodolistEMFactory.createEM("todolistpersist");
		UserDao userDao = new UserDao(em);
		User user = userDao.retrieveUser(username);
		boolean statusDelete = userDao.deleteUser(user);

		em.close();
		return statusDelete;*/
		return true;
	}

}
