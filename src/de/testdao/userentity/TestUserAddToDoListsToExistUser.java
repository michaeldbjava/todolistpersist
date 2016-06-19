/**
 * 
 */
package de.testdao.userentity;

import static org.junit.Assert.*;

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
public class TestUserAddToDoListsToExistUser {

	
	@Test
	public void testAddToDoListsToExistingUser() {
			EntityManagerFactory emf= Persistence.createEntityManagerFactory("todolistpersist");
			EntityManager em = emf.createEntityManager();
			UserDao userDao = new UserDao(em);
			// Test 1, nur einen neuen Nutzer hinzufügen
			User user = userDao.retrieveUser("heinz40");
			/*Test 2, einen neuen Nutzer mit einer neuen Nutzergruppe hinzufügen
			 * 
			 */
			Todolist tList1 = new Todolist(user,"Liste 1",true);
			Todolist tList2 = new Todolist(user,"Liste 2",true);
			Todolist tList3 = new Todolist(user,"Liste 3",true);
			user.getTodolists().add(tList1);
			user.getTodolists().add(tList2);
			user.getTodolists().add(tList3);
			boolean stutusUpdate = userDao.updateUser(user);
			em.close();
			assertTrue(stutusUpdate);

	}


}
