package de.testdao.userentity;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import de.dao.TodolistEMFactory;
import de.dao.UserDao;
import de.entity.todolist.Todo;
import de.entity.todolist.Todolist;
import de.entity.user.User;
import de.entity.user.UserGroup;

/**
 * This class test the CRUD operations for objects of type ToDo
 * 
 * @author michael
 * @version 0.1
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test3TodoCRUD {
	String username = "mondschein";
	String groupname = "gruppeSachbearbeiter";

	/**
	 * Test method to initialize test envirement.
	 */
	@Test
	public void aInitalizeTestCollection() {
		this.initializeTestCaseCollection();
	}

	/**
	 * Test method to add a todos to todolist.
	 */
	@Test
	public void bAddTodos() {
		EntityManager em = TodolistEMFactory.createEM("todolistpersist");
		UserDao userDao = new UserDao(em);
		User user = userDao.retrieveUser(username);

		List<Todolist> lists = user.getTodolists();
		Todolist list = lists.get(0);
		Todo t1 = new Todo("todo 1", "offen", "hoch", "irgendein content", null, null, null, null, null, false, null,
				null);
		t1.setTodolist(list);

		Todo t2 = new Todo("todo 2", "offen", "hoch", "irgendein content", null, null, null, null, null, false, null,
				null);
		t2.setTodolist(list);
		list.getTodos().add(t1);
		list.getTodos().add(t2);

		boolean statusAddTodos = userDao.updateUser(user);
		em.close();
		assertEquals(true, statusAddTodos);
	}

	/**
	 * Test method to retrive todos from todolist.
	 */

	@Test
	public void cRetriveTodos() {
		EntityManager em = TodolistEMFactory.createEM("todolistpersist");
		UserDao userDao = new UserDao(em);
		User user = userDao.retrieveUser(username);

		List<Todolist> lists = user.getTodolists();
		Todolist list = lists.get(0);
		List<Todo> todolist = list.getTodos();
		boolean todosExists = false;
		for (Todo todo : todolist) {
			System.out.println(todo.toString());
			todosExists = true;
		}
		em.close();
		assertEquals(true, todosExists);
	}

	/**
	 * Test method to updte todos from todolist.
	 */

	@Test
	public void dUpdateTodos() {
		EntityManager em = TodolistEMFactory.createEM("todolistpersist");
		UserDao userDao = new UserDao(em);
		User user = userDao.retrieveUser(username);

		List<Todolist> lists = user.getTodolists();
		Todolist list = lists.get(0);
		List<Todo> todolist = list.getTodos();
		boolean todosExists = false;
		for (Todo todo : todolist) {
			todo.setStartdate(new Date());
			todo.setEnddate(new Date());
			System.out.println(todo.toString());

		}

		boolean statusUpdate = userDao.updateUser(user);

		em.close();
		assertEquals(true, statusUpdate);
	}

	/**
	 * Test method to delete todos from todolist
	 */
	@Test
	public void eDeleteTodos() {
		EntityManager em = TodolistEMFactory.createEM("todolistpersist");
		UserDao userDao = new UserDao(em);
		User user = userDao.retrieveUser(username);

		List<Todolist> lists = user.getTodolists();
		Todo todo1 = null;
		Todo todo2 = null;
		for (Todolist todolist : lists) {
			List<Todo> todolisttodos = todolist.getTodos();
			
			for (Todo todo : todolisttodos) {
				if(todo!=null && todo.getTodo().equals("todo 1")){
					todo1=todo;
				}
				else if(todo!=null && todo.getTodo().equals("todo 2")){
					todo2=todo;
				}
				
			}
			
			if(todo1!=null && todo2!=null){
				todolisttodos.remove(todo1);
				todolisttodos.remove(todo2);
			}
		}

		boolean statusUpdate = userDao.updateUser(user);

		em.close();
		assertEquals(true, statusUpdate);
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
		EntityManager em = TodolistEMFactory.createEM("todolistpersist");
		UserDao userDao = new UserDao(em);
		User user = userDao.retrieveUser(username);
		boolean statusDelete = userDao.deleteUser(user);

		em.close();
		return statusDelete;
	}

}
