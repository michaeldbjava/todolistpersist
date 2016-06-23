package de.testdao.userentity;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import de.dao.TodolistEMFactory;
import de.dao.UserDao;
import de.entity.todolist.Todolist;
import de.entity.user.User;
import de.entity.user.UserGroup;
/**
 * This class test the CRUD operations for objects of type Todolist
 * @author michael
 * @version 0.1
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test2TodolistCRUD {
	String username = "mondschein";
	String groupname = "gruppeSachbearbeiter";
	/**
	 * Test method for initialize Test
	 */
	@Test
	public void aInitTestCollection() {
		 boolean statusInit = initializeTestCaseCollection();
		 assertEquals(true, statusInit);
	}
	
	/**
	 * Test method to add a todolist to user.
	 */
	@Test
	public void bAddTodolistToUser(){
		EntityManager em = TodolistEMFactory.createEM("todolistpersist");
		UserDao userDao = new UserDao(em);
		User user = userDao.retrieveUser(username);
		Todolist list1 = new Todolist();
		list1.setTodolist("Liste 1");
		list1.setVisible(true);
		list1.setUser(user);
		user.getTodolists().add(list1);
		boolean statusAddTodolist= userDao.updateUser(user);
		em.close();
		assertEquals(true, statusAddTodolist);
		
	}
	
	/**
	 * Test method to add some  todolists to user.
	 */
	@Test
	public void cAddSomeTodolists(){
		EntityManager em = TodolistEMFactory.createEM("todolistpersist");
		UserDao userDao = new UserDao(em);
		User user = userDao.retrieveUser(username);
		Todolist list1 = new Todolist();
		list1.setTodolist("Liste 2");
		list1.setVisible(true);
		list1.setUser(user);
		
		Todolist list2 = new Todolist();
		list2.setTodolist("Liste 3");
		list2.setVisible(true);
		list2.setUser(user);
		
		Todolist list3 = new Todolist();
		list3.setTodolist("Liste 4");
		list3.setVisible(true);
		list3.setUser(user);
		
		
		Todolist list4 = new Todolist();
		list4.setTodolist("Liste 5");
		list4.setVisible(true);
		list4.setUser(user);
		
		user.getTodolists().add(list2);
		user.getTodolists().add(list3);
		user.getTodolists().add(list4);
		boolean statusAddTodolists= userDao.updateUser(user);
		em.close();
		assertEquals(true, statusAddTodolists);
	}
	
	/**
	 * Test method to retrive some  todolists to user.
	 */
	@Test
	public void dRetriveTodolist(){
		EntityManager em = TodolistEMFactory.createEM("todolistpersist");
		UserDao userDao = new UserDao(em);
		User user = userDao.retrieveUser(username);
		List<Todolist> lists = user.getTodolists();
		int i=1;
		for(Todolist tX:lists){
			System.out.println(tX.getTodolist());
		}
		boolean statusUpdate= userDao.updateUser(user);
		em.close();
		assertEquals(true, statusUpdate);
	}
	
	/**
	 * Test method to update some  todolists to user.
	 */
	@Test
	public void eUpdateTodolist(){
		EntityManager em = TodolistEMFactory.createEM("todolistpersist");
		UserDao userDao = new UserDao(em);
		User user = userDao.retrieveUser(username);
		List<Todolist> lists = user.getTodolists();
		int i=1;
		for(Todolist tX:lists){
			tX.setTodolist("Aufgabenliste " + i);
			i++;
		}
		boolean statusUpdate= userDao.updateUser(user);
		em.close();
		assertEquals(true, statusUpdate);
	}
	
	/**
	 * Test method to update some  todolists to user.
	 */
	@Test
	public void fDeleteOneTodolist(){
		EntityManager em = TodolistEMFactory.createEM("todolistpersist");
		UserDao userDao = new UserDao(em);
		User user = userDao.retrieveUser(username);
		List<Todolist> lists = user.getTodolists();
		boolean statusDelete=false;
		Todolist todolistToDelete = null;
		for(Todolist tX:lists){
			if(tX.getTodolist().equals("Aufgabenliste 2")){
				todolistToDelete=tX;
				statusDelete=true;
			}
		}
		lists.remove(todolistToDelete);
		boolean statusUpdate= userDao.updateUser(user);
		em.close();
		assertEquals(true, statusDelete&&statusUpdate);
	}
	
	@Test
	public void zCleanTestCollection(){
		boolean statusClean = cleanTestCaseCollection();
		
		
		assertEquals(true, statusClean);
	}
	
	public boolean initializeTestCaseCollection(){
		EntityManager em = TodolistEMFactory.createEM("todolistpersist");
		UserDao userDao = new UserDao(em);
		userDao.addUser(username,"Mondschein","Frank","Herr","frank@testtest.de","0221/6789898","0178/8989889","geheim","Lieblingstier?","Pferd");
		User user =userDao.retrieveUser(username);
		UserGroup userGroup = new UserGroup(groupname,user);
		
		user.getUserGroups().add(userGroup);
		
		boolean statusInsert = userDao.updateUser(user);
		em.close();
		return statusInsert;
	}

	public boolean cleanTestCaseCollection(){
		EntityManager em = TodolistEMFactory.createEM("todolistpersist");
		UserDao userDao = new UserDao(em);
		User user= userDao.retrieveUser(username);
		boolean statusDelete = userDao.deleteUser(user);
		
		em.close();
		return statusDelete;
	}
}
