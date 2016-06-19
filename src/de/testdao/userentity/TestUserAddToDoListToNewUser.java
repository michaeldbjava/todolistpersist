/**
 * 
 */
package de.testdao.userentity;


import static org.junit.Assert.assertTrue;

import javax.net.ssl.SSLEngineResult.Status;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import de.dao.UserDao;
import de.entity.todolist.Todolist;
import de.entity.user.User;
import de.entity.user.UserGroup;

/**
 * @author michael
 *
 */
public class TestUserAddToDoListToNewUser {

	
	
	/**
	 * Test method for {@link de.dao.UserDao#retrieveUser(java.lang.String)}.
	 */
	@Test
	public void testAddToDoListsToNewUser() {
			EntityManagerFactory emf= Persistence.createEntityManagerFactory("todolistpersist");
			EntityManager em = emf.createEntityManager();
			UserDao userDao = new UserDao(em);
			// Test 1, nur einen neuen Nutzer hinzufügen
			User userToInsert = new User("heinz40", "Laube", "Michael", "Herr", "michael@web.de", "0221/8888", "0178/8888", "secret", "Tier", "Tiger");
			
			/*Test 2, einen neuen Nutzer mit einer neuen Nutzergruppe hinzufügen
			 * 
			 */
			UserGroup userGroup = new UserGroup("gruppexx",userToInsert);
			Todolist tList1 = new Todolist(userToInsert,"Liste 1",true);
			Todolist tList2 = new Todolist(userToInsert,"Liste 2",true);
			Todolist tList3 = new Todolist(userToInsert,"Liste 3",true);
			userToInsert.getUserGroups().add(userGroup);
			userToInsert.getTodolists().add(tList1);
			userToInsert.getTodolists().add(tList2);
			userToInsert.getTodolists().add(tList3);
			boolean statusInsert1 = userDao.addUser(userToInsert);
			
			em.close();
			assertTrue(statusInsert1);

	}
	
}
