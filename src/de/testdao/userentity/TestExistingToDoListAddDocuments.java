/**
 * 
 */
package de.testdao.userentity;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.plaf.basic.BasicToolBarUI.DockingListener;

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
public class TestExistingToDoListAddDocuments {

	

	@Test
	public void test() {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("todolistpersist");
		EntityManager em = emf.createEntityManager();
		UserDao userDao = new UserDao(em);
		User user = userDao.retrieveUser("heinz40");
		List<Todolist> toDoList = user.getTodolists();
		for(Todolist list:toDoList){
			
			DocumentTodolist doc1 = new DocumentTodolist();
			doc1.setDocumentname("Dokument 1");
			doc1.setTodolist(list);
			DocumentTodolist doc2 = new DocumentTodolist();
			doc2.setDocumentname("Dokument Carmen");
			doc2.setTodolist(list);
			
			list.getDocumentsTodolist().add(doc1);
			list.getDocumentsTodolist().add(doc2);
		}
		boolean statusUpdate=userDao.updateUser(user);
		em.close();
		assertTrue(statusUpdate);
	}

}
