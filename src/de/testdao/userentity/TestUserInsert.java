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
import de.entity.user.User;
import de.entity.user.UserGroup;

/**
 * @author michael
 *
 */
public class TestUserInsert {

	/**
	 * Test method for {@link de.dao.UserDao#addUser(de.entity.user.User)}.
	 */
	@Test
	public void testAddUserUser() {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("todolistpersist");
		EntityManager em = emf.createEntityManager();
		UserDao userDao = new UserDao(em);
		userDao.addUser("ralf10","Müller","Ralf","Herr","ralf@testtest.de","0221/54545","0178/888","geheim","Geburtsort?","Köln");
		User user =userDao.retrieveUser("ralf10");
		UserGroup userGroup = new UserGroup("gruppexx",user);
		
		user.getUserGroups().add(userGroup);
		
		boolean statusInsert = userDao.updateUser(user);
		em.close();
		assertEquals(true, statusInsert);
	}

}
