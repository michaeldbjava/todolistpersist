/**
 * 
 */
package de.testdao.userentity;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import de.dao.TodolistEMFactory;
import de.dao.UserDao;
import de.entity.user.User;
import de.entity.user.UserGroup;

/**
 * This class test the CRUD operations for objects of type user
 * @author michael
 * @version 0.1
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test1UserCRUD {
	String username = "ralf114";
	String groupname = "gruppexyz";
	
	String usernameObject = "ralf204";
	/**
	 * Test method for {@link de.dao.UserDao#addUser(de.entity.user.User)}.
	 * Insert a new Object of type User with UserDao class. 
	 * This contains insert a usergroup Object with UserGroup class
	 */
	@Test
	
	public void aTestUser() {
		EntityManager em = TodolistEMFactory.createEM("todolistpersist");		UserDao userDao = new UserDao(em);
		userDao.addUser(username,"Müller","Ralf","Herr","ralf@testtest.de","0221/54545","0178/888","geheim","Geburtsort?","Köln");
		User user =userDao.retrieveUser(username);
		UserGroup userGroup = new UserGroup(groupname,user);
		
		user.getUserGroups().add(userGroup);
		
		boolean statusInsert = userDao.updateUser(user);
		em.close();
		assertEquals(true, statusInsert);
	}
	
	/**
	 * Test method for {@link de.dao.UserDao#retrieveUser(java.lang.String)}.
	 * Retrive  a Object of type User with UserDao object. 
	 */
	@Test
	public void bTestUser() {
		EntityManager em = TodolistEMFactory.createEM("todolistpersist");		
		UserDao userDao = new UserDao(em);
		User user = userDao.retrieveUser(username);
		System.out.println(user.toString());
		
		assertEquals(username, user.getUsername());
		em.close();
	}
	
	/**
	 * Test method for {@link de.dao.UserDao#updateUser(...)}.
	 * Update fields of object User
	 */	
	@Test
	public void cTestUser() {
		EntityManager em = TodolistEMFactory.createEM("todolistpersist");		
		UserDao userDao = new UserDao(em);
		boolean statusUpdate = userDao.updateUser(username,"Sternentaler","Ralf","Herr","ralfsternentaler@testtest.de","0221/54545","0178/888","geheim","Geburtsort?","Köln");
		em.close();
		
		assertEquals(true, statusUpdate);
	}

	/**
	 * Test method for {@link de.dao.UserDao#deleteUser(java.lang.String)}.
	 * Delete User object
	 */
	@Test
	public void dTestUser() {
		EntityManager em = TodolistEMFactory.createEM("todolistpersist");
		UserDao userDao = new UserDao(em);
		boolean statusDelete = userDao.deleteUser(username);
		
		em.close();
		assertEquals(true, statusDelete);
	}
	
	
	/**
	 * Test method for {@link de.dao.UserDao#deleteUser(java.lang.String)}.
	 * This method test to add user object
	 */
	@Test
	public void eTestUser() {
		EntityManager em = TodolistEMFactory.createEM("todolistpersist");
		UserDao userDao = new UserDao(em);
		User newUser = new User(usernameObject,"Müller","Ralf","Herr","ralf@testtest.de","0221/54545","0178/888","geheim","Geburtsort?","Köln");
		UserGroup userGroup = new UserGroup(groupname,newUser);
		List<UserGroup> userGroups = new ArrayList<UserGroup>();
		userGroups.add(userGroup);
		newUser.setUserGroups(userGroups);
		boolean statusInsertObject = userDao.addUser(newUser);
		
		em.close();
		assertEquals(true, statusInsertObject);
	}
	
	/**
	 * Test method for {@link de.dao.UserDao#deleteUser(java.lang.String)}.
	 * This method test to retrive user object. It get a user object as paramter, which should be returned
	 */
	@Test
	public void tTestUser() {
		EntityManager em = TodolistEMFactory.createEM("todolistpersist");
		UserDao userDao = new UserDao(em);
		User user= new User();
		user.setUsername(usernameObject);
		User userRetrived = userDao.retrieveUser(user);
		
		em.close();
		assertEquals(true, userRetrived.getUsername().equals(usernameObject));
	}
	
	
	/**
	 * Test method for {@link de.dao.UserDao#updateUser(java.lang.String)}.
	 * This method test to update user object. It get a user object as paramter, which should be returned
	 */
	@Test
	public void uTestUser() {
		EntityManager em = TodolistEMFactory.createEM("todolistpersist");
		UserDao userDao = new UserDao(em);
		User user= userDao.retrieveUser(usernameObject);
		user.setE_mail("update@erma.de");
		boolean statusUpdate = userDao.updateUser(user);
		
		em.close();
		assertEquals(true, statusUpdate);
	}
	
	/**
	 * Test method for {@link de.dao.UserDao#deleteUser(java.lang.String)}.
	 * This method test to delete user object. It get a user object as paramter, which should be returned
	 */
	@Test
	public void vTestUser() {
		EntityManager em = TodolistEMFactory.createEM("todolistpersist");
		UserDao userDao = new UserDao(em);
		User user= userDao.retrieveUser(usernameObject);
		boolean statusDelete = userDao.deleteUser(user);
		
		em.close();
		assertEquals(true, statusDelete);
	}

	

}





